/*

*/
var app = angular.module("questionMng", ["ui.router", 'ui.bootstrap']);

app.config(function($stateProvider, $urlRouterProvider, $locationProvider) {
    $locationProvider.hashPrefix('');
    //trở về trang mặc định
    $urlRouterProvider.otherwise("/question-manager");
    $stateProvider
        .state("question", {
            url: "/question-manager",
            views: {
                "content": {
                    templateUrl: "question.html",
                    controller: "questionController"
                }
            }
        })
});

app.filter('beginningQuestion', function () {
    return function (input, begin) {
        if (input) {
            begin = +begin;
            return input.slice(begin);
        }
        return [];
    }
});
app.controller("questionController", function ($scope, $http, $state) {
    console.log("Question controller");

    $scope.questionDTO = {
        "id": "",
        "question": "",
        "answera": "",
        "answerb": "",
        "answerc": "",
        "answerd": "",
        "rightanswer": "",
        "questiongroup": ""
    };

    $scope.questionG = [
        {
            "group": "easy"
        },
        {
            "group": "medium"
        },
        {
            "group": "hard"
        }
    ];

    $scope.result = [
        {
            "key": "A"
        },
        {
            "key": "B"
        },
        {
            "key": "C"
        },
        {
            "key": "D"
        }
    ];

    //get all question
    $http({
        method: 'GET',
        url: "http://localhost:8080/question/getAll"
    }).then(function successCallback(response) {
        console.log(response);

        $scope.questionList = response.data;
        $scope.currentPage = 1;
        $scope.questionPerPage = 10;
        $scope.filterQuestion = $scope.questionList.length;
        $scope.entireQuestion = $scope.questionList.length;
    }, function errorCallback(response) {
        console.log(response)
    });

    $scope.pagePosition = function (pageNumber) {
        $scope.currentPage = pageNumber;
    };

    $scope.filter = function () {
        $timeout(function () {
            $scope.filterTimeSheet = $scope.searched.length;
        }, 20);
    };
    $scope.sortWith = function (base) {
        $scope.base = base;
        $scope.reverse = !$scope.reverse;
    };

    $scope.deleteConfirm = function deleteConfirm(data) {
        var result = confirm("Bạn chắc chắn muốn xoá câu hỏi này");
        if (result) {
            console.log(data);
            $scope.delete(data);
        } else {
            this.close();
        }
    };

    //delete question
    $scope.delete = function (data) {
        $http({
            method: 'DELETE',
            url: "http://localhost:8080/question/delete/" + data.id
        }).then(function successCallback(response) {
            console.log(response);
            $state.reload();
        }, function errorCallback(response) {
            console.log(response);
            $state.reload();
        });
    };


    //set value for questionDTO
    $scope.getQuestion = function getQuestion(data) {
        if (data == null) {
            $scope.questionDTO.id = "";
            $scope.questionDTO.question = "";
            $scope.questionDTO.answera = "";
            $scope.questionDTO.answerb = "";
            $scope.questionDTO.answerc = "";
            $scope.questionDTO.answerd = "";
            $scope.questionDTO.rightanswer = "";
            $scope.questionDTO.questiongroup = "";
        } else {
            $scope.questionDTO.id = data.id;
            $scope.questionDTO.question = data.question;
            $scope.questionDTO.answera = data.answera;
            $scope.questionDTO.answerb = data.answerb;
            $scope.questionDTO.answerc = data.answerc;
            $scope.questionDTO.answerd = data.answerd;
            $scope.questionDTO.rightanswer = data.rightanswer;
            $scope.questionDTO.questiongroup = data.questiongroup.uppercase;
        }
    };


    //save or update question
    $scope.save = function save() {
        console.log($scope.questionDTO);
        if ($scope.questionDTO.id === "") {
            $http({
                method: 'POST',
                url: "http://localhost:8080/question/insert",
                data: $scope.questionDTO
            }).then(function successCallback(response) {
                console.log(response);
                $state.reload();
            }, function errorCallback(response) {
                console.log(response);
                $state.reload();
            });
        } else {
            $http({
                method: 'PUT',
                url: "http://localhost:8080/question/update",
                data: $scope.questionDTO
            }).then(function successCallback(response) {
                console.log(response);
                $state.reload();
            }, function errorCallback(response) {
                console.log(response);
                $state.reload();
            });
        }
    }
});

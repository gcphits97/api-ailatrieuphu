package com.end.api.ailatrieuphu.question.business;

import com.end.api.ailatrieuphu.question.model.QuestionModel;
import com.end.api.ailatrieuphu.question.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

@Service
public class QuestionBusiness {
    @Autowired
    QuestionRepository questionRepository;

    public List<QuestionModel> getQuestion() {
        List<QuestionModel> questionList = new ArrayList<>();
        Random random = new Random();

        Vector v = new Vector();
        int r;
        List<QuestionModel> easyQuestionList = questionRepository.questionList("easy");
        for (int i = 0; i < 5; ) {
            r = random.nextInt(easyQuestionList.size());
            if (!v.contains(r)) {
                i++;
                v.add(r);
                questionList.add(easyQuestionList.get(r));
            }
        }

        Vector v1 = new Vector();
        int r1;
        List<QuestionModel> mediumQuestionList = questionRepository.questionList("medium");
        for (int i = 0; i < 5; ) {
            r1 = random.nextInt(mediumQuestionList.size());
            if (!v1.contains(r1)) {
                i++;
                v1.add(r1);
                questionList.add(mediumQuestionList.get(r1));
            }
        }

        Vector v2 = new Vector();
        int r2;
        List<QuestionModel> hardQuestionList = questionRepository.questionList("hard");
        for (int i = 0; i < 5; ) {
            r2 = random.nextInt(hardQuestionList.size());
            if (!v2.contains(r2)) {
                i++;
                v2.add(r2);
                questionList.add(hardQuestionList.get(r2));
            }
        }
        return questionList;
    }
}

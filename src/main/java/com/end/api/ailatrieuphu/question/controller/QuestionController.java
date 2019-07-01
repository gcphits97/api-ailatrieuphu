package com.end.api.ailatrieuphu.question.controller;

import com.end.api.ailatrieuphu.question.business.QuestionBusiness;
import com.end.api.ailatrieuphu.question.model.QuestionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/question")
public class QuestionController {
    @Autowired
    QuestionBusiness questionBusiness;

    @GetMapping(path = "/get")
    public ResponseEntity<List<QuestionModel>> getQuestion() {
        return ResponseEntity.ok(questionBusiness.getQuestion());
    }
}

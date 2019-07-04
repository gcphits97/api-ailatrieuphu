package com.end.api.ailatrieuphu.question.controller;

import com.end.api.ailatrieuphu.question.business.QuestionBusiness;
import com.end.api.ailatrieuphu.question.dto.QuestionDTO;
import com.end.api.ailatrieuphu.question.model.QuestionModel;
import com.end.api.ailatrieuphu.question.notification.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(path = "/insert", consumes = "application/json", produces = "text/plain")
    public ResponseEntity<String>  insertQuestion(@RequestBody QuestionDTO questionDTO) {
        if (questionDTO.getQuestion().trim().length() == 0) return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Câu hỏi không được để trống");
        if (questionDTO.getAnswera().trim().length() == 0) return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Đáp án không được để trống");
        if (questionDTO.getAnswerb().trim().length() == 0) return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Đáp án không được để trống");
        if (questionDTO.getAnswerc().trim().length() == 0) return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Đáp án không được để trống");
        if (questionDTO.getAnswerd().trim().length() == 0) return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Đáp án không được để trống");
        if (questionDTO.getRightanswer().trim().length() == 0) return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Câu trả lời không được để trống");
        if (questionDTO.getQuestiongroup().trim().length() == 0) return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Loại câu hỏi không được để trống");
        return ResponseEntity.status(HttpStatus.OK).body(questionBusiness.insertQuestion(questionDTO));
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<QuestionModel>> getAll() {
        return ResponseEntity.ok(questionBusiness.getAll());
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity deleteQuestion(@PathVariable int id) {
        return ResponseEntity.ok(new Notification(200, questionBusiness.deleteQuestion(id)));
    }

    @PutMapping(path = "update", consumes = "application/json", produces = "text/plain")
    public ResponseEntity<String> updateQuestion(@RequestBody QuestionDTO questionDTO) {
        return ResponseEntity.ok(questionBusiness.updateQuestion(questionDTO));
    }
}

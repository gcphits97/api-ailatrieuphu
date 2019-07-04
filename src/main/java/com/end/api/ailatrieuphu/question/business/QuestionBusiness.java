package com.end.api.ailatrieuphu.question.business;

import com.end.api.ailatrieuphu.question.dto.QuestionDTO;
import com.end.api.ailatrieuphu.question.model.QuestionModel;
import com.end.api.ailatrieuphu.question.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public String insertQuestion(QuestionDTO questionDTO) {
        QuestionModel questionModel = questionRepository.save(QuestionModel.builder()
            .question(questionDTO.getQuestion())
            .answera(questionDTO.getAnswera())
            .answerb(questionDTO.getAnswerb())
            .answerc(questionDTO.getAnswerc())
            .answerd(questionDTO.getAnswerd())
            .rightanswer(questionDTO.getRightanswer())
            .questiongroup(questionDTO.getQuestiongroup())
            .build());
        if (questionModel != null) {
            return "Thêm câu hỏi thành công!";
        } else {
            return "Thêm câu hỏi thất bại!";
        }
    }

    public List<QuestionModel> getAll() {
        return questionRepository.findAll();
    }

    @Transactional
    public String deleteQuestion(int id) {
        questionRepository.delete(questionRepository.findQuestionModelById(id));
        if (questionRepository.findQuestionModelById(id) == null) {
            return "Xoá câu hỏi thành công";
        } else {
            return "Xoá câu hỏi thất bại";
        }
    }

    @Transactional
    public String updateQuestion(QuestionDTO questionDTO) {
        int i = questionRepository.updateQuestion(questionDTO.getQuestion(), questionDTO.getAnswera(), questionDTO.getAnswerb(),
                questionDTO.getAnswerc(), questionDTO.getAnswerd(), questionDTO.getRightanswer(), questionDTO.getQuestiongroup(), questionDTO.getId());
        if (i == 1) {
            return "Cập nhật câu hỏi thành công";
        } else {
            return "Cập nhật câu hỏi thất bại";
        }
    }

    @Transactional
    public String deleteMultipleQuestion(List<Integer> listId) {
        boolean check = true;
        for (int id: listId) {
            questionRepository.delete(questionRepository.findQuestionModelById(id));
            if (questionRepository.findQuestionModelById(id) == null) {
                check = true;
            } else {
                check = false;
            }
        }
        if (check) {
            return "Xoá thành công";
        } else {
            return "Xoá thất bại";
        }
    }
}

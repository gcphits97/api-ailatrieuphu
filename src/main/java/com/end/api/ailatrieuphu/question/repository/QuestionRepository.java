package com.end.api.ailatrieuphu.question.repository;

import com.end.api.ailatrieuphu.question.model.QuestionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository extends JpaRepository<QuestionModel, Long> {
    @Query("select q from QuestionModel q where q.questiongroup = ?1")
    List<QuestionModel> questionList(String group);

    QuestionModel findQuestionModelById(int id);

    @Modifying
    @Query("update QuestionModel q set q.question = ?1, q.answera = ?2, q.answerb = ?3, q.answerc = ?4, q.answerd = ?5, q.rightanswer = ?6, q.questiongroup = ?7 where q.id = ?8")
    int updateQuestion(String question, String answera, String answerb, String answerc, String answerd, String rightanswer, String questiongroup, int id);
}

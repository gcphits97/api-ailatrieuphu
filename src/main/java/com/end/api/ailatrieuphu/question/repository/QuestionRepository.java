package com.end.api.ailatrieuphu.question.repository;

import com.end.api.ailatrieuphu.question.model.QuestionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository extends JpaRepository<QuestionModel, Long> {
    @Query("select q from QuestionModel q where q.questiongroup = ?1")
    List<QuestionModel> questionList(String group);
}

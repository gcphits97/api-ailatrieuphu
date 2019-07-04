package com.end.api.ailatrieuphu.question.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "question")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private int id;

    @Column(name = "question", nullable = false)
    private String question;

    @Column(name = "answera", nullable = false)
    private String answera;

    @Column(name = "answerb", nullable = false)
    private String answerb;

    @Column(name = "answerc", nullable = false)
    private String answerc;

    @Column(name = "answerd", nullable = false)
    private String answerd;

    @Column(name = "rightanswer", nullable = false)
    private String rightanswer;

    @Column(name = "questiongroup", nullable = false)
    private String questiongroup;
}

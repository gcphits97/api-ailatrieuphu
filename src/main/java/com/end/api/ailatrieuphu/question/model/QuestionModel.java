package com.end.api.ailatrieuphu.question.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "question")
@Data
public class QuestionModel {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
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

//    @Column(name = "questiontype", nullable = false)
//    private String questiontype;

    @Column(name = "questiongroup", nullable = false)
    private String questiongroup;
}

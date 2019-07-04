package com.end.api.ailatrieuphu.question.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDTO {
    private int id;
    private String question;
    private String answera;
    private String answerb;
    private String answerc;
    private String answerd;
    private String rightanswer;
    private String questiongroup;
}

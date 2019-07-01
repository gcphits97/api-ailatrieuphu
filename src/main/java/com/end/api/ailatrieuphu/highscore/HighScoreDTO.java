package com.end.api.ailatrieuphu.highscore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HighScoreDTO {
    private int id;
    private String playtime;
    private int lanchoi;
    private int tongsocautraloidung;
    private double tyle;
    private int bestplay;
    private String bestreward;
    private int user_model_id;
}

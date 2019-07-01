package com.end.api.ailatrieuphu.highscore;

import com.end.api.ailatrieuphu.login.model.UserModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "highscore")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HighScoreModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private int id;

    @Column(name = "playtime", nullable = false)
    private String playtime;

    @Column(name = "lanchoi", nullable = false)
    private int lanchoi;

    @Column(name = "tongsocautraloidung", nullable = false)
    private int tongsocautraloidung;

    @Column(name = "tyle", nullable = false)
    private double tyle;

    @Column(name = "bestplay", nullable = false)
    private int bestplay;

    @Column(name = "bestreward", nullable = false)
    private String bestreward;

    @ManyToOne(fetch = FetchType.EAGER)
    private UserModel userModel;

    public HighScoreModel(String playtime, double tyle, int bestplay, String bestreward, UserModel userModel) {
        this.playtime = playtime;
        this.tyle = tyle;
        this.bestplay = bestplay;
        this.bestreward = bestreward;
        this.userModel = userModel;
    }
}

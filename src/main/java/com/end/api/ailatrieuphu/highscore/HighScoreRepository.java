package com.end.api.ailatrieuphu.highscore;

import com.end.api.ailatrieuphu.login.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HighScoreRepository extends JpaRepository<HighScoreModel, Long> {
    @Query("select new HighScoreModel(h.playtime, h.tyle, h.bestplay, h.bestreward, h.userModel)" +
            "from HighScoreModel h order by h.bestplay desc, h.tyle desc")
    List<HighScoreModel> highScoreList();


    @Modifying
    @Query("update HighScoreModel h set h.bestplay = ?1, h.bestreward = ?2, h.playtime = ?3, h.lanchoi = ?4" +
            ", h.tyle = ?5, h.tongsocautraloidung = ?6 where h.userModel = ?7")
    int update(int bestplay, String bestreward, String playtime, int lanchoi, double tyle, int tongsocautraloidung, UserModel userModel);


    HighScoreModel findHighScoreModelByUserModel(UserModel userModel);


    @Modifying
    @Query("update HighScoreModel h set h.lanchoi = ?1" +
            ", h.tyle = ?2, h.tongsocautraloidung = ?3 where h.userModel = ?4")
    int updateTyLe(int lanchoi, double tyle, int tongsocautraloidung, UserModel userModel);


//    HighScoreModel findHighScoreModelById(int id);
}

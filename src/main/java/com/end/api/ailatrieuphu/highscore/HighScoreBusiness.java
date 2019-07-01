package com.end.api.ailatrieuphu.highscore;

import com.end.api.ailatrieuphu.login.model.UserModel;
import com.end.api.ailatrieuphu.login.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class HighScoreBusiness {
    @Autowired
    HighScoreRepository highScoreRepository;
    @Autowired
    LoginRepository loginRepository;

    public List<HighScoreModel> getHighScore() {
        return highScoreRepository.highScoreList();
    }

    @Transactional
    public HighScoreModel createOrUpdate(HighScoreDTO highScoreDTO) {
        UserModel userModel = loginRepository.findUserModelById(highScoreDTO.getUser_model_id());
        HighScoreModel highScoreModel = highScoreRepository.findHighScoreModelByUserModel(userModel);

        SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Date date = new Date(System.currentTimeMillis());
        if (highScoreModel == null) {
            double i = (double) highScoreDTO.getBestplay();
            double tyle = i/15*100;

            HighScoreModel highScoreModel1 = highScoreRepository.save(HighScoreModel.builder()
            .bestplay(highScoreDTO.getBestplay())
            .bestreward(highScoreDTO.getBestreward())
            .userModel(userModel)
            .lanchoi(1)
            .playtime(formatter.format(date))
            .tongsocautraloidung(highScoreDTO.getBestplay())
            .tyle(Double.parseDouble(new DecimalFormat("#0.00").format(tyle)))
            .build());

            if (highScoreModel1 != null) {
                return highScoreRepository.findHighScoreModelByUserModel(userModel);
            } else {
                return null;
            }
        } else {
            String oReward = "";
            String nReward = "";
            String[] oldReward = highScoreModel.getBestreward().split("\\.");
            String[] newReward = highScoreDTO.getBestreward().split("\\.");
            for (int i = 0; i < oldReward.length; i++) {
                oReward +=oldReward[i];
            }

            for (int i = 0; i < newReward.length; i++) {
                nReward +=newReward[i];
            }
            if (Double.parseDouble(oReward) <= Double.parseDouble(nReward)) {
                int i = highScoreRepository.update(highScoreDTO.getBestplay(), highScoreDTO.getBestreward(), formatter.format(date)
                        , (highScoreModel.getLanchoi() + 1), Double.parseDouble(new DecimalFormat("#0.00").format(((double) (highScoreModel.getTongsocautraloidung() + highScoreDTO.getBestplay())
                                /((double) (highScoreModel.getLanchoi() + 1)* 15) *100))), (highScoreModel.getTongsocautraloidung() + highScoreDTO.getBestplay()), userModel);
                if (i == 1) {
                    return highScoreRepository.findHighScoreModelByUserModel(userModel);
                } else {
                    return null;
                }
            } else {
                int i = highScoreRepository.updateTyLe((highScoreModel.getLanchoi() + 1), Double.parseDouble(new DecimalFormat("#0.00").format(((double) (highScoreModel.getTongsocautraloidung() + highScoreDTO.getBestplay())
                                /((double) (highScoreModel.getLanchoi() + 1)* 15) *100))), (highScoreModel.getTongsocautraloidung() + highScoreDTO.getBestplay()), userModel);
                if (i == 1) {
                    return highScoreRepository.findHighScoreModelByUserModel(userModel);
                } else {
                    return null;
                }
            }
        }

    }

//    public HighScoreModel getTest(int id) {
//        return highScoreRepository.findHighScoreModelById(id);
//    }
}

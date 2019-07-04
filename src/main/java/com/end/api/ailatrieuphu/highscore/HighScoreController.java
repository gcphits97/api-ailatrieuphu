package com.end.api.ailatrieuphu.highscore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/highscore")
public class HighScoreController {
    @Autowired
    HighScoreBusiness highScoreBusiness;

    @GetMapping(path = "/get")
    public ResponseEntity<List<HighScoreModel>> getHighScore() {
        return ResponseEntity.ok(highScoreBusiness.getHighScore());
    }

    @PostMapping(path = "/create-update")
    public ResponseEntity<HighScoreModel> highScoreCRU(@RequestBody HighScoreDTO highScoreDTO) {
        if (highScoreBusiness.createOrUpdate(highScoreDTO) == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(highScoreBusiness.createOrUpdate(highScoreDTO));
        }
    }

//    @GetMapping(path = "/getTest/{id}")
//    public ResponseEntity<HighScoreModel> getHSbyID(@PathVariable int id) {
//        return ResponseEntity.ok(highScoreBusiness.getTest(id));
//    }
}

package com.ford.fs.powerup.bowling.score;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ScoreWithArrays {

    List<Integer> pins = new ArrayList<>();
    public int bowlingScore(int pinScore) {
        pins.add(pinScore);

        return calculateScore();
    }

    int framescore;
    int totalScore=0;


    private int calculateScore() {


        for(int i =0; i<pins.size();i++) {
           if(!(i%2 == 0)) {
               framescore = pins.get(i);
               return totalScore;
           }else{
                framescore += pins.get(i);
                totalScore += framescore;
                framescore = 0;
           }
        }
        return totalScore;
    }
}

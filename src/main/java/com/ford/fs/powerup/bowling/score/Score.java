package com.ford.fs.powerup.bowling.score;

import org.springframework.stereotype.Component;


@Component
public class Score {
    int totalScore = 0;
    int prevRoll = 0;
    int frameSize= 0;
    public int calculateScore(int pins) {

        if(frameSize == 0){
            prevRoll = pins;
            frameSize++;
            return 0;
        }
        totalScore = prevRoll+pins;
        return totalScore;
    }
}

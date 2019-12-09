package com.ford.fs.powerup.bowling.score;

import org.springframework.stereotype.Component;


@Component
public class Score {
    int totalScore = 0;
    int frameSize = 0;
    int rollCount= 0;
    int frameScore = 0;
    boolean isSpare = false;

    public int calculateScore(int pins) {
        if(isSpare){
            totalScore += pins;
            frameScore = pins;
            isSpare = false;
            rollCount++;
            return totalScore;
        }
        if(pins>10){
            throw new IllegalArgumentException("pin cannot be more than 10");
        }
        if(rollCount % 2 == 0){
            frameScore=0;
            frameScore = pins;
            rollCount++;
            return totalScore;
        }

        frameScore +=pins;
        totalScore += frameScore;
        rollCount++;
        if(frameScore==10){
            isSpare = true;
            return 0;
        }

        return totalScore;
    }
}

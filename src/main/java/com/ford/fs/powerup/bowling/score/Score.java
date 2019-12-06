package com.ford.fs.powerup.bowling.score;

import org.springframework.stereotype.Component;


@Component
public class Score {
    int totalScore = 0;
    int prevRoll = 0;
    int rollCount= 0;
    public int calculateScore(int pins) {
        if(pins>10){
            throw new IllegalArgumentException("pin cannot be more than 10");
        }
        if(rollCount % 2 ==0){
            prevRoll = pins;
            rollCount++;
            return totalScore;
        }
        totalScore += prevRoll + pins;
        rollCount++;
        return totalScore;
    }
}

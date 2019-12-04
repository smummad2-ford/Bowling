package com.ford.fs.powerup.bowling.score;

import org.springframework.stereotype.Component;


@Component
public class Score {

    public int calculateScore(int pins) {
        return pins;
    }
}

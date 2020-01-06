package com.ford.fs.powerup.bowling.game;

public class Frame {
    private int frameScore;
    private int rollCount;

    public int getScore() {
        if(rollCount==1)
            return 0;
        return frameScore;
    }

    public void addPins(int pins) {
        rollCount++;
        frameScore += pins;
    }
}

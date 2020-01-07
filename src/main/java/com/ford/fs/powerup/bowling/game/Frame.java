package com.ford.fs.powerup.bowling.game;

public class Frame {
    private int frameScore;
    private int rollCount;
    private boolean isClosed;
    private boolean isSpare;
    private Roll roll;

    public int getScore() {
        if(!isClosed || isSpare)
            return 0;
        return frameScore;
    }

    public void addPins(int pins) {
        rollCount++;
        if(rollCount == 2) {
            isClosed = true;
        }
        frameScore += pins;
        if(frameScore==10){
            isSpare=true;
        }
    }

    public boolean isClosed() {
        return isClosed;
    }

}

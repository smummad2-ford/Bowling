package com.ford.fs.powerup.bowling.game;

public class Frame {
    private int rollCount;
    private boolean isClosed;
    int[] rolls =new int[2];

    public int getScore() {
        if(rollCount != 2)
            return 0;
        return rolls[0]+rolls[1];
    }

    public int addPins(int pins) {
        if(rollCount == 2) {
            return pins;
        }
        rolls[rollCount++] = pins;
        return -1;
    }

    public boolean isClosed() {
        return isClosed;
    }

}

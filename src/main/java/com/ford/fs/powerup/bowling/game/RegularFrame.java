package com.ford.fs.powerup.bowling.game;

public class RegularFrame extends Frame {
    private int rollCount;
    int[] rolls = new int[2];

    @Override
    public int getScore() {
        if (rollCount != 2)
            return 0;
        return rolls[0] + rolls[1];
    }

    @Override
    public int addPins(int pins) {
        if (rollCount == 2) {
            return pins;
        }
        rolls[rollCount++] = pins;
        return -1;
    }
}

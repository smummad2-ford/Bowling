package com.ford.fs.powerup.bowling.game;

public abstract class Frame {

    protected Context context;

    public abstract int getScore();

    public abstract int addPins(int pins);

    public Frame(Context context) {
        this.context = context;
    }
}

package com.ford.fs.powerup.bowling.game;

import java.util.List;

public abstract class Frame {

    protected Context context;
    protected List<Integer> rolls;

    public abstract int getScore();

    public abstract int addPins(int pins);

    public Frame(Context context, List<Integer> rolls) {
        this.context = context;
        this.rolls = rolls;
    }
}

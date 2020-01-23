package com.ford.fs.powerup.bowling.game;

import java.util.List;

public class StrikeFrame extends Frame {
    public StrikeFrame(Context context, List<Integer> rolls) {
        super(context,rolls);
    }

    @Override
    public int getScore() {
        if(rolls.size()<3)
            return 0;
        return rolls.get(0)+rolls.get(1)+rolls.get(2);
    }

    @Override
    public boolean isComplete() {
        return rolls.size()==3;
    }

    @Override
    public int addPins(int pins) {
        if(rolls.size()<=3)
            rolls.add(pins);
        return pins;
    }
}

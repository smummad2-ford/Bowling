package com.ford.fs.powerup.bowling.game;

import java.util.ArrayList;
import java.util.List;

public class RegularFrame extends Frame {
    List<Integer> rolls = new ArrayList<>();

    public RegularFrame(Context context) {
        super(context);
    }

    @Override
    public int getScore() {
        if (rolls.size() != 2)
            return 0;
        return rolls.get(0) + rolls.get(1);
    }

    @Override
    public int addPins(int pins) {
        if (rolls.size() == 2) {
            return pins;
        }
        rolls.add(pins);
        Integer pinsSum=0;
        for(int roll:rolls)
            pinsSum+=roll;
        if (pinsSum == 10){
            if(rolls.size() == 2)
            context.updateState( new SpareFrame(context, rolls));
            else
                context.updateState(new StrikeFrame(context, rolls));
        }
        return -1;
    }
}

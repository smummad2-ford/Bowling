package com.ford.fs.powerup.bowling.game;

import java.util.List;

public class SpareFrame extends Frame {


    private List<Integer> rolls;
    boolean isCalled = false;

    public SpareFrame(Context context, List<Integer> rolls) {
        super(context);
        this.rolls = rolls;
    }

    public  int getScore(){
        if(!isCalled) return 0;
        return rolls.get(0) + rolls.get(1) + rolls.get(2);
    }

    public  int addPins(int pins){
         isCalled = true;
         this.rolls.add(pins);
         return pins;
    }
}

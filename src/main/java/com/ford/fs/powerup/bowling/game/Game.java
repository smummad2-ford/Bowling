package com.ford.fs.powerup.bowling.game;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Context> contextList = new ArrayList<>();
    private Context newContext;

    public void roll(int pins){
        if(contextList.isEmpty()){
            newContext = new Context();
            contextList.add(newContext);
        }
        for(Context context:contextList) {
            if (context.addPins(pins) == -1) {
               return;
            }
        }

        newContext = new Context();
        newContext.addPins(pins);
        contextList.add(newContext);

    }

    public int calculateScore(int pins) {

        if (contextList.size()> 10 && contextList.get(9).isComplete()) {

            throw new RuntimeException("game ended");

        }
        roll(pins);

        int totalScore = 0;

        for (Context context : contextList) {
            totalScore += context.getScore();
        }

        return totalScore;
    }
}

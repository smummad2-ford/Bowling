package com.ford.fs.powerup.bowling.game;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Context> contextList = new ArrayList<>();
    private Context currentFrame;

    public void roll(int pins){
        if(contextList.isEmpty()){
            currentFrame = new Context();
            contextList.add(currentFrame);
        }
        if(currentFrame.addPins(pins)>-1)
        {
            currentFrame = new Context();
            currentFrame.addPins(pins);
            contextList.add(currentFrame);
        }
    }

    public int calculateScore(int pins) {
        roll(pins);
        int totalScore = 0;
        for(Context context : contextList) {
                totalScore += context.getScore();
        }
        return totalScore;
    }
}

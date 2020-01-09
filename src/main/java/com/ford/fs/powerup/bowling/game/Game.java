package com.ford.fs.powerup.bowling.game;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Frame> framesList = new ArrayList<>();
    private Frame currentFrame;

    public void roll(int pins){
        if(framesList.isEmpty()){
            currentFrame = new RegularFrame();
            framesList.add(currentFrame);
        }
        if(currentFrame.addPins(pins)>-1)
        {
            currentFrame = new RegularFrame();
            currentFrame.addPins(pins);
            framesList.add(currentFrame);
        }
    }

    public int calculateScore(int pins) {
        roll(pins);
        int totalScore = 0;
        for(Frame frame : framesList) {
                totalScore += frame.getScore();
        }
        return totalScore;
    }
}

package com.ford.fs.powerup.bowling.game;

public class Game {

    private Frame frame = new Frame();

    //Add pins -> Frames
    public void roll(int pins){
        frame.addPins(pins);
    }

    public int calculateScore(int pins) {
        roll(pins);
        int score = frame.getScore();
        return score;
    }
}

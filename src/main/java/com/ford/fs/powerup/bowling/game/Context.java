package com.ford.fs.powerup.bowling.game;

import java.util.ArrayList;

public class Context {

    Frame currentState;

    Context () {
        currentState = new RegularFrame(this, new ArrayList<>());
    }

    public boolean isComplete()
    {
        return currentState.isComplete();
    }

    public void updateState(Frame newState){
        currentState =  newState;
    }

    public int getScore(){
        return currentState.getScore();
    }

    public  int addPins(int pins){
        return currentState.addPins(pins);
    }
}

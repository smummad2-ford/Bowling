package com.ford.fs.powerup.bowling.game;

public class Context {

    Frame currentState;

    Context () {
        currentState = new RegularFrame(this);
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

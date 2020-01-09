package com.ford.fs.powerup.bowling.game;

public class Context {

    Frame currentState;

    Context () {
        currentState = new RegularFrame();
    }

    public void updateState(Frame newState){
        currentState =  newState;
    }
}

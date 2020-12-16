package states;

import java.awt.*;

import Game.*;


public abstract class State {
    private static State currentState = null;

    public static State getCurrentState() {
        return currentState;
    }

    public static void setCurrentState(State currentState) {
        State.currentState = currentState;
    }

    //CLASS
    protected Handler handler;
    public State(Handler handler) {
        this.handler = handler ;
    }
    public abstract void tick();
    public abstract void render(Graphics g);
}

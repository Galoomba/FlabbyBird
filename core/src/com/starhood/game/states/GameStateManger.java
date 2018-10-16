package com.starhood.game.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

/**
 * Created by starhood on 02/10/18.
 */

public class GameStateManger {
    private Stack<State> states;

    public GameStateManger(){
        states=new Stack<State>();
    }

    public void push(State state){
        states.push(state);
    }
    public void pop(){
        states.pop().dispose();
    }
    public void set(State state){
        states.pop().dispose();
        states.push(state);
    }

    public void update(float dt){
        states.peek().update(dt);
    }

    public void render(SpriteBatch sp){
        states.peek().render(sp);
    }
}

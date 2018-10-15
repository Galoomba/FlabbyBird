package com.starhood.game.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by starhood on 02/10/18.
 */

public abstract class State {

    protected OrthographicCamera cam;
    protected Vector3 mouse;
    protected GameStateManger gsm;

    public State(GameStateManger gsm)
    {
        this.gsm=gsm;
        this.mouse=new Vector3();
        this.cam=new OrthographicCamera();
    }


    protected abstract void handleInput();
    public abstract void update(float dt);
    public abstract void render (SpriteBatch sb);
    public abstract void dispose();
}

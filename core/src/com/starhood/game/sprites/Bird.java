package com.starhood.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

import java.util.Stack;

/**
 * Created by starhood on 15/10/18.
 */

public class Bird {
    private static final int GRAVITY=-10;

    private Vector3 position;
    private Vector3 velocity;
    private Texture bird;

    public Vector3 getPosition() {
        return position;
    }

    public Texture getBird() {
        return bird;
    }

    public Bird(int x, int y){
        bird=new Texture("bird.png");
        position =new Vector3(x,y,0);
        velocity= new Vector3(0,0,0);
    }

    public void update(float dt){
        velocity.add(0,GRAVITY,0);
        velocity.scl(dt);
        position.add(0,velocity.y,0);
        velocity.scl(1/dt);
    }
}

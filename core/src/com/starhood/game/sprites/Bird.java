package com.starhood.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

import java.util.Stack;

/**
 * Created by starhood on 15/10/18.
 */

public class Bird {
    private static final int GRAVITY=-15;
    private static final int MOVEMENT=100;

    private Vector3 position;
    private Vector3 velocity;
    private Texture bird;
    private Sound flap;

    private Rectangle bounds;

    public Vector3 getPosition() {
        return position;
    }

    public Texture getBird() {
        return bird;
    }

    public Bird(int x, int y,String birdType, String flap){
        bird=new Texture(birdType);
        position =new Vector3(x,y,0);
        velocity= new Vector3(0,0,0);
        bounds=new Rectangle(x,y,bird.getWidth(),bird.getHeight());
        this.flap= Gdx.audio.newSound(Gdx.files.internal(flap));
    }

    public void update(float dt){
        movement(dt);
    }

    private void movement(float dt) {
        if (position.y>0)
            velocity.add(0,GRAVITY,0);
        velocity.scl(dt);
        position.add(MOVEMENT*dt,velocity.y,0);
        if(position.y<0)
            position.y=0;
        velocity.scl(1/dt);

        bounds.setPosition(position.x,position.y);
    }

    public void jump(){
        velocity.y=250;
        flap.play(0.4f);
    }

    public Rectangle getBounds(){
        return bounds;
    }

    public void dispose(){
        bird.dispose();
        flap.dispose();
    }
}

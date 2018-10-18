package com.starhood.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by starhood on 18/10/18.
 */

public class Ground {
    private Texture ground;
    private Vector2 position1, position2;

    public Ground(float x, float y){
        ground=new Texture("ground.png");
        position1=new Vector2(x,y);
        position2=new Vector2(x+ground.getWidth(),y);
    }

    public Texture getGround() {
        return ground;
    }

    public Vector2 getPosition1() {
        return position1;
    }

    public Vector2 getPosition2() {
        return position2;
    }

    public void dispose(){
        ground.dispose();
    }
}

package com.starhood.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by starhood on 16/10/18.
 */

public class PlayButton {

    private Vector2 position;
    private Texture playButton;
    private Rectangle bounds;

    public PlayButton(float x, float y,String path){
        playButton=new Texture(path);
        position=new Vector2(x,y);
        bounds=new Rectangle(x,y,50,30);
    }

    public Texture getPlayButton() {
        return playButton;
    }

    public Rectangle getBounds(){
        return bounds;
    }

    public Vector2 getPosition() {
        return position;
    }

    public int getWidth(){
        return playButton.getWidth();
    }

    public int getHeight(){
        return playButton.getHeight();
    }

    public void dispose(){
        playButton.dispose();
    }
}

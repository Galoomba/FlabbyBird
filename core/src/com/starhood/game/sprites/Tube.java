package com.starhood.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

/**
 * Created by starhood on 15/10/18.
 */

public class Tube {
    private static final int FLUCTUATION=130;
    private static final int TUBE_GAP=100;
    private static final int LOWEST_OPENING=120;

    private Texture topTube,botTube;
    private Vector2 posTopTube,posBotTube;

    private Random rand;

    public Texture getTopTube() {
        return topTube;
    }

    public Texture getBotTube() {
        return botTube;
    }

    public Vector2 getPosTopTube() {
        return posTopTube;
    }

    public Vector2 getPosBotTube() {
        return posBotTube;
    }

    public Tube(int x){
        topTube=new Texture("toptube.png");
        botTube=new Texture("bottomtube.png");
        rand=new Random();

        posTopTube =new Vector2(x,rand.nextInt(FLUCTUATION)+TUBE_GAP+LOWEST_OPENING);
        posBotTube=new Vector2(x,posTopTube.y-TUBE_GAP-botTube.getHeight());

    }

    public void reposition(float x){
        posTopTube.set(x,rand.nextInt(FLUCTUATION)+TUBE_GAP+LOWEST_OPENING);
        posBotTube.set(x,posTopTube.y-TUBE_GAP-botTube.getHeight());
    }
}

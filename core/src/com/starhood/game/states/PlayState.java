package com.starhood.game.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.starhood.game.FlabbyBirdDemo;

/**
 * Created by starhood on 15/10/18.
 */

public class PlayState extends State {
    private Texture bird;

    public PlayState(GameStateManger gsm) {
        super(gsm);
        bird=new Texture("bird.png");
        cam.setToOrtho(false, FlabbyBirdDemo.WIDTH/2,FlabbyBirdDemo.HEIGHT/2);

    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(bird,50,50);
        sb.end();
    }

    @Override
    public void dispose() {

    }
}

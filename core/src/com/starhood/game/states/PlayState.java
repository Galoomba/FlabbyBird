package com.starhood.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.starhood.game.FlabbyBirdDemo;
import com.starhood.game.sprites.Bird;

/**
 * Created by starhood on 15/10/18.
 */

public class PlayState extends State {

    private Bird bird;

    public PlayState(GameStateManger gsm) {
        super(gsm);
        bird=new Bird(50,200);
        cam.setToOrtho(false, FlabbyBirdDemo.WIDTH/2,FlabbyBirdDemo.HEIGHT/2);

    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched())
            bird.jump();
    }

    @Override
    public void update(float dt) {
        handleInput();
        bird.update(dt);
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(bird.getBird(), bird.getPosition().x,bird.getPosition().y);
        sb.end();
    }

    @Override
    public void dispose() {

    }
}

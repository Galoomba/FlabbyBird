package com.starhood.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.starhood.game.FlabbyBirdDemo;

/**
 * Created by starhood on 02/10/18.
 */

public class MenuState extends State {

    private Texture background;
    private Texture playButton;


    public MenuState(GameStateManger gsm) {
        super(gsm);
        background=new Texture("background.png");
        playButton=new Texture("playbtn.png");
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            gsm.set(new PlayState(gsm));
            dispose();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background,0,0, FlabbyBirdDemo.WIDTH,FlabbyBirdDemo.HEIGHT);
        sb.draw(playButton,(FlabbyBirdDemo.WIDTH/2)-(playButton.getWidth()/2),FlabbyBirdDemo.HEIGHT/2);
        sb.end();
    }

    @Override
    public void dispose() {
        playButton.dispose();
        background.dispose();
    }
}

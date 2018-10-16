package com.starhood.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.starhood.game.FlabbyBirdDemo;
import com.starhood.game.sprites.PlayButton;

/**
 * Created by starhood on 02/10/18.
 */

public class MenuState extends State {

    private Texture background;
    private PlayButton playButton;


    public MenuState(GameStateManger gsm) {
        super(gsm);
        background=new Texture("background.png");
        playButton=new PlayButton(50,150);
        cam.setToOrtho(false, FlabbyBirdDemo.WIDTH/2,FlabbyBirdDemo.HEIGHT/2);
    }

    @Override
    public void handleInput() {

        if(Gdx.input.justTouched()){
            Vector3 tmp=new Vector3(Gdx.input.getX(),Gdx.input.getY(),0);
            cam.unproject(tmp);
            if(playButton.getBounds().contains(tmp.x,tmp.y))
            {
                gsm.set(new PlayState(gsm,"bird.png"));
            }
            else
                gsm.set(new PlayState(gsm,"bird10.png"));
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(background,0,0);
        sb.draw(playButton.getPlayButton(),playButton.getPosition().x,playButton.getPosition().y);
        sb.end();
    }

    @Override
    public void dispose() {
        playButton.dispose();
        background.dispose();
    }
}

package com.starhood.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.starhood.game.FlabbyBirdDemo;

/**
 * Created by starhood on 02/10/18.
 */

public class MenuState extends State {

    private Texture background;
    private Texture playButton;

    private Vector2 playButtonPosition;

    public MenuState(GameStateManger gsm) {
        super(gsm);
        background=new Texture("background.png");
        playButton=new Texture("playbtn.png");
        playButtonPosition=new Vector2((FlabbyBirdDemo.WIDTH/2)-(playButton.getWidth()/2),FlabbyBirdDemo.HEIGHT/2);
    }

    @Override
    public void handleInput() {

        if(Gdx.input.justTouched()){
            Vector3 tmp=new Vector3(Gdx.input.getX(),Gdx.input.getY(),0);
            Rectangle textureBounds=new Rectangle(150,300,playButton.getWidth(),playButton.getHeight());
            if(textureBounds.contains(tmp.x,tmp.y))
            {
                gsm.set(new PlayState(gsm,"bird.png"));
            }
            else
                gsm.set(new PlayState(gsm,"bird10.png"));
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
        sb.draw(playButton,playButtonPosition.x,playButtonPosition.y);
        sb.end();
    }

    @Override
    public void dispose() {
        playButton.dispose();
        background.dispose();
    }
}

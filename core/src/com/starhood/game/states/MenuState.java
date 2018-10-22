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
    private PlayButton playButton1,playButton2,playButton3,playButton4,playButton5,playButton6,playButton8,playButton9,playButton10,playButton11,playButton12;



    public MenuState(GameStateManger gsm) {
        super(gsm);
        background=new Texture("background.png");
        playButton1=new PlayButton(15,250,"playbtn1.png");
        playButton2=new PlayButton(80,250,"playbtn2.png");
        playButton3=new PlayButton(140,250,"playbtn3.png");
        playButton4=new PlayButton(15,200,"playbtn4.png");
        playButton5=new PlayButton(80,200,"playbtn5.png");
        playButton6=new PlayButton(140,200,"playbtn6.png");
        playButton8=new PlayButton(15,150,"playbtn8.png");
        playButton9=new PlayButton(80,150,"playbtn9.png");
        playButton10=new PlayButton(140,150,"playbtn10.png");
        playButton11=new PlayButton(45,100,"playbtn11.png");
        playButton12=new PlayButton(105,100,"playbtn12.png");
        cam.setToOrtho(false, FlabbyBirdDemo.WIDTH/2,FlabbyBirdDemo.HEIGHT/2);
    }

    @Override
    public void handleInput() {

        if(Gdx.input.justTouched()){
            Vector3 tmp=new Vector3(Gdx.input.getX(),Gdx.input.getY(),0);
            cam.unproject(tmp);
            if(playButton1.getBounds().contains(tmp.x,tmp.y))
                gsm.set(new PlayState(gsm,"bird1.png","sfx_wing.ogg"));
            else if(playButton2.getBounds().contains(tmp.x,tmp.y))
                gsm.set(new PlayState(gsm,"bird2.png","sfx_wing.ogg"));
            else if(playButton3.getBounds().contains(tmp.x,tmp.y))
                gsm.set(new PlayState(gsm,"bird3.png","sfx_wing.ogg"));
            else if(playButton4.getBounds().contains(tmp.x,tmp.y))
                gsm.set(new PlayState(gsm,"bird4.png","sfx_bat.ogg"));
            else if(playButton5.getBounds().contains(tmp.x,tmp.y))
                gsm.set(new PlayState(gsm,"bird5.png","sfx_wings2.ogg"));
            else if(playButton6.getBounds().contains(tmp.x,tmp.y))
                gsm.set(new PlayState(gsm,"bird6.png","sfx_hen.ogg"));
            else if(playButton8.getBounds().contains(tmp.x,tmp.y))
                gsm.set(new PlayState(gsm,"bird8.png","sfx_bat.ogg"));
            else if(playButton9.getBounds().contains(tmp.x,tmp.y))
                gsm.set(new PlayState(gsm,"bird9.png","sfx_wings2.ogg"));
            else if(playButton10.getBounds().contains(tmp.x,tmp.y))
                gsm.set(new PlayState(gsm,"bird10.png","sfx_hen.ogg"));
            else if(playButton11.getBounds().contains(tmp.x,tmp.y))
                gsm.set(new PlayState(gsm,"bird11.png","sfx_bat.ogg"));
            else if(playButton12.getBounds().contains(tmp.x,tmp.y))
                gsm.set(new PlayState(gsm,"bird12.png","sfx_wings2.ogg"));

            else
                gsm.set(new PlayState(gsm,"bird.png","sfx_wings2.ogg"));
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
        sb.draw(playButton1.getPlayButton(),playButton1.getPosition().x,playButton1.getPosition().y,50,30);
        sb.draw(playButton2.getPlayButton(),playButton2.getPosition().x,playButton2.getPosition().y,50,30);
        sb.draw(playButton3.getPlayButton(),playButton3.getPosition().x,playButton3.getPosition().y,50,30);
        sb.draw(playButton4.getPlayButton(),playButton4.getPosition().x,playButton4.getPosition().y,50,30);
        sb.draw(playButton5.getPlayButton(),playButton5.getPosition().x,playButton5.getPosition().y,50,30);
        sb.draw(playButton6.getPlayButton(),playButton6.getPosition().x,playButton6.getPosition().y,50,30);
        sb.draw(playButton8.getPlayButton(),playButton8.getPosition().x,playButton8.getPosition().y,50,30);
        sb.draw(playButton9.getPlayButton(),playButton9.getPosition().x,playButton9.getPosition().y,50,30);
        sb.draw(playButton10.getPlayButton(),playButton10.getPosition().x,playButton10.getPosition().y,50,30);
        sb.draw(playButton11.getPlayButton(),playButton11.getPosition().x,playButton11.getPosition().y,50,30);
        sb.draw(playButton12.getPlayButton(),playButton12.getPosition().x,playButton12.getPosition().y,50,30);
        sb.end();
    }

    @Override
    public void dispose() {
        playButton1.dispose();
        background.dispose();
    }
}

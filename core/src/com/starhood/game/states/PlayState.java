package com.starhood.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.starhood.game.FlabbyBirdDemo;
import com.starhood.game.sprites.Bird;
import com.starhood.game.sprites.Tube;

/**
 * Created by starhood on 15/10/18.
 */

public class PlayState extends State {

    private Bird bird;
    private Tube tube;
    private Texture bg;

    public PlayState(GameStateManger gsm) {
        super(gsm);
        bg=new Texture("background.png");
        bird=new Bird(50,200);
        tube=new Tube(100);
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
        sb.draw(bg,cam.position.x -(cam.viewportWidth/2),0);
        sb.draw(bird.getBird(), bird.getPosition().x,bird.getPosition().y);
        sb.draw(tube.getTopTube(),tube.getPosTopTube().x,tube.getPosTopTube().y);
        sb.draw(tube.getBotTube(),tube.getPosBotTube().x,tube.getPosBotTube().y);
        sb.end();
    }

    @Override
    public void dispose() {

    }
}

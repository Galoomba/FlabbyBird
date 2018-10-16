package com.starhood.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.starhood.game.FlabbyBirdDemo;
import com.starhood.game.sprites.Bird;
import com.starhood.game.sprites.Tube;

/**
 * Created by starhood on 15/10/18.
 */

public class PlayState extends State {
    private static final int TUBE_SPACING=125;
    private static final int TUBE_COUNT=4;

    private Bird bird;
    private Array<Tube> tubes;
    private Texture bg;

    public PlayState(GameStateManger gsm,String birdType) {
        super(gsm);
        bg=new Texture("background.png");
        bird=new Bird(50,200,birdType);
        cam.setToOrtho(false, FlabbyBirdDemo.WIDTH/2,FlabbyBirdDemo.HEIGHT/2);

        tubes=new Array<Tube>();
        for (int i =1 ;i<=TUBE_COUNT;i++)
        {
            tubes.add(new Tube(i *(TUBE_SPACING+Tube.TUBE_WIDTH)));
        }
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
        cam.position.x=bird.getPosition().x+80;
        tubesReposition();
        cam.update();
    }


    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(bg,cam.position.x -(cam.viewportWidth/2),0);
        sb.draw(bird.getBird(), bird.getPosition().x,bird.getPosition().y);
        for (Tube tube : tubes) {
            sb.draw(tube.getTopTube(), tube.getPosTopTube().x, tube.getPosTopTube().y);
            sb.draw(tube.getBotTube(), tube.getPosBotTube().x, tube.getPosBotTube().y);
        }
        sb.end();
    }

    @Override
    public void dispose() {

    }

    private void tubesReposition(){
        for (Tube tube:tubes){
            if (cam.position.x -(cam.viewportWidth/2)>tube.getPosTopTube().x+tube.getTopTube().getWidth())
                tube.reposition(tube.getPosTopTube().x+((Tube.TUBE_WIDTH+TUBE_SPACING)*TUBE_COUNT));
        }
    }
}

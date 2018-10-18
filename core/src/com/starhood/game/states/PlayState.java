package com.starhood.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.starhood.game.FlabbyBirdDemo;
import com.starhood.game.sprites.Bird;
import com.starhood.game.sprites.Ground;
import com.starhood.game.sprites.Score;
import com.starhood.game.sprites.Tube;

/**
 * Created by starhood on 15/10/18.
 */

public class PlayState extends State {
    private static final int TUBE_SPACING=125;
    private static final int TUBE_COUNT=4;

    private BitmapFont score;
    private Bird bird;
    private Ground ground;
    private Array<Tube> tubes;
    private Texture bg;

    public PlayState(GameStateManger gsm,String birdType) {
        super(gsm);
        bg=new Texture("background.png");
        bird=new Bird(50,200,birdType);
        ground=new Ground(cam.position.x - cam.viewportWidth/2,-50);
        cam.setToOrtho(false, FlabbyBirdDemo.WIDTH/2,FlabbyBirdDemo.HEIGHT/2);
        score=new BitmapFont();

        tubes=new Array<Tube>();
        for (int i =1 ;i<=TUBE_COUNT;i++)
            tubes.add(new Tube(i *(TUBE_SPACING+Tube.TUBE_WIDTH)));

    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched())
            bird.jump();
    }

    @Override
    public void update(float dt) {
        handleInput();
        updateGround();
        bird.update(dt);
        cam.position.x=bird.getPosition().x+80;
        tubesReposition();
        birdOnGround();
        cam.update();
    }

    private void birdOnGround() {
        if (bird.getPosition().y<= ground.getGround().getHeight()+-50)
            gsm.set(new MenuState(gsm));
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
        sb.draw(ground.getGround(),ground.getPosition1().x,ground.getPosition1().y);
        sb.draw(ground.getGround(),ground.getPosition2().x,ground.getPosition2().y);

        score.setColor(1.0f, 1.0f, 1.0f, 1.0f);
        score.draw(sb, Score.getScore(), (cam.position.x +(cam.viewportWidth/2))- (score.getSpaceWidth()+15), cam.viewportHeight-(score.getSpaceWidth()*2));
        sb.end();
    }

    @Override
    public void dispose() {
        bg.dispose();
        bird.dispose();
        ground.dispose();
        for (Tube tube :tubes){
            tube.dispose();
        }
    }

    private void tubesReposition(){
        for (int i=0 ;i<tubes.size;i++){
            Tube tube=tubes.get(i);
            if (cam.position.x -(cam.viewportWidth/2)>tube.getPosTopTube().x+tube.getTopTube().getWidth())
            {
                tube.reposition(tube.getPosTopTube().x+((Tube.TUBE_WIDTH+TUBE_SPACING)*TUBE_COUNT));
                Score.addScore();
                Score.printScore();
            }

            if (tube.collides(bird.getBounds()))
            {
                gsm.set(new MenuState(gsm));
                Score.clearScore();
            }
        }
    }

    private void updateGround(){
        if (cam.position.x-(cam.viewportWidth/2)>ground.getPosition1().x+ground.getGround().getWidth())
            ground.getPosition1().add(ground.getGround().getWidth()*2,0);
        if (cam.position.x-(cam.viewportWidth/2)>ground.getPosition2().x+ground.getGround().getWidth())
            ground.getPosition2().add(ground.getGround().getWidth()*2,0);
    }
}

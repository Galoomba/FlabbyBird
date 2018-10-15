package com.starhood.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.starhood.game.states.GameStateManger;
import com.starhood.game.states.MenuState;

public class FlabbyBirdDemo extends ApplicationAdapter {
	public static final int WIDTH=400;
	public static final int HEIGHT=800;
	public static final String TITLE="Flabby Birds";

	private GameStateManger gsm;
	private SpriteBatch batch;

	//Create the screen good
	@Override
	public void create () {
		batch = new SpriteBatch();
		gsm=new GameStateManger();
		Gdx.gl.glClearColor(1, 0, 0, 1);
		gsm.push(new MenuState(gsm));
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);
       //render note

	}
	
	@Override
	public void dispose () {
		batch.dispose();

	}
}

package com.starhood.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.starhood.game.FlabbyBirdDemo;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width=FlabbyBirdDemo.WIDTH;
		config.height=FlabbyBirdDemo.HEIGHT;
		config.title=FlabbyBirdDemo.TITLE;
		new LwjglApplication(new FlabbyBirdDemo(), config);
	}
}

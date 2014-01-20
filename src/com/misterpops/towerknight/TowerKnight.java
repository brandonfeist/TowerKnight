package com.misterpops.towerknight;

import com.badlogic.gdx.Game;
import com.misterpops.towerknight.Screens.SplashScreen;

public class TowerKnight extends Game {
	
	public static final String VERSION = "0.0.0.01 Pre-Alpha";
	public static final String LOG = "Tower Knight";
	
	@Override
	public void create() {
		setScreen(new SplashScreen(this));
	}

	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}
}

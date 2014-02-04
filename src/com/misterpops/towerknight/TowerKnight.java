package com.misterpops.towerknight;

import com.badlogic.gdx.Game;
import com.misterpops.towerknight.Screens.MainMenu;

public class TowerKnight extends Game {
	
	public static final String VERSION = "0.0.0.03 Pre-Alpha";
	public static final String LOG = "Tower Knight";
	public static final int TILE_SIZE = 32;
	public static final int COL_TILE_SIZE = 16;
	
	@Override
	public void create() {
		//setScreen(new SplashScreen(this));
		setScreen(new MainMenu(this));
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

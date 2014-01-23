package com.misterpops.towerknight.Screens;

import com.badlogic.gdx.Screen;
import com.misterpops.towerknight.TowerKnight;
import com.misterpops.towerknight.Level.World;
import com.misterpops.towerknight.Rendering.WorldRender;

public class Game implements Screen{
	
	TowerKnight game;
	World world;
	WorldRender render;
	
	public Game(TowerKnight game) {
		this.game = game;
		world = new World(game);
		render = new WorldRender(world);
	}

	@Override
	public void render(float delta) {
		world.update();
		render.render();
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void show() {
		
	}

	@Override
	public void hide() {
		dispose();
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void dispose() {
		world.dispose();
	}

}

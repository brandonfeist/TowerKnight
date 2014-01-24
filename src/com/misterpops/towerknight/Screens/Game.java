package com.misterpops.towerknight.Screens;

import com.badlogic.gdx.Screen;
import com.misterpops.towerknight.TowerKnight;
import com.misterpops.towerknight.Level.World;
import com.misterpops.towerknight.Rendering.Textures;
import com.misterpops.towerknight.Rendering.WorldRender;

public class Game implements Screen{
	
	TowerKnight game;
	World world;
	WorldRender render;
	Textures textures;
	
	public Game(TowerKnight game) {
		this.game = game;
		textures = new Textures();			//Loads textures.
		world = new World(game);			//Creates the world
		render = new WorldRender(world);	//Creates new world renderer.
	}

	@Override
	public void render(float delta) {
		world.update(delta);
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

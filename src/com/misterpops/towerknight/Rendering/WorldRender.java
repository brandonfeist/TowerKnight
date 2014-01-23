package com.misterpops.towerknight.Rendering;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.misterpops.towerknight.Entities.Mob.Knight;
import com.misterpops.towerknight.Level.World;

public class WorldRender {
	
	World world;
	SpriteBatch batch;
	Texture knightTexture;
	Knight knight;
	Camera cam;
	
	public WorldRender(World world) {
		this.world = world;
		batch = new SpriteBatch();
		cam = new OrthographicCamera();
		knightTexture = new Texture("data/mobs/knight_standing0.png");
	}
	
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		knight = world.getKnight();
		batch.begin();
		batch.draw(knightTexture, knight.getPosistion().x, knight.getPosistion().y);
		batch.end();
	}
	
	public void dispose() {
		batch.dispose();
		knightTexture.dispose();
	}

}

package com.misterpops.towerknight.Rendering;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.misterpops.towerknight.Entities.Mob.Knight;
import com.misterpops.towerknight.Level.World;

public class WorldRender {
	
	World world;
	SpriteBatch batch;
	ShapeRenderer sr;
	Knight knight;
	Camera cam;
	float width, height;
	
	public WorldRender(World world) {
		this.world = world;
		width = Gdx.graphics.getWidth() / 4;  // / scale;
		height = Gdx.graphics.getHeight() / 4; // / scale;
		
		//Camera intialization.
		cam = new OrthographicCamera();
		((OrthographicCamera) cam).setToOrtho(false, width, height);
		cam.update();
		
		batch = new SpriteBatch();
		batch.setProjectionMatrix(cam.combined);
		
		//Shape drawing initialization, for AABB boxes.
		sr = new ShapeRenderer();
		sr.setColor(Color.CYAN);
	}
	
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		knight = world.getKnight();
		cam.position.set(knight.getPosistion().x, knight.getPosistion().y, 0);
		cam.update();
		
		//Later, set Array loop to render separate objects.
		batch.setProjectionMatrix(cam.combined);
		batch.begin();
		batch.draw(knight.getCurrentFrame(), knight.getPosistion().x, knight.getPosistion().y);
		batch.end();
		
		//Later, set Array loop to render separate AABB boxes with different colors.
		sr.setProjectionMatrix(cam.combined);
		sr.begin(ShapeType.Rectangle);
		sr.rect(knight.getPosistion().x, knight.getPosistion().y, 
				knight.getWidth(), knight.getHeight());
		sr.end();
	}
	
	public void dispose() {
		batch.dispose();
	}

}

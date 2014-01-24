package com.misterpops.towerknight.Rendering;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Textures {

	private TextureAtlas knightAtlas;
	
	public static TextureRegion[] knightStanding,
			knightStandingLeft, knightRunning, knightRunningLeft;
	
	public Textures() {
		knightAtlas = new TextureAtlas("data/mobs/knight.pack");
		loadTextures();
	}

	private void loadTextures() {
		knightStanding = arrayLoad(knightAtlas, "knight_standing", 8, false);
		knightStandingLeft = arrayLoad(knightAtlas, "knight_standing", 8, true);
		knightRunning = arrayLoad(knightAtlas, "knight_running", 8, false);
		knightRunningLeft = arrayLoad(knightAtlas, "knight_running", 8, true);
	}
	
	private TextureRegion[] arrayLoad(TextureAtlas atlas, String mainName, int numOfFrames, boolean flip) {
		TextureRegion[] array = new TextureRegion[numOfFrames];
		for (int i = 0; i < numOfFrames; i++) {
			if(flip) {
				array[i] = new TextureRegion(atlas.findRegion(mainName + i));
				array[i].flip(flip, false);
			} else {
				array[i] = atlas.findRegion(mainName + i);
			}
		}
		return array;
	}
}

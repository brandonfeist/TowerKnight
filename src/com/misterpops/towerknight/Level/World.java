package com.misterpops.towerknight.Level;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.misterpops.towerknight.TowerKnight;
import com.misterpops.towerknight.Entities.Mob.Knight;

public class World {
	
	TowerKnight game;
	Knight knight;
	
	public World(TowerKnight game) {
		this.game = game;
		knight = new Knight(0, new Vector2(Gdx.graphics.getWidth() / 2,Gdx.graphics.getHeight() / 2), 1, 1);
	}
	
	public Knight getKnight() {
		return knight;
	}
}

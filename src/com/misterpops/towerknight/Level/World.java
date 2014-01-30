package com.misterpops.towerknight.Level;

import java.util.concurrent.ConcurrentHashMap;

import com.badlogic.gdx.math.Vector2;
import com.misterpops.towerknight.TowerKnight;
import com.misterpops.towerknight.Entities.Mob.Knight;
import com.misterpops.towerknight.Entities.Tile.Coord;
import com.misterpops.towerknight.Entities.Tile.Tile;

public class World {
	
	TowerKnight game;
	Knight knight;
	public static final float GRAVITY = 60 * 4;
	
	public static ConcurrentHashMap<Coord, Tile> map = LevelGenerator.debugGenerateLevel(); // Ex. = get dungeonMap.getMap();\
	
	public World(TowerKnight game) {
		this.game = game;
		knight = new Knight(0, new Vector2(124, 90), 16, 32);
	}
	
	public void update(float delta) {
		knight.update();
	}
	
	public Knight getKnight() {
		return knight;
	}
	
	public void dispose() {
		
	}
}

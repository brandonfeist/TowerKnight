package com.misterpops.towerknight.Level;

import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import com.badlogic.gdx.math.Vector2;
import com.misterpops.towerknight.TowerKnight;
import com.misterpops.towerknight.Entities.Mob.Knight;
import com.misterpops.towerknight.Entities.Tile.Coord;
import com.misterpops.towerknight.Entities.Tile.Tile;
import com.misterpops.towerknight.Entities.Tile.TileLibrary;

public class World {
	
	TowerKnight game;
	Knight knight;
	public static final float GRAVITY = 60 * 4;
	
	public static ConcurrentHashMap<Coord, Tile> map = LevelGenerator.debugGenerateLevel(); // Ex. = get dungeonMap.getMap();\
	public static ConcurrentHashMap<Coord, Tile> colMap = colMap();
	
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
	
	private static ConcurrentHashMap<Coord, Tile> colMap() {
		ConcurrentHashMap<Coord, Tile> colMap = new ConcurrentHashMap<Coord, Tile>();
		
		for(Entry<Coord, Tile> entry : World.map.entrySet()) {
			Coord coord = entry.getKey();
			Tile tile = entry.getValue();
			
			boolean[] colArray = tile.getColInfo();
			if(colArray[0])
				colMap.put(new Coord(coord.getX() *  (TowerKnight.TILE_SIZE / TowerKnight.COL_TILE_SIZE),
						coord.getY() *  (TowerKnight.TILE_SIZE / TowerKnight.COL_TILE_SIZE)), TileLibrary.col_tile);
			if(colArray[1])
				colMap.put(new Coord(coord.getX() *  (TowerKnight.TILE_SIZE / TowerKnight.COL_TILE_SIZE) + 1,
						coord.getY() *  (TowerKnight.TILE_SIZE / TowerKnight.COL_TILE_SIZE)), TileLibrary.col_tile);
			if(colArray[2])
				colMap.put(new Coord(coord.getX() *  (TowerKnight.TILE_SIZE / TowerKnight.COL_TILE_SIZE) + 1,
						coord.getY() *  (TowerKnight.TILE_SIZE / TowerKnight.COL_TILE_SIZE) + 1), TileLibrary.col_tile);
			if(colArray[3])
				colMap.put(new Coord(coord.getX() *  (TowerKnight.TILE_SIZE / TowerKnight.COL_TILE_SIZE),
						coord.getY() *  (TowerKnight.TILE_SIZE / TowerKnight.COL_TILE_SIZE) + 1), TileLibrary.col_tile);
		}
		return colMap;
	}
}

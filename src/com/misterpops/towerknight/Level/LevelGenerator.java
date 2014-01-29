package com.misterpops.towerknight.Level;

import java.util.concurrent.ConcurrentHashMap;

import com.misterpops.towerknight.Entities.Tile.Coord;
import com.misterpops.towerknight.Entities.Tile.Tile;
import com.misterpops.towerknight.Entities.Tile.TileLibrary;

public class LevelGenerator {
	
	public static ConcurrentHashMap<Coord, Tile> debugGenerateLevel() {
		 ConcurrentHashMap<Coord, Tile> map = new ConcurrentHashMap<Coord, Tile>();
		 
		 for(int indexY = 0; indexY < 1; indexY++) {
			 for(int indexX = 0; indexX < 10; indexX++) {
				 map.put(new Coord(indexX, indexY), TileLibrary.debug_tile);
			 }
			 map.put(new Coord(0, 1), TileLibrary.debug_tile);
			 map.put(new Coord(9, 1), TileLibrary.debug_tile);
			 map.put(new Coord(4, 1), TileLibrary.debug_tile);
			 map.put(new Coord(7, 2), TileLibrary.debug_tile);
		 }
		 
		 return map;
	}

}

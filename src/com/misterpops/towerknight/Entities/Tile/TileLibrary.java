package com.misterpops.towerknight.Entities.Tile;

import com.misterpops.towerknight.TowerKnight;
import com.misterpops.towerknight.Rendering.Textures;

public class TileLibrary {
	
	public static Tile col_tile = new Tile(TowerKnight.COL_TILE_SIZE, TowerKnight.COL_TILE_SIZE, true, 0, Textures.debug_tile);
	
	public static Tile debug_tile = new Tile(TowerKnight.TILE_SIZE, TowerKnight.TILE_SIZE, true, true, true, true, -1, Textures.debug_tile);

}

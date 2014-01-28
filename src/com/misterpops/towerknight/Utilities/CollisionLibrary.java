package com.misterpops.towerknight.Utilities;

import com.misterpops.towerknight.TowerKnight;
import com.misterpops.towerknight.Entities.Entity;
import com.misterpops.towerknight.Entities.Tile.Coord;
import com.misterpops.towerknight.Level.World;

public class CollisionLibrary {
	
	//Collision functions are whack, not working at all with HashMap
	//FIX DIS SHIT.
	
	private static boolean isTileBlocked(float x, float y) {
		Coord coord = new Coord(x / TowerKnight.TILE_SIZE, y / TowerKnight.TILE_SIZE);
		if(World.map.containsKey(coord)) {
			return World.map.get(coord).getIsSolid();
		}
		return false;
	}

	public static boolean collidesLeft(Entity entity) {
		for(float step = 0; step < entity.getAABB().getHeight(); step += TowerKnight.TILE_SIZE / 2) {
			if(isTileBlocked(entity.getAABB().getX(), entity.getAABB().getY() + step)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean collidesRight(Entity entity) {
		for(float step = 0; step < entity.getAABB().getHeight(); step += TowerKnight.TILE_SIZE / 2) {
			if(isTileBlocked(entity.getAABB().getX() + entity.getWidth(), entity.getAABB().getY() + step)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean collidesBot(Entity entity) {
		for(float step = 0; step < entity.getAABB().getWidth(); step += TowerKnight.TILE_SIZE / 2) {
			if(isTileBlocked(entity.getAABB().getX() + step, entity.getAABB().getY())) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean collidesTop(Entity entity) {
		for(float step = 0; step < entity.getAABB().getWidth(); step += TowerKnight.TILE_SIZE / 2) {
			if(isTileBlocked(entity.getAABB().getX() + step, entity.getAABB().getY() + entity.getAABB().getHeight())) {
				return true;
			}
		}
		return false;
	}
}

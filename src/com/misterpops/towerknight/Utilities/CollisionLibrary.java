package com.misterpops.towerknight.Utilities;

import com.misterpops.towerknight.TowerKnight;
import com.misterpops.towerknight.Entities.Entity;
import com.misterpops.towerknight.Entities.Tile.Coord;
import com.misterpops.towerknight.Level.World;

public class CollisionLibrary {
	
	//Collision still not perfect...
	
	private static final int COLLISION_PERCISION = 16;
	private static final float COLLISION_ADJUSTMENT = 3;
	
	private static boolean isTileBlocked(float x, float y) {
		int intX = (int) (x) / TowerKnight.TILE_SIZE;
		int intY = (int) (y) / TowerKnight.TILE_SIZE;
		Coord coord = new Coord(intX, intY);
		
		if(World.map.containsKey(coord)) {
			return World.map.get(coord).getIsSolid();
		}
		return false;
	}

	public static boolean collidesLeft(Entity entity) {
		for(float step = 0; step < entity.getHeight() - COLLISION_ADJUSTMENT;
				step += TowerKnight.TILE_SIZE / COLLISION_PERCISION) {
			
			if(isTileBlocked(entity.getPosistion().x,
					entity.getPosistion().y + COLLISION_ADJUSTMENT + step)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean collidesRight(Entity entity) {
		for(float step = 0; step < entity.getHeight() - COLLISION_ADJUSTMENT;
				step += TowerKnight.TILE_SIZE / COLLISION_PERCISION) {
			
			if(isTileBlocked(entity.getPosistion().x + entity.getWidth(),
					entity.getPosistion().y + COLLISION_ADJUSTMENT + step)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean collidesBot(Entity entity) {
		for(float step = 0; step < entity.getWidth(); step += TowerKnight.TILE_SIZE / COLLISION_PERCISION) {
			if(isTileBlocked(entity.getPosistion().x + step, entity.getPosistion().y)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean collidesTop(Entity entity) {
		for(float step = 0; step < entity.getWidth(); step += TowerKnight.TILE_SIZE / COLLISION_PERCISION) {
			if(isTileBlocked(entity.getPosistion().x + step, entity.getPosistion().y + entity.getHeight())) {
				return true;
			}
		}
		return false;
	}
}

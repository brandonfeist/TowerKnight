package com.misterpops.towerknight.Utilities;

import com.misterpops.towerknight.TowerKnight;
import com.misterpops.towerknight.Entities.Entity;
import com.misterpops.towerknight.Entities.Tile.Coord;
import com.misterpops.towerknight.Level.World;

public class CollisionLibrary {
	
	private static final int COLLISION_PERCISION = 6;
	
	private static boolean isTileBlocked(float x, float y) {
		int intX = (int) (x) / TowerKnight.COL_TILE_SIZE;
		int intY = (int) (y) / TowerKnight.COL_TILE_SIZE;
		Coord coord = new Coord(intX, intY);
		
		if(World.colMap.containsKey(coord)) {
			return World.colMap.get(coord).getIsSolid();
		}
		return false;
	}

	public static boolean collidesLeft(Entity entity) {
		for(float step = 0; step < entity.getHeight();
				step += entity.getHeight() / COLLISION_PERCISION) {
			
			if(isTileBlocked(entity.getPosistion().x,
					entity.getPosistion().y + step)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean collidesRight(Entity entity) {
		for(float step = 0; step < entity.getHeight();
				step += entity.getHeight() / COLLISION_PERCISION) {
			
			if(isTileBlocked(entity.getPosistion().x + entity.getWidth(),
					entity.getPosistion().y + step)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean collidesBot(Entity entity) {
		for(float step = 0; step < entity.getWidth(); step +=entity.getWidth() / COLLISION_PERCISION) {
			if(isTileBlocked(entity.getPosistion().x + step, entity.getPosistion().y)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean collidesTop(Entity entity) {
		for(float step = 0; step < entity.getWidth(); step += entity.getWidth() / COLLISION_PERCISION) {
			if(isTileBlocked(entity.getPosistion().x + step, entity.getPosistion().y + entity.getHeight())) {
				return true;
			}
		}
		return false;
	}
}

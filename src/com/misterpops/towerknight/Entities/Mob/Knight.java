package com.misterpops.towerknight.Entities.Mob;

import com.badlogic.gdx.math.Vector2;
import com.misterpops.towerknight.Entities.MovableEntity;

public class Knight extends MovableEntity{

	public Knight(float rotation, Vector2 position, float width, float height) {
		super(rotation, position, width, height);
		this.speed = 5f;
	}

}

package com.misterpops.towerknight.Entities.Mob;

import com.badlogic.gdx.math.Vector2;
import com.misterpops.towerknight.Entities.MovableEntity;

public abstract class Enemy extends MovableEntity {

	public Enemy(float rotation, Vector2 position, float width, float height) {
		super(rotation, position, width, height);
	}

	public abstract void move(float delta, Knight knight);
}

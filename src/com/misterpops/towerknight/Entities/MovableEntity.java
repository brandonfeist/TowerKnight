package com.misterpops.towerknight.Entities;

import com.badlogic.gdx.math.Vector2;

public abstract class MovableEntity extends Entity {

	protected Vector2 velocity;
	protected float speed, rotation;
	protected boolean moving = false,	//If entity is moving.
			right = true;				//If entity is facing right.
	
	public MovableEntity(float rotation, Vector2 position, float width, float height) {
		super(position, width, height);
		this.rotation = rotation;
	}

	/**
	 * @return the velocity
	 */
	public Vector2 getVelocity() {
		return velocity;
	}

	/**
	 * @param velocity the velocity to set
	 */
	public void setVelocity(Vector2 velocity) {
		this.velocity = velocity;
	}

	/**
	 * @return the speed
	 */
	public float getSpeed() {
		return speed;
	}

	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
	/**
	 * @return the rotation
	 */
	public float getRotation() {
		return rotation;
	}
	
	/**
	 * @param rotation the rotation to set
	 */
	public void setRotation(float rotation) {
		this.rotation = rotation;
	}
	
}

package com.misterpops.towerknight.Entities;

import com.badlogic.gdx.math.Vector2;

public abstract class MovableEntity extends Entity {

	protected Vector2 velocity, acceleration;
	protected float rotation;
	protected boolean right = true;	//If entity is facing right.
	
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
	
	public Vector2 getAcceleration() {
		return acceleration;
	}
	
	public void setAcceleration(Vector2 acceleration) {
		this.acceleration = acceleration;
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

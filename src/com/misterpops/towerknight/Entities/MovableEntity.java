package com.misterpops.towerknight.Entities;

import com.badlogic.gdx.math.Vector2;
import com.misterpops.towerknight.Utilities.CollisionLibrary;

public abstract class MovableEntity extends Entity {

	protected Vector2 velocity, acceleration;
	protected float rotation;
	protected boolean right = true, canJump = false;	//If entity is facing right.
	
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
	
	protected void collision() {
		Vector2 oldPosition = new Vector2(position);
		boolean collisionX = false, collisionY = false;
		position.add(velocity);
		
		if(velocity.x < 0) {
			collisionX = CollisionLibrary.collidesLeft(this);
		} else if(velocity.x > 0) {
			collisionX = CollisionLibrary.collidesRight(this);
		}
		
		if(collisionX) {
			position.x = oldPosition.x;
			velocity.x = 0;
		}
		
		if(velocity.y < 0) {
			canJump = collisionY = CollisionLibrary.collidesBot(this);
		} else if(velocity.y > 0) {
			collisionY = CollisionLibrary.collidesTop(this);
		}
		
		if(collisionY) {
			position.y = oldPosition.y;
			velocity.y = 0;
		}
	}
	
}

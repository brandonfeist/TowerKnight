package com.misterpops.towerknight.Entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.misterpops.towerknight.Level.World;
import com.misterpops.towerknight.Utilities.CollisionLibrary;

public abstract class MovableEntity extends Entity {

	protected Vector2 velocity, acceleration;
	protected float rotation, jumpSpeed = 0;
	protected boolean right = true, canJump = false,
			jumping = false;
	
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
		oldPosition = new Vector2(position);
		boolean collisionX = false, collisionY = false;
		
		//position.add(velocity);
		
		//X Collisions
		if(velocity.x != 0) {
			int countX = 0;
			while (countX < 16) {
				oldPosition.x = position.x;
				position.x += velocity.x / 16;
				
				if(velocity.x < 0) {
					collisionX = CollisionLibrary.collidesLeft(this);
				} else if(velocity.x > 0) {
					collisionX = CollisionLibrary.collidesRight(this);
				}

				if(collisionX) {
					position.x = oldPosition.x;
					velocity.x = 0;
					break;
				}
				countX++;
			}
		}


		//Y Collisions
		if(velocity.y != 0) {
			int countY = 0;
			while(countY < 16) {
				oldPosition.y = position.y;
				position.y += velocity.y / 16;

				canJump = collisionY = CollisionLibrary.collidesBot(this);
				if(velocity.y > 0) {
					collisionY = CollisionLibrary.collidesTop(this);
					jumping = !CollisionLibrary.collidesTop(this);
				}

				if(collisionY) {
					position.y = oldPosition.y;
					velocity.y = 0;
					break;
				}
				countY++;
			}
		}
	}
	
	public void jump() {
		if(jumping) {
			velocity.add(0, jumpSpeed);
			jumpSpeed -= 4.3f;
			
			if(!Gdx.input.isKeyPressed(Input.Keys.SPACE) ||
					jumpSpeed <= 0 || jumpSpeed < World.GRAVITY) {
				jumping = false;
				jumpSpeed = 0;
			}
		}
	}
}

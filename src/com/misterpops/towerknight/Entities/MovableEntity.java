package com.misterpops.towerknight.Entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.misterpops.towerknight.Level.World;
import com.misterpops.towerknight.Utilities.CollisionLibrary;

public abstract class MovableEntity extends Entity {

	private final int COL_CHECK_STEPS = 6;
	protected Vector2 velocity, acceleration;
	protected float rotation, jumpSpeed = 0;
	protected boolean right = true, canJump = false,
			jumping = false, collisionLeft = false,
			collisionRight = false;
	
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
		boolean collisionY = false;
		collisionLeft = false;
		collisionRight = false;
		
		//X Collisions
		if(velocity.x != 0) {
			int countX = 0;
			while (countX < COL_CHECK_STEPS) {
				oldPosition.x = position.x;
				position.x += velocity.x / COL_CHECK_STEPS;
				
				if(velocity.x < 0) {
					collisionLeft  = CollisionLibrary.collidesLeft(this);
				} else if(velocity.x > 0) {
					collisionRight = CollisionLibrary.collidesRight(this);
				}

				if(collisionRight || collisionLeft) {
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
			while(countY < COL_CHECK_STEPS) {
				oldPosition.y = position.y;
				position.y += velocity.y / COL_CHECK_STEPS;

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
			jumpSpeed -= 16.7f;
			
			if(!Gdx.input.isKeyPressed(Input.Keys.SPACE) ||
					jumpSpeed <= 0 || jumpSpeed < World.GRAVITY) {
				jumping = false;
				jumpSpeed = 0;
			}
		}
	}
}

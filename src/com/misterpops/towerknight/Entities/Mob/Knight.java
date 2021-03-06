package com.misterpops.towerknight.Entities.Mob;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.math.Vector2;
import com.misterpops.towerknight.Entities.MovableEntity;
import com.misterpops.towerknight.Level.World;
import com.misterpops.towerknight.Rendering.Textures;

public class Knight extends MovableEntity{
	
	private final float MAX_HORIZONTAL_SPEED = 60 * 2.8f;
	private final float MAX_VERTICAL_SPEED = 60 * 2.8f;
	private final int ACCEL_DEGRADE = 16;
	//Animation states and timer.
	private Animation standingAnimation, standingLeftAnimation,
			runningAnimation, runningLeftAnimation, fallingRight,
			fallingLeft, pushingRight, pushingLeft;
	//State times for animations.
	private float stateTime, pushingStateTime, fallingStateTime;
	private boolean doneJumping = true;

	public Knight(float rotation, Vector2 position, float width, float height) {
		super(rotation, position, width, height);
		
		velocity = new Vector2();
		acceleration = new Vector2();
		
		//Initialize animation stuff
		standingAnimation = new Animation(0.060f, Textures.knightStanding);
		standingLeftAnimation = new Animation(0.060f, Textures.knightStandingLeft);
		runningAnimation = new Animation(0.060f, Textures.knightRunning);
		runningLeftAnimation = new Animation(0.060f, Textures.knightRunningLeft);
		fallingRight = new Animation(0.070f, Textures.knightFallingRight);
		fallingLeft = new Animation(0.070f, Textures.knightFallingLeft);
		pushingRight = new Animation(0.090f, Textures.knightPushingRight);
		pushingLeft = new Animation(0.090f, Textures.knightPushingLeft);
	}

	@Override
	public void update() {	
		stateTime += Gdx.graphics.getDeltaTime();
		move();
		setAABBCoord(position.x, position.y);
	}
	
	/**
	 * Everything to do with the knight's movement throughout the world.
	 */
	private void move() {
		float deltaTime = Gdx.graphics.getDeltaTime();
		
		//Apply gravity
		velocity.y -= World.GRAVITY;
		
		//Clamp velocity
		if(velocity.y > MAX_VERTICAL_SPEED)
			velocity.y = MAX_VERTICAL_SPEED;
		else if(velocity.y < - MAX_VERTICAL_SPEED)
			velocity.y = - MAX_VERTICAL_SPEED;
		
		//Jumping
		//Not in MovableEntity because it has to do with player input.
		if(Gdx.input.isKeyPressed(Input.Keys.SPACE) && canJump && doneJumping) {
				canJump = false;
				doneJumping = false;
				jumping = true;
				jumpSpeed = World.GRAVITY * 2f;
		}
		//Checks if player let go of space bar before jumping again.
		if(!Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
			doneJumping = true;
		}
		
		//Input and acceleration.
		accleration();
		
		//Jumping action if jumping == true.
		jump();
		
		velocity.add(acceleration);
		velocity.mul(deltaTime);
		
		//Collision Detection
		collision();
		
		jumpingFallingAnim();
	}
	
	private void accleration() {
		//Frankenstein Input action and acceleration system.
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			right = true;
			if(collisionRight) {
				currentFrame = pushingRight.getKeyFrame(pushingStateTime, false);
				pushingStateTime += Gdx.graphics.getDeltaTime();
			} else {
				currentFrame = runningAnimation.getKeyFrame(stateTime, true);
				pushingStateTime = 0;
			}
			if(acceleration.x < MAX_HORIZONTAL_SPEED)
				acceleration.x += MAX_HORIZONTAL_SPEED / (ACCEL_DEGRADE / 2);
		} else if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			right = false;
			if(collisionLeft) {
				currentFrame = pushingLeft.getKeyFrame(pushingStateTime, false);
				pushingStateTime += Gdx.graphics.getDeltaTime();
			} else {
				currentFrame = runningLeftAnimation.getKeyFrame(stateTime, true);
				pushingStateTime = 0;
			}
			if(acceleration.x > - MAX_HORIZONTAL_SPEED)
				acceleration.x += - MAX_HORIZONTAL_SPEED / (ACCEL_DEGRADE / 2);
		} else {
			//Standing/sliding animations.
			if(acceleration.x != 0) {
				//sliding animations
				//just standing animation right now. Need to draw sliding animation
				currentFrame = right? standingAnimation.getKeyFrame(stateTime, true) : 
					standingLeftAnimation.getKeyFrame(stateTime, true);
			} else {
				currentFrame = right? standingAnimation.getKeyFrame(stateTime, true) : 
					standingLeftAnimation.getKeyFrame(stateTime, true);
			}

			//If in the air acceleration.x degrades slower. If on the ground faster.
			//If canJump, the knight is on the ground.
			if(canJump) {
				acceleration.mul(0.60f, 0);
			} else {
				if(acceleration.x > 0)
					acceleration.x -= MAX_HORIZONTAL_SPEED / (ACCEL_DEGRADE * 2.5f);
				else if(acceleration.x < 0)
					acceleration.x += MAX_HORIZONTAL_SPEED / (ACCEL_DEGRADE * 2.5f);
			}
		}
	}
	
	private void jumpingFallingAnim() {
		//Jumping Animation
		if(jumping) {
			currentFrame = right? fallingRight.getKeyFrame(0, false) : 
				fallingLeft.getKeyFrame(0, false);
			fallingStateTime = 0;
		}
		
		//Falling animation.
		if(velocity.y < -1.7f) {
			currentFrame = right? fallingRight.getKeyFrame(fallingStateTime, false) : 
				fallingLeft.getKeyFrame(fallingStateTime, false);
			fallingStateTime += Gdx.graphics.getDeltaTime();
		}
	}
}

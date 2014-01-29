package com.misterpops.towerknight.Entities.Mob;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.math.Vector2;
import com.misterpops.towerknight.Entities.MovableEntity;
import com.misterpops.towerknight.Level.World;
import com.misterpops.towerknight.Rendering.Textures;

public class Knight extends MovableEntity{
	
	private final float MAX_HORIZONTAL_SPEED = 60 * 2;
	private Animation standingAnimation, standingLeftAnimation,
			runningAnimation, runningLeftAnimation;
	private float stateTime;	//Keeps track of animation timing.

	public Knight(float rotation, Vector2 position, float width, float height) {
		super(rotation, position, width, height);
		
		velocity = new Vector2();
		acceleration = new Vector2();
		
		//Initialize animation stuff
		standingAnimation = new Animation(0.060f, Textures.knightStanding);
		standingLeftAnimation = new Animation(0.060f, Textures.knightStandingLeft);
		runningAnimation = new Animation(0.060f, Textures.knightRunning);
		runningLeftAnimation = new Animation(0.060f, Textures.knightRunningLeft);
		stateTime = 0f;
	}

	@Override
	public void update() {	
		stateTime += Gdx.graphics.getDeltaTime();
		move();
		setAABBCoord(position.x, position.y);
	}
	
	private void move() {
		float deltaTime = Gdx.graphics.getDeltaTime();
		
		
		//Apply gravity
		velocity.y = - World.GRAVITY;
		
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			 right = true;
			currentFrame = runningAnimation.getKeyFrame(stateTime, true);
			acceleration.x = MAX_HORIZONTAL_SPEED;
		} else if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			right = false;
			currentFrame = runningLeftAnimation.getKeyFrame(stateTime, true);
			acceleration.x = - MAX_HORIZONTAL_SPEED;
		} else {
			currentFrame = right? standingAnimation.getKeyFrame(stateTime, true) : 
				standingLeftAnimation.getKeyFrame(stateTime, true);
			acceleration.x = 0;
		}
		
		velocity.add(acceleration);
		velocity.mul(deltaTime);
		
		//Collision Detection
		collision();
				
		/*if(velocity.x != 0 || velocity.y != 0) {
			//if still moving after letting go of key
		}*/
	}
}

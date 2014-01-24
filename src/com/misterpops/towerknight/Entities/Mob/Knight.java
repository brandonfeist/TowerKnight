package com.misterpops.towerknight.Entities.Mob;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.math.Vector2;
import com.misterpops.towerknight.Entities.MovableEntity;
import com.misterpops.towerknight.Rendering.Textures;

public class Knight extends MovableEntity{
	
	private Animation standingAnimation, standingLeftAnimation,
			runningAnimation, runningLeftAnimation;
	private float stateTime;	//Keeps track of animation timing.

	public Knight(float rotation, Vector2 position, float width, float height) {
		super(rotation, position, width, height);
		this.speed = 5f;
		
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
	}
	
	private void move() {
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			moving = true; right = true;
			currentFrame = runningAnimation.getKeyFrame(stateTime, true);
		} else if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			moving = true; right = false;
			currentFrame = runningLeftAnimation.getKeyFrame(stateTime, true);
		} else {
			moving = false;
			currentFrame = right? standingAnimation.getKeyFrame(stateTime, true) : 
				standingLeftAnimation.getKeyFrame(stateTime, true);
		}
	}

}

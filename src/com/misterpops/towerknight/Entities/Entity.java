package com.misterpops.towerknight.Entities;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class Entity {
	protected Vector2 position;
	protected float width, height;
	protected Rectangle AABB;
	protected TextureRegion currentFrame;
	
	public Entity(Vector2 position, float width, float height) {
		this.position = position;
		this.width = width;
		this.height = height;
		AABB = new Rectangle(position.x, position.y, height, width);
	}
	
	public abstract void update();
	
	/**
	 * @return the position
	 */
	public Vector2 getPosistion() {
		return position;
	}
	/**
	 * @param position the position to set
	 */
	public void setPosistion(Vector2 position) {
		this.position = position;
	}
	/**
	 * @return the width
	 */
	public float getWidth() {
		return width;
	}
	/**
	 * @param width the width to set
	 */
	public void setWidth(float width) {
		this.width = width;
	}
	/**
	 * @return the height
	 */
	public float getHeight() {
		return height;
	}
	/**
	 * @param height the height to set
	 */
	public void setHeight(float height) {
		this.height = height;
	}
	/**
	 * @return the AABB
	 */
	public Rectangle getAABB() {
		return AABB;
	}
	/**
	 * @param bounds the AABB to set
	 */
	public void setAABB(Rectangle bounds) {
		AABB = bounds;
	}
	
	public TextureRegion getCurrentFrame() {
		return currentFrame;
	}
	
	
}

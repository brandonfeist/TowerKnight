package com.misterpops.towerknight.Entities.Tile;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.misterpops.towerknight.Entities.Entity;

public class Tile extends Entity{
	
	private boolean isSolid;
	private int id;
	TextureRegion texture;

	public Tile(float width, float height, boolean isSolid, int id, TextureRegion texture) {
		super(width, height);
		this.isSolid = isSolid;
		this.id = id;
		this.texture = new TextureRegion(texture);
	}

	@Override
	public void update() {
		
	}
	
	public boolean getIsSolid() {
		return isSolid;
	}
	
	public void setIsSolid(boolean isSolid) {
		this.isSolid =  isSolid;
	}
	
	public int getTileId() {
		return id;
	}
	
	public TextureRegion getTileTex() {
		return texture;
	}

}

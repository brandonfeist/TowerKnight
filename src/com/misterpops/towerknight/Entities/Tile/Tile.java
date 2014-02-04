package com.misterpops.towerknight.Entities.Tile;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.misterpops.towerknight.Entities.Entity;

public class Tile extends Entity{
	
	private boolean isSolid;
	private boolean solidBotLeft, solidBotRight,
	solidTopRight, solidTopLeft;
	private int id;
	TextureRegion texture;

	/**
	 * This constructor is mainly used for the collision map tiles.
	 * @param width The tiles width.
	 * @param height The tiles height.
	 * @param isSolid If the tile is solid.
	 * @param id The tiles id.
	 * @param texture The tiles given texture. (Not really necessary).
	 */
	public Tile(float width, float height, boolean isSolid, int id, TextureRegion texture) {
		super(width, height);
		this.isSolid = isSolid;
		this.id = id;
		this.texture = new TextureRegion(texture);
	}
	
	/**
	 * Constructor used for non-collision map tiles. Used to set which 16px x 16px blocks in the
	 * 32px x 32px are solid and not solid. Allows for half blocks while still maintaining a tile
	 * based collision system.
	 * @param width The width of the tile
	 * @param height The height of the tile
	 * @param solidBotLeft If bottom left of the tile is solid.
	 * @param solidBotRight If bottom right of the tile is solid.
	 * @param solidTopRight If top right of the tile is solid.
	 * @param solidTopLeft If top left of the tile is solid.
	 * @param id The tile's id number.
	 * @param texture The tiles given texture.
	 */
	public Tile(float width, float height, boolean solidBotLeft, boolean solidBotRight,
			boolean solidTopRight, boolean solidTopLeft, int id, TextureRegion texture) {
		super(width, height);
		this.solidBotLeft = solidBotLeft;
		this.solidBotRight = solidBotRight;
		this.solidTopRight = solidTopRight;
		this.solidTopLeft = solidTopLeft;
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
	
	/**
	 * In this order, solidBotLeft, solidBotRight, solidTopRight, and
	 * solidTopLeft.
	 * @return array of collision info for the tile.
	 */
	public boolean[] getColInfo() {
		boolean[] colArray = {solidBotLeft, solidBotRight,
				solidTopRight, solidTopLeft};
		
		return colArray;
	}

}

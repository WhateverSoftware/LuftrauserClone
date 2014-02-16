package com.WhateverSoftware.LuftrauserClone.Objects.Ships;

import com.WhateverSoftware.LuftrauserClone.AI.IAI;
import com.WhateverSoftware.LuftrauserClone.Graphics.Assets;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * @author WhateverSoftware
 * @class ShipLarge
 */
public class ShipLarge extends AShip {

	//The speed of this entity
	private static final int SPEED = 1;

	//The cooldown period of this entity
	private static final int COOLDOWN_PERIOD = 8;

	//The maximum health of this entity
	private static final int HEALTH = 200;

	/**
	 * @constructor -Calls AShip constructor
	 * @param x - x-position of this entity
	 * @param y - y-position of thsi entity
	 * @param ai - The AI that controls this entity
	 * @param directionFacing -The direction of this entity
	 */
	public ShipLarge(int x, int y, IAI ai, int directionFacing) {
		super(x, y, ai, ShipLarge.SPEED, directionFacing, ShipLarge.COOLDOWN_PERIOD, ShipLarge.HEALTH);
	}

	/**AShipLarge.draw()
	 * Draws this entity in the appropriate orientation
	 */
	@Override
	public void draw(SpriteBatch batch,int xOffset,int yOffset) {
		super.draw(batch,xOffset,yOffset,Assets.assetManager.get("Boats/ship6.png", Texture.class));
	}

}

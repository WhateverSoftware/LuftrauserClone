package com.WhateverSoftware.LuftrauserClone.Objects.Ships;

import com.WhateverSoftware.LuftrauserClone.AI.IAI;
import com.WhateverSoftware.LuftrauserClone.Graphics.Assets;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * @author WhateverSoftware
 * @class ShipSmall
 */
public class ShipSmall extends AShip {

	//The speed of this entity
	private static final int SPEED = 3;
	
	//The cooldown period of this entity
	private static final int COOLDOWN_PERIOD = 20;
	
	//The maximum health of this entity
	private static final int HEALTH = 50;

	/**
	 * @constructor -Calls AShip constructor
	 * @param x - x-position of this entity
	 * @param y - y-position of thsi entity
	 * @param ai - The AI that controls this entity
	 * @param directionFacing -The direction of this entity
	 */
	public ShipSmall(int x, int y, IAI ai, int directionFacing) {
		super(x, y, ai, ShipSmall.SPEED, directionFacing, ShipSmall.COOLDOWN_PERIOD, ShipSmall.HEALTH);
	}

	/**AShipSmall.draw()
	 * Draws this entity in the appropriate orientation
	 */
	@Override
	public void draw(SpriteBatch batch, int xOffset, int yOffset) {
		super.draw(batch,xOffset,yOffset,Assets.assetManager.get("Boats/ship2.png", Texture.class));
	}


}

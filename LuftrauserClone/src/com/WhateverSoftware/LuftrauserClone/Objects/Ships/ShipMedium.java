package com.WhateverSoftware.LuftrauserClone.Objects.Ships;

import com.WhateverSoftware.LuftrauserClone.AI.IAI;
import com.WhateverSoftware.LuftrauserClone.Graphics.Assets;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * @author WhateverSoftware
 * @class ShipMedium
 */
public class ShipMedium extends AShip {

	//The speed of this entity
	private static final int SPEED = 2;
	
	//The cooldown period of this entity
	private static final int COOLDOWN_PERIOD = 12;
	
	//The maximum health of this entity
	private static final int HEALTH = 100;

	/**
	 * @constructor -Calls AShip constructor
	 * @param x - x-position of this entity
	 * @param y - y-position of thsi entity
	 * @param ai - The AI that controls this entity
	 * @param directionFacing -The direction of this entity
	 */
	public ShipMedium(int x, int y, IAI ai, int directionFacing) {
		super(x, y, ai, ShipMedium.SPEED, directionFacing, ShipMedium.COOLDOWN_PERIOD, ShipMedium.HEALTH);
	}

	/**AShipMedium.draw()
	 * Draws this entity in the appropriate orientation
	 */
	@Override
	public void draw(SpriteBatch batch) {
		// will need some way to differentiate between boat textures

		// Math here to rotate texture to match direction facing
		batch.draw(Assets.assetManager.get("Boats/ship3.png", Texture.class), x, y);
	}

}

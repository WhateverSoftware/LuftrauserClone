package com.WhateverSoftware.LuftrauserClone.Objects.Ships;

import com.WhateverSoftware.LuftrauserClone.AI.IAI;
import com.WhateverSoftware.LuftrauserClone.Graphics.Assets;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ShipMedium extends AShip {

	private static final int SPEED = 2;
	private static final int COOLDOWN_PERIOD = 8;
	private static final int HEALTH = 100;

	public ShipMedium(int x, int y, IAI ai, int directionFacing) {
		super(x, y, ai, ShipMedium.SPEED, directionFacing, ShipMedium.COOLDOWN_PERIOD, ShipMedium.HEALTH);
	}

	@Override
	public void draw(SpriteBatch batch) {
		// will need some way to differentiate between boat textures

		// Math here to rotate texture to match direction facing
		batch.draw(Assets.assetManager.get("Boats/ship3.png", Texture.class), x, y);
	}

}

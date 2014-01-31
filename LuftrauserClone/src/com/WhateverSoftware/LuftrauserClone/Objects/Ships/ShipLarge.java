package com.WhateverSoftware.LuftrauserClone.Objects.Ships;

import com.WhateverSoftware.LuftrauserClone.AI.IAI;
import com.WhateverSoftware.LuftrauserClone.Graphics.Assets;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ShipLarge extends AShip {

	private static final int SPEED = 1;
	private static final int COOLDOWN_PERIOD = 4;
	private static final int HEALTH = 200;

	public ShipLarge(int x, int y, IAI ai, int directionFacing) {
		super(x, y, ai, ShipLarge.SPEED, directionFacing, ShipLarge.COOLDOWN_PERIOD, ShipLarge.HEALTH);
	}

	@Override
	public void draw(SpriteBatch batch) {
		// will need some way to differentiate between boat textures

		// Math here to rotate texture to match direction facing
		batch.draw(Assets.assetManager.get("Boats/ship6.png", Texture.class), x, y);
	}

}

package com.WhateverSoftware.LuftrauserClone.Objects.Ships;

import com.WhateverSoftware.LuftrauserClone.AI.IAI;
import com.WhateverSoftware.LuftrauserClone.Graphics.Assets;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ShipSmall extends AShip {

	private static final int SPEED = 3;
	private static final int COOLDOWN_PERIOD = 20;
	private static final int HEALTH = 50;

	public ShipSmall(int x, int y, IAI ai, int directionFacing) {
		super(x, y, ai, ShipSmall.SPEED, directionFacing, ShipSmall.COOLDOWN_PERIOD, ShipSmall.HEALTH);
	}

	@Override
	public void draw(SpriteBatch batch) {
		// will need some way to differentiate between boat textures

		// Math here to rotate texture to match direction facing
		batch.draw(Assets.assetManager.get("Boats/ship2.png", Texture.class), x, y);
	}


}

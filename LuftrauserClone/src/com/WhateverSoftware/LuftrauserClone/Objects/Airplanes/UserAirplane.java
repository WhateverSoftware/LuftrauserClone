package com.WhateverSoftware.LuftrauserClone.Objects.Airplanes;

import com.WhateverSoftware.LuftrauserClone.Graphics.Assets;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class UserAirplane extends AAirplane {

	private static final int COOLDOWN_PERIOD = 5; //ticks
	private static final int MAX_HEALTH = 100;
	
	public UserAirplane(int x, int y, int directionFacing) {
		super(x, y, directionFacing, COOLDOWN_PERIOD, MAX_HEALTH);
	}

	@Override
	public void draw(SpriteBatch batch) {
		super.draw(batch,Assets.assetManager.get("Planes/plane2.png", Texture.class));
	}

}

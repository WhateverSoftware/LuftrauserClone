package com.WhateverSoftware.LuftrauserClone.Objects.Airplanes;

import com.WhateverSoftware.LuftrauserClone.Graphics.Assets;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * @author WhateverSoftware
 * @class UserAirplane
 */
public class UserAirplane extends AAirplane {

	//The minimum period of time between firing projectiles
	private static final int COOLDOWN_PERIOD = 5;
	
	//The maximum health of this entity
	private static final int MAX_HEALTH = 100;
	
	/**
	 * @constructor -Calls AAirplane constructor
	 * @param x - x-position of this entity
	 * @param y - y-position of this entity
	 * @param directionFacing - direction of this entity
	 */
	public UserAirplane(int x, int y, int directionFacing) {
		super(x, y, directionFacing, COOLDOWN_PERIOD, MAX_HEALTH);
	}

	/**UserAirplane.draw()
	 * Draws this entity's graphics in the appropriate orientation
	 */
	@Override
	public void draw(SpriteBatch batch,int xOffset, int yOffset) {
		super.draw(batch,xOffset,yOffset,Assets.assetManager.get("Planes/plane2.png", Texture.class));
	}

}

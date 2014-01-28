package com.WhateverSoftware.LuftrauserClone.Objects;

import java.awt.geom.Point2D;

import com.WhateverSoftware.LuftrauserClone.Graphics.Assets;
import com.WhateverSoftware.LuftrauserClone.Toolbox.MathEngine;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class AAirplane extends AShootingEntity implements IEntity {

	private final int THRUST_SPEED = 1;

	private boolean isThrusting = false;
	
	public AAirplane(int x, int y, int directionFacing, int cooldownPeriod, int health){
		super(x,y,cooldownPeriod,directionFacing,health);
	}
	
	/**
	 * Call all of the actions that need to be performed in a game tick.
	 */
	public void update(){
		super.handleCooling();
		this.turn();
		this.thrust();
		this.move();
		shoot(this.directionFacing);	
	}
	
	/**
	 * Toggle whether the plane is thrusting or not.
	 * @param thrusting - Set to true to have the plane thrust and false otherwise.
	 */
	public void setThrust(boolean thrusting) {
		isThrusting = thrusting;
	}
	
	/**
	 * Handles one tick of thrust for the plane.
	 * If the plane is currently thrusting, the velocity will be increased in the direction the plane is facing.
	 */
	public void thrust(){
		if(!isThrusting) return;
		
		Point2D.Double temp = MathEngine.calcVelocity(velx, velx, THRUST_SPEED, directionFacing);
		velx += temp.getX();
		vely += temp.getY();
	}
	
	@Override
	public void draw(SpriteBatch batch) {
		// will need some way to differentiate between plane textures
		
		// Math here to rotate texture to match angle
		batch.draw(Assets.assetManager.get("Planes/plane2.png", Texture.class), x, y);
	}
}

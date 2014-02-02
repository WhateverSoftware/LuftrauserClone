package com.WhateverSoftware.LuftrauserClone.Objects.Airplanes;

import java.awt.geom.Point2D;
import com.WhateverSoftware.LuftrauserClone.Objects.AShootingEntity;
import com.WhateverSoftware.LuftrauserClone.Objects.IEntity;
import com.WhateverSoftware.LuftrauserClone.Toolbox.MathEngine;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class AAirplane extends AShootingEntity implements IEntity {

	public static final int MAX_VELOCITY = 10;

	private final double THRUST_SPEED = .5;

	private boolean isThrusting = false;

	public AAirplane(int x, int y, int directionFacing, int cooldownPeriod, int health) {
		super(x, y, cooldownPeriod, directionFacing, health);
	}

	/**
	 * Call all of the actions that need to be performed in a game tick.
	 */
	public void update() {
		super.handleCooling();
		this.turn();
		if (this.isThrusting) {
			this.thrust();
		}
		else{
			this.implementGravity();
		}
		this.move();
		shoot(this.directionFacing);
	}

	/**
	 * Toggle whether the plane is thrusting or not.
	 * 
	 * @param thrusting
	 *            - Set to true to have the plane thrust and false otherwise.
	 */
	public void setThrust(boolean thrusting) {
		isThrusting = thrusting;
	}

	/**
	 * Handles one tick of thrust for the plane. If the plane is currently
	 * thrusting, the velocity will be increased in the direction the plane is
	 * facing.
	 */
	public void thrust() {
		Point2D.Double temp = MathEngine.calcVelocity(velx, vely, THRUST_SPEED, directionFacing);
		velx = temp.getX();
		vely = temp.getY();
	}
	
	private void implementGravity(){
		Point2D.Double temp = MathEngine.calcVelocity(velx, vely, 0, directionFacing);
		velx = temp.getX();
		vely = temp.getY();
	}
	
	public void draw(SpriteBatch batch, Texture texture) {
		Sprite sprite = new Sprite(texture);
		sprite.setBounds(x, y, (int)(texture.getWidth()/3.0), (int)(texture.getHeight()/3.0));
		sprite.setOrigin(sprite.getWidth()/2,sprite.getHeight()/4);
		sprite.rotate(-directionFacing);
		sprite.draw(batch);
	}
}

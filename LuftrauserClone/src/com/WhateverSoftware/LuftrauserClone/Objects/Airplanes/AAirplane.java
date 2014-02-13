package com.WhateverSoftware.LuftrauserClone.Objects.Airplanes;

import java.awt.geom.Point2D;
import com.WhateverSoftware.LuftrauserClone.Objects.AShootingEntity;
import com.WhateverSoftware.LuftrauserClone.Objects.IEntity;
import com.WhateverSoftware.LuftrauserClone.Toolbox.MathEngine;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * @author WhateverSoftware
 * @class AAirplane
 */
public abstract class AAirplane extends AShootingEntity implements IEntity {

	//The maximum velocity all Airplanes can travel at
	public static final int MAX_VELOCITY = 10;

	//The value velocity is incremented by each tick of thrusting
	private final double THRUST_SPEED = .5;
	
	private boolean isThrusting = false;

	/**
	 * @constructor -Calls AShootingEntity constructor
	 * @param x - x-position of this entity
	 * @param y - y-position of this entity
	 * @param directionFacing - direction of this entity
	 * @param cooldownPeriod - Minimum duration between shooting of projectiles from this entity
	 * @param health - health of this entity
	 */
	public AAirplane(int x, int y, int directionFacing, int cooldownPeriod, int health) {
		super(x, y, cooldownPeriod, directionFacing, health);
	}

	/**AAirplance.update()
	 * Call all of the actions that need to be performed in a game tick.
	 */
	public void update() {
		super.handleCooling();
		this.turn();
		if (this.isThrusting) {//if this entity is thrusting
			//thrust
			this.thrust();
		}
		else{//otherwise:
			//only gravity effects the velocity
			this.implementGravity();
		}
		this.move();
		shoot(this.directionFacing);
	}

	/**AAirplane.setThrust()
	 * Toggle whether the plane is thrusting or not.
	 * @param thrusting - Set to true to have the plane thrust and false otherwise.
	 */
	public void setThrust(boolean thrusting) {
		isThrusting = thrusting;
	}

	/**AAirplance.thrust()
	 * Handles one tick of thrust for the plane. If the plane is currently
	 * thrusting, the velocity will be increased in the direction the plane is
	 * facing.
	 */
	public void thrust() {
		Point2D.Double temp = MathEngine.calcVelocity(velx, vely, THRUST_SPEED, directionFacing);
		velx = temp.getX();
		vely = temp.getY();
	}
	
	/**AAirplane.implementGravity()
	 * Causes the planes velocity to sway towards MAX_VELOCITY in the +y direction
	 */
	private void implementGravity(){
		Point2D.Double temp = MathEngine.calcVelocity(velx, vely, 0, directionFacing);
		velx = temp.getX();
		vely = temp.getY();
	}
	
	/**AAirplane.draw()
	 * Draws this entity onto the screen in the proper orientation
	 */
	public void draw(SpriteBatch batch, Texture texture) {
		Sprite sprite = new Sprite(texture);
		sprite.setBounds(x, y, (int)(texture.getWidth()/3.0), (int)(texture.getHeight()/3.0));
		sprite.setOrigin(sprite.getWidth()/2,sprite.getHeight()/4);
		sprite.rotate(-directionFacing);
		sprite.draw(batch);
	}
}

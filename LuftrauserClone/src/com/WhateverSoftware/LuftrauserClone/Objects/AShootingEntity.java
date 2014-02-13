package com.WhateverSoftware.LuftrauserClone.Objects;

import java.awt.Point;
import java.awt.geom.Point2D;

import com.WhateverSoftware.LuftrauserClone.StateManagers.IGameTickHandlerEntityView;

/**
 * @author WhateverSoftware
 * @class AShootingEntity
 */
public abstract class AShootingEntity implements IEntity, IShootingEntityAIView {

	//Degrees per turn
	protected final int TURN_SPEED = 5;
	
	//minimum time between projectiles being fired
	private final int COOLDOWN_PERIOD; 
	private int cooldownCounter;
	protected boolean coolingDown;
	
	protected int x;
	protected int y;
	protected double velx;
	protected double vely;
	protected int directionFacing;
	protected int turnDirection;
	protected boolean isShooting;
	protected int health;
	
	//A collection of methods from the GTH that an entity may need
	private IGameTickHandlerEntityView gth;

	/**
	 * @constructor -Sets global variables
	 * @param x - x-position of entity
	 * @param y - y-position of entity
	 * @param cooldownPeriod - minimum time between projectiles being fired from entity
	 * @param directionFacing - direction of entity
	 * @param health - health of entity
	 */
	public AShootingEntity(int x, int y, int cooldownPeriod, int directionFacing, int health) {
		this.x = x;
		this.y = y;
		this.velx = 0;
		this.vely = 0;
		this.COOLDOWN_PERIOD = cooldownPeriod;
		this.cooldownCounter = cooldownPeriod;
		this.coolingDown = false;
		this.directionFacing = directionFacing;
		this.turnDirection = 0;
		this.isShooting = false;
		this.health = health;
	}

	/**AShootingEntity.setGameTickHandler()
	 * Replace the current GTH with a new GTH
	 * @param gth - The replacement GameTickHandler
	 */
	public void setGameTickHandler(IGameTickHandlerEntityView gth) {
		this.gth = gth;
		gth.register(this);
	}

	/**AShootingEntity.shoot()
	 * Registers a projectile in the direction specified as a parameter
	 * @param direction - Direction of the projectile
	 */
	public void shoot(int direction) {
		//If the entity is not cooling down and is currently shooting
		if (!this.coolingDown && isShooting) {
			//register a projectile with the GTH
			this.gth.register(new Projectile(this.x, this.y, direction));
			//begin cooling
			this.coolingDown = true;
		}
	}

	/**AShootingEntity.handleCooling()
	 * Decrements cooling or resets cooling
	 */
	protected void handleCooling() {
		if (this.cooldownCounter == 0) {//If the unit is no longer cooling
			//Update the variables accordingly
			this.coolingDown = false;
			this.cooldownCounter = this.COOLDOWN_PERIOD;
		}
		else if (coolingDown){//If the unit is currently cooling
			//Decrement the counter
			this.cooldownCounter--;
		}
	}

	/**AShootingEntity.getLocation()
	 * Returns the location of this entity
	 * @return Point - The location
	 */
	@Override
	public Point getLocation() {
		return new Point(x, y);
	}

	/**AShootingEntity.setLocation()
	 * Replaces the current location with a new location
	 * @param x - The replacement x-position
	 * @param y - The replacement y-position
	 */
	public void setLocation(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**AShootingEntity.getDirectionFacing()
	 * Returns the current direction of this entity
	 * @return int - The direction in degrees
	 */
	@Override
	public int getDirectionFacing() {
		return this.directionFacing;
	}

	/**AShootingEntity.move()
	 * Increment this entity's location with it's current velocity-vector
	 */
	public void move() {
		x += velx;
		y += vely;
	}

	/**AShootingEntity.setTurning()
	 * Uses input direction as direction of rotation for object. 0 indicates no rotation.
	 * @param direction
	 *            - Indicates which direction of rotation. Only accepts 0, 1
	 *            (clockwise), and -1 (counter-clockwise).
	 */
	public void setTurning(int direction) {
		if (direction == 1 || direction == -1 || direction == 0)
			turnDirection = direction;
	}

	/**AShootingEntity.turn()
	 * This method turns the cannon for a ship. For the plane, it turns the nose
	 * (so it also determines the change of movement on thrust).
	 */
	public void turn() {
		this.directionFacing += (this.TURN_SPEED * this.turnDirection);
	}

	/**AShootingEntity.setShooting()
	 * Changes whether the object is currently firing projectiles.
	 * @param shooting - new boolean value to set for shooting.
	 */
	public void setShooting(boolean shooting) {
		isShooting = shooting;
	}

	/**AShootingEntity.adjustHealth()
	 * Changes this entity's health value
	 * @param adjustment - the increment/decrement we will be adding to this entity's health
	 */
	public void adjustHealth(int adjustment) {
		this.health += adjustment;
	}

	/**AShootingEntity.getHealth()
	 * @return int - This entity's health
	 */
	public int getHealth() {
		return this.health;
	}

	/**AShootingEntity.getCooldownPeriod()
	 * @return int - This entity's cooldown period
	 */
	public int getCooldownPeriod() {
		return this.COOLDOWN_PERIOD;
	}
	
	/**AShootingEntity.isCooling()
	 * @return boolean - Returns true of this entity is currently cooling
	 */
	public boolean isCooling() {
		return this.coolingDown;
	}

	/**AShootingEntity.getVelocity()
	 * @return Point2D.Double - The velocity of this entity
	 */
	public Point2D.Double getVelocity() {
		return new Point2D.Double(this.velx, this.vely);
	}
}

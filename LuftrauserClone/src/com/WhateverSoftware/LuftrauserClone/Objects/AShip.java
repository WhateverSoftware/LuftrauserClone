package com.WhateverSoftware.LuftrauserClone.Objects;

public abstract class AShip extends AShootingEntity implements IEntity {
	
	public AShip(int x, int y, int speed, int directionFacing, int cooldownPeriod, int health){
		super(x,y,cooldownPeriod,directionFacing,health);
		this.velx=speed;
	}
	
	/**
	 * Call all of the actions that need to be performed in a game tick.
	 */
	public void update(){
		super.handleCooling();
		this.turn();
		this.move();
		if(isShooting)
			super.shoot(this.directionFacing);
	}
	
	/**
	 * Changes the direction of movement for the ship.
	 * @param direction - Indicates which direction the ship will move. Only accepts 0, 1 (for right), and -1 (for left).
	 */
	public void setMoveDirection(int direction) {
		if(direction == 1 || direction == -1 || direction == 0)
			velx *= direction;
	}
	
	@Override
	public void draw() {
		// TODO Auto-generated method stub

	}

}

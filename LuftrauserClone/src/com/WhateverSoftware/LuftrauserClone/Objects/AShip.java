package com.WhateverSoftware.LuftrauserClone.Objects;

import com.WhateverSoftware.LuftrauserClone.StateManagers.IGameTickHandlerEntityView;

public abstract class AShip extends AShootingEntity implements IEntity {
	
	private final int TURN_SPEED = 1; //degrees
	
	private int directionFacing;
	private int health;
	private int speed;
	
	public AShip(int x, int y, int speed, int directionFacing, int cooldownPeriod, int health, IGameTickHandlerEntityView gth){
		super(x,y,cooldownPeriod,gth);
		this.directionFacing=directionFacing;
		this.health=health;
		this.speed=speed;
	}
	
	protected void update(boolean shouldMoveLeft, boolean shouldMoveRight, boolean shouldTurnC, boolean shouldTurnCC, boolean shouldShoot){
		if(shouldMoveLeft)
			this.moveLeft();
		if(shouldMoveRight)
			this.moveRight();
		if(shouldTurnC)
			this.turnClockwise();
		if(shouldTurnCC)
			this.turnCounterClockwise();
		if(shouldShoot)
			super.shoot(this.directionFacing);
	}
	
	private void moveLeft(){
		this.x -= this.speed;
	}
	
	private void moveRight(){
		this.x += this.speed;
	}
	
	private void turnClockwise(){
		this.directionFacing += this.TURN_SPEED;
	}
	
	private void turnCounterClockwise(){
		this.directionFacing -= this.TURN_SPEED;
	}
	
	public void adjustHealth(int adjustment){
		this.health += adjustment;
	}
	
	public int getHealth(){
		return this.health;
	}
	
	@Override
	public void draw() {
		// TODO Auto-generated method stub

	}

}

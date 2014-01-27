package com.WhateverSoftware.LuftrauserClone.Objects;

import com.WhateverSoftware.LuftrauserClone.StateManagers.IGameTickHandlerEntityView;

public abstract class AShip extends AShootingEntity implements IEntity {
	
	private final int TURN_SPEED = 1; //degrees
	
	private int directionFacing;
	private int health;
	private int speed;
	private int moveDirection = 0;
	
	public AShip(int x, int y, int speed, int directionFacing, int cooldownPeriod, int health, IGameTickHandlerEntityView gth){
		super(x,y,cooldownPeriod,gth);
		this.directionFacing=directionFacing;
		this.health=health;
		this.speed=speed;
	}
	
	public void update(){
		super.handleCooling();
		this.move();
		this.turn();
		if(isShooting)
			super.shoot(this.directionFacing);
		this.move();		
	}
	
	public void setMoveDirection(int direction) {
		if(direction == 1 || direction == -1 || direction == 0)
			moveDirection = direction;
	}

	public void turn(){
		this.directionFacing += (this.TURN_SPEED*this.turnDirection);
	}
	
	private void move(){
		this.x += (this.speed*moveDirection);
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

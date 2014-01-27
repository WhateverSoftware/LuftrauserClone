package com.WhateverSoftware.LuftrauserClone.Objects;

import java.awt.Point;

import com.WhateverSoftware.LuftrauserClone.StateManagers.IGameTickHandlerEntityView;

public abstract class AShootingEntity implements IEntity {
	
	protected final int TURN_SPEED = 1; //degrees
	private final int COOLDOWN_PERIOD; //in ticks
	private int cooldownCounter;
	protected boolean coolingDown;
	protected int x;
	protected int y;
	protected int velx;
	protected int vely;
	protected int directionFacing;
	protected int turnDirection = 0;
	protected boolean isShooting = false;
	protected int health;
	private IGameTickHandlerEntityView gth;
	
	public AShootingEntity(int x, int y, int cooldownPeriod, int directionFacing, int health){
		this.x=x;
		this.y=y;
		this.velx = 0;
		this.vely = 0;
		this.COOLDOWN_PERIOD=cooldownPeriod;
		this.cooldownCounter=cooldownPeriod;
		this.coolingDown=false;
		this.directionFacing = directionFacing;
		this.health = health;
	}
	
	public void setGameTickHandler(IGameTickHandlerEntityView gth) {
		this.gth = gth;
		gth.register(this);
	}
	
	public void shoot(int direction){
		if(!this.coolingDown && isShooting){
			this.gth.register(new Projectile(this.x,this.y,direction));
			this.coolingDown=true;
		}
	}
	
	protected void handleCooling(){
		if(this.cooldownCounter==0){
			this.coolingDown=false;
			this.cooldownCounter=this.COOLDOWN_PERIOD;
		}
		if(coolingDown)
			this.cooldownCounter--;
	}
	
	@Override
	public Point getLocation() {
		return new Point(x,y);
	}
	
	/**
	 * Move one tick based on the current velocity
	 */
	public void move() {
		x += velx;
		y += vely;
	}
	
	/**
	 * Uses input direction as direction of rotation for object.
	 * 0 indicates no rotation.
	 * @param direction - Indicates which direction of rotation. Only accepts 0, 1 (clockwise), and -1 (counter-clockwise).
	 */
	public void setTurning(int direction) {
		if(direction == 1 || direction == -1 || direction == 0)
			turnDirection = direction;
	}
	
	/**
	 * This method turns the cannon for a ship.
	 * For the plane, it turns the nose (so also the direction of movement is changed).
	 */
	public void turn(){
		this.directionFacing += (this.TURN_SPEED*this.turnDirection);
	}
	
	/**
	 * Changes whether the object is currently firing projectiles.
	 * @param shooting - new boolean value to set for shooting.
	 */
	public void setShooting(boolean shooting) {
		isShooting = shooting;
	}
	
	public void adjustHealth(int adjustment){
		this.health += adjustment;
	}
	
	public int getHealth(){
		return this.health;
	}
}


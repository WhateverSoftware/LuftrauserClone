package com.WhateverSoftware.LuftrauserClone.Objects;

import com.WhateverSoftware.LuftrauserClone.StateManagers.IGameTickHandlerEntityView;
import com.WhateverSoftware.LuftrauserClone.Toolbox.MathEngine;

public abstract class AAirplane extends AShootingEntity implements IEntity {

	private final int MAX_THRUST = 5;
	private final int TURN_SPEED = 1; //degrees
	private final int THRUST_SPEED = 1;

	private double thrust;
	private int directionFacing;
	private int directionMoving;
	private int health;
	private boolean isThrusting = false;
	private int turnDirection = 0;
	private boolean isShooting = false;
	
	public AAirplane(int x, int y, int directionFacing, int cooldownPeriod, int health, IGameTickHandlerEntityView gth){
		super(x,y,cooldownPeriod,gth);
		this.directionFacing=directionFacing;
		this.health=health;
	}
	
	public void update(){
		super.handleCooling();
		if(isThrusting)
			this.thrust();
		//conditional not needed because of how the function works
		this.turn();
		if(isShooting)
			super.shoot(this.directionFacing);
		this.move();		
	}
	
	public void setThrust(boolean thrusting) {
		isThrusting = thrusting;
	}

	public void turn(){
		this.directionFacing += (this.TURN_SPEED*this.turnDirection);
	}
	
	public void thrust(){
		double radDirectionFacing = MathEngine.degreesToRadians(directionFacing);
		double radDirectionMoving = MathEngine.degreesToRadians(directionMoving);
		double currentThrustPartialX = this.thrust * Math.cos(radDirectionMoving);
		double currentThrustPartialY = this.thrust * Math.sin(radDirectionMoving);
		double newThrustPartialX = this.THRUST_SPEED * Math.cos(radDirectionFacing);
		double newThrustPartialY = this.THRUST_SPEED * Math.sin(radDirectionFacing);
		newThrustPartialX += currentThrustPartialX;
		newThrustPartialY += currentThrustPartialY;
		this.directionMoving = (int)Math.atan(newThrustPartialY/newThrustPartialX);
		
		//handles quadrant issues with Math.atan()
		if(newThrustPartialX<0)
			directionMoving += 180; 
		
		this.thrust = MathEngine.pythagorean(newThrustPartialX,newThrustPartialY);
		if(this.thrust>this.MAX_THRUST)
			this.thrust = MAX_THRUST;
	}
	
	public void move() {
		double radDirection = MathEngine.degreesToRadians(directionMoving);
		double dx = thrust * Math.cos(radDirection);
		double dy = thrust * Math.sin(radDirection);
		x += dx;
		y += dy;
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
		// Call static method in class: GraphicsManager
	}
}

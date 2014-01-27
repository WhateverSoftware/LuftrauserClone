package com.WhateverSoftware.LuftrauserClone.Objects;

import com.WhateverSoftware.LuftrauserClone.Toolbox.MathEngine;

public abstract class AAirplane extends AShootingEntity implements IEntity {

	private final int MAX_THRUST = 5;
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
		
		//use directionFacing to figure out the 
		double radDirectionFacing = MathEngine.degreesToRadians(directionFacing);
		double newThrustPartialX = this.THRUST_SPEED * Math.cos(radDirectionFacing);
		double newThrustPartialY = this.THRUST_SPEED * Math.sin(radDirectionFacing);
		velx += newThrustPartialX;
		vely += newThrustPartialY;
		
		//limit velocity
		if(velx > MAX_THRUST) velx = MAX_THRUST;
		if(vely > MAX_THRUST) vely = MAX_THRUST;
	}
	
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		// Call static method in class: GraphicsManager
	}
}

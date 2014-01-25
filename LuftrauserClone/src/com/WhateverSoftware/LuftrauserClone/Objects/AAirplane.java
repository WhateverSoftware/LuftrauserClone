package com.WhateverSoftware.LuftrauserClone.Objects;

import com.WhateverSoftware.LuftrauserClone.StateManagers.IGameTickHandlerEntityView;
import com.WhateverSoftware.LuftrauserClone.Toolbox.MathEngine;

public abstract class AAirplane extends AShootingEntity implements IEntity {

	public final int MAX_THRUST = 5;
	public final int TURN_SPEED = 1; //degrees
	public final int THRUST_SPEED = 1;

	private double thrust;
	private int directionFacing;
	private int directionMoving;
	
	public AAirplane(int x, int y, int directionFacing, IGameTickHandlerEntityView gth){
		super(x,y,gth);
		this.directionFacing=directionFacing;
	}
	
	public void update(){
		//do stuff here
	}

	public void turnClockwise(){
		this.directionFacing += this.TURN_SPEED;
	}
	
	public void turnCounterClockwise(){
		this.directionFacing -= this.TURN_SPEED;
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
	
	public void shoot(){
		//unwritten
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		// Call static method in class: GraphicsManager
	}
}

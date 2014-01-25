package com.WhateverSoftware.LuftrauserClone.Objects;

import java.awt.Point;

import com.WhateverSoftware.LuftrauserClone.Toolbox.MathEngine;

public class Projectile implements IEntity {
	
	private final int PROJECTILE_SPEED = 10;
	
	private double x;
	private double y;
	private int direction;

	public Projectile(int x, int y, int direction){
		this.x=x;
		this.y=y;
		this.direction=direction;
	}
	
	@Override
	public Point getLocation() {
		return new Point((int)x,(int)y);
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		// something with graphics manager
	}

	@Override
	public void update() {
		this.move();
	}

	public void move(){
		double radDirection = MathEngine.degreesToRadians(direction);
		this.x += this.PROJECTILE_SPEED * Math.cos(radDirection);
		this.y += this.PROJECTILE_SPEED * Math.sin(radDirection);
	}

}

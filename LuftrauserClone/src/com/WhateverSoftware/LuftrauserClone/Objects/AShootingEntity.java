package com.WhateverSoftware.LuftrauserClone.Objects;

import java.awt.Point;

import com.WhateverSoftware.LuftrauserClone.StateManagers.IGameTickHandlerEntityView;

public abstract class AShootingEntity implements IEntity {
	
	protected double x;
	protected double y;
	private IGameTickHandlerEntityView gth;
	
	public AShootingEntity(int x, int y, IGameTickHandlerEntityView gth){
		this.x=x;
		this.y=y;
		this.gth=gth;
	}
	
	public void shoot(int x, int y, int direction){
		gth.register(new Projectile(x,y,direction));
	}
	
	@Override
	public Point getLocation() {
		return new Point((int)x,(int)y);
	}
}

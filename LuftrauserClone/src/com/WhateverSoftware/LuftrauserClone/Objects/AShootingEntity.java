package com.WhateverSoftware.LuftrauserClone.Objects;

import java.awt.Point;

import com.WhateverSoftware.LuftrauserClone.StateManagers.IGameTickHandlerEntityView;

public abstract class AShootingEntity implements IEntity {
	
	private final int COOLDOWN_PERIOD; //in ticks
	private int cooldownCounter;
	protected boolean coolingDown;
	protected int x;
	protected int y;
	private IGameTickHandlerEntityView gth;
	
	public AShootingEntity(int x, int y, int cooldownPeriod, IGameTickHandlerEntityView gth){
		this.x=x;
		this.y=y;
		this.COOLDOWN_PERIOD=cooldownPeriod;
		this.cooldownCounter=cooldownPeriod;
		this.coolingDown=false;
		this.gth=gth;
	}
	
	public void shoot(int direction){
		if(!this.coolingDown){
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
}

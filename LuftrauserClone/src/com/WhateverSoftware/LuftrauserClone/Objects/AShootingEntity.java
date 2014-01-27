package com.WhateverSoftware.LuftrauserClone.Objects;

import java.awt.Point;

import com.WhateverSoftware.LuftrauserClone.StateManagers.IGameTickHandlerEntityView;

public abstract class AShootingEntity implements IEntity {
	
	private final int COOLDOWN_PERIOD; //in ticks
	private int cooldownCounter;
	protected boolean coolingDown;
	protected int x;
	protected int y;
	protected int turnDirection = 0;
	protected boolean isShooting = false;
	private IGameTickHandlerEntityView gth;
	
	public AShootingEntity(int x, int y, int cooldownPeriod){
		this.x=x;
		this.y=y;
		this.COOLDOWN_PERIOD=cooldownPeriod;
		this.cooldownCounter=cooldownPeriod;
		this.coolingDown=false;
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
	
	public void setTurning(int direction) {
		if(direction == 1 || direction == -1 || direction == 0)
			turnDirection = direction;
	}
	
	public void setShooting(boolean shooting) {
		isShooting = shooting;
	}
}


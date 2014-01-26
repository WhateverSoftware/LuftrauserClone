package com.WhateverSoftware.LuftrauserClone.Objects;

import com.WhateverSoftware.LuftrauserClone.StateManagers.IGameTickHandlerEntityView;

public class UserAirplane extends AAirplane {

	private static final int COOLDOWN_PERIOD = 5; //ticks
	private static final int MAX_HEALTH = 100;
	
	private boolean isThrusting;
	private boolean isTurningC;
	private boolean isTurningCC;
	private boolean isShooting;
	
	public UserAirplane(int x, int y, int directionFacing, IGameTickHandlerEntityView gth) {
		super(x, y, directionFacing, COOLDOWN_PERIOD, MAX_HEALTH, gth);
		// TODO Auto-generated constructor stub
	}

	public void setIsThrusting(boolean isThrusting){
		this.isThrusting=isThrusting;
	}
	
	public void setIsTurningC(boolean isTurningC){
		this.isTurningC=isTurningC;
	}
	
	public void setIsTurningCC(boolean isTurningCC){
		this.isTurningCC=isTurningCC;
	}
	
	public void setIsShooting(boolean isShooting){
		this.isShooting=isShooting;
	}
	
	@Override
	public void update() {
		super.update(this.isThrusting,this.isTurningC,this.isTurningCC,this.isShooting);
	}

}

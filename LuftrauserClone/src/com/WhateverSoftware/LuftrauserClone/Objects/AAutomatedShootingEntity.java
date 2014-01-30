package com.WhateverSoftware.LuftrauserClone.Objects;

import com.WhateverSoftware.LuftrauserClone.AI.IAI;

public abstract class AAutomatedShootingEntity extends AShootingEntity {

	private IAI ai;
	
	public AAutomatedShootingEntity(int x, int y, IAI ai, int cooldownPeriod, int directionFacing, int health) {
		super(x, y, cooldownPeriod, directionFacing, health);
		this.ai=ai;
	}
	
	protected void runAI(){
		this.ai.processActions();
	}
	
	public void setAI(IAI ai){
		this.ai=ai;
	}

	@Override
	public void setThrust(boolean b) {
		// TODO Auto-generated method stub

	}

}

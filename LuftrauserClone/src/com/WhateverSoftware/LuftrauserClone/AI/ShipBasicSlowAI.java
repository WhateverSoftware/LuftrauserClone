package com.WhateverSoftware.LuftrauserClone.AI;

import com.WhateverSoftware.LuftrauserClone.Objects.IShootingEntityAIView;

public class ShipBasicSlowAI extends ABasicTargettingShipAI {

	private final double SHOOTING_RATE = 0.1;
	
	public ShipBasicSlowAI(IShootingEntityAIView user, IShootingEntityAIView me) {
		super(user, me);
	}

	/* If the Entity this AI controls is not cooling, have the Entity
	 * shoot at a rate equal to the rate specified by: SHOOTING_RATE
	 */
	@Override
	public void handleShooting() {
		boolean isCooling = super.me.isCooling();
		if(!isCooling&&Math.random()<=this.SHOOTING_RATE)
			super.me.setShooting(true);
		else
			super.me.setShooting(false);
	}

	@Override
	public void processActions() {
		super.handleAiming();
		this.handleShooting();
	}

}

package com.WhateverSoftware.LuftrauserClone.AI;

import com.WhateverSoftware.LuftrauserClone.Objects.IShootingEntityAIView;

public class ShipBasicTRBAI extends ABasicTargettingShipAI {
	
	private final double SHOOTING_RATE = 0.3;
	
	private boolean shooting;
	private int burstCounter;

	public ShipBasicTRBAI(IShootingEntityAIView user, IShootingEntityAIView me) {
		super(user, me);
		this.resetBurst();
	}

	/* If the three round burst is over, reset the burst.
	 * Otherwise, as long as the Entity this AI controls is not cooling, fire
	 *   and decrement the burst-counter.
	 * If the AI is not shooting, shoot based on SHOOTING_RATE
	 */
	@Override
	public void handleShooting() {
		if(this.burstCounter==0){
			this.resetBurst();
			super.me.setShooting(false);
		}
		else if(this.shooting){
			boolean isCooling = super.me.isCooling();
			if(!isCooling){
				super.me.setShooting(true);
				burstCounter--;
			}
			else
				super.me.setShooting(false);
		}
		else{
			if(Math.random()<=this.SHOOTING_RATE)
				this.shooting=true;
		}
	}

	@Override
	public void processActions() {
		super.handleAiming();
		this.handleShooting();
	}
	
	/* Sets shooting-mode to off
	 * Resets the counter for the three-round burst to 3
	 */
	private void resetBurst(){
		this.shooting=false;
		this.burstCounter=3;
	}

}

package com.WhateverSoftware.LuftrauserClone.AI.Ships;

import com.WhateverSoftware.LuftrauserClone.Objects.IShootingEntityAIView;

/**
 * @author WhateverSoftware
 * @class ShipBasicSlowAI
 * 		 	-Basic Targetting
 * 			-Slow Shooting
 */
public class ShipAdvancedTRBAI extends AAdvancedTargettingShipAI {
	
	//The rate that the controlled entity fires projectiles
	private final double SHOOTING_RATE = .1;
	
	//Evaluates as true of we are in the middle of a 3-round burst
	private boolean shooting;
		
	//Decrements burst from 3 to 0
	private int burstCounter;

	/**
	 * @constructor -Calls AAdvancedTargettingShipAI constructor
	 * 				-Calls ShipAdvancedTRBAI.resetBurst()
	 * @param user - The user's airplane
	 * @param me - The entity this AI controls
	 */
	public ShipAdvancedTRBAI(IShootingEntityAIView user, IShootingEntityAIView me) {
		super(user, me);
		this.resetBurst();
	}

	/**ShipAdvancedTRBAI.handleShooting()
	 * Shoots projectiles in increments of 3 at a rate of SHOOTING_RATE
	 */
	@Override
	public void handleShooting() {
		if(this.burstCounter==0){//If the 3-round burst is over
			//reset the burst
			this.resetBurst();
		}
		else if(this.shooting){//If we are currently shooting
			boolean isCooling = super.me.isCooling();
			if(!isCooling){//If we aren't cooling
				//Turn on shooting and increment the burst
				super.me.setShooting(true);
				burstCounter--;
			}
			else{//Otherwise:
				//Turn off shooting
				super.me.setShooting(false);
			}
		}
		else{
			//Start a 3-round burst at a rate of SHOOTING_RATE
			if(Math.random()<=this.SHOOTING_RATE)
				this.shooting=true;
		}
	}
	
	/**ShipAdvancedTRBAI.processActions()
	 * Calls AAdvancedTargettingShipAI.handleAiming()
	 * Calls ShipAdvancedTRBAI.handleShooting()
	 */
	@Override
	public void processActions() {
		super.handleAiming();
		this.handleShooting();
	}
	
	/**ShipAdvancedTRBAI.resetBurst()
	 * Sets shooting-mode to off
	 * Resets the counter for the three-round burst to 3
	 * Turns off shooting
	 */
	private void resetBurst(){
		this.shooting=false;
		this.burstCounter=3;
		super.me.setShooting(false);
	}

}

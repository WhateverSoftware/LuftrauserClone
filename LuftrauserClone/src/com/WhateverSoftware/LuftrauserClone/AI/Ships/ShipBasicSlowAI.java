package com.WhateverSoftware.LuftrauserClone.AI.Ships;

import com.WhateverSoftware.LuftrauserClone.Objects.IShootingEntityAIView;

/**
 * @author WhateverSoftware
 * @class ShipBasicSlowAI
 * 		 	-Basic Targetting
 * 			-Slow Shooting
 */
public class ShipBasicSlowAI extends ABasicTargettingShipAI {

	//The rate that the controlled entity fires projectiles
	private final double SHOOTING_RATE = 0.1;
	
	/**
	 * @constructor - Calls ABasicTargettingShipAI constructor
	 * @param user - The user's airplane
	 * @param me - The entity this AI controls
	 */
	public ShipBasicSlowAI(IShootingEntityAIView user, IShootingEntityAIView me) {
		super(user, me);
	}

	/**ShipBasicSlowAI.handleShooting()
	 * If the controlled entity is not cooling, the controlled entity will file projectiles
	 * at a rate of SHOOTING_RATE
	 */
	@Override
	public void handleShooting() {
		boolean isCooling = super.me.isCooling();
		if(!isCooling&&Math.random()<=this.SHOOTING_RATE)
			super.me.setShooting(true);
		else
			super.me.setShooting(false);
	}
	
	/**ShipBasicSlowAI.processActions()
	 * Calls ABasicTargettingShipAI.handleAiming()
	 * Calls ShipBasicSlowAI.handleShooting()
	 */
	@Override
	public void processActions() {
		super.handleAiming();
		this.handleShooting();
	}

}

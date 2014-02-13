package com.WhateverSoftware.LuftrauserClone.Objects;

import com.WhateverSoftware.LuftrauserClone.AI.IAI;

/**
 * @author WhateverSoftware
 * @class AAutomatedShootingEntity
 * 			-Represents all ShootingEntities with an AI
 */
public abstract class AAutomatedShootingEntity extends AShootingEntity {

	//The AI controlling this shooting entity
	private IAI ai;
	
	/**
	 * @constructor -Calls AShootingEntity constructor
	 * 				-Sets global variables
	 * @param x - x-location of entity
	 * @param y - y-location of entity
	 * @param ai - ai that controls entity
	 * @param cooldownPeriod - minimum cooling period between firing projectiles
	 * @param directionFacing - direction of entity
	 * @param health - health of entity
	 */
	public AAutomatedShootingEntity(int x, int y, IAI ai, int cooldownPeriod, int directionFacing, int health) {
		super(x, y, cooldownPeriod, directionFacing, health);
		this.ai=ai;
	}
	
	/**AAutomatedShootingEntity.runAI()
	 * Calls for the entity's ai to process actions
	 */
	protected void runAI(){
		this.ai.processActions();
	}
	
	/**AAutomatedShootingEntity.setAI()
	 * Replaces the current ai with a new one
	 * @param ai - The replacement AI
	 */
	public void setAI(IAI ai){
		this.ai=ai;
	}
}

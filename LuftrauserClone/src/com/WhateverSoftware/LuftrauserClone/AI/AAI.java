package com.WhateverSoftware.LuftrauserClone.AI;

import com.WhateverSoftware.LuftrauserClone.Objects.IShootingEntityAIView;

/**
 * @author WhateverSoftware
 * @class AAI
 */
public abstract class AAI {
	
	// All AI's have access to the entity they control
	protected IShootingEntityAIView me;
	
	// All AI's have access to the user
	protected IShootingEntityAIView user;
	
	/**
	 * @constructor Sets global-variables
 	 * @param user - The user's airplane
	 * @param me - The entity this AI controls
	 */
	public AAI(IShootingEntityAIView user, IShootingEntityAIView me){
		this.user=user;
		this.me=me;
	}
}

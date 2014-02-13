package com.WhateverSoftware.LuftrauserClone.AI.Ships;

import java.awt.Point;

import com.WhateverSoftware.LuftrauserClone.AI.AAI;
import com.WhateverSoftware.LuftrauserClone.Objects.IShootingEntityAIView;
import com.WhateverSoftware.LuftrauserClone.Toolbox.MathEngine;

/**
 * @author WhateverSoftware
 * @class ABasicTargettingShipAI
 */
public abstract class ABasicTargettingShipAI extends AAI implements IShipAI {
	
	/**
	 * @constructor - Calls AAI constructor
	 * @param user - The user's airplane
	 * @param me - The entity this AI controls
	 */
	public ABasicTargettingShipAI(IShootingEntityAIView user, IShootingEntityAIView me){
		super(user,me);
	}

	/**ABasicTargettingShipAI.handleAiming()
	 * Has the direction of the controlled entity turn towards the current location of the user
	 */
	@Override
	public void handleAiming() {
		//Take the location of the user and the controlled entity
		Point userLocation = super.user.getLocation();
		Point meLocation = super.me.getLocation();
		
		//Take the x and y components of the distance between the user and the controlled entity
		double dx = (double)userLocation.getX()/(double)meLocation.getY();
		double dy = (double)userLocation.getY()/(double)meLocation.getY();
		
		//Take the angle between the user and the controlled entity
		int degree = MathEngine.radiansToDegrees(Math.atan(dy/dx));
		
		//Have the controlled entity turn towards the user
		if(degree>super.me.getDirectionFacing())
			super.me.setTurning(-1);
		else if(degree<super.me.getDirectionFacing())
			super.me.setTurning(1);
		else
			super.me.setTurning(0);
	}
}

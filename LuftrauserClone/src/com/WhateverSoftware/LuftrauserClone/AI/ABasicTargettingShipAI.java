package com.WhateverSoftware.LuftrauserClone.AI;

import java.awt.Point;

import com.WhateverSoftware.LuftrauserClone.Objects.IShootingEntityAIView;
import com.WhateverSoftware.LuftrauserClone.Toolbox.MathEngine;

public abstract class ABasicTargettingShipAI extends AAI implements IShipAI {
	
	public ABasicTargettingShipAI(IShootingEntityAIView user, IShootingEntityAIView me){
		super(user,me);
	}

	/* Aims the entities cannon directly at user
	 */
	@Override
	public void handleAiming() {
		Point userLocation = super.user.getLocation();
		Point meLocation = super.me.getLocation();
		double dx = (double)userLocation.getX()/(double)meLocation.getY();
		double dy = (double)userLocation.getY()/(double)meLocation.getY();
		int degree = MathEngine.radiansToDegrees(Math.atan(dy/dx));
		if(degree>super.me.getDirectionFacing())
			super.me.setTurning(-1);
		else if(degree<super.me.getDirectionFacing())
			super.me.setTurning(1);
		else
			super.me.setTurning(0);
	}

}

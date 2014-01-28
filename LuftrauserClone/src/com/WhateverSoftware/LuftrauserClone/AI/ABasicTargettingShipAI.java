package com.WhateverSoftware.LuftrauserClone.AI;

import java.awt.Point;

import com.WhateverSoftware.LuftrauserClone.Objects.IShootingEntityAIView;
import com.WhateverSoftware.LuftrauserClone.Toolbox.MathEngine;

public abstract class ABasicTargettingShipAI implements IShipAI {

	protected IShootingEntityAIView user;
	protected IShootingEntityAIView me;
	
	public ABasicTargettingShipAI(IShootingEntityAIView user, IShootingEntityAIView me){
		this.user=user;
		this.me=me;
	}

	/* Aims the entities cannon directly at user
	 */
	@Override
	public void handleAiming() {
		Point userLocation = user.getLocation();
		Point meLocation = me.getLocation();
		double dx = (double)userLocation.getX()/(double)meLocation.getY();
		double dy = (double)userLocation.getY()/(double)meLocation.getY();
		int degree = MathEngine.radiansToDegrees(Math.atan(dy/dx));
		if(degree>me.getDirectionFacing())
			me.setTurning(-1);
		else if(degree<me.getDirectionFacing())
			me.setTurning(1);
		else
			me.setTurning(0);
	}

}

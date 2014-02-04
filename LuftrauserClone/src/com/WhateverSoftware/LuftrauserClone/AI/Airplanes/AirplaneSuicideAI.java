package com.WhateverSoftware.LuftrauserClone.AI.Airplanes;

import java.awt.Point;

import com.WhateverSoftware.LuftrauserClone.Objects.IShootingEntityAIView;
import com.WhateverSoftware.LuftrauserClone.Toolbox.MathEngine;

public class AirplaneSuicideAI implements IAirplaneAI {

	private IShootingEntityAIView user;
	private IShootingEntityAIView me;
	
	public AirplaneSuicideAI(IShootingEntityAIView user, IShootingEntityAIView me){
		this.user=user;
		this.me=me;
	}
	
	@Override
	public void processActions() {
		this.establishFlightManeuver();
		this.establishShooting();
	}

	/* Directs the plane this AI controls towards the user and
	 * thrusts to maximum acceleration.
	 */
	@Override
	public void establishFlightManeuver() {
		Point userLocation = user.getLocation();
		Point meLocation = me.getLocation();
		double dx = (double)userLocation.getX() - (double)meLocation.getX();
		double dy = (double)userLocation.getY() - (double)meLocation.getY();
		int degree = MathEngine.radiansToDegrees(Math.atan(dy/dx));
		if(degree>me.getDirectionFacing())
			me.setTurning(-1);
		else if(degree<me.getDirectionFacing())
			me.setTurning(1);
		me.setThrust(true);
	}

	/* The suicideAI does not shoot.
	 */
	@Override
	public void establishShooting() {
		return;
	}

}

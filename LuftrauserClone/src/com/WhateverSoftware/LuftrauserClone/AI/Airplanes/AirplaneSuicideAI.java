package com.WhateverSoftware.LuftrauserClone.AI.Airplanes;

import java.awt.Point;

import com.WhateverSoftware.LuftrauserClone.AI.AAI;
import com.WhateverSoftware.LuftrauserClone.Objects.IShootingEntityAIView;
import com.WhateverSoftware.LuftrauserClone.Toolbox.MathEngine;

/**
 * @author WhateverSoftware
 * @class AirplaneSuicideAI
 */
public class AirplaneSuicideAI extends AAI implements IAirplaneAI {
	
	/**
	 * @constructor - calls AAI constructor
	 * @param user - The user's airplane
	 * @param me - The entity this AI controls
	 */
	public AirplaneSuicideAI(IShootingEntityAIView user, IShootingEntityAIView me){
		super(user,me);
	}
	
	/**AirplaneSuicideAI.processActions()
	 * Calls AirplaneSuicideAI.establishFlightManeuver()
	 * Calls AirplaneSuicideAI.establishShooting()
	 */
	@Override
	public void processActions() {
		this.establishFlightManeuver();
		this.establishShooting();
	}

	/**AirplaneSuicideAI.establishFlightManeuver()
	 * Directs the entity this AI controls towards the user's airplane
	 * Thrusts
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

	/**AirplaneSuicideAI.establishShooting()
	 * The AirplaneSuicideAI never calls for the entity it controls to shoot
	 */
	@Override
	public void establishShooting() {
		return;
	}

}

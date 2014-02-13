package com.WhateverSoftware.LuftrauserClone.AI.Airplanes;

import com.WhateverSoftware.LuftrauserClone.AI.IAI;

/**
 * @author WhateverSoftware
 * @interface IAirplaneAI
 */
public interface IAirplaneAI extends IAI {
	//All Airplane's fly and shoot
	public void establishFlightManeuver();
	public void establishShooting();
}

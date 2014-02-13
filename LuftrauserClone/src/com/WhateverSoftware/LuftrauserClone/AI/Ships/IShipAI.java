package com.WhateverSoftware.LuftrauserClone.AI.Ships;

import com.WhateverSoftware.LuftrauserClone.AI.IAI;

/**
 * @author WhateverSoftware
 * @interface IShipAI
 */
public interface IShipAI extends IAI{
	//All Ships Aim
	public void handleAiming();
	//All Ships Shoot
	public void handleShooting();
}

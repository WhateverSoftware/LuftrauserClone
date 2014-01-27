package com.WhateverSoftware.LuftrauserClone.Objects;

import com.WhateverSoftware.LuftrauserClone.StateManagers.IGameTickHandlerEntityView;

public class UserAirplane extends AAirplane {

	private static final int COOLDOWN_PERIOD = 5; //ticks
	private static final int MAX_HEALTH = 100;
	
	public UserAirplane(int x, int y, int directionFacing, IGameTickHandlerEntityView gth) {
		super(x, y, directionFacing, COOLDOWN_PERIOD, MAX_HEALTH, gth);
		// TODO Auto-generated constructor stub
	}

}

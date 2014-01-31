package com.WhateverSoftware.LuftrauserClone.Objects.Airplanes;


public class UserAirplane extends AAirplane {

	private static final int COOLDOWN_PERIOD = 5; //ticks
	private static final int MAX_HEALTH = 100;
	
	public UserAirplane(int x, int y, int directionFacing) {
		super(x, y, directionFacing, COOLDOWN_PERIOD, MAX_HEALTH);
		// TODO Auto-generated constructor stub
	}

}

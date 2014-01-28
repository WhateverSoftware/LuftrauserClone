package com.WhateverSoftware.LuftrauserClone.Objects;

import java.awt.Point;
import java.awt.geom.Point2D;

public interface IShootingEntityAIView {
	public Point getLocation();
	public int getDirectionFacing();
	public void setShooting(boolean b);
	public void setThrust(boolean b);
	public void setTurning(int i);
	public int getCooldownPeriod();
	public Point2D.Double getVelocity();
	public boolean isCooling();
}

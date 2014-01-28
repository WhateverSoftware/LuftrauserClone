package com.WhateverSoftware.LuftrauserClone.Objects;

import java.awt.Point;

public interface IShootingEntityAIView {
	public Point getLocation();
	public int getDirectionFacing();
	public void setThrust(boolean b);
	public void setTurning(int i);
}

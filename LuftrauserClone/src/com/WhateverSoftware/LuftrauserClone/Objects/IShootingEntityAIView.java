package com.WhateverSoftware.LuftrauserClone.Objects;

import java.awt.Point;
import java.awt.geom.Point2D;

/**
 * @author WhateverSoftware
 * @interface IShootingEntityAIView
 */
public interface IShootingEntityAIView {
	//Entities are permitted to view the following methods of the class: AShootingEntity
	public Point getLocation();
	public int getDirectionFacing();
	public void setShooting(boolean b);
	public void setThrust(boolean b);
	public void setTurning(int i);
	public int getCooldownPeriod();
	public Point2D.Double getVelocity();
	public boolean isCooling();
}

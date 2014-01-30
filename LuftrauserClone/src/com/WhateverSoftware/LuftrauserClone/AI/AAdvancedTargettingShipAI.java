package com.WhateverSoftware.LuftrauserClone.AI;

import java.awt.Point;
import java.awt.geom.Point2D;

import com.WhateverSoftware.LuftrauserClone.Objects.IShootingEntityAIView;
import com.WhateverSoftware.LuftrauserClone.Objects.Projectile;
import com.WhateverSoftware.LuftrauserClone.Toolbox.MathEngine;

public abstract class AAdvancedTargettingShipAI extends AAI implements IShipAI{

	private final int ACCEPTABLE_MIN = -5;
	private final int ACCEPTABLE_MAX = 5;
	
	private int idealDirection;
	
	public AAdvancedTargettingShipAI(IShootingEntityAIView user, IShootingEntityAIView me){
		super(user,me);
		this.idealDirection = 90;
	}
	
	@Override
	public void handleAiming(){
		Point userLocation = super.user.getLocation();
		Point meLocation = super.me.getLocation();
		Point2D.Double userVelocity = super.user.getVelocity();
		int projectileSpeed = Projectile.PROJECTILE_SPEED;
		Point projectedLocation = MathEngine.solveSystem(userLocation, userVelocity, meLocation, projectileSpeed);
		int projectedAngle = MathEngine.radiansToDegrees(Math.atan((projectedLocation.getY()-userLocation.getY())/(projectedLocation.getX()-userLocation.getX())));
		this.idealDirection = projectedAngle;
		int directionFacing = super.me.getDirectionFacing();
		if(projectedAngle > directionFacing)
			super.me.setTurning(-1);
		else if(projectedAngle < directionFacing)
			super.me.setTurning(1);
		else
			super.me.setTurning(0);
	}
	
	protected boolean inAcceptableRange(){
		return super.me.getDirectionFacing()>=this.idealDirection+this.ACCEPTABLE_MIN &&
				super.me.getDirectionFacing()<=this.idealDirection+this.ACCEPTABLE_MAX;
	}

	
}

package com.WhateverSoftware.LuftrauserClone.AI;

import java.awt.Point;
import java.awt.geom.Point2D;

import com.WhateverSoftware.LuftrauserClone.Objects.IShootingEntityAIView;
import com.WhateverSoftware.LuftrauserClone.Objects.Projectile;
import com.WhateverSoftware.LuftrauserClone.Toolbox.MathEngine;

public abstract class AAdvancedTargettingShipAI implements IShipAI{

	private final int ACCEPTABLE_MIN = -5;
	private final int ACCEPTABLE_MAX = 5;
	
	protected IShootingEntityAIView user;
	protected IShootingEntityAIView me;
	private int idealDirection;
	
	public AAdvancedTargettingShipAI(IShootingEntityAIView user, IShootingEntityAIView me){
		this.user=user;
		this.me=me;
		this.idealDirection = 90;
	}
	
	@Override
	public void handleAiming(){
		Point userLocation = this.user.getLocation();
		Point meLocation = this.me.getLocation();
		Point2D.Double userVelocity = this.user.getVelocity();
		int projectileSpeed = Projectile.PROJECTILE_SPEED;
		Point projectedLocation = MathEngine.solveSystem(userLocation, userVelocity, meLocation, projectileSpeed);
		int projectedAngle = MathEngine.radiansToDegrees(Math.atan((projectedLocation.getY()-userLocation.getY())/(projectedLocation.getX()-userLocation.getX())));
		this.idealDirection = projectedAngle;
		int directionFacing = me.getDirectionFacing();
		if(projectedAngle > directionFacing)
			me.setTurning(-1);
		else if(projectedAngle < directionFacing)
			me.setTurning(1);
		else
			me.setTurning(0);
	}
	
	protected boolean inAcceptableRange(){
		return me.getDirectionFacing()>=this.idealDirection+this.ACCEPTABLE_MIN &&
				me.getDirectionFacing()<=this.idealDirection+this.ACCEPTABLE_MAX;
	}

	
}

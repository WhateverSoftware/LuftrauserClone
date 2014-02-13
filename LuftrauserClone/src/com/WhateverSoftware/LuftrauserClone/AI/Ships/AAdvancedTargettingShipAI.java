package com.WhateverSoftware.LuftrauserClone.AI.Ships;

import java.awt.Point;
import java.awt.geom.Point2D;

import com.WhateverSoftware.LuftrauserClone.AI.AAI;
import com.WhateverSoftware.LuftrauserClone.Objects.IShootingEntityAIView;
import com.WhateverSoftware.LuftrauserClone.Objects.Projectile;
import com.WhateverSoftware.LuftrauserClone.Toolbox.MathEngine;

/**
 * @author WhateverSoftware
 * @class AdvancedTargettingShipAI
 */
public abstract class AAdvancedTargettingShipAI extends AAI implements IShipAI{

	//The acceptable range of deviation from 'idealDirection'
	private final int ACCEPTABLE_MIN = -5;
	private final int ACCEPTABLE_MAX = 5;
	
	//The angle formed between 'me' and the predicted location of 'user'
	private int idealDirection;
	
	/**
	 * @constructor -Calls AAI constructor
	 * 				-Sets 'idealDirection' to 90
	 * @param user - The user's airplane
	 * @param me - The entity this AI controls
	 */
	public AAdvancedTargettingShipAI(IShootingEntityAIView user, IShootingEntityAIView me){
		super(user,me);
		this.idealDirection = 90;
	}
	
	/**AAdvancedTargettingShipAI.handleAiming()
	 * Uses advanced-algorithm to determine the ideal direction of the controlled entity
	 */
	@Override
	public void handleAiming(){
		//Take the location of the user and the controlled entity
		Point userLocation = super.user.getLocation();
		Point meLocation = super.me.getLocation();
		
		//Take the velocity of the user
		Point2D.Double userVelocity = super.user.getVelocity();
		
		//Take the velocity of a projectile fired from the controlled entity
		int projectileSpeed = Projectile.PROJECTILE_SPEED;
		
		//Calculate the projected location of the user based on the two velocity's taken
		Point projectedLocation = MathEngine.solveSystem(userLocation, userVelocity, meLocation, projectileSpeed);
		
		//Set the idealDirection for this AI to the projected angle of the system in degrees
		int projectedAngle = MathEngine.radiansToDegrees(Math.atan((projectedLocation.getY()-userLocation.getY())/(projectedLocation.getX()-userLocation.getX())));
		this.idealDirection = projectedAngle;
		
		//Take the direction of the controlled entity
		int directionFacing = super.me.getDirectionFacing();
		
		//Have the controlled entity turn towards the ideal direction
		if(projectedAngle > directionFacing)
			super.me.setTurning(-1);
		else if(projectedAngle < directionFacing)
			super.me.setTurning(1);
		else
			super.me.setTurning(0);
	}
	
	/**AAdvancedTargettingShipAI.inAcceptableRange()
	 * Returns a value of true if the controlled entity's direction is within an acceptable range of the ideal direction
	 * @return boolean
	 */
	protected boolean inAcceptableRange(){
		return super.me.getDirectionFacing()>=this.idealDirection+this.ACCEPTABLE_MIN &&
				super.me.getDirectionFacing()<=this.idealDirection+this.ACCEPTABLE_MAX;
	}

	
}

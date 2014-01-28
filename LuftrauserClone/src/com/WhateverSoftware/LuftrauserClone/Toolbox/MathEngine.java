package com.WhateverSoftware.LuftrauserClone.Toolbox;

import java.awt.geom.Point2D;

public class MathEngine {
	//I'm just guessing with these. They can be adjusted once we get a visual representation working.
	private static final double friction = 0.2;
	private static final double gravity = 0.1;

	public static double degreesToRadians(int degree){
		return degree * Math.PI / 180;
	}
	
	public static int radiansToDegrees(double radian){
		return (int)(radian / Math.PI * 180);
	}
	
	public static double pythagorean(double x, double y){
		return Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
	}
	
	/**
	 * Takes in velocity components, plane acceleration, and direction of movement.
	 * Calculates new velocity for a single tick and returns as a Point.
	 * 
	 * NOTE: This is just my interpretation. Look over it and give feedback. 
	 * 
	 * @param velx - X-component of velocity
	 * @param vely - Y-component of velocity
	 * @param thrust - vector value of acceleration
	 * @param direction - angle in degrees of the plane's orientation
	 * @return Store the x-component and y-component of new velocity in a Point2D.Double object
	 */
	public static double calcVelocity(double velx, double vely, double thrust, int direction) {
		double radDirectionFacing = MathEngine.degreesToRadians(direction);
		double thrustX = thrust * Math.cos(radDirectionFacing);
		double thrustY = thrust * Math.sin(radDirectionFacing);
		
		//adjust for friction
		velx *= (1-friction);
		vely *= (1-friction);
		
		//adjust with new acceleration and gravity
		velx += thrustX;
		vely += thrustY - gravity;
		
		//scale to max_magnitude
		int maxMagnitude = AAirplane.MAX_VELOCITY;
		int currentMagnitude = pythagorean(velx,vely);
		if(currentMagnitude>maxMagnitude){
			velx = velx / currentMagnitude * maxMagnitude;
			vely = vely / currentMagnitude * maxMagnitude;
		}
		
		return new Point2D.Double(velx, vely);
	}
}

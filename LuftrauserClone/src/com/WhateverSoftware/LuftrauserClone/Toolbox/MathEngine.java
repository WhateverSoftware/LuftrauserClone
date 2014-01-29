package com.WhateverSoftware.LuftrauserClone.Toolbox;

import java.awt.Point;
import java.awt.geom.Point2D;

import com.WhateverSoftware.LuftrauserClone.Objects.AAirplane;

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
	public static Point2D.Double calcVelocity(double velx, double vely, double thrust, int direction) {
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
		int currentMagnitude = (int)pythagorean(velx,vely);
		if(currentMagnitude>maxMagnitude){
			velx = velx / currentMagnitude * maxMagnitude;
			vely = vely / currentMagnitude * maxMagnitude;
		}
		
		return new Point2D.Double(velx, vely);
	}
	
	/**
	 * Takes in locations and velocity components of two points and finds the point of their intersection.
	 * 
	 * @param location1 -point that we will be modifying to find projectedLocation
	 * @param velocity1 -velocity of location1
	 * @param location2 -static point we will be using to find projectedLocation
	 * @param velocity2 -velocity of location2
	 * @return -the projected location
	 */
	public static Point solveSystem(Point location1, Point2D.Double velocity1, Point location2, int velocity2){
		double x1 = location1.getX();
		double y1 = location1.getY();
		double dx1 = velocity1.getX();
		double dy1 = velocity1.getY();
		double dvelocity = MathEngine.pythagorean(dx1,dy1);
		double x2 = location2.getX();
		double y2 = location2.getY();
		int ticks1 = 0;
		int ticks2 = 0;
		Point2D.Double sharedLocation;
		do{
			sharedLocation = new Point2D.Double(x1,y1);
			double distance1 = MathEngine.pythagorean(x1-sharedLocation.getX(), y1-sharedLocation.getY());
			double distance2 = MathEngine.pythagorean(x2-sharedLocation.getX(), y2-sharedLocation.getY());
			if(distance1==0)
				ticks1=0;
			else
				ticks1=(int)(distance1/dvelocity);
			if(distance2==0)
				ticks2=0;
			else
				ticks2=(int)(distance2/velocity2);
			x1 += dx1;
			x2 += dy1;
		}while(!Math.abs(ticks1-ticks2)<=1);
		Point projectedLocation = new Point((int)sharedLocation.getX(),(int)sharedLocation.getY());
		return projectedLocation;
	}
}

package com.WhateverSoftware.LuftrauserClone.Toolbox;

import java.awt.Point;
import java.awt.geom.Point2D;

import com.WhateverSoftware.LuftrauserClone.Objects.Airplanes.AAirplane;

/**
 * @author WhateverSoftware
 * @class MathEngine
 */
public class MathEngine {
	
	//Value velocity is depreciated by each thrust
	private static final double friction = 0.01;
	
	//Value velocity is weighted by in the +y direction
	private static final double gravity = 0.15;

	/**MathEngine.degreesToRadians()
	 * Takes an angle in degrees and converts it to it's radian counterpart
	 * @param degree - The degree we are converting
	 * @return double - The angle in radians
	 */
	public static double degreesToRadians(int degree){
		return degree * Math.PI / 180;
	}
	
	/**MathEngine.radiansToDegrees()
	 * Takes an angle in radians and converts it to it's degree counterpart
	 * @param radian - The angle we are converting
	 * @return int - The angle in degrees
	 */
	public static int radiansToDegrees(double radian){
		return (int)(radian / Math.PI * 180);
	}
	
	/**MathEngine.pythagorean()
	 * Calculates 'C' with the formula: square root of (A^2 + B^2)
	 * @param x - The 'A' value
	 * @param y - The 'B' value
	 * @return double - The 'C' value
	 */
	public static double pythagorean(double x, double y){
		return Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
	}
	
	/**MathEngine.calcVelocity()
	 * Takes in velocity components, plane acceleration, and direction of movement.
	 * Calculates new velocity for a single tick and returns as a Point.
	 * @param velx - X-component of velocity
	 * @param vely - Y-component of velocity
	 * @param thrust - vector value of acceleration
	 * @param direction - angle in degrees of the plane's orientation
	 * @return Store the x-component and y-component of new velocity in a Point2D.Double object
	 */
	public static Point2D.Double calcVelocity(double velx, double vely, double thrust, int direction) {
		double radDirectionFacing = MathEngine.degreesToRadians(direction);
		double thrustX = thrust * Math.cos(radDirectionFacing);
		double thrustY = -thrust * Math.sin(radDirectionFacing);
		
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
	
	/**MathEngine.solveSystem()
	 * Takes in locations and velocity components of two points and finds the point of their intersection.
	 * @param location1 -point that we will be modifying to find projectedLocation
	 * @param velocity1 -velocity of location1
	 * @param location2 -static point we will be using to find projectedLocation
	 * @param velocity2 -velocity of location2
	 * @return -the projected location
	 */
	public static Point solveSystem(Point location1, Point2D.Double velocity1, Point location2, int velocity2){
		//Take the location of the first point
		double x1 = location1.getX();
		double y1 = location1.getY();
		
		//Take the velocity of the first point
		double dx1 = velocity1.getX();
		double dy1 = velocity1.getY();
		
		//Calculate the velocity vector of the first point
		double dvelocity = MathEngine.pythagorean(dx1,dy1);
		
		//Take the location of the second point
		double x2 = location2.getX();
		double y2 = location2.getY();
		
		//Ticks it takes for point 1 to get to shared location
		int ticks1 = 0;
		
		//Ticks it takes for point 2 to get to shared location
		int ticks2 = 0;
		
		//The projected location of point 1 going at velocity 1 meeting point 2 going at velocity 2
		Point2D.Double sharedLocation;
		
		do{
			//Set the shared location equal to the newly established point
			sharedLocation = new Point2D.Double(x1,y1);
			
			//Take the distance between point 1 and the shared Location
			double distance1 = MathEngine.pythagorean(x1-sharedLocation.getX(), y1-sharedLocation.getY());
			
			//Take the distance between point 2 and the shared Location
			double distance2 = MathEngine.pythagorean(x2-sharedLocation.getX(), y2-sharedLocation.getY());
			
			
			if(distance1==0)//if the distance between point 1 and sharedLocation is 0
				ticks1=0;//it takes no time for point 1 to reach sharedLocation
			else//otherwise calculate the ticks
				ticks1=(int)(distance1/dvelocity);
			
			if(distance2==0)//if the distance between point 2 and sharedLocation is 0
				ticks2=0;//it takes no time for point 2 to reach sharedLocation
			else//otherwise calculate the ticks
				ticks2=(int)(distance2/velocity2);
			
			//increment the next point to test
			x1 += dx1;
			x2 += dy1;
		}while(!(Math.abs(ticks1-ticks2)<=1));//repeat this process until the time difference is close to 0
		
		//Instantiate a point representing the projected location
		Point projectedLocation = new Point((int)sharedLocation.getX(),(int)sharedLocation.getY());
		return projectedLocation;
	}
}

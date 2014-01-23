package com.WhateverSoftware.LuftrauserClone.Toolbox;

public class MathEngine {

	public static double degreesToRadians(int degree){
		return degree * Math.PI / 180;
	}
	
	public static int radiansToDegrees(double radian){
		return (int)(radian / Math.PI * 180);
	}
	
	public static double pythagorean(double x, double y){
		return Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
	}
}

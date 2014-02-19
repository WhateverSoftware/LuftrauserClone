package com.WhateverSoftware.LuftrauserClone.AI.Airplanes;

public enum AAirplaneStateEnum implements IAirplaneAI
{
	//The reason the most accurate "ai type" is of type SUICIDE is because of the plane's nature
	//to chase the player although never reaching them due to a slower acceleration/ thrust.<br><br>
	//I realize that in the game we are replicating, ALL of the planes essentially are suicidal, however
	//these other AIs are present as a challenge for the player as they aim to kill and not be killed, and for 
	//us as programmers to write the AI.
	
	TOP(5, 20, 0.7f),
	HIGH(4, 30, 0.65f),
	MEDIUM(3, 50, 0.6f),
	LOW(2, 70, 0.55f),
	BOTTOM(1, 100, 0.5f),
	SUICIDE(0, 0, 1.0f); 
	
	
	public final int level, reactionSpeed;//out of 100 milliseconds
	public final float accuracy;
	
	private int reactionSpeedVariant;
	private float accuracyVariant;
	
	AAirplaneStateEnum(int level, int reactionSpeed, float accuracy)
	{
		this.level=level;
		this.reactionSpeed=this.reactionSpeedVariant=reactionSpeed;
		this.accuracy=this.accuracyVariant=accuracy;
	}
	
	/**
	 * Adjusts the object's ai to coordinate with the skill of the player
	 * 
	 * @param int userHitMissRate - TODO: ensure proper data to be used for accurate representation
	 * 	of the player's skill
	 * 
	 * @return AAirplaneStateEnum newState - this is the newly updated Ai (with new stats as well) for an AiAirplane
	 */
	public AAirplaneStateEnum adjustAiStats(int userHitMissRate)
	{
		float skill=this.getUserSkill();
		
		AAirplaneStateEnum newState;
		
		switch(skill){
			case skill<this.BOTTOM.accuracy: newState = this.SUICIDE; break;
			case skill<this.LOW.accuracy: newState = this.BOTTOM; break;
			case skill<this.MEDIUM.accuracy: newState = this.LOW; break;
			case skill<this.HIGH.accuracy: newState = this.MEDIUM; break;
			case skill<this.TOP.accuracy: newState = this.HIGH; break;
			case skill>this.TOP.accuracy: newState = this.TOP; break;
			default: newState = this.SUICIDE; break;
		}
		
		return newState;
	}

	
	/**
	 * Generates a portfolio/ stat over how well the player is doing and returns the percentage 
	 * as a float.<br><br>
	 * 
	 * This may be done by a hit/miss ratio over the course of 5 to 10 seconds?
	 * 
	 * @return float - percentage of player skill
	 */
	private float getUserSkill()
	{
		return 0;
	}

	@Override
	public void processActions() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void establishFlightManeuver() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void establishShooting() {
		// TODO Auto-generated method stub
		
	}
}

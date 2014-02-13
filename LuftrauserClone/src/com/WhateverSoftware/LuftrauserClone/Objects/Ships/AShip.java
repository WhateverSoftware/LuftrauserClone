package com.WhateverSoftware.LuftrauserClone.Objects.Ships;

import com.WhateverSoftware.LuftrauserClone.AI.IAI;
import com.WhateverSoftware.LuftrauserClone.Objects.AAutomatedShootingEntity;

/**
 * @author WhateverSoftware
 * @class AShip
 */
public abstract class AShip extends AAutomatedShootingEntity{
	
	/**
	 * @constructor -Calls AAutomatedShootingEntity constructor
	 * 				-Sets global variables
	 * @param x - x-position of this entity
	 * @param y - y-position of this entity
	 * @param ai - The AI that controls this entity
	 * @param speed - The speed this entity moves at
	 * @param directionFacing - This entities direction
	 * @param cooldownPeriod - The minimum period of time between the firing of projectiles from this entity
	 * @param health - health of this entity
	 */
	public AShip(int x, int y, IAI ai, int speed, int directionFacing, int cooldownPeriod, int health){
		super(x,y,ai, cooldownPeriod,directionFacing,health);
		this.velx=speed;
	}
	
	/**AShip.update()
	 * Call all of the actions that need to be performed in a game tick.
	 */
	public void update(){
		super.handleCooling();
		this.turn();
		this.move();
		shoot(this.directionFacing);
	}
	
	/**AShip.setMoveDirection()
	 * Changes the direction of movement for the ship.
	 * @param direction - Indicates which direction the ship will move. Only accepts 0, 1 (for right), and -1 (for left).
	 */
	public void setMoveDirection(int direction) {
		if(direction == 1 || direction == -1 || direction == 0)
			velx *= direction;
	}
	
	@Override
	public void setThrust(boolean b){
		//right now nothing FIX LATER
	}
}

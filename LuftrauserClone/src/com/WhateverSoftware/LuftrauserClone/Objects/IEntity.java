package com.WhateverSoftware.LuftrauserClone.Objects;

import java.awt.Point;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * @author WhateverSoftware
 * @interface IEntity
 */
public interface IEntity {
	//All entities have a location
	public Point getLocation();
	
	//All entities have a graphical representation
	public void draw(SpriteBatch batch, int xOffset, int yOffset);
	
	//All entities can be updated
	public void update();
}

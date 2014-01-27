package com.WhateverSoftware.LuftrauserClone.Objects;

import java.awt.Point;

import com.WhateverSoftware.LuftrauserClone.Graphics.Assets;
import com.WhateverSoftware.LuftrauserClone.Toolbox.MathEngine;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Projectile implements IEntity {
	
	private final int PROJECTILE_SPEED = 10;
	
	private double x;
	private double y;
	private int direction;

	public Projectile(int x, int y, int direction){
		this.x=x;
		this.y=y;
		this.direction=direction;
	}
	
	@Override
	public Point getLocation() {
		return new Point((int)x,(int)y);
	}

	@Override
	public void draw(SpriteBatch batch) {
		// will need some way to differentiate between projectile textures
		
		// Math here to rotate texture to match angle
		batch.draw(Assets.assetManager.get("Boats/ship1.png", Texture.class), (float)x, (float)y);
	}

	@Override
	public void update() {
		this.move();
	}

	public void move(){
		double radDirection = MathEngine.degreesToRadians(direction);
		this.x += this.PROJECTILE_SPEED * Math.cos(radDirection);
		this.y += this.PROJECTILE_SPEED * Math.sin(radDirection);
	}

}

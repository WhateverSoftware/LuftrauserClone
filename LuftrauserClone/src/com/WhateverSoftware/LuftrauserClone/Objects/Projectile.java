package com.WhateverSoftware.LuftrauserClone.Objects;

import java.awt.Point;

import com.WhateverSoftware.LuftrauserClone.Graphics.Assets;
import com.WhateverSoftware.LuftrauserClone.Toolbox.MathEngine;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * @author WhateverSoftware
 * @class Projectile
 */
public class Projectile implements IEntity {
	
	//The speed that all Projectiles move at in the game
	public static final int PROJECTILE_SPEED = 30;
	
	//The location-data of this projectile
	private double x;
	private double y;
	private int direction;

	/**
	 * @constructor -Set global variables
	 * @param x - x-position of this projectile
	 * @param y - y-position of this projectile
	 * @param direction - direction of this projectile
	 */
	public Projectile(int x, int y, int direction){
		this.x=x;
		this.y=y;
		this.direction=direction;
	}
	
	/**Projectile.getLocation()
	 * @return Point - the location of this projectile
	 */
	@Override
	public Point getLocation() {
		return new Point((int)x,(int)y);
	}

	/**Projectile.draw()
	 * Draws this projectile to the screen in the correct orientation
	 */
	@Override
	public void draw(SpriteBatch batch,int xOffset,int yOffset) {
		//BULLETS ARE NOT THE SAME AS BOATS! FIX!!!!!!!!!!
		Texture texture = Assets.assetManager.get("Boats/ship1.png", Texture.class);
		Sprite sprite = new Sprite(texture);
		sprite.setBounds((int)x-xOffset, (int)y-yOffset, (int)(texture.getWidth()/3.0), (int)(texture.getHeight()/3.0));
		sprite.setOrigin(sprite.getWidth()/2,sprite.getHeight()/4);
		sprite.rotate(-direction);
		sprite.draw(batch);
	}

	/**Projectile.update()
	 * Moves the projectile
	 */
	@Override
	public void update() {
		this.move();
	}

	public void move(){
		double radDirection = MathEngine.degreesToRadians(direction);
		this.x += Projectile.PROJECTILE_SPEED * Math.cos(radDirection);
		this.y -= Projectile.PROJECTILE_SPEED * Math.sin(radDirection);
	}

}

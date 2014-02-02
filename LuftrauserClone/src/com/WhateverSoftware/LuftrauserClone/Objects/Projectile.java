package com.WhateverSoftware.LuftrauserClone.Objects;

import java.awt.Point;

import com.WhateverSoftware.LuftrauserClone.Graphics.Assets;
import com.WhateverSoftware.LuftrauserClone.Toolbox.MathEngine;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Projectile implements IEntity {
	
	public static final int PROJECTILE_SPEED = 30;
	
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
		Texture texture = Assets.assetManager.get("Boats/ship1.png", Texture.class);
		Sprite sprite = new Sprite(texture);
		sprite.setBounds((int)x, (int)y, (int)(texture.getWidth()/3.0), (int)(texture.getHeight()/3.0));
		sprite.setOrigin(sprite.getWidth()/2,sprite.getHeight()/4);
		sprite.rotate(-direction);
		sprite.draw(batch);
	}

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

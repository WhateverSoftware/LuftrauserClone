package com.WhateverSoftware.LuftrauserClone.Objects;

import java.awt.Point;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface IEntity {
	public Point getLocation();
	public void draw(SpriteBatch batch);
	public void update(float delta);
}

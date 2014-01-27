package com.WhateverSoftware.LuftrauserClone.Screens;

import com.WhateverSoftware.LuftrauserClone.Graphics.Assets;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class LoadingBar extends Actor {
	BitmapFont font;

	public LoadingBar(float width, float height) {
		setPosition(0, 0);
		setWidth(width);
		setHeight(height);

		font = new BitmapFont();
	}

	public void act(float delta) {

	}

	public void draw(SpriteBatch batch, float parentAlpha) {
		if (Assets.assetManager.isLoaded("Background/Backgrounds/sky01.png")) {
			batch.draw(Assets.assetManager.get("Background/Backgrounds/sky01.png", Texture.class), getX(), getY(), getWidth(), getHeight());
		}

		font.draw(batch, "Loading Screen", 100, 700);
		font.draw(batch, "Assets Loaded: " + Math.round(Assets.assetManager.getProgress() * 100) + "%", 100, 680);
		font.draw(batch, "Assets Remaining/Loaded: " + Assets.assetManager.getQueuedAssets() + "/" + Assets.assetManager.getLoadedAssets(), 100, 660);

		if (Assets.assetManager.isLoaded("Planes/plane1.png")) {
			batch.draw(Assets.assetManager.get("Planes/plane1.png", Texture.class), -200 + (getWidth() + 200) * Assets.assetManager.getProgress(), 300);
		}

	}
}

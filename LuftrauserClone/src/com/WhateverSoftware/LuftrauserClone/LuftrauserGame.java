package com.WhateverSoftware.LuftrauserClone;

import LoadingScreen.LoadingScreen;

import com.WhateverSoftware.LuftrauserClone.Graphics.Assets;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;

public class LuftrauserGame extends Game {
	public static LuftrauserGame game;

	@Override
	public void create() {
		LuftrauserGame.game = this;
		Assets.assetManager = new AssetManager();

		setScreen(new LoadingScreen());
	}
}
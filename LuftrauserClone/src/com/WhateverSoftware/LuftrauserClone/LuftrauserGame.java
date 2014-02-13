package com.WhateverSoftware.LuftrauserClone;

import com.WhateverSoftware.LuftrauserClone.Graphics.Assets;
import com.WhateverSoftware.LuftrauserClone.Screens.LoadingScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;

/**
 * @author WhateverSoftware
 * @class LuftrauserGame
 */
public class LuftrauserGame extends Game {
	public static LuftrauserGame game;
	
	/**LuftrauserGame.create()
	 * -Starts the log for the game
	 * -Creates AssetManager
	 * -Opens LoadingScreen
	 */
	@Override
	public void create() {
		Gdx.app.log("LuftrauserGame:Create", "Start");
		LuftrauserGame.game = this;
		Assets.assetManager = new AssetManager();

		setScreen(new LoadingScreen());
	}
}
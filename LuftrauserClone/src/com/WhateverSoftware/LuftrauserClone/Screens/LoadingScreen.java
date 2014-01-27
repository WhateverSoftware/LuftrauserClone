package com.WhateverSoftware.LuftrauserClone.Screens;


import com.WhateverSoftware.LuftrauserClone.LuftrauserGame;
import com.WhateverSoftware.LuftrauserClone.Graphics.Assets;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class LoadingScreen implements Screen {
	Stage stage;

	@Override
	public void show() {
		Gdx.app.log("LoadingScreen:Show", "Creating Screen");
		stage = new Stage();
		stage.addActor(new LoadingBar(stage.getWidth(), stage.getHeight()));

		Assets.loadArtAssets();
		Assets.loadSoundAssets();
	}

	@Override
	public void resize(int width, int height) {
		stage.setViewport(width, height, true);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act();
		stage.draw();

		if (Assets.assetManager.update()) {
			// All assets are loaded - move to next screen
			Gdx.app.log("LoadingScreen:AssetCheck", "Asset Loading Complete");

			LuftrauserGame.game.setScreen(new MainMenuScreen());
		}
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}

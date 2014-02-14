package com.WhateverSoftware.LuftrauserClone.Graphics.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

/**
 * @author WhateverSoftware
 * @class MainMenuScreen
 */
public class MainMenuScreen implements Screen {
	Stage stage;

	BitmapFont font;

	/**MainMenuScreen.show()
	 * Displays the MainMenuScreen
	 */
	@Override
	public void show() {
		Gdx.app.log("MainMenuScreen:Show", "Creating Screen");
		stage = new Stage();

		// Add input listener to screen
		stage.addListener(new MainMenuInput());
		Gdx.input.setInputProcessor(stage);

		// Creating UI
		Table table = new Table();
		table.setFillParent(true);
		stage.addActor(table);

	}

	/**MainMenuScreen.resize()
	 * Replaces current dimension with a new one
	 * @param width - The replacement width
	 * @param height - The replacement height
	 */
	@Override
	public void resize(int width, int height) {
		stage.setViewport(width, height, true);
	}

	/**MainMenuScreen.render()
	 * Updates the screen with it's new data
	 */
	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act();
		stage.draw();

		Table.drawDebug(stage);
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

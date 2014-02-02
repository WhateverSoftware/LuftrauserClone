package com.WhateverSoftware.LuftrauserClone.Screens;

import com.WhateverSoftware.LuftrauserClone.Objects.Airplanes.UserAirplane;
import com.WhateverSoftware.LuftrauserClone.StateManagers.GameTickHandler;
import com.WhateverSoftware.LuftrauserClone.StateManagers.KeyInputHandler;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen implements Screen {
	SpriteBatch batch;
	OrthographicCamera camera;

	GameTickHandler gameTickHandler;

	@Override
	public void show() {
		Gdx.app.log("GameScreen:Show", "Creating Screen");
		
		batch = new SpriteBatch();
		gameTickHandler = new GameTickHandler();

		camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera.position.set(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, 0);
		camera.update();
		
		UserAirplane uA = new UserAirplane(100,100,0);
		gameTickHandler.register(uA);
		KeyInputHandler kIA = new KeyInputHandler(uA, true);
		Gdx.input.setInputProcessor(kIA);
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();

		gameTickHandler.updateEntities();
		gameTickHandler.drawEntities(batch);

		batch.end();
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

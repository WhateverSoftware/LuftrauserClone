package com.WhateverSoftware.LuftrauserClone.Graphics.Screens;

import com.WhateverSoftware.LuftrauserClone.Objects.Airplanes.UserAirplane;
import com.WhateverSoftware.LuftrauserClone.StateManagers.GameTickHandler;
import com.WhateverSoftware.LuftrauserClone.StateManagers.KeyInputHandler;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * @author WhateverSoftware
 * @class GameScreen
 */
public class GameScreen implements Screen {
	SpriteBatch batch;
	OrthographicCamera camera;

	GameTickHandler gameTickHandler;

	public static BitmapFont font;
	
	/**GameScreen.show()
	 * Displays this screen
	 */
	@Override
	public void show() {
		Gdx.app.log("GameScreen:Show", "Creating Screen");
		
		batch = new SpriteBatch();
		gameTickHandler = new GameTickHandler();

		//Set up the view for the user
		camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera.position.set(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, 0);
		camera.update();
		
		//Create the user
		UserAirplane uA = new UserAirplane(100,Gdx.graphics.getHeight()/2,0);
		uA.setGameTickHandler(gameTickHandler);
		Gdx.input.setInputProcessor(new KeyInputHandler(uA,true));
		
		font = new BitmapFont();
	}

	/**GameScreen.resize()
	 * Replaces the current screen's width and height with new values
	 * @param width - The replacement-width of the screen
	 * @param height - The replacement-height of the screen
	 */
	@Override
	public void resize(int width, int height) {

	}

	/**GameScreen.render()
	 * Render all changes to the screen
	 * @param delta - not really sure what this does. must not be important
	 */
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

package com.WhateverSoftware.LuftrauserClone.Graphics.Screens;

import com.WhateverSoftware.LuftrauserClone.AI.IAI; //remove later
import com.WhateverSoftware.LuftrauserClone.AI.Ships.*; //remove later
import com.WhateverSoftware.LuftrauserClone.Graphics.Assets;
import com.WhateverSoftware.LuftrauserClone.Objects.Airplanes.UserAirplane;
import com.WhateverSoftware.LuftrauserClone.Objects.Ships.*; //remove later
import com.WhateverSoftware.LuftrauserClone.StateManagers.GameTickHandler;
import com.WhateverSoftware.LuftrauserClone.StateManagers.KeyInputHandler;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * @author WhateverSoftware
 * @class GameScreen
 */
public class GameScreen implements Screen{
	int userX = 0;
	int userY = 0;
	
	SpriteBatch batch;
	OrthographicCamera camera;

	GameTickHandler gameTickHandler;
	UserAirplane uA;

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
		camera.position.set(Gdx.graphics.getWidth() / 4, Gdx.graphics.getHeight() / 2, 0);
		camera.update();
		
		//Create the user
		this.userX = 0;
		this.userY = Gdx.graphics.getHeight()/2;
		uA = new UserAirplane(this.userX,this.userY,0);
		uA.setGameTickHandler(gameTickHandler);
		AShip s = new ShipSmall(0,0,null,10);
		IAI ai = new ShipAdvancedTRBAI(uA,s);
		s.setAI(ai);
		s.setGameTickHandler(gameTickHandler);
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
		int xOffset = this.userX + 50 - Gdx.graphics.getWidth()/2;
		int yOffset = this.userY - Gdx.graphics.getHeight()/2;
		if(yOffset<0)
			yOffset=0;
		
		batch.begin();
		
		if (Assets.assetManager.isLoaded("Background/Backgrounds/sky01.png")) {
			batch.draw(Assets.assetManager.get("Background/Backgrounds/sky01.png", Texture.class), 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
			Texture skyline = Assets.assetManager.get("Background/Skylines/city1.png", Texture.class);
			
			//Draw skylines
			int skylineWidth = skyline.getWidth()*4;
			int skylineHeight = skyline.getHeight()*4;
			int xPos = this.userX-(this.userX%skylineWidth);
			int relativeMin = this.userX-Gdx.graphics.getWidth()/2;
			int relativeMax = this.userX+Gdx.graphics.getWidth();
			while(xPos>relativeMin)
				xPos-=skylineWidth;
			while(xPos<relativeMax){
				batch.draw(skyline,xPos-this.userX,-yOffset,skylineWidth,skylineHeight);
				xPos+=skylineWidth;
			}
		}

		gameTickHandler.updateEntities();
		gameTickHandler.drawEntities(batch,xOffset,yOffset);
		this.userX = (int)uA.getLocation().getX();
		this.userY = (int)uA.getLocation().getY();

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

package com.WhateverSoftware.LuftrauserClone.StateManagers;

import com.WhateverSoftware.LuftrauserClone.Objects.Airplanes.UserAirplane;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

/**
 * @author WhateverSoftware
 * @class KeyInputHandler
 */
public class KeyInputHandler implements InputProcessor {

	//The entity effected by the KIH
	private UserAirplane airplane;
	
	//Whether or not the user's input has an effect on the game-state
	private boolean acceptingData;

	/**
	 * @constructor -Sets global variables
	 * @param airplane
	 * @param acceptingData
	 */
	public KeyInputHandler(UserAirplane airplane, boolean acceptingData) {
		this.airplane = airplane;
		this.acceptingData = acceptingData;
	}

	/**KeyInputHandler.setAcceptingData()
	 * Replaces the current 'acceptingData' value with a new one
	 * @param acceptingData - The replacement value
	 */
	public void setAcceptingData(boolean acceptingData) {
		this.acceptingData = acceptingData;
	}

	/**KeyInputHandler.keyDown()
	 * Registers events when a key is pressed
	 * @param keyCode -The value of the key pressed
	 */
	@Override
	public boolean keyDown(int keyCode) {
		if (acceptingData) {
			switch (keyCode) {
			case Input.Keys.UP://if the user pressed the 'up-arrow key'
				//Set the target entity's thrust-value to true
				this.airplane.setThrust(true);
				break;
			case Input.Keys.LEFT://if the user pressed the 'left-arrow key'
				//Have the target entity turn counter-clockwise
				this.airplane.setTurning(-1);
				break;
			case Input.Keys.RIGHT://if the user pressed the 'right-arrow key'
				//Have the target entity turn clockwise
				this.airplane.setTurning(1);
				break;
			case Input.Keys.X://if the user pressed the 'x' key
				//Set the target entity's shooting value to true
				System.out.println(airplane.getLocation().getX()+","+airplane.getLocation().getY());
				this.airplane.setShooting(true);
				break;
			case Input.Keys.SPACE://if the user pressed the 'space' key
				//Reset the target-entities location to it's original position
				Gdx.app.log("KeyInputHandler:KeyDown", "Reset UserAirplane to 100,100");
				airplane.setLocation(100, Gdx.graphics.getHeight()/2);
			default://If the user pressed any other key
				//Log that the key was pressed
				Gdx.app.log("KeyInputHandler:KeyDown", "Unhandled Key Code:"+ keyCode);
				break;
			}
		}
		return false;
	}

	/**KeyInputHandler.keyUp()
	 * Registers events when a key is released
	 * @param keyCode -The value of the key released
	 */
	@Override
	public boolean keyUp(int keyCode) {
		if (acceptingData) {
			switch (keyCode) {
			case Input.Keys.UP://If the user releases the 'up-arrow key'
				//Set the target entity's thrust value to false
				this.airplane.setThrust(false);
				break;
			case Input.Keys.LEFT://if the user releases the 'left-arrow key'
			case Input.Keys.RIGHT://OR the 'right-arrow key'
				//Have the target entity stop turning
				this.airplane.setTurning(0);
				break;
			case Input.Keys.X://if the user releases the 'x' key
				//Set the target entity's shooting value to false
				this.airplane.setShooting(false);
				break;
			default:
				Gdx.app.log("KeyInputHandler:KeyUp", "Unhandled Key Code:"+ keyCode);
				break;
			}
		}
		return false;
	}
	
	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}
}

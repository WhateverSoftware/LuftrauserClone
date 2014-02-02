package com.WhateverSoftware.LuftrauserClone.StateManagers;

import com.WhateverSoftware.LuftrauserClone.Objects.Airplanes.UserAirplane;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

public class KeyInputHandler implements InputProcessor {

	private UserAirplane airplane;
	private boolean acceptingData;

	public KeyInputHandler(UserAirplane airplane, boolean acceptingData) {
		this.airplane = airplane;
		this.acceptingData = acceptingData;
	}

	public void setAcceptingData(boolean acceptingData) {
		this.acceptingData = acceptingData;
	}

	@Override
	public boolean keyDown(int keyCode) {
		if (acceptingData) {
			switch (keyCode) {
			case Input.Keys.UP:
				this.airplane.setThrust(true);
				break;
			case Input.Keys.LEFT:
				this.airplane.setTurning(-1);
				break;
			case Input.Keys.RIGHT:
				this.airplane.setTurning(1);
				break;
			case Input.Keys.X:
				this.airplane.setShooting(true);
				break;
			case Input.Keys.SPACE:
				Gdx.app.log("KeyInputHandler:KeyDown", "Reset UserAirplane to 100,100");
				airplane.setLocation(100, 100);
			default:
				Gdx.app.log("KeyInputHandler:KeyDown", "Unhandled Key Code:"+ keyCode);
				break;
			}
		}
		return false;
	}

	@Override
	public boolean keyUp(int keyCode) {
		if (acceptingData) {
			switch (keyCode) {
			case Input.Keys.UP:
				this.airplane.setThrust(false);
				break;
			case Input.Keys.LEFT:
			case Input.Keys.RIGHT:
				this.airplane.setTurning(0);
				break;
			case Input.Keys.X:
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
}

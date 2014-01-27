package com.WhateverSoftware.LuftrauserClone.StateManagers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.WhateverSoftware.LuftrauserClone.Objects.UserAirplane;

public class KeyInputHandler implements KeyListener {	

	private UserAirplane airplane;
	private boolean acceptingData;

	public KeyInputHandler(UserAirplane airplane, boolean acceptingData){
		this.airplane=airplane;
		this.acceptingData=acceptingData;
	}

	public void setAcceptingData(boolean acceptingData){
		this.acceptingData=acceptingData;
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		if(acceptingData){
			if(e.getKeyCode() == KeyEvent.VK_X) {
				this.airplane.setShooting(true);
			}
			else if(e.getKeyCode() == KeyEvent.VK_UP) {
				this.airplane.setThrust(true);
			}
			else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
				this.airplane.setTurning(-1);
			}
			else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
				this.airplane.setTurning(1);
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(acceptingData){
			if(e.getKeyCode() == KeyEvent.VK_X) {
				this.airplane.setShooting(false);
			}
			else if(e.getKeyCode() == KeyEvent.VK_UP) {
				this.airplane.setThrust(false);
			}
			else if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT) {
				this.airplane.setTurning(0);
			}
		}
	}
}

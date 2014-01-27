package com.WhateverSoftware.LuftrauserClone.StateManagers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInputHandler implements KeyListener {	

	private UserAirplane airplane;
	private boolean acceptingData;

	public KeyInputHandler(UserAirplane airplane, boolean acceptingData){
		this.airplane=airplane;
		this.acceptingData=acceptingData;
	}

	public boolean setAcceptingData(boolean acceptingData){
		this.acceptingData=acceptingData;
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		if(acceptingData){
			if(e.getKeyCode() == KeyEvent.VK_X) {
				this.airplane.setIsShooting(true);
			}
			else if(e.getKeyCode() == KeyEvent.VK_UP) {
				this.airplane.setIsThrusting(true);
			}
			else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
				this.airplane.setTurningCC(true);
			}
			else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
				this.airplane.setTurningC(true);
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(acceptingData){
			if(e.getKeyCode() == KeyEvent.VK_X) {
				this.airplane.setIsShooting(false);
			}
			else if(e.getKeyCode() == KeyEvent.VK_UP) {
				this.airplane.setIsThrusting(false);
			}
			else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
				this.airplane.setTurningCC(false);
			}
			else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
				this.airplane.setTurningC(false);
			}
		}
	}
}

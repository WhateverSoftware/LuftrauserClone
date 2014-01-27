package com.WhateverSoftware.LuftrauserClone.StateManagers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener {	
	@Override
	public void keyTyped(KeyEvent e) {}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_X) {
			//start shooting
		}
		else if(e.getKeyCode() == KeyEvent.VK_UP) {
			//turn thrust on
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			//rotate counter-clockwise
		}
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			//rotate clockwise
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_X) {
			//stop shooting
		}
		else if(e.getKeyCode() == KeyEvent.VK_UP) {
			//turn thrust off
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT) {
			//stop rotating
		}		
	}
}

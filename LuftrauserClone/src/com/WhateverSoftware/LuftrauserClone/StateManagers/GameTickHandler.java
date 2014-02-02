package com.WhateverSoftware.LuftrauserClone.StateManagers;

import java.util.ArrayList;
import java.util.List;

import com.WhateverSoftware.LuftrauserClone.Objects.IEntity;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameTickHandler implements IGameTickHandlerEntityView {
	private List<IEntity> entities;
	
	public GameTickHandler(){
		entities = new ArrayList<IEntity>();
	}

	/**
	 * Calls update for all entities attached to this handler.
	 */
	public void updateEntities() {
		for(int n = entities.size()-1;n>=0;n--){
			IEntity entity = entities.get(n);
			entity.update();
		}
	}
	/**
	 * Calls draw for all entities attached to this handler.
	 */
	public void drawEntities(SpriteBatch batch) {
		for (IEntity entity : this.entities) {
			entity.draw(batch);
		}
	}

	/**
	 * Add a new entity to the list.
	 */
	public void register(IEntity entity) {
		this.entities.add(entity);
	}
}

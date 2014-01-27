package com.WhateverSoftware.LuftrauserClone.StateManagers;

import java.util.List;

import com.WhateverSoftware.LuftrauserClone.Objects.IEntity;

public class GameTickHandler implements IGameTickHandlerEntityView {
	private List<IEntity> entities;
	
	/**
	 * Calls update for all entities attached to this handler.
	 */
	public void updateEntities(){
		for(IEntity entity:this.entities){
			entity.update();
		}
	}
	
	/**
	 * Add a new entity to the list.
	 */
	public void register(IEntity entity){
		this.entities.add(entity);
	}
}

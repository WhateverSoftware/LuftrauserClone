package com.WhateverSoftware.LuftrauserClone.StateManagers;

import java.util.List;

import com.WhateverSoftware.LuftrauserClone.Objects.IEntity;

public class GameTickHandler implements IGameTickHandlerEntityView {
	private List<IEntity> entities;
	
	public void updateEntities(){
		for(IEntity entity:this.entities){
			entity.update();
		}
	}
	
	public void register(IEntity entity){
		this.entities.add(entity);
	}
}

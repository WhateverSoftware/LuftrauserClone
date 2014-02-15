package com.WhateverSoftware.LuftrauserClone.StateManagers;

import java.util.ArrayList;
import java.util.List;

import com.WhateverSoftware.LuftrauserClone.Objects.IEntity;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * @author WhateverSoftware
 * @class GameTickHandler
 */
public class GameTickHandler implements IGameTickHandlerEntityView {
	
	//A list of all entities in the game
	private List<IEntity> entities;
	
	/**
	 * @construcotr -Set global variables
	 */
	public GameTickHandler(){
		entities = new ArrayList<IEntity>();
	}

	/**GameTickHandler.updateEntities()
	 * Calls update for all entities attached to this handler.
	 */
	public void updateEntities() {
		for(int n = entities.size()-1;n>=0;n--){
			IEntity entity = entities.get(n);
			entity.update();
		}
	}
	
	/**GameTickHandler.drawEntities()
	 * Calls draw for all entities attached to this handler.
	 */
	public void drawEntities(SpriteBatch batch,int xOffset,int yOffset) {
		for (IEntity entity : this.entities) {
			entity.draw(batch,xOffset,yOffset);
		}
	}

	/**GameTickHandler.register()
	 * Add a new entity to the list.
	 * @param entity - The entity we are adding to the handler
	 */
	public void register(IEntity entity) {
		this.entities.add(entity);
	}
}


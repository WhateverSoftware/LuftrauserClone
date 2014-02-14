package com.WhateverSoftware.LuftrauserClone.StateManagers;

import com.WhateverSoftware.LuftrauserClone.Objects.IEntity;

/**
 * @author IGameTickHandler
 * @interface IGameTickHandlerEntityView
 */
public interface IGameTickHandlerEntityView {
	
	//These are the methods that Entity's have access to from the GTH
	public void register(IEntity entity);
}

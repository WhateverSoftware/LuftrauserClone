package com.WhateverSoftware.LuftrauserClone.AI;

import com.WhateverSoftware.LuftrauserClone.Objects.IShootingEntityAIView;

public abstract class AAI {

	protected IShootingEntityAIView me;
	protected IShootingEntityAIView user;

	public AAI(IShootingEntityAIView user, IShootingEntityAIView me){
		this.user=user;
		this.me=me;
	}
}

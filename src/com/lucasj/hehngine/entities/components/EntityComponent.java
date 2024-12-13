package com.lucasj.hehngine.entities.components;

import com.lucasj.hehngine.entities.Entity;

public abstract class EntityComponent {
	
	private Entity entity;
	
	public EntityComponent(Entity entity) {
		this.entity = entity;
	}

	public Entity getEntity() {
		return entity;
	}

}

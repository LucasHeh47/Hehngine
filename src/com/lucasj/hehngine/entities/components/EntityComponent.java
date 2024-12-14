package com.lucasj.hehngine.entities.components;

import java.util.ArrayList;
import java.util.List;

import com.lucasj.hehngine.Game;
import com.lucasj.hehngine.entities.Entity;

public abstract class EntityComponent {
	
	private Entity entity;
	private List<Class<? extends EntityComponent>> componentsRequired;
	protected Game game;
	
	public EntityComponent(Game game, Entity entity) {
		this.game = game;
		this.entity = entity;
		this.componentsRequired = new ArrayList<>();
	}

	public Entity getEntity() {
		return entity;
	}
	
	/***
	 * 
	 * @param deltaTime
	 */
	public abstract void update(double deltaTime);
	
	/***
	 * 
	 * @param Component Class
	 */
	protected void addRequiredComponentClass(Class<? extends EntityComponent> comp) {
		this.componentsRequired.add(comp);
	}
	
	public List<Class<? extends EntityComponent>> getRequiredComponents() {
		return this.componentsRequired;
	}
	
}

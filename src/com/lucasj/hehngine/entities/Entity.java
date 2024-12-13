package com.lucasj.hehngine.entities;

import java.util.ArrayList;
import java.util.List;

import com.lucasj.hehngine.Game;
import com.lucasj.hehngine.entities.components.EntityComponent;
import com.lucasj.hehngine.exceptions.entitycomponents.EntityComponentException;
import com.lucasj.hehngine.ui.rendering.Render;

public abstract class Entity {
	
	private Game game;
	private List<EntityComponent> components;
	
	public Entity(Game game) {
		this.game = game;
		this.components = new ArrayList<EntityComponent>();
	}

	public abstract void update(double deltaTime);
	public abstract Render render();

	public List<EntityComponent> getComponents() {
		return components;
	}
	
	public EntityComponent getComponent(Class<? extends EntityComponent> comp) throws EntityComponentException {
		if(components.size() == 0) {
			throw new EntityComponentException("Entity has no components!");
		}
		for(EntityComponent component : components) {
			if(component.getClass().equals(comp.getClass())) return component;
		}
		throw new EntityComponentException("Entity does not contain component: " + comp.getSimpleName());
	}
	
}

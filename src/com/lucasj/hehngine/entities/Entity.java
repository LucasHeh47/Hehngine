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
	
	/***
	 * 
	 * @param Entity Component
	 * @throws EntityComponentException 
	 */
	public void addComponent(EntityComponent comp) throws EntityComponentException {
		if(this.hasAllComponents(comp.getRequiredComponents())) {
			if(this.hasComponent(comp.getClass())) {
				throw new EntityComponentException("Entity already contains component: " + comp.getClass().getSimpleName());
			}
			this.components.add(comp);
		} else {
			throw new EntityComponentException("Entity cannot contain component " + comp.getClass().getSimpleName() + " due to component requirements");
		}
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
	
	public boolean hasComponent(Class<? extends EntityComponent> comp) {
		for (EntityComponent c : this.components) {
			if(c.getClass().equals(comp)) return true;
		}
		return false;
	}
	
	public boolean hasAllComponents(List<Class<? extends EntityComponent>> comps) {
		for(Class<? extends EntityComponent> comp : comps) {
			boolean found = false;
			for (EntityComponent c : this.components) {
				if(c.getClass().equals(comp)) {
					found = true;
					break;
				}
			}
			if(!found) return false;
		}
		return true;
	}
	
}

package com.lucasj.hehngine.entities.components;

import com.lucasj.hehngine.entities.Entity;
import com.lucasj.hehngine.math.Vector2D;

public class TransformComponent extends EntityComponent {
	
	private Vector2D position;
	private Vector2D size;

	public TransformComponent(Entity entity) {
		super(entity);
	}

	public Vector2D getPosition() {
		return position;
	}

	public void setPosition(Vector2D position) {
		this.position = position;
	}

	public Vector2D getSize() {
		return size;
	}

	public void setSize(Vector2D size) {
		this.size = size;
	}

}

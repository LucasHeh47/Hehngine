package com.lucasj.hehngine.entities.components;

import com.lucasj.hehngine.Game;
import com.lucasj.hehngine.entities.Entity;
import com.lucasj.hehngine.math.Vector2D;

public class TransformComponent extends EntityComponent {
	
	/***
	 * Screen position is updated each frame. camera.worldToScreenPosition(worldPosition)
	 */
	private Vector2D screenPosition;
	private Vector2D worldPosition;
	private Vector2D size;

	public TransformComponent(Game game, Entity entity) {
		super(game, entity);
	}

	@Override
	public void update(double deltaTime) {
		this.screenPosition = game.getCamera().worldToScreenPosition(worldPosition);
		
	}

	public Vector2D getSize() {
		return size;
	}

	public void setSize(Vector2D size) {
		this.size = size;
	}

	public Vector2D getScreenPosition() {
		return screenPosition;
	}

	public Vector2D getWorldPosition() {
		return worldPosition;
	}

	public void setWorldPosition(Vector2D worldPosition) {
		this.worldPosition = worldPosition;
	}

}

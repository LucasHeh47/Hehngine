package com.lucasj.hehngine.ui.rendering;

import com.lucasj.hehngine.Game;
import com.lucasj.hehngine.math.Vector2D;

public class Camera {

	private Game game;
	private Vector2D viewport;
	private Vector2D worldPosition;
	
	public Camera(Game game) {
		this.game = game;
	}

	public Vector2D worldToScreenPosition(Vector2D worldPos) {
		return worldPos.subtract(getWorldPosition());
	}
	
	public Vector2D screenToWorldPosition(Vector2D screenPos) {
		return getWorldPosition().add(screenPos);
	}
	
	public Vector2D getViewport() {
		return viewport;
	}

	public void setViewport(Vector2D viewport) {
		this.viewport = viewport;
	}

	public Vector2D getWorldPosition() {
		return worldPosition;
	}

	public void setWorldPosition(Vector2D worldPosition) {
		this.worldPosition = worldPosition;
	}
	
	

}

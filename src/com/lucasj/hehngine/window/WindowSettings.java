package com.lucasj.hehngine.window;

import com.lucasj.hehngine.math.Vector2D;

public class WindowSettings {
	
	private Vector2D windowDimensions;
	private String gameTitle;
	
	/***
	 * 
	 * Used for adjusting game window
	 * 
	 * @param gameTitle
	 * @param dimensions
	 */
	public WindowSettings(String gameTitle, Vector2D dimensions) {
		this.setWindowDimensions(dimensions);
		this.setGameTitle(gameTitle);
	}

	public Vector2D getWindowDimensions() {
		return windowDimensions;
	}

	public void setWindowDimensions(Vector2D windowDimensions) {
		this.windowDimensions = windowDimensions;
	}

	public String getGameTitle() {
		return gameTitle;
	}

	public void setGameTitle(String gameTitle) {
		this.gameTitle = gameTitle;
	}
	
}

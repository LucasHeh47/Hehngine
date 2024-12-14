package com.lucasj.hehngine.events;

import com.lucasj.hehngine.events.listener.EventListener;

public abstract class GameEvent {

	private Class<? extends EventListener> listenerClass;
	
	public GameEvent(Class<? extends EventListener> listenerClass) {
		this.listenerClass = listenerClass;
	}

	public Class<? extends EventListener> getListenerClass() {
		return listenerClass;
	}
	
}

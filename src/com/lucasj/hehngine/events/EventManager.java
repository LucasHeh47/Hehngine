package com.lucasj.hehngine.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lucasj.hehngine.debug.Debug;

class EventManager {
private Map<Class<? extends GameEvent>, List<Object>> eventMap = new HashMap<>();
    
    public void addListener(Object listening, Class<? extends GameEvent> eventToListenFor) {
    	eventMap.computeIfAbsent(eventToListenFor, k -> new ArrayList<>());
        
        eventMap.get(eventToListenFor).add(listening);
        Debug.log("EventManager", "Adding " + listening.getClass().getSimpleName() + " to " + eventToListenFor.getSimpleName());
    }
    
    public void removeListener(Object listener, Class<? extends GameEvent> eventListeningFor) {
    	if(eventMap.containsKey(eventListeningFor) && eventMap.get(eventListeningFor).contains(listener)) {
    		eventMap.get(eventListeningFor).remove(listener);
    		Debug.log("EventManager", "Removed " + listener.getClass().getSimpleName() + " from event listener: " + eventListeningFor.getSimpleName());
    	}
    }
    
    public void dispatchEvent(GameEvent e) {
    	
    }
}

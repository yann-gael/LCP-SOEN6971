package viewIMPL;

import view.IEvent;

public class Event implements IEvent {

	private String eventType;
	
	public Event(String eventType) {
		this.eventType = eventType;
	}
	
	public String getEventType() {
		return eventType;
	}
}

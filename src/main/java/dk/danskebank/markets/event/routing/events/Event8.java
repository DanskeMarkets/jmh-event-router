package dk.danskebank.markets.event.routing.events;

public class Event8 implements Event {
	private final String text;

	public Event8(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
}

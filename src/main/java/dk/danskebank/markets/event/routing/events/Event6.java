package dk.danskebank.markets.event.routing.events;

public class Event6 implements Event {
	private final String text;

	public Event6(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
}

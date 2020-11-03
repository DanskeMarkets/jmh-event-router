package dk.danskebank.markets.event.routing.events;

public class Event4 implements Event {
	private final String text;

	public Event4(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
}

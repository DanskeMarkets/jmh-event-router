package dk.danskebank.markets.event.routing.events;

public class Event7 implements Event {
	private final String text;

	public Event7(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
}

package dk.danskebank.markets.event.routing.events;

public class Event10 implements Event {
	private final String text;

	public Event10(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
}

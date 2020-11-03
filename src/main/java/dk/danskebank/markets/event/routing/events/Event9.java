package dk.danskebank.markets.event.routing.events;

public class Event9 implements Event {
	private final String text;

	public Event9(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
}

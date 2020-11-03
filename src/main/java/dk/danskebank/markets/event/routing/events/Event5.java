package dk.danskebank.markets.event.routing.events;

public class Event5 implements Event {
	private final String text;

	public Event5(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
}

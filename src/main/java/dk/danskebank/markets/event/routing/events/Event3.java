package dk.danskebank.markets.event.routing.events;

public class Event3 implements Event {
	private final String text;

	public Event3(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
}

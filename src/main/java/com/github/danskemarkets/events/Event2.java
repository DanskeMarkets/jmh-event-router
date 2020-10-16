package com.github.danskemarkets.events;

public class Event2 implements Event {
	private final int number;

	public Event2(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}
}

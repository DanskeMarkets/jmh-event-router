package com.github.danskemarkets.events;

public class Event1 implements Event {
	private final double number;

	public Event1(double number) {
		this.number = number;
	}

	public double getNumber() {
		return number;
	}
}

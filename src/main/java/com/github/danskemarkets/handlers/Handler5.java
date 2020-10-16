package com.github.danskemarkets.handlers;

import com.github.danskemarkets.events.Event1;
import com.github.danskemarkets.events.Event4;
import com.github.danskemarkets.events.Event5;
import com.google.common.eventbus.Subscribe;
import org.openjdk.jmh.infra.Blackhole;

public class Handler5 extends AbstractHandler {
	public Handler5(final Blackhole bh, int cpuConsumption) {
		super(bh, cpuConsumption);
	}

	@Subscribe public void handle(Event1 event) {
		blackhole.consume(event.getNumber());
		Blackhole.consumeCPU(cpuConsumption);
	}

	@Subscribe public void handle(Event4 event) {
		blackhole.consume(event.getText());
		Blackhole.consumeCPU(cpuConsumption);
	}

	@Subscribe public void handle(Event5 event) {
		blackhole.consume(event.getText());
		Blackhole.consumeCPU(cpuConsumption);
	}
}
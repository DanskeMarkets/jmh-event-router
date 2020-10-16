package com.github.danskemarkets.handlers;

import com.github.danskemarkets.events.Event2;
import com.github.danskemarkets.events.Event9;
import com.google.common.eventbus.Subscribe;
import org.openjdk.jmh.infra.Blackhole;

public class Handler2 extends AbstractHandler {
	public Handler2(final Blackhole bh, int cpuConsumption) {
		super(bh, cpuConsumption);
	}

	@Subscribe public void handle(Event2 event) {
		blackhole.consume(event.getNumber());
		Blackhole.consumeCPU(cpuConsumption);
	}

	@Subscribe public void handle(Event9 event) {
		blackhole.consume(event.getText());
		Blackhole.consumeCPU(cpuConsumption);
	}
}

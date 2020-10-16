package com.github.danskemarkets.handlers;

import com.github.danskemarkets.events.Event1;
import com.google.common.eventbus.Subscribe;
import org.openjdk.jmh.infra.Blackhole;

public class Handler1 extends AbstractHandler {
	public Handler1(final Blackhole bh, int cpuConsumption) {
		super(bh, cpuConsumption);
	}

	@Subscribe public void handle(Event1 event) {
		blackhole.consume(event.getNumber());
		Blackhole.consumeCPU(cpuConsumption);
	}
}

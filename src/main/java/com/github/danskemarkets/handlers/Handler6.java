package com.github.danskemarkets.handlers;

import com.github.danskemarkets.events.Event2;
import com.github.danskemarkets.events.Event6;
import com.github.danskemarkets.events.Event7;
import com.github.danskemarkets.events.Event8;
import com.google.common.eventbus.Subscribe;
import org.openjdk.jmh.infra.Blackhole;

public class Handler6 extends AbstractHandler {
	public Handler6(final Blackhole bh, int cpuConsumption) {
		super(bh, cpuConsumption);
	}

	@Subscribe public void handle(Event2 event) {
		blackhole.consume(event.getNumber());
		Blackhole.consumeCPU(cpuConsumption);
	}

	@Subscribe public void handle(Event6 event) {
		blackhole.consume(event.getText());
		Blackhole.consumeCPU(cpuConsumption);
	}

	@Subscribe public void handle(Event7 event) {
		blackhole.consume(event.getText());
		Blackhole.consumeCPU(cpuConsumption);
	}

	@Subscribe public void handle(Event8 event) {
		blackhole.consume(event.getText());
		Blackhole.consumeCPU(cpuConsumption);
	}
}

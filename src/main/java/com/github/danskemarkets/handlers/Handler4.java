package com.github.danskemarkets.handlers;

import com.github.danskemarkets.events.Event1;
import com.github.danskemarkets.events.Event2;
import com.github.danskemarkets.events.Event3;
import com.github.danskemarkets.events.Event4;
import com.google.common.eventbus.Subscribe;
import org.openjdk.jmh.infra.Blackhole;

public class Handler4 extends AbstractHandler {
	public Handler4(final Blackhole bh, int cpuConsumption) {
		super(bh, cpuConsumption);
	}

	@Subscribe public void handle(Event1 event) {
		blackhole.consume(event.getNumber());
		Blackhole.consumeCPU(cpuConsumption);
	}

	@Subscribe public void handle(Event2 event) {
		blackhole.consume(event.getNumber());
		Blackhole.consumeCPU(cpuConsumption);
	}

	@Subscribe public void handle(Event3 event) {
		blackhole.consume(event.getText());
		Blackhole.consumeCPU(cpuConsumption);
	}

	@Subscribe public void handle(Event4 event) {
		blackhole.consume(event.getText());
		Blackhole.consumeCPU(cpuConsumption);
	}
}

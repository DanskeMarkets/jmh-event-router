package dk.danskebank.markets.event.routing.handlers;

import dk.danskebank.markets.event.routing.events.Event1;
import dk.danskebank.markets.event.routing.events.Event2;
import dk.danskebank.markets.event.routing.events.Event3;
import dk.danskebank.markets.event.routing.events.Event4;
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

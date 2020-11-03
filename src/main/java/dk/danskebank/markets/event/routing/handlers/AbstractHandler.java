package dk.danskebank.markets.event.routing.handlers;

import org.openjdk.jmh.infra.Blackhole;

public abstract class AbstractHandler {
	protected final Blackhole blackhole;
	protected final int cpuConsumption;
	public AbstractHandler(final Blackhole bh, int cpuConsumption) {
		this.blackhole      = bh;
		this.cpuConsumption = cpuConsumption;
	}
}

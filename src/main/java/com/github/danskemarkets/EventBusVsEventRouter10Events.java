package com.github.danskemarkets;

import com.github.danskemarkets.events.*;
import com.github.danskemarkets.handlers.*;
import com.google.common.eventbus.EventBus;
import dk.danskebank.markets.event.processing.Dispatcher;
import dk.danskebank.markets.event.routing.EventRouter;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 5, time = 3)
@Measurement(iterations = 5, time = 3)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class EventBusVsEventRouter10Events {
	// Don't make final to prevent constant folding by the compiler.
	private Event1   event1 = new Event1(Math.PI);
	private Event2   event2 = new Event2(42);
	private Event3   event3 = new Event3("The quick brown fox jumped over the lazy dog.");
	private Event4   event4 = new Event4("The quick brown fox jumped over the lazy dog 1.");
	private Event5   event5 = new Event5("The quick brown fox jumped over the lazy dog 2.");
	private Event6   event6 = new Event6("The quick brown fox jumped over the lazy dog 3.");
	private Event7   event7 = new Event7("The quick brown fox jumped over the lazy dog 4.");
	private Event8   event8 = new Event8("The quick brown fox jumped over the lazy dog 5.");
	private Event9   event9 = new Event9("The quick brown fox jumped over the lazy dog 6.");
	private Event10 event10 = new Event10("The quick brown fox jumped over the lazy dog 7.");

	@Param({"0", "1", "64"})
	private int cpuConsumption;

	private Handler1 handler1;
	private Handler2 handler2;
	private Handler3 handler3;
	private Handler4 handler4;
	private Handler5 handler5;
	private Handler6 handler6;

	private EventBus eventBus;
	private Dispatcher dispatcher;

	@Setup public void setup(final Blackhole blackhole) {
		handler1 = new Handler1(blackhole, cpuConsumption);
		handler2 = new Handler2(blackhole, cpuConsumption);
		handler3 = new Handler3(blackhole, cpuConsumption);
		handler4 = new Handler4(blackhole, cpuConsumption);
		handler5 = new Handler5(blackhole, cpuConsumption);
		handler6 = new Handler6(blackhole, cpuConsumption);

		eventBus = new EventBus();
		eventBus.register(handler1);
		eventBus.register(handler2);
		eventBus.register(handler3);
		eventBus.register(handler4);
		eventBus.register(handler5);
		eventBus.register(handler6);

		dispatcher = new EventRouter.Builder()
				.route( Event1.class).to(handler1, handler4)
				.route( Event2.class).to(handler2, handler4)
				.route( Event3.class).to(handler3, handler4)
				.route( Event4.class).to(handler3, handler4)
				.route( Event5.class).to(handler5)
				.route( Event6.class).to(handler6)
				.route( Event7.class).to(handler6)
				.route( Event8.class).to(handler6)
				.route( Event9.class).to(handler2)
				.route(Event10.class).to(handler3)
			.build();
	}

	@Benchmark public void testEventBusOneEvent() {
		eventBus.post(event1);
	}

	@Benchmark public void testEventRouterOneEvent() {
		dispatcher.dispatch(event1);
	}

	@Benchmark public void testEventBusThreeEvents() {
		eventBus.post(event1);
		eventBus.post(event2);
		eventBus.post(event3);
	}

	@Benchmark public void testEventRouterThreeEvents() {
		dispatcher.dispatch(event1);
		dispatcher.dispatch(event2);
		dispatcher.dispatch(event3);
	}

	@Benchmark public void testEventBusTenEvents() {
		eventBus.post(event1);
		eventBus.post(event2);
		eventBus.post(event3);
		eventBus.post(event4);
		eventBus.post(event5);
		eventBus.post(event6);
		eventBus.post(event7);
		eventBus.post(event8);
		eventBus.post(event9);
		eventBus.post(event10);
	}

	@Benchmark public void testEventRouterTenEvents() {
		dispatcher.dispatch(event1);
		dispatcher.dispatch(event2);
		dispatcher.dispatch(event3);
		dispatcher.dispatch(event4);
		dispatcher.dispatch(event5);
		dispatcher.dispatch(event6);
		dispatcher.dispatch(event7);
		dispatcher.dispatch(event8);
		dispatcher.dispatch(event9);
		dispatcher.dispatch(event10);
	}
}

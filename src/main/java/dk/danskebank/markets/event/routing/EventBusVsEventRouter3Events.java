package dk.danskebank.markets.event.routing;

import dk.danskebank.markets.event.routing.events.Event1;
import dk.danskebank.markets.event.routing.events.Event2;
import dk.danskebank.markets.event.routing.events.Event3;
import dk.danskebank.markets.event.routing.handlers.Handler4;
import dk.danskebank.markets.event.routing.handlers.Handler1;
import dk.danskebank.markets.event.routing.handlers.Handler2;
import dk.danskebank.markets.event.routing.handlers.Handler3;
import com.google.common.eventbus.EventBus;
import dk.danskebank.markets.event.processing.Dispatcher;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 5, time = 3)
@Measurement(iterations = 5, time = 3)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class EventBusVsEventRouter3Events {
	// Don't make final to prevent constant folding by the compiler.
	private Event1 event1 = new Event1(Math.PI);
	private Event2 event2 = new Event2(42);
	private Event3 event3 = new Event3("The quick brown fox jumped over the lazy dog.");

	@Param({"1", "64"})
	private int cpuConsumption;

	private Handler1 handler1;
	private Handler2 handler2;
	private Handler3 handler3;
	private Handler4 handler4;

	private EventBus eventBus;
	private Dispatcher dispatcher;

	@Setup public void setup(final Blackhole blackhole) {
		handler1 = new Handler1(blackhole, cpuConsumption);
		handler2 = new Handler2(blackhole, cpuConsumption);
		handler3 = new Handler3(blackhole, cpuConsumption);
		handler4 = new Handler4(blackhole, cpuConsumption);

		eventBus = new EventBus();
		eventBus.register(handler1);
		eventBus.register(handler2);
		eventBus.register(handler3);
		eventBus.register(handler4);

		dispatcher = new EventRouter.Builder()
				.route(Event1.class).to(handler1, handler4)
				.route(Event2.class).to(handler2, handler4)
				.route(Event3.class).to(handler3, handler4)
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
}

package com.seezoon.luna.utils.guava.eventbus;

import org.junit.Test;

import com.google.common.eventbus.EventBus;

public class EvenBusTest {

	@Test
	public void t1() {
		 EventBus eventBus = new EventBus("testEventBus");
		 eventBus.register(new EventListener());
		 eventBus.post(new EventMessage("hello event bus"));
	}
}

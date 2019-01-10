package com.seezoon.luna.utils.guava.eventbus;

import com.google.common.eventbus.Subscribe;

public class EventListener {

	@Subscribe
	public void listen(EventMessage message) {
		System.out.println(message.getMessage());
	} 
}

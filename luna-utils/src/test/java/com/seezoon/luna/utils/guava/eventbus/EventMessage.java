package com.seezoon.luna.utils.guava.eventbus;

public class EventMessage {

	private String message;

	public EventMessage(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}

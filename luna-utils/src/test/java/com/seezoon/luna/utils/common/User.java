package com.seezoon.luna.utils.common;

import javax.validation.constraints.NotNull;

public class User {

	@NotNull(message="不能为空")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}

package com.seezoon.luna.service;

public class OperatorUser {

	private String userId;
	private String name;
	private String ext1;
	private String ext2;
	private String ext3;
	private String ext4;

	/**
	 * 利用了容器的线程池，ThreadLocal 数据会相互干扰
	 */
	private static ThreadLocal<OperatorUser> threadLocal = new ThreadLocal<>();
	public static void put(OperatorUser operatorUser) {
		threadLocal.remove();
		threadLocal.set(operatorUser);
	}

	public static OperatorUser get() {
		OperatorUser operatorUser =  threadLocal.get();
		return operatorUser;
	}
	public static void remove() {
		threadLocal.remove();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExt1() {
		return ext1;
	}

	public void setExt1(String ext1) {
		this.ext1 = ext1;
	}

	public String getExt2() {
		return ext2;
	}

	public void setExt2(String ext2) {
		this.ext2 = ext2;
	}

	public String getExt3() {
		return ext3;
	}

	public void setExt3(String ext3) {
		this.ext3 = ext3;
	}

	public String getExt4() {
		return ext4;
	}

	public void setExt4(String ext4) {
		this.ext4 = ext4;
	}
	
}

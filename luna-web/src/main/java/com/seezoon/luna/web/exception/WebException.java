package com.seezoon.luna.web.exception;


/**
 * web 层异常
 * @author hdf
 *
 */
public class WebException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WebException() {
		
	}
	
	public WebException(String msg) {
		super(msg);
	}
	
	public WebException(Throwable throwable) {
		super(throwable);
	}
}

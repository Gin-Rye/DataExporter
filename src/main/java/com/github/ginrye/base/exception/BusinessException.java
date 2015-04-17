package com.github.ginrye.base.exception;

public class BusinessException extends Exception {

	private static final long serialVersionUID = -8358583499584033910L;

	public BusinessException() {
		super();
	}
	
	public BusinessException(Throwable e) {
		super(e);
	}
	
	public BusinessException(String message) {
		super(message);
	}
	
	public BusinessException(String message, Throwable e) {
		super(message, e);
	}
}

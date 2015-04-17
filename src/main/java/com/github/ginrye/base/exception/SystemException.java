package com.github.ginrye.base.exception;

public class SystemException extends RuntimeException {

	private static final long serialVersionUID = -3831372996932543246L;

	public SystemException() {
		super();
	}
	
	public SystemException(Throwable e) {
		super(e);
	}
	
	public SystemException(String message) {
		super(message);
	}
	
	public SystemException(String message, Throwable e) {
		super(message, e);
	}
}

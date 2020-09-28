package com.cg.omts.screen.exception;

public class CustomException extends RuntimeException {

	public CustomException(String arg0, Throwable arg1) {
		super(arg0, arg1);

	}

	public CustomException(String arg0) {
		super(arg0);
	}
}

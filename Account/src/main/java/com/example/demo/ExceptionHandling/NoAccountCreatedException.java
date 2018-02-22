package com.example.demo.ExceptionHandling;

public class NoAccountCreatedException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public NoAccountCreatedException() {
		 super("Account could not be found");
	}
	
}

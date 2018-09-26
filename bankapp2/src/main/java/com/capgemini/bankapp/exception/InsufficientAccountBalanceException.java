package com.capgemini.bankapp.exception;

public class InsufficientAccountBalanceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InsufficientAccountBalanceException(String message)
	{
		super(message);
	}
	
}

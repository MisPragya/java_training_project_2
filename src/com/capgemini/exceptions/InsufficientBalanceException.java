package com.capgemini.exceptions;

public class InsufficientBalanceException extends Exception{

	public InsufficientBalanceException(String s)
	{ 
		System.out.println(s);
	}
}

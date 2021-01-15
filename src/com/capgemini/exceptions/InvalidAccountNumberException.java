package com.capgemini.exceptions;

public class InvalidAccountNumberException extends Exception {

	public InvalidAccountNumberException(String s)
	{ 
		System.out.println(s);
	}
	
}

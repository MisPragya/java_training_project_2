package com.capgemini.service;

import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InvalidAccountNumberException;

public interface Bank  {

	String createAccount(int accountNumber,int amount) throws InvalidAccountNumberException, InsufficientBalanceException;
	String depositAmount(int accountNumber,int amount) throws InvalidAccountNumberException;
	int withdrawAmount(int accountNumber,int amount) throws InvalidAccountNumberException, InsufficientBalanceException;
	int[][] fundTransfer(int fromAccountNo, int toAccountNo, int amount) throws InvalidAccountNumberException, InsufficientBalanceException;
}

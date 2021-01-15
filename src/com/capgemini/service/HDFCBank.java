package com.capgemini.service;

import com.capgemini.exceptions.*;
import java.util.LinkedList;
import com.capgemini.bean.Account;

public class HDFCBank implements Bank  {

	LinkedList<Account> list = new LinkedList<Account>();
	public String createAccount(int accountNumber,int amount) throws InvalidAccountNumberException, InsufficientBalanceException
	{ 
		for(Account a:list)
			{ if( a.getAccountNumber()==accountNumber)
		      throw new InvalidAccountNumberException("Account number already exists!"); }
		Account account=new Account();
		if(amount<500)
			throw new InsufficientBalanceException("Insufficient minimum balance!");
		account.setAccountNumber(accountNumber);	
		account.setAmount(amount);	
		list.add(account);
		return "Account created successfully...";
	}
	
	 public String depositAmount(int accountNumber,int amount) throws InvalidAccountNumberException
	 {
		 for(Account account:list)
		 {
			 if(account.getAccountNumber()==accountNumber)
			 { account.setAmount(account.getAmount()+amount); 
			 return "Amount deposited...";
			 
			 }
		 }
		 throw new InvalidAccountNumberException("Account number does not exists!");
		 		
	 }
	 
	 public int withdrawAmount(int accountNumber,int amount) throws InvalidAccountNumberException, InsufficientBalanceException
	 {
		 for(Account account:list)
		 {
			 if(account.getAccountNumber()==accountNumber)
			 {
				 if(account.getAmount()>=amount)
				 {
					 account.setAmount(account.getAmount()-amount);
					 System.out.println("Amount is: "+account.getAmount());
					 return account.getAmount();
				 }
				 else throw new InsufficientBalanceException("Insufficient balance in account!");
			 }
		 }
		 throw new InvalidAccountNumberException("Account number does not exists!");
	 }
	
	 public int[][] fundTransfer(int fromAccountNo, int toAccountNo, int amount) throws InvalidAccountNumberException, InsufficientBalanceException
	 {
				
				 
				 int[][] array=new int[2][2];
				 int flag1=0;
				 int flag2=0;
				 for(Account acnt:list)
				 {
					 if(acnt.getAccountNumber()==fromAccountNo)
						 flag1=1;
					 if(acnt.getAccountNumber()==toAccountNo)
						 flag2=1;
				 }
				 if(flag1 != 1 || flag2 != 1)
				 {
					 throw new InvalidAccountNumberException("Account number does not exists!");
				 }
				 else
				 {
					 for(Account account:list)
					 {
						 if(account.getAccountNumber()==fromAccountNo)
						 {
							 if(account.getAmount()<amount)
								 throw new InsufficientBalanceException("Insufficient balance in sender's account!");
							 account.setAmount(account.getAmount()-amount);
							 array[0][0]=account.getAccountNumber();
							 array[0][1]=account.getAmount();
						 } 	 
				     }
					 for(Account account2:list)
					 {
						 if(account2.getAccountNumber()==toAccountNo)
						 {
							 account2.setAmount(account2.getAmount()+amount);
							 array[1][0]=account2.getAccountNumber();
							 array[1][1]=account2.getAmount();
						 }
					 } 
				 }
				 return array; 
		
		
	 }
	 
	 
}

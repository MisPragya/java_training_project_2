package com.capgemini.UI;

import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InvalidAccountNumberException;
import java.util.LinkedList;
import java.util.Scanner;

import com.capgemini.bean.Account;
import com.capgemini.service.*;

public class Client {

	LinkedList<HDFCBank> banklist = new LinkedList<HDFCBank>();
	static HDFCBank hdfc=new HDFCBank();
	private static Scanner scanner=new Scanner(System.in);
		
	public static void main(String[] args)
	{
	   
	   System.out.println(".....Welcome to HDFC Bank.....");
	   
	   int choice;
		while(true)
		{
			System.out.println("1. Open new Account");
			System.out.println("2. Deposit Money");
			System.out.println("3. Cash withdrawl");
			System.out.println("4. Fund Transfer");
			System.out.println("5. Exit");
			
			System.out.println("Enter your choice: ");
			choice=scanner.nextInt();
			
			switch(choice)
			{
			case 1:
				createAccount();
				break;
			case 2:
				depositAmount();
				break;
			case 3:
				withdrawAmount();
				break;
			case 4:
				fundTransfer();
				break;
			case 5:
				System.exit(0);
				break;
			default:
				System.out.println("Oops! Wrong choice.");
			}	
		}		


	}
	
	private static void createAccount()
	{
		  // System.out.println("Enter account holder name: ");
		   //String name=scanner.next();
		   //System.out.println("Enter DOB (dd/mm/yyyy): ");
		   //System.out.println("Enter Aadhaar number: ");
		   System.out.println("Enter account number: ");
		   int accountNumber=scanner.nextInt();
		   System.out.println("Enter amount (minimum 500): ");
		   int amount=scanner.nextInt();
		   try {
		   System.out.println(hdfc.createAccount(accountNumber,amount));}
		   catch(InvalidAccountNumberException ia) {}  
		   catch(InsufficientBalanceException ib) {}
		   
	}
	static void depositAmount()
	{
		System.out.println("Enter account number: ");
		int accountNumber=scanner.nextInt();
		System.out.println("Enter amount to be deposited: ");
		int amount=scanner.nextInt();
		try {
		System.out.println(hdfc.depositAmount(accountNumber,amount));
		}  catch(InvalidAccountNumberException ia) {}  
	}
	static void withdrawAmount()
	{
		System.out.println("Enter account number: ");
		int accountNumber=scanner.nextInt();
		System.out.println("Enter amount to withdraw: ");
		int amount=scanner.nextInt();
		try{
			int rAmount=hdfc.withdrawAmount(accountNumber, amount);
			System.out.println("Remaining balance in account: "+rAmount);
		}  
		catch(InvalidAccountNumberException ia) {}  
		catch(InsufficientBalanceException ib) {}
	}
		
	static void fundTransfer()
	{
		System.out.println("Enter transfer FROM account number: ");
		int FromAccountNumber=scanner.nextInt();
		System.out.println("Enter transfer TO account number: ");
		int toAccountNumber=scanner.nextInt();
		if(FromAccountNumber == toAccountNumber)
			System.out.println("Can't transfer to account from same account! ");
		else {
		System.out.println("Enter fund transfer amount: ");
		int amount=scanner.nextInt();
		int[][] s=new int[2][2];
		try{
			s=hdfc.fundTransfer(FromAccountNumber, toAccountNumber, amount);
		} 
		catch(InvalidAccountNumberException ia) {}  
		catch(InsufficientBalanceException ib) {}
		System.out.println("Remaining balance in account number "+s[0][0]+" is: "+s[0][1]);
		System.out.println("Updated balance in account number "+s[1][0]+" is: "+s[1][1]);
	
		}
	}
}

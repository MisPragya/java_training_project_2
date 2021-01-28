package com.capgemini.view;
import com.capgemini.service.StudentSchedular;
import java.util.Scanner;
public class Admin {

	private static Scanner scanner=new Scanner(System.in);
	static StudentSchedular studSc=new StudentSchedular();
	static int[] existingRolls=new int[10];
	static int counter;
	
	public static void main(String[] args) {
		int choice;
		while(true)
		{
			System.out.println("1. Add a student");
			System.out.println("2. View all students' details");
			System.out.println("3. Show student details by roll number");
			System.out.println("4. Show student details by course name");
			System.out.println("5. Show student count by course name");
			System.out.println("6. Exit");
			
			System.out.println("Enter your choice: ");
			choice=scanner.nextInt();
			
			switch(choice)
			{
			case 1:
				addStudent();
				break;
			case 2:
				showAllStudents();
				break;
			case 3:
				showStudByRoll();
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				System.exit(0);
				break;
			default:
				System.out.println("Oops! Wrong choice.");
			}	
		}		
	}

	private static void addStudent()
	{
		System.out.println("Enter roll number: ");
		int rollNum=scanner.nextInt();
		System.out.println("Enter name: ");
		String name=scanner.next();
		System.out.println("Enter no. of courses student is enrolled in: ");
		int courseCount=scanner.nextInt();
		String[] courses=new String[courseCount];
		System.out.println("Enter courses: ");
		for(int i=0;i<courseCount;i++)
			courses[i]=scanner.next();
		
		//validating roll numbers		
	    existingRolls[counter]=studSc.addStudent(rollNum,name,courses,existingRolls);
        counter++;
	    if(existingRolls[--counter]==-1) {
	    	System.out.println("Sorry, this Roll number already exists or is invalid!");
	    	existingRolls[counter]=0;
	    	counter--;
	    }else
	    	System.out.println(" student added successfully.......");
	}
	
	private static void showAllStudents()
	{
		String[][] studentDetails=new String[10][];
		studentDetails=studSc.showAllStudents(counter);
		System.out.println(studentDetails);
	}

	private static void showStudByRoll()
	{
		System.out.println("Enter roll number to show details: ");
		int roll=scanner.nextInt();
		studSc.showStudByRoll(roll);
		
	}
}







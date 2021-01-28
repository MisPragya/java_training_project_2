package com.capgemini.service;

import com.capgemini.model.Student;

public class StudentSchedular {
		
	private Student[] studs=new Student[10];
	private static int counterStudent;
	
	public int addStudent(int rollNum,String name,String[] courses,int[] existingRolls)
	{
		boolean rollExists=checkIfRollExists(rollNum,existingRolls);
		if(rollExists)
			return -1;
		
		if(rollNum < 1)
			return -1;
		
		studs[counterStudent]=new Student();
		studs[counterStudent].setRollNum(rollNum);
		studs[counterStudent].setName(name);
		studs[counterStudent].setCourses(courses);
		counterStudent++;
		return studs[--counterStudent].getRollNum();
	}
	
	public String[][] showAllStudents(int counterStudent)
	{ 
		System.out.println("counterStudent is: "+counterStudent);
			String[][] studentDetails=new String[counterStudent][];
			for(int i=0;i<counterStudent;i++)
			{
					studentDetails[i][0]=Integer.toString(studs[i].getRollNum());	
					studentDetails[i][1]=studs[i].getName();
					String[] courses=studs[i].getCourses();
					System.out.println("i is "+i+" "+courses);
					//studentDetails[i][2]=courses;	
			}
		
		return studentDetails;	
	}
	
	public String[] showStudByRoll(int roll)
	{
		String details[]=new String[10];
		details[0]=Integer.toString(studs[roll].getRollNum());
		details[1]=studs[roll].getName();
	//	details[2]=studs[roll].getCourses();
		return details;
	}
	
	private boolean checkIfRollExists(int rollNum,int[] existingRolls)
	{
		boolean rollExists=false;
		int i = 0;
		
		while(i <10 && existingRolls[i] > 0 )
		{
			if(existingRolls[i]==rollNum)
			{
				rollExists=true;
				return rollExists;
			}
			i++;
		}
		return rollExists;
	}
	
}

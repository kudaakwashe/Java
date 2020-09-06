/*Part A : ModuleGrader Class 
 * Practical Programming Assessment 1
 */

import java.util.Scanner;

public class ModuleGrader {
	
	//declaring variables
	private int mark;
	private String grade;
	String response;
	
	//method to take the mark and provide a grade
	public String gradeModule(int markIn)
	{
		mark = markIn;
		if (mark >= 70 && mark <=100)
		{
			grade = "Excellent";
		}
		else if (mark >= 60 && mark <=69)
		{
			grade = "Good";
		}
		else if (mark >= 50 && mark <= 59)
		{
			grade = "Satisfactory";
		}
		else if (mark >= 40 && mark <= 49)
		{
			grade = "Compensatable fail";
		}
		else
		{
			grade = "Outright fail";
		}
		
		return grade;
	}
	
	//method to validate mark
	public int getValidModuleMark()
	{
		//create a Scanner object to get keyboard input
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		
		//checking if a valid mark has been entered
		do
		{
			System.out.println("Please enter a valid mark from 0 - 100.");
			mark = keyboard.nextInt();
		}
		while(mark < 0 || mark > 100);

		return mark;
	}	
	
	//method that starts the grading
	public void startModuleGrading()
	{
		//create a Scanner object for continuing grading
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		do 
		{
			//display start of program
			System.out.println("*************Module Grading Program*************");
			System.out.println();
			getValidModuleMark();
			System.out.println("Your grade is: " + gradeModule(mark));
			System.out.println();
			//request to continue grading
			System.out.println("Would you like to continue grading? (Enter yes to continue or no to end).");
			response = s.nextLine();
			System.out.println();
		}
		while (response.equalsIgnoreCase("yes"));
	}
}

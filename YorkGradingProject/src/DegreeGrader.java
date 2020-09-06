/*Part B : DegreeGrader Class 
 * Practical Programming Assessment 1
 */

import java.util.Scanner;

public class DegreeGrader {
	
	//variable declaration
	private int allModuleAverage;
	private int ismModuleAverage;
	private int compensentableFailed;
	private int outrightFailed;
	private String degreeClass;
	private int totalFailedCredits;
	String response;
	
	//method to determine degree class
	public String gradeDegree(int allModuleAverageIn, int ismModuleAverageIn, int compensentableFailedIn, int outrightFailedIn)
	{
		
		allModuleAverage = allModuleAverageIn;
		ismModuleAverage = ismModuleAverageIn;
		compensentableFailed = compensentableFailedIn;
		outrightFailed = outrightFailedIn;
		
		if (allModuleAverage >= 70 && ismModuleAverage >= 70 && compensentableFailed == 0 && outrightFailed == 0)
		{
			degreeClass = "distinction";
		}
		else if (allModuleAverage >= 60 && ismModuleAverage >= 60 && compensentableFailed <= 15 && outrightFailed == 0)
		{
			degreeClass = "merit";
		}
		else if (allModuleAverage >= 50 && ismModuleAverage >= 50 && compensentableFailed <= 30 && outrightFailed == 0)
		{
			degreeClass = "pass";
		}
		else 
		{
			//find total failed credits
			totalFailedCredits = compensentableFailed + (outrightFailed * 2);
			
			if(allModuleAverage < 50 && ismModuleAverage < 50 && outrightFailed <= 2 && totalFailedCredits <= 60) 
			{
				degreeClass = "fail";
			}
		}
		
		return degreeClass;
	}
	
	//method to get valid input for All Module Average
	public int getValidAllModuleAverage()
	{
		//create a Scanner object to get keyboard input
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
			
		//checking if valid input has been entered
		do
		{
			System.out.println("Please enter a valid all module average from 0 - 100.");
			allModuleAverage = keyboard.nextInt();
		}
		while(allModuleAverage < 0 || allModuleAverage > 100);
			
		return allModuleAverage;		
	}
		
	//method to get valid input for ISM Module Average
	public int getValidISMModuleAverage()
	{
		//create a Scanner object to get keyboard input
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
			
		//checking if valid input has been entered
		do
		{
			System.out.println("Please enter a valid ISM module average from 0 - 100.");
			ismModuleAverage = keyboard.nextInt();
		}
		while(ismModuleAverage < 0 || ismModuleAverage > 100);
			
		return ismModuleAverage;	
	}
		
	//method to get valid input for Compensentable Failed credits
	public int getValidCompensatableFailed()
	{
		//create a Scanner object to get keyboard input
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
			
		//checking if valid input has been entered
		do
		{
			System.out.println("Please enter a valid compensentable credits from 0 - 180.");
			compensentableFailed = keyboard.nextInt();
		}
		while (compensentableFailed < 0 || compensentableFailed > 180);
			
		return compensentableFailed;
	}	
		
	//method to get valid input for Outright Failed Modules
	public int getValidOutrightFailed()
	{
		//create a Scanner object to get keyboard input
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
			
		//checking if valid input has been entered
		do
		{
			System.out.println("Please enter a valid outright failed modules from 0 - 11.");
			outrightFailed = keyboard.nextInt();
		}
		while(outrightFailed < 0 || outrightFailed > 11);
			
		return outrightFailed;
	}	
	
	public void startDegreeGrading()
	{
		//create a Scanner object for continuing grading
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		do 
		{
			//display start of program
			System.out.println("*************Degree Classification Program*************");
			System.out.println();
			getValidAllModuleAverage();
			getValidISMModuleAverage();
			getValidCompensatableFailed();
			getValidOutrightFailed();
			System.out.println("Your degree classification is: " + gradeDegree(allModuleAverage, ismModuleAverage, compensentableFailed, outrightFailed));
			System.out.println();
			
			//request to continue degree classification
			System.out.println("Would you like to continue degree classification? (Enter yes to continue or no to end).");
			response = s.nextLine();
			System.out.println();
		}
		while (response.equalsIgnoreCase("yes"));
	}
}

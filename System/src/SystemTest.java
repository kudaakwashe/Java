import java.util.Locale;
import java.util.Scanner;

public class SystemTest {
	
	 public static void main(String args[]) 
	 {
		 //create scanner object to take input and Locale.UK allows inputs of type double with (.) instead of (,)
		 @SuppressWarnings("resource")
		Scanner keyboard = new Scanner(java.lang.System.in).useLocale(Locale.UK);
		 
		 //declare attributes used
		 char response;
		 int memorySize;
		 double hardDiskSize;
		 double purchaseCost;
		 
		 //creating a System object
		 System s = new System("Dell", "Inspiron", 2);
		 
		 do
		 {
			//creating textual menu
			 java.lang.System.out.println();
			 java.lang.System.out.println("***SYSTEM MENU***");
			 java.lang.System.out.println();
			 java.lang.System.out.println("Choice 1 – Print System Details");
			 java.lang.System.out.println("Choice 2 - Display System Properties");
			 java.lang.System.out.println("Choice 3 – Diagnose System");
			 java.lang.System.out.println("Choice 4 – Set Details");
			 java.lang.System.out.println("Choice 0 – Quit the program");
			 java.lang.System.out.println("Enter the number next to your choice (e.g 1 for Choice 1)");
			 java.lang.System.out.println();
			 response = keyboard.next().charAt(0);
			 java.lang.System.out.println();
			 switch(response)
			 {
			 case '1' : java.lang.System.out.println(s.displayDetails());
			 		   	break;
			 case '2' : java.lang.System.out.println(s.displaySystemProperties());
	 		   			break;
			 case '3' : java.lang.System.out.println(s.diagnoseSystem());
			 			break;
			 case '4' : try
			 			{
				 			java.lang.System.out.println("Please enter the memory size (MB): ");
				 			memorySize = keyboard.nextInt();
				 			s.setMemory(memorySize);
				 			java.lang.System.out.println("Please enter the hard disk size (GB): ");
				 			hardDiskSize = keyboard.nextDouble();
				 			s.setHardDisk(hardDiskSize);
				 			java.lang.System.out.println("Please enter the purchase price ($): ");
				 			purchaseCost = keyboard.nextDouble();
				 			s.setPurchaseCost(purchaseCost);
			 			}
			 			catch (Exception e)
			 			{
			 				java.lang.System.out.println("Please enter the correct values: "  +
									 "Memory Size as integer, Hard Disk Size and Purchase Cost as numeric.");
			 			}
			 			finally
			 			{
			 				java.lang.System.out.println("");
			 			}
			 			break;
			 case '0' : break;
			 default : java.lang.System.out.println("Enter the only numbers from 0 - 4.");
			 		   java.lang.System.out.println();
			 }
			 
		 } while (response != '0');
		 
		 
		 
		 //get value of getMake() method
		 java.lang.System.out.println();
		 java.lang.System.out.println("***Testing getMake method***");
		 java.lang.System.out.println(s.getMake());
		 java.lang.System.out.println();
		 
		//get value of getModel() method
		 java.lang.System.out.println("***Testing getModel method***");
		 java.lang.System.out.println(s.getModel());
		 java.lang.System.out.println();
		 
		//get value of getProcessorSpeed() method
		 java.lang.System.out.println("***Testing getProcessorSpeed***");
		 java.lang.System.out.println(s.getProcessorSpeed());
		 
		 //set memory method and print value
		 s.setMemory(64);
		 java.lang.System.out.println();
		 
		//set hard disk size
		 s.setHardDisk(2.4);
		 java.lang.System.out.println();
		 
		//set purchase cost
		 s.setPurchaseCost(147.69);
		 java.lang.System.out.println();
		 
		 //display details
		 java.lang.System.out.println("***Testing displayDetails***");
		 java.lang.System.out.println(s.displayDetails());
		 java.lang.System.out.println();
		 
		 //check HD status
		 java.lang.System.out.println("***Testing checkHDStatus***");
		 java.lang.System.out.println(s.checkHDStatus());
		 java.lang.System.out.println();
		 
		 //check if memory size is good
		 java.lang.System.out.println("***Testing goodMemorySize***");
		 java.lang.System.out.println(s.goodMemorySize());
		 java.lang.System.out.println();
		 
		 //diagnose system method
		 java.lang.System.out.println("***Testing the diagnoseSystem***");
		 java.lang.System.out.println(s.diagnoseSystem());	 
		 java.lang.System.out.println();
		 
		 //testing the system properties method
		 java.lang.System.out.println(s.displaySystemProperties());
		 
	 }

}

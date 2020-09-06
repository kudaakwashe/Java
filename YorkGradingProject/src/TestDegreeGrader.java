
public class TestDegreeGrader {
	
	static int allModuleAverage;
	static int ismModuleAverage;
	static int compensentableFailed;
	static int outrightFailed;
	static int totalFailedCredits;
	static String degreeClass;
	
	
	public static void main (String args[])
	{
		DegreeGrader masters = new DegreeGrader();
		System.out.println("Testing the gradeDegree method.");
		degreeClass = masters.gradeDegree(69,70,14,0);
		System.out.println(degreeClass);
		System.out.println();
		
		//testing getValidAllModuleAverage method
		System.out.println("Testing the getValidAllModuleAverage method.");
		allModuleAverage = masters.getValidAllModuleAverage();
		System.out.println(allModuleAverage);
		System.out.println();
		
		//testing getValidISMModuleAverage method
		System.out.println("Testing the getValidISMModuleAverage method.");
		ismModuleAverage = masters.getValidISMModuleAverage();
		System.out.println(ismModuleAverage);
		System.out.println();
		
		//testing getValidCompensatableFailed method
		System.out.println("Testing the getValidCompensatableFailed method.");
		compensentableFailed = masters.getValidCompensatableFailed();
		System.out.println(compensentableFailed);
		System.out.println();
		
		//testing getValidOutrightFailed method
		System.out.println("Testing the getValidOutrightFailed method.");
		outrightFailed= masters.getValidOutrightFailed();
		System.out.println(outrightFailed);
		System.out.println();
		
		//testing startDegreeGrading method
		System.out.println("Testing the startDegreeGrading() method.");
		System.out.println();
		masters.startDegreeGrading();
		
	}


}

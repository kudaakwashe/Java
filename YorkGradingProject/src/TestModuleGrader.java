/*Part A : TestModuleGrader Class 
 * Practical Programming Assessment 1
 */
public class TestModuleGrader {
	
	static int mark;
	public static void main (String args[])
	{
		ModuleGrader student = new ModuleGrader();
		//testing gradeModule method
		System.out.println("Testing the gradeModule method: " + student.gradeModule(90));
		System.out.println();
		
		//testing getValidModuleMark method
		System.out.println("Testing the getValidModuleMark method.");
		mark = student.getValidModuleMark();
		System.out.println(mark);
		System.out.println();
		
		//testing gradeModule method
		System.out.println("Testing the startModuleGrading method.");
		System.out.println();
		student.startModuleGrading();
		
	}

}

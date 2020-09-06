/* PART A : System Class
 * Practical Programming Assessment 2
 */


public class System {
	
	//declare the attributes
	private String make;
	private String model;
	private int speed;
	private int memorySize; // in MB
	private double hardDiskSize; // in GB
	private double purchaseCost; 
	
	
	//create the constructor
	public System(String makeIn, String modelIn, int speedIn)
	{
		make = makeIn;
		model = modelIn;
		speed = speedIn;
	}
	
	//create get make method
	public String getMake()
	{
		return make;
	}
	
	//create get model method
	public String getModel()
	{
		return model;
	}
	
	//create get process speed
	public int getProcessorSpeed()
	{
		return speed;
	}
	
	//create set memory size method
	public void setMemory(int memorySizeIn)
	{
		memorySize = memorySizeIn;
	}
	
	//create set hard disk size method
	public void setHardDisk(double hardDiskSizeIn) 
	{
		hardDiskSize = hardDiskSizeIn;
	}
	
	//create set purchase cost
	public void setPurchaseCost(double purchaseCostIn)
	{
		purchaseCost = purchaseCostIn;
	}
	
	//displaying system details method
	public String displayDetails()
	{
		return "Make: " + make + "\n" +
				"Model: " + model + "\n" +
				"Speed: " + speed + "\n" +
				"Memory Size: " + memorySize + "\n"+
				"Hard Disk Size: " + hardDiskSize + "\n" +
				"Purchase Cost: " + purchaseCost;
	}
	
	//check hard disk status method
	public String checkHDStatus()
	{
		if(hardDiskSize < 2)
		{
			return "low";
		}
		else
		{
			return "OK";
		}
	}
	
	//checking memory size method
	public boolean goodMemorySize()
	{
		if(memorySize < 128)
			return false;
		else
			return true;
	}
	
	//create diagnose system
	public String diagnoseSystem()
	{
		return "Hard disk size = " + checkHDStatus() +"\n" +
			   "Memory size OK = " + goodMemorySize();
	}
	
	//display system properties method
	public String displaySystemProperties()
	{
		String os_name = java.lang.System.getProperty("os.name");
		String os_message;
		
		if(os_name.equalsIgnoreCase("Windows 10"))
		{
			os_message = "(This is the optimal operating system.)";
		}
		else if(os_name.equalsIgnoreCase("Linux"))
		{
			os_message = "(This is not the required operating system.)";
		}
		else
		{
			os_message = "(This operating system is not optimal but it will work.)";
		}
		
		return "Operating System Architecture: " + java.lang.System.getProperty("os.arch") + "\n" +
		   		"Operating System Name: " + os_name + " " + os_message + "\n" +
		   		"Operating System Version: " + java.lang.System.getProperty("os.version") + "\n" + 
		   		"User Account Name: " + java.lang.System.getProperty("user.name") + "\n" + 
		   		"Java Version: " + java.lang.System.getProperty("java.version");
	}

}


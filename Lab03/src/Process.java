/*
*Written by Andrew Davison
*/
public class Process {
	
	private String name;
	private double compTime;
	
	public Process()
	{
		this.name = "none";
		this.compTime = 0.0;
	}
	public Process(String aName, double aTime)
	{
		this.setName(aName);
		this.setCompletionTime(aTime);
	}
	public String getName()
	{
		return this.name;
	}
	public double getCompletionTime()
	{
		return this.compTime;
	}
	public void setName(String aName)
	{
		if(aName == null)
			this.name = "none";
		else
			this.name = aName;
	}
	public void setCompletionTime(double aTime)
	{
		if(aTime >= 0.0)
			this.compTime = aTime;
		else
			this.compTime = 0.0;
	}
	public String toString()
	{
		return "Process Name: " + this.name + " Completion Time: " + this.compTime;
	}

}

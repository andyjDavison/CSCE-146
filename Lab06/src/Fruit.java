/*
*Written by Andrew Davison
*/
public class Fruit implements Comparable<Fruit>{
	
	private String type;
	private double weight;
	public Fruit()
	{
		this.type = "apple";
		this.weight = 1.0;
	}
	public Fruit(String aT, double aW)
	{
		this.setType(aT);
		this.setWeight(aW);
	}
	public String getType()
	{
		return this.type;
	}
	public double getWeight()
	{
		return this.weight;
	}
	public void setType(String aT)
	{
		if(aT != null && (aT.equalsIgnoreCase("apple") || aT.equalsIgnoreCase("orange") || aT.equalsIgnoreCase("banana") || aT.equalsIgnoreCase("kiwi") || aT.equalsIgnoreCase("tomato")))
			this.type = aT;
		else
			this.type = "apple";
	}
	public void setWeight(double aW)
	{
		if(aW > 0.0)
			this.weight = aW;
		else
			this.weight = 1.0;
	}
	public String toString()
	{
		return "Type: "+this.type+" Weight: "+this.weight;
	}
	public int compareTo(Fruit aF)
	{
		if(aF == null)
		{
			return -1;
		}
		if(this.weight > aF.getWeight())
		{
			return 1;
		}
		else if(this.weight < aF.getWeight())
		{
			return -1;
		}
		else
		{
			if(this.type.compareTo(aF.getType()) == 0)//are the same
				return 0;
			else
				return -1;
		}
	}

}

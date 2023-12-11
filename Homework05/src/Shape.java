/*
*Written by Andrew Davison
*/
public class Shape implements Comparable<Shape>{
	
	private String type;
	private double area;
	
	public Shape()
	{
		this.type = "rectangle";
		this.area = 1.0;
	}
	public Shape(String aT, double aA)
	{
		this.setType(aT);
		this.setArea(aA);
	}
	public String getType()
	{
		return this.type;
	}
	public double getArea()
	{
		return this.area;
	}
	public void setType(String aT)
	{
		if(aT != null && (aT.equalsIgnoreCase("rectangle") || aT.equalsIgnoreCase("circle") || aT.equalsIgnoreCase("right triangle")))
			this.type = aT;
		else
			this.type = "rectangle";
	}
	public void setArea(double aA)
	{
		if(aA > 0.0)
			this.area = aA;
		else
			this.area = 1.0;
	}
	public String toString()
	{
		return this.type;
	}
	public int compareTo(Shape aS)
	{
		if(aS == null)
			return -1;
		else
		{
			if(this.area > aS.getArea())
				return 1;
			else if(this.area < aS.getArea())
				return -1;
			else
				return this.type.compareTo(aS.getType());
		}
	}

}

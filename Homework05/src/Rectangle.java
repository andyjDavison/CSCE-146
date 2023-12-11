/*
*Written by Andrew Davison
*/
public class Rectangle extends Shape{
	
	private double length;
	private double width;
	public Rectangle()
	{
		super();
		this.length = 1.0;
		this.width = 1.0;
	}
	public Rectangle(String aT, double aA, double aL, double aW)
	{
		super(aT,aA);
		this.setLength(aL);
		this.setWidth(aW);
	}
	public double getLength()
	{
		return this.length;
	}
	public double getWidth()
	{
		return this.width;
	}
	public void setLength(double aL)
	{
		if(aL > 0.0)
			this.length = aL;
		else
			this.length = 1.0;
	}
	public void setWidth(double aW)
	{
		if(aW > 0.0)
			this.width = aW;
		else
			this.width = 1.0;
	}
	public void calcArea(double aL, double aW)
	{
		super.setArea(aL*aW);
	}
	public String toString()
	{
		return super.toString()+" Length: "+this.length+" Width: "+this.width;
	}

}

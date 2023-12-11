/*
*Written by Andrew Davison
*/
public class Circle extends Shape{
	
	private double radius;
	public Circle()
	{
		super();
		this.radius = 1.0;
	}
	public Circle(String aT, double aA, double aR)
	{
		super(aT,aA);
		this.setRadius(aR);
	}
	public double getRadius()
	{
		return this.radius;
	}
	public void setRadius(double aR)
	{
		if(aR > 0.0)
			this.radius = aR;
		else
			this.radius = 1.0;
	}
	public void calcArea(double aR)
	{
		super.setArea(Math.PI*(Math.pow(aR, 2)));
	}
	public String toString()
	{
		return super.toString()+" Radius: "+this.radius;
	}

}

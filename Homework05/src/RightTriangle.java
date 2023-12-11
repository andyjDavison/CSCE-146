/*
*Written by Andrew Davison
*/
public class RightTriangle extends Shape{
	
	private double base;
	private double height;
	public RightTriangle()
	{
		super();
		this.base = 1.0;
		this.height = 1.0;
	}
	public RightTriangle(String aT, double aA, double aB, double aH)
	{
		super(aT, aA);
		this.setBase(aB);
		this.setHeight(aH);
	}
	public double getBase()
	{
		return this.base;
	}
	public double getHeight()
	{
		return this.height;
	}
	public void setBase(double aB)
	{
		if(aB > 0.0)
			this.base = aB;
		else
			this.base = 1.0;
	}
	public void setHeight(double aH)
	{
		if(aH > 0.0)
			this.height = aH;
		else
			this.height = 1.0;
	}
	public void calcArea(double aB, double aH)
	{
		super.setArea((0.5)*aB*aH);
	}
	public String toString()
	{
		return super.toString()+" Base: "+this.base+" Height: "+this.height;
	}

}

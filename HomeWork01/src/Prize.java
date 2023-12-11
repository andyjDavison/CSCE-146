/*
*Written by Andrew Davison
*/
public class Prize {
	private String prizeName;
	private int price;
	public Prize()
	{
		this.prizeName = "none";
		this.price = 0;
	}
	public Prize(String aName, int aPrice)
	{
		this.setPrizeName(aName);
		this.setPrice(aPrice);
	}
	public String getPrizeName()
	{
		return this.prizeName;
	}
	public int getPrice()
	{
		return this.price;
	}
	public void setPrizeName(String aName)
	{
		if(aName != null)
			this.prizeName = aName;
		else
			this.prizeName = "none";
	}
	public void setPrice(int aPrice)
	{
		if(aPrice >= 0)
			this.price = aPrice;
		else
			this.price = 0;
	}
	public String toString()
	{
		return this.prizeName+"\t"+this.price;
	}
	public boolean equals(Prize aP)
	{
		return aP != null &&
				this.prizeName.equalsIgnoreCase(aP.getPrizeName()) &&
				this.price == aP.getPrice();
	}
}

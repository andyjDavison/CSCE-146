/*
*Written by Andrew Davison
*/
public class Game {
	private String name;
	private String console;
	
	public Game()
	{
		name = "none";
		console = "none";
	}
	public Game(String aName, String aConsole)
	{
		this.setName(aName);
		this.setConsole(aConsole);
	}
	public void setName(String aName)
	{
		if(aName == null)
			this.name = "none";
		else
			this.name = aName;
	}
	public void setConsole(String aConsole)
	{
		if(aConsole == null)
			this.console = "none";
		else
			this.console = aConsole;
	}
	public String getName()
	{
		return this.name;
	}
	public String getConsole()
	{
		return this.console;
	}
	public String toString()
	{
		return this.name + "\t" + this.console;
	}
	public boolean equals(Game aGame)
	{
		return aGame != null &&
				this.name.equalsIgnoreCase(aGame.getName()) &&
				this.console.equalsIgnoreCase(aGame.getConsole());
	}

}

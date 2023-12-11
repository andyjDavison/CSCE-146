/*
*Written by Andrew Davison
*/
import java.util.Scanner;
import java.io.*;
public class GameManager {
	
	public static final String DELIM = "\t";
	public static final int BODY_FIELD_AMT = 2;
	private GenLL<Game> games;
	private GenLL<Game> searchOutput;
	public GameManager()
	{
		games = new GenLL<Game>();
		searchOutput = new GenLL<Game>();
	}
	public void addGame(Game aGame)
	{
		games.add(aGame);
	}
	public void readGameFile(String aName)
	{
		try
		{
			Scanner fileScanner = new Scanner(new File(aName));
			while(fileScanner.hasNextLine())
			{
				String fileLine = fileScanner.nextLine();
				String[] splitLines = fileLine.split(DELIM);
				if(splitLines.length == BODY_FIELD_AMT)
				{
					String name = splitLines[0];
					String console = splitLines[1];
					Game aGame = new Game(name, console);
					this.addGame(aGame);
				}
			}
			fileScanner.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void writeGameFile(String aName)
	{
		try
		{
			PrintWriter fileWriter = new PrintWriter(new FileOutputStream(aName));
			//body
			searchOutput.reset();
			while(searchOutput.hasMore())
			{
				Game aGame = searchOutput.getCurrent();
				fileWriter.println(aGame.getName()+DELIM+aGame.getConsole());
				searchOutput.gotoNext();
			}
			fileWriter.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void search(String aName, String aConsole)
	{
		int size = games.getSize();
		for(int i=0;i<size;i++)
		{
			String name = games.getAt(i).getName();
			String console = games.getAt(i).getConsole();
			if((aName.equals("*") || aName.equalsIgnoreCase(name)) && (aConsole.equals("*") || aConsole.equalsIgnoreCase(console)))
			{
				Game aGame = new Game(name, console);
				searchOutput.add(aGame);
			}
		}
		searchOutput.print();
	}
	public void printGames()
	{
		games.print();
	}

}

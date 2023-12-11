/*
*Written by Andrew Davison
*/
import java.util.Scanner;
public class VGDatabaseReaderFE {

	private static Scanner keyboard = new Scanner(System.in);
	private static GameManager gameManager = new GameManager();
	public static void main(String[] args) {
		
		greetings();
		boolean quit = false;
		while(!quit)
		{
			readGameFile();
			search();
			printToFile();
			System.out.println("To quit type \"quit\", to continue hit ENTER");
			String choice = keyboard.nextLine();
			if(choice.equalsIgnoreCase("quit"))
				quit = true;
		}
	}
	public static void greetings()
	{
		System.out.println("Welcome to the Video Game Database!");
	}
	public static void readGameFile()
	{
		System.out.println("Enter the file name to read a Game Database");
		String fileName = keyboard.nextLine();
		gameManager.readGameFile(fileName);
	}
	public static void writeGameFile()
	{
		System.out.println("Enter a file name to write a Game Database");
		String fileName = keyboard.nextLine();
		gameManager.writeGameFile(fileName);
	}
	public static void search()
	{
		System.out.println("Enter the name of a game or enter \"*\" to search all games");
		String gameName = keyboard.nextLine();
		System.out.println("Enter the name of a console or enter \"*\" to search all consoles");
		String consoleName = keyboard.nextLine();
		gameManager.search(gameName, consoleName);
	}
	public static void printToFile()
	{
		System.out.println("Do you want to add these search results to a file?\nEnter \"yes\" or \"no\"");
		String choice = keyboard.nextLine();
		if(choice.equalsIgnoreCase("yes"))
		{
			writeGameFile();
		}
	}

}

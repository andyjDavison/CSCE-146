/*
*Written by Andrew Davison
*/
import java.util.Scanner;
public class RobotGameFE {

	public static Scanner keyboard = new Scanner(System.in);
	public static RobotSimulator roboSim = new RobotSimulator();
	public static void main(String[] args) {
		boolean quit = false;
		while(!quit)
		{
			readBoardFile();
			roboSim.printBoard();
			System.out.println("----------");
			readCommandFile();
			System.out.println("To quit type \"quit\". To continue press ENTER");
			String choice = keyboard.nextLine();
			if(choice.equalsIgnoreCase("quit"))
			{
				System.out.println("Goodbye");
				quit = true;
				break;
			}
			quit = false;
		}

	}
	public static void readBoardFile()
	{
		System.out.println("Enter a file for the board");
		String fileName = keyboard.nextLine();
		roboSim.makeBoard(fileName);
	}
	public static void readCommandFile()
	{
		System.out.println("Enter a file for the robot commands");
		String fileName = keyboard.nextLine();
		roboSim.moveWithCommands(fileName);
	}

}

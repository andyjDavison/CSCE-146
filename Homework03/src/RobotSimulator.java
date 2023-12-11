/*
*Written by Andrew Davison
*/
import java.util.Scanner;
import java.io.*;
public class RobotSimulator {
	public static final int SIZE = 10;
	private char board[][];
	private GenericQueue<String> commands;
	
	public RobotSimulator()
	{
		board = new char[SIZE][SIZE];
		commands = new GenericQueue<String>();
	}
	//Make the board
	public void makeBoard(String aName)
	{
		try
		{
			Scanner fileScanner = new Scanner(new File(aName));
			while(fileScanner.hasNextLine())
			{
				for(int i=0;i<board.length;i++)
				{
					String fileLine = fileScanner.nextLine();
					for(int j=0;j<board[i].length;j++)
					{
						char boardSpot = fileLine.charAt(j);
						board[i][j] = boardSpot;
					}
				}
			}
			board[0][0] = 'O';
			fileScanner.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	//print the board
	public void printBoard()
	{
		for(int i=0;i<board.length;i++)
		{
			for(int j=0;j<board[i].length;j++)
				System.out.print(board[i][j]);
			System.out.println();
		}
	}
	//check if the robot is inbounds
	public boolean inbounds(int i, int j, char board[][])
	{
		if(i>=0 && i<SIZE && j<SIZE && j>=0 && board[i][j] == '_')
			return true;
		else
		{
			System.out.println("CRASH!");
			return false;
		}
	}
	public void moveWithCommands(String aName)
	{
		int x = 0;
		int y = 0;
		
		try
		{
			Scanner fileScanner = new Scanner(new File(aName));
			while(fileScanner.hasNextLine())
			{
				String command = fileScanner.nextLine();
				commands.enqueue(command);
				System.out.println("----------\n"+commands.peek()+"\n----------");
				if(commands.peek().equals("Move Up"))
				{
					if(inbounds(y-1, x, board))
					{
						board[y][x] = '_';
						board[y-1][x] = 'O';
						y--;
						printBoard();
						commands.dequeue();
					}
				}
				else if(commands.peek().equals("Move Down"))
				{
					if(inbounds(y+1, x, board))
					{
						board[y][x] = '_';
						board[y+1][x] = 'O';
						y++;
						printBoard();
						commands.dequeue();
					}
				}
				else if(commands.peek().equals("Move Left"))
				{
					if(inbounds(y, x-1, board))
					{
						board[y][x] = '_';
						board[y][x-1] = 'O';
						x--;
						printBoard();
						commands.dequeue();
					}
				}
				else if(commands.peek().equals("Move Right"))
				{
					if(inbounds(y, x+1, board))
					{
						board[y][x] = '_';
						board[y][x+1] = 'O';
						x++;
						printBoard();
						commands.dequeue();
					}
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}

/*
*Written by Andrew Davison
*/
import java.util.Scanner;
import java.util.Random;
public class ShowcaseShowdown {

	public static PrizeManager prizeManager = new PrizeManager();
	public static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args) {
		
		boolean quit = false;
		while(!quit)
		{
			System.out.println("Welcome to Showcase Showdown!");
			readPrizeFile();
			Prize[] randomPrize = prizeManager.pickRandomPrizes();
			int price = 0;
			for(int i=0;i<randomPrize.length;i++)
			{
				System.out.println(randomPrize[i].getPrizeName());
				price += randomPrize[i].getPrice();
			}
			System.out.println("Enter your guess for the total cost without going $3,500 under the total, or going over");
			int priceGuess = keyboard.nextInt();
			keyboard.nextLine();
			if(didWin(priceGuess,price))
			{
				System.out.println("Congratulations, you win!!");
			}
			else
				System.out.println("You lost.");
			System.out.println("Would you like to quit?Enter \"quit\" to quit");
			if(keyboard.nextLine().equals("quit"))
			{
				quit = true;
				System.out.println("Goodbye");
				return;
			}
		}
		
	}
	public static void readPrizeFile()
	{
		System.out.println("Enter a file that you want to read from");
		String fileName = keyboard.next();
		keyboard.nextLine();
		prizeManager.readPrizeFile(fileName);
	}
	public static boolean didWin(int guess, int price)
	{
		return guess >= price-3500 && guess <= price;
	}

}

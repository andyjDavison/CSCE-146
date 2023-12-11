/*
*Written by Andrew Davison
*/
import java.util.Scanner;
import java.io.*;
public class FruitTreeTester {

	public static Scanner keyboard = new Scanner(System.in);
	public static LinkedBST<Fruit> fruitTree = new LinkedBST<Fruit>();
	public static final String DELIM = "\t";
	public static final int BODY_FIELD_AMT = 2;
	public static void main(String[] args) {
		printGreetings();
		readFile();
		System.out.println("Populating tree file");
		System.out.println("Printing the in-order traversal");
		fruitTree.printInorder();
		System.out.println("\nPrinting the pre-order traversal");
		fruitTree.printPreorder();
		System.out.println("\nPrinting the post-order traversal");
		fruitTree.printPostorder();
		System.out.println("\nDeleting Apple 0.4859853412170728");
		fruitTree.remove(new Fruit("Apple", 0.4859853412170728));
		System.out.println("Printing the in-order traversal");
		fruitTree.printInorder();
	}
	public static void printGreetings()
	{
		System.out.println("Welcome to the fruit tree!");
	}
	public static void readFile()
	{
		System.out.println("Please enter a Fruit File Name");
		String fileName = keyboard.nextLine();
		try
		{
			Scanner fileScanner = new Scanner(new File(fileName));
			while(fileScanner.hasNextLine())
			{
				String fileLine = fileScanner.nextLine();
				String[] splitLines = fileLine.split(DELIM);
				if(splitLines.length == BODY_FIELD_AMT)
				{
					String type = splitLines[0];
					double weight = Double.parseDouble(splitLines[1]);
					Fruit aF = new Fruit(type, weight);
					fruitTree.add(aF);
				}
			}
			fileScanner.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}

/*
*Written by Andrew Davison
*/
import java.util.Scanner;
import java.io.*;
public class ShapeTreeFE {

	public static Scanner keyboard = new Scanner(System.in);
	public static ShapeBST shapeTree = new ShapeBST();
	public static final String DELIM = "\t";
	public static void main(String[] args) {
		printGreetings();
		boolean quit = false;
		while(!quit)
		{
			printChoices();
			int choice = keyboard.nextInt();
			keyboard.nextLine();
			switch(choice)
			{
			case 1:
				readFile();
				break;
			case 2:
				print();
				break;
			case 3:
				addShape();
				break;
			case 4:
				removeShape();
				break;
			case 5:
				getMaxArea();
				break;
			case 6:
				removeIfGreater();
				break;
			case 9:
				quit = true;
				break;
			default:
				System.out.println("Invalid Input");
			}
		}
	}
	public static void printGreetings()
	{
		System.out.println("Welcome to the shape tree!");
	}
	public static void printChoices()
	{
		System.out.println("Enter 1 to read a shape file\n"
				+"Enter 2 to print the shape tree\n"
				+"Enter 3 to add a shape to the tree\n"
				+"Enter 4 to remove a shape from the tree\n"
				+"Enter 5 to get the shape with the maximum area\n"
				+"Enter 6 to remove shapes greater than a certain area\n"
				+"Enter 9 to quit");
	}
	public static void readFile()
	{
		System.out.println("Enter the name of the file you want to read from");
		String fileName = keyboard.nextLine();
		try
		{
			Scanner fileScanner = new Scanner(new File(fileName));
			while(fileScanner.hasNextLine())
			{
				String fileLine = fileScanner.nextLine();
				String[] splitLines = fileLine.split(DELIM);
				if(splitLines.length == 3)
				{
					if(splitLines[0].equalsIgnoreCase("rectangle"))
					{
						Rectangle aR = new Rectangle(splitLines[0],0.0,Integer.parseInt(splitLines[1]),Integer.parseInt(splitLines[2]));
						aR.calcArea(aR.getLength(),aR.getWidth());
						shapeTree.add(aR);
					}
					else if(splitLines[0].equalsIgnoreCase("right triangle"))
					{
						RightTriangle aT = new RightTriangle(splitLines[0],0.0,Double.parseDouble(splitLines[1]),Double.parseDouble(splitLines[2]));
						aT.calcArea(aT.getBase(),aT.getHeight());
						shapeTree.add(aT);
					}
				}
				else if(splitLines.length == 2)
				{
					Circle aC = new Circle(splitLines[0],0.0,Double.parseDouble(splitLines[1]));
					aC.calcArea(aC.getRadius());
					shapeTree.add(aC);
				}
			}
			fileScanner.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void addShape()
	{
		System.out.println("Enter what shape you would like to add");
		String shape = keyboard.nextLine();
		if(shape.equalsIgnoreCase("circle"))
		{
			System.out.println("Enter a radius for the circle and I will add it to the tree");
			double radius = keyboard.nextDouble();
			Circle aC = new Circle(shape, 0.0, radius);
			aC.calcArea(aC.getArea());
			if(shapeTree.search(aC))
				System.out.println("This shape already exists");
			else
				shapeTree.add(aC);
		}
		else if(shape.equalsIgnoreCase("rectangle"))
		{
			System.out.println("Enter a length for the rectangle");
			double len = keyboard.nextDouble();
			keyboard.nextLine();
			System.out.println("Enter a width");
			double width = keyboard.nextDouble();
			Rectangle aR = new Rectangle(shape,0.0,len,width);
			aR.calcArea(aR.getLength(),aR.getWidth());
			if(shapeTree.search(aR))
				System.out.println("This shape already exists");
			else
				shapeTree.add(aR);
		}
		else if(shape.equalsIgnoreCase("right triangle"))
		{
			System.out.println("Enter a base for the triangle");
			double base = keyboard.nextDouble();
			keyboard.nextLine();
			System.out.println("Enter a height");
			double height = keyboard.nextDouble();
			RightTriangle aT = new RightTriangle(shape,0.0,base,height);
			aT.calcArea(base, height);
			if(shapeTree.search(aT))
				System.out.println("This shape already exists");
			else
				shapeTree.add(aT);
		}
		else
			System.out.println("Not a valid shape");
	}
	public static void removeShape()
	{
		System.out.println("Enter the shape you would like to remove");
		String shape = keyboard.nextLine();
		if(shape.equalsIgnoreCase("circle"))
		{
			System.out.println("Enter a radius for the circle and I will remove it from the tree");
			double radius = keyboard.nextDouble();
			Circle aC = new Circle(shape, 0.0, radius);
			if(shapeTree.search(aC))
				shapeTree.remove(aC);
			else
				System.out.println("This shape is not in the tree");
		}
		else if(shape.equalsIgnoreCase("rectangle"))
		{
			System.out.println("Enter a length for the rectangle");
			double len = keyboard.nextDouble();
			keyboard.nextLine();
			System.out.println("Enter a width");
			double width = keyboard.nextDouble();
			Rectangle aR = new Rectangle(shape,0.0,len,width);
			if(shapeTree.search(aR))
				shapeTree.remove(aR);
			else
				System.out.println("This shape is not in the tree");
		}
		else if(shape.equalsIgnoreCase("right triangle"))
		{
			System.out.println("Enter a base for the triangle");
			double base = keyboard.nextDouble();
			keyboard.nextLine();
			System.out.println("Enter a height");
			double height = keyboard.nextDouble();
			RightTriangle aT = new RightTriangle(shape,0.0,base,height);
			if(shapeTree.search(aT))
				shapeTree.remove(aT);
			else
				System.out.println("This shape is not in the tree");
		}
		else
			System.out.println("Not a valid shape");
		shapeTree.printInorder();
		
	}
	public static void searchForShape()
	{
		System.out.println("Enter a shape and I will search for it");
		keyboard.nextLine();
	}
	public static void getMaxArea()
	{
		System.out.println("The shape with the greatest Area:\n"+shapeTree.maxArea());
	}
	public static void removeIfGreater()
	{
		System.out.println("Enter an area, and I will remove all shapes with greater areas");
		shapeTree.removeIfGreater(keyboard.nextInt());
		keyboard.nextLine();
	}
	public static void print()
	{
		System.out.println("Enter the method you want to print the tree\n\"Preorder\"\t\"Inorder\"\t\"Postorder");
		String mode = keyboard.nextLine();
		if(mode.equalsIgnoreCase("Preorder"))
		{
			shapeTree.printPreorder();
		}
		else if(mode.equalsIgnoreCase("Inorder"))
		{
			shapeTree.printInorder();
		}
		else if(mode.equalsIgnoreCase("Postorder"))
		{
			shapeTree.printPostorder();
		}
		else
		{
			System.out.println("Thats not a valid print mode");
			return;
		}
	}

}

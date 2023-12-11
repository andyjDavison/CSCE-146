/*
 * Written by Andrew Davison
 */
import java.util.Scanner;
public class Vectors {

	public static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args) {

		printGreetings();
		boolean quit = false;
		while(!quit)
		{
			printChoices();
			int choice = keyboard.nextInt();
			if(choice == 1) {
				//make another vector and add
				//must have same length
				addVectors(makeVector());
			}
			else if(choice == 2) {
				//make another vector and subtract
				//must have same length
				subtractVectors(makeVector());
			}
			else if(choice == 3) {
				//find mag of vector we already made
				double sum = 0.0;
				double[] v = makeVector();
				for(int i=0;i<v.length;i++)
				{
					double squared = Math.pow(v[i],2);
					sum = sum + squared;
				}
				double mag = Math.sqrt(sum);
				System.out.println(mag);
			}
			else if(choice == 9) {
				quit = true;
				System.out.println("Goodbye!");
				return;
			}
			else
				System.out.println("Not a valid input");
		}
	}
	public static void printGreetings()
	{
		System.out.println("Welcome to Vector Calculator!");
	}
	public static void printChoices()
	{
		System.out.println("Enter 1 to add vectors\n"
				+ "Enter 2 to subtract vectors\n"
				+ "Enter 3 to find the magnitude of a vector\n"
				+ "Enter 9 to quit");
	}
	public static void addVectors(double[] vOne) {
		System.out.println("Enter the size of the second vector");
		int sizeTwo = keyboard.nextInt();
		keyboard.nextLine();
		double[] vTwo = new double[sizeTwo];
		for(int i=0;i<sizeTwo;i++) {
			System.out.println("Enter the value of component "+ i);
			vTwo[i] = keyboard.nextDouble();
			keyboard.nextLine();
		}
		if(!checkSize(vOne,vTwo)) {
			System.out.println("These vectors are not the same size");
		}
		else {
			System.out.println("The two vectors added: ");
			double[] aV = new double[vOne.length];
			for(int i=0;i<vOne.length;i++)
			{
				aV[i] = vOne[i] + vTwo[i];
				System.out.println("Component "+i+": "+aV[i]);
			}
		}
	}
	public static void subtractVectors(double[] vOne) {
		System.out.println("Enter the size of the second vector");
		int sizeTwo = keyboard.nextInt();
		keyboard.nextLine();
		double[] vTwo = new double[sizeTwo];
		for(int i=0;i<sizeTwo;i++) {
			System.out.println("Enter the value of component "+i);
			vTwo[i] = keyboard.nextDouble();
			keyboard.nextLine();
		}
		if(!checkSize(vOne, vTwo)) {
			System.out.println("These vectors are not the same size");
		}
		else {
			System.out.println("The two vectors subtracted: ");
			double[] sV = new double[vOne.length];
			for(int i=0;i<vOne.length;i++)
			{
				sV[i] = vOne[i] - vTwo[i];
				System.out.println("Component "+i+": "+sV[i]);
			}
		}
	}
	public static boolean checkSize(double[] vOne, double[] vTwo) {
		return vOne.length == vTwo.length;
	}
	public static double[] makeVector()
	{
		System.out.println("Enter the size of the vector");
		int vSize = keyboard.nextInt();
		double[] vectorOne = new double[vSize];
		if(vSize < 1) {
			System.out.println("Not a valid size");
			while(vSize < 1) {
				System.out.println("Enter a valid size");
				vSize = keyboard.nextInt();
			}
		}
		for(int i=0;i<vectorOne.length;i++) {
			System.out.println("Enter the value of the component "+i);
			vectorOne[i] = keyboard.nextDouble();
		}
		return vectorOne;
	}

}

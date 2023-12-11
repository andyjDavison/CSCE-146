/*
*Written by Andrew Davison
*/
import java.util.Scanner;
public class SortBySort {

	public static Scanner keyboard = new Scanner(System.in);
	public static GenLL<String> words = new GenLL<String>();
	public static void main(String[] args) {
		boolean quit = false;
		while(!quit)
		{
			printGreetings();
			while(keyboard.hasNextLine())
			{
				String nextLine = keyboard.nextLine();
				if(nextLine.equalsIgnoreCase("quit"))
				{
					break;
				}
				words.add(nextLine);
			}
			System.out.println("sort SORTED!");
			String[] newWords = toArray(words);
			int[] counts = countArray(newWords);
			printSorted(counts,newWords);
			System.out.println("\nWould you like to sort more Strings?");
			if(keyboard.nextLine().equalsIgnoreCase("No"))
			{
				System.out.println("Goodbye!");
				quit = true;
				break;
			}
			else
			{
				//make list empty again so there are no duplicates
				words = new GenLL<String>();
			}
		}
	}
	public static void printGreetings()
	{
		System.out.println("Enter any number of strings and I will sort by SORT's.\nOnce you're done entering sentences enter \"quit\"");
	}
	public static String[] toArray(GenLL<String> stringLL)
	{
		String[] wordsArray = new String[stringLL.getSize()];
		for(int i=0;i<wordsArray.length;i++)
		{
			wordsArray[i] = stringLL.getAt(i);
		}
		return wordsArray;
	}
	public static int[] countArray(String[] words)
	{
		int[] counts = new int[words.length];
		for(int i=0;i<counts.length;i++)
		{
			counts[i] = countSort(words[i]);
		}
		return counts;
	}
	public static int countSort(String aWord)
	{
		int count = 0;
		for(int i=0;i<aWord.length();i++)
		{
			if(i == aWord.length()-4 && aWord.substring(i).equalsIgnoreCase("sort"))
			{
					count++;
			}
			else if(i<aWord.length()-4 && aWord.substring(i,i+4).equalsIgnoreCase("sort"))
			{
					count++;
			}
		}
		return count;
	}
	public static void mergeSort(int[] a, String[] b)
	{
		int size = a.length;
		if(size < 2)
			return;
		int mid = size / 2;
		int leftSize = mid;
		int rightSize = size-mid;
		int[] left = new int[leftSize];
		String[] leftS = new String[leftSize];
		int[] right = new int[rightSize];
		String[] rightS = new String[rightSize];
		for(int i=0;i<mid;i++)
		{
			left[i] = a[i];
			leftS[i] = b[i];
		}
		for(int i=mid;i<size;i++)
		{
			right[i-mid] = a[i];
			rightS[i-mid] = b[i];
		}
		mergeSort(left,leftS);
		mergeSort(right,rightS);
		merge(left,right,leftS,rightS,a,b);
	}
	public static void merge(int[] left, int[] right, String[] leftS, String[] rightS, int[] a, String[] b)
	{
		int leftSize = left.length;
		int rightSize = right.length;
		int i = 0;//Left array's index
		int j = 0;//Right array's index
		int k = 0;//Merged array's index
		while(i<leftSize && j<rightSize)
		{
			if(left[i] <= right[j])
			{
				a[k] = left[i];
				b[k] = leftS[i];
				i++;
				k++;
			}
			else
			{
				a[k] = right[j];
				b[k] = rightS[j];
				j++;
				k++;
			}
		}
		while(i<leftSize)
		{
			a[k] = left[i];
			b[k] = leftS[i];
			i++;
			k++;
		}
		while(j<rightSize)
		{
			a[k] = right[j];
			b[k] = rightS[j];
			j++;
			k++;
		}
	}
	public static void printSorted(int[] a,String[] b)
	{
		mergeSort(a,b);
		for(int i=0;i<b.length;i++)
			System.out.println(b[i]);
	}

}

/*
 * Written by Andrew Davison
 */
public class WordHelper {
	public static String[] sortByVowels(String[] aStrings)
	{
		int[] vowelCount = new int[aStrings.length];
		for(int i=0;i<vowelCount.length;i++)
		{
			vowelCount[i] = 0;
			for(int j=0;j<aStrings[i].length();j++)
			{
				String letter;
				if(j == aStrings[i].length()-1)
					letter = aStrings[i].substring(j);
				else
					letter = aStrings[i].substring(j,j+1);
				if(letter.equals("a") || letter.equals("e") || letter.equals("i") || letter.equals("o") || letter.equals("u") || letter.equals("y"))
				{
					vowelCount[i]++;
				}
			}
		}
		//bubble sort
		boolean hasSwapped = true;
		while(hasSwapped)
		{
			hasSwapped = false;
			for(int i=0;i<vowelCount.length-1;i++)
			{
				if(vowelCount[i] > vowelCount[i+1])
				{
					String temp = aStrings[i];
					int countTemp = vowelCount[i];
					aStrings[i] = aStrings[i+1];
					vowelCount[i] = vowelCount[i+1];
					aStrings[i+1] = temp;
					vowelCount[i+1] = countTemp;
					hasSwapped = true;
				}
			}
		}
		String[] newStrings = new String[aStrings.length];
		for(int i=0;i<aStrings.length;i++)
			newStrings[i] = aStrings[i];
		return newStrings;
	}
	public static String[] sortByConsonants(String[] aStrings)
	{
		//bubble sort
		int[] consonantCount = new int[aStrings.length];
		for(int i=0;i<consonantCount.length;i++)
		{
			consonantCount[i] = 0;
			for(int j=0;j<aStrings[i].length();j++)
			{
				String letter;
				if(j == aStrings[i].length()-1)
					letter = aStrings[i].substring(j);
				else
					letter = aStrings[i].substring(j,j+1);
				if(!letter.equals("a") && !letter.equals("e") && !letter.equals("i") && !letter.equals("o") && !letter.equals("u") && !letter.equals("y"))
				{
					consonantCount[i]++;
				}
			}
		}
		//bubble sort
		boolean hasSwapped = true;
		while(hasSwapped)
		{
			hasSwapped = false;
			for(int i=0;i<consonantCount.length-1;i++)
			{
				if(consonantCount[i] > consonantCount[i+1])
				{
					String temp = aStrings[i];
					int countTemp = consonantCount[i];
					aStrings[i] = aStrings[i+1];
					consonantCount[i] = consonantCount[i+1];
					aStrings[i+1] = temp;
					consonantCount[i+1] = countTemp;
					hasSwapped = true;
				}
			}
		}
		String[] newStrings = new String[aStrings.length];
		for(int i=0;i<aStrings.length;i++)
			newStrings[i] = aStrings[i];
		return newStrings;
	}
	public static String[] sortByLength(String[] aStrings)
	{
		//bubble sort
		boolean hasSwapped = true;
		while(hasSwapped)
		{
			hasSwapped = false;
			for(int i=0;i<aStrings.length-1;i++)
			{
				if(aStrings[i].length() > aStrings[i+1].length())
				{
					String temp = aStrings[i];
					aStrings[i] = aStrings[i+1];
					aStrings[i+1] = temp;
					hasSwapped = true;
				}
			}
		}
		return aStrings;
	}
}

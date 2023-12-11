/*
*Written by Andrew Davison
*/
import java.util.Scanner;
import java.io.*;
import java.util.Random;
public class PrizeManager {
	private Prize[] prizes;
	public static final int DEF_SIZE = 53;
	public static final String DELIM = "\t";
	public static final int BODY_FIELD_AMT = 2;
	
	public PrizeManager()
	{
		init(DEF_SIZE);
	}
	public PrizeManager(int size)
	{
		init(size);
	}
	public void init(int size)
	{
		if(size >= 1)
			prizes = new Prize[size];
		else
			prizes = new Prize[DEF_SIZE];
	}
	public void addPrize(Prize aPrize)
	{
		if(prizes[prizes.length-1] != null)//full array
			return;
		for(int i=0;i<prizes.length;i++)
		{
			if(prizes[i] == null)
			{
				prizes[i] = aPrize;
				break;
			}
		}
	}
	public void readPrizeFile(String aName)
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
					String prizeName = splitLines[0];
					int price = Integer.parseInt(splitLines[1]);
					Prize aPrize = new Prize(prizeName, price);
					this.addPrize(aPrize);
				}
			}
			fileScanner.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public Prize[] pickRandomPrizes()
	{
		Random r = new Random();
		Prize[] randomPrizes = new Prize[5];
		for(int i=0;i<5;i++)
		{
			int rand = r.nextInt(53);
			randomPrizes[i] = prizes[rand];
		}
		return randomPrizes;
	}
	

}

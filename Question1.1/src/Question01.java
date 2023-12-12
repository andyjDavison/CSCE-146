/*
 * Andrew Davison
 * CSCE 146 Exam01 Question01
 * Provided code. Do not alter the code that says "Do not alter"
 * Make sure this at least compiles (no syntax errors)
 * You may write additional methods to help
 */
//Do not alter-----------------------------------------------------------------------
public class Question01 {

//-----------------------------------------------------------------------------------	
	//Write your method here
	public static boolean largerComponents(int[] a1, int[] a2)
	{
		if(a1 == null || a2 == null)
			return false;
		if(checkSize(a1, a2))
		{
			for(int i=0;i<a1.length;i++)
			{
				if(a2[i] >= a1[i])
					return false;
			}
		}
		else
			return false;
		return true;
	}
				
	//Write any additional helper properties or methods here
	public static boolean checkSize(int[] a1, int[] a2)
	{
		return a1.length == a2.length;
	}
	//--------------------------------------------------------------------------------
	//Test your code here. You may alter this as needed.
	public static void main(String[] args)
	{

		int[] test01 = {5,4,3};
		int[] test02 = {1,3,2};

		System.out.println(largerComponents(test01,test02));
	}
	//--------------------------------------------------------------------------------
}//Do not alter this

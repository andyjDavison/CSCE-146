/*
 * Andrew Davison
 * CSCE 146 Exam01 Question03
 * Provided code. Do not alter the code that says "Do not alter"
 * Make sure this at least compiles (no syntax errors)
 * You may write additional methods to help
 * Testing is encouraged but remove all testing code before turning it in.
 */
//Do not alter-----------------------------------------------------------------------
public class Question03 
{
	public class ListNode//public for testing purposes
	{
		public int data;//public for testing purposes
		public ListNode link;//public for testing purposes
		public ListNode(int aData, ListNode aLink)
		{
			data = aData;
			link = aLink;
		}
	}
	public ListNode head;//public for testing purposes
//-----------------------------------------------------------------------------------
	//Write your method here
	public int getMinValue()
	{
		int min = head.data;
		if(head != null)
		{
			for(ListNode temp = head;temp.link != null;temp = temp.link)
			{
				if(min > temp.link.data)
					min = temp.link.data;
			}
			return min;
		}
		else
			return 0;
	}

	//Write additional methods or properties here
	public Question03()
	{
		head = null;
	}
	//--------------------------------------------------------------------------------
	//Test your code here. You may alter this as needed.
	public static void main(String[] args)
	{
		//Example
		Question03 intLL = new Question03();
		intLL.head = intLL.new ListNode(0, 
							intLL.new ListNode(1, 
									intLL.new ListNode(2,
											intLL.new ListNode(3,
													intLL.new ListNode(4,null)))));
		int min = intLL.getMinValue();
		System.out.println(min);
	}
	//--------------------------------------------------------------------------------
}//Do not alter this

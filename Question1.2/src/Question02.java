//import IntLL.ListNode;

/*
 * Andrew Davison
 * CSCE 146 Exam01 Question02
 * Provided code. Do not alter the code that says "Do not alter"
 * Make sure this at least compiles (no syntax errors)
 * You may write additional methods to help
 * Testing is encouraged but remove all testing code before turning it in.
 */
//Do not alter-----------------------------------------------------------------------
public class Question02 
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
	public void insertDoubles()
	{
		if(head == null)
			return;
		else
		{
			ListNode temp = head;
			while(temp.link != null)
			{
				ListNode newNode = new ListNode(temp.data*2, temp.link);
				temp.link = newNode;
				temp = newNode.link;
			}
			ListNode newNode = new ListNode(temp.data*2, null);
			temp.link = newNode;
		}
	}
		
	
	//Write additional methods or properties here
	public ListNode current;
	public Question02()
	{
		head = current = null;
	}
	//--------------------------------------------------------------------------------
	//Test your code here. You may alter this as needed.
	public static void main(String[] args)
	{
		//Example
		Question02 intLL = new Question02();
		intLL.head = intLL.new ListNode(0, 
							intLL.new ListNode(1, 
									intLL.new ListNode(2,
											intLL.new ListNode(3,
													intLL.new ListNode(4,null)))));
		intLL.insertDoubles();
		//Printing Results
		for(Question02.ListNode temp = intLL.head;temp != null; temp = temp.link)
			System.out.println(temp.data);
	}
	//--------------------------------------------------------------------------------
}//Do not alter this


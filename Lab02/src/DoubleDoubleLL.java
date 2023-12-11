/*
*Written by Andrew Davison
*/
public class DoubleDoubleLL {

	private class ListNode
	{
		double data;
		ListNode prevLink;
		ListNode nextLink;
		public ListNode(double aData, ListNode aNext, ListNode aPrev)
		{
			data = aData;
			prevLink = aPrev;
			nextLink = aNext;
		}
	}
	private ListNode head;
	private ListNode previous;
	private ListNode current;
	
	public DoubleDoubleLL()
	{
		head = previous = current = null;
	}
	public void gotoNext()
	{
		if(current == null)
			return;
		previous = current;
		current = current.nextLink;
	}
	public void gotoPrev()
	{
		if(current == null || previous == null)
			return;
		current = previous;
		previous = previous.prevLink;
	}
	public void reset()
	{
		current = head;
		previous = null;
	}
	public void gotoEnd()
	{
		this.reset();
		if(current != null)
		{
			while(current.nextLink != null)
				current = current.nextLink;
		}
	}
	public boolean hasMore()
	{
		return current != null;
	}
	public double getCurrent()
	{
		if(current == null)
			return 0;
		return current.data;
	}
	public void setCurrent(double aData)
	{
		if(current == null)
			return;
		current.data = aData;
	}
	public void add(double aData)
	{
		ListNode newNode = new ListNode(aData, null, null);
		if(head == null)
		{
			head = current = newNode;
			return;
		}
		ListNode temp = head;
		while(temp.nextLink != null)
			temp = temp.nextLink;
		temp.nextLink = newNode;
		newNode.prevLink = temp;
	}
	public void addAfterCurrent(double aData)
	{
		if(current == null)
			return;
		ListNode newNode = new ListNode(aData, current.nextLink, current);
		current.nextLink = newNode;
		
	}
	public void remove(double aData)
	{
		current = head;
		previous = null;
		while(current.nextLink != null)
		{
			if(current.data == aData)
			{
				if(current == head)
				{
					head = head.nextLink;
					current = head;
				}
				else
				{
					previous = current.prevLink;
					current = current.nextLink;
					previous.nextLink = current;
					current.prevLink = previous;
				}
				return;
			}
			current = current.nextLink;
		}
	}
	public void removeCurrent()
	{
		if(current == head)
		{
			head = head.nextLink;
			current = head;
		}
		else if(current.nextLink == null)
		{
			current = current.prevLink;
			current.nextLink = null;
		}
		else
		{
			current = current.nextLink;
			previous.nextLink = current;
			current.prevLink = previous;
		}
	}
	public void print()
	{
		ListNode temp = head;
		while(temp != null)
		{
			System.out.println(temp.data);
			temp = temp.nextLink;
		}
	}
	public boolean contains(double aData)
	{
		ListNode temp = head;
		while(temp != null)
		{
			if(temp.data == aData)
				return true;
			temp = temp.nextLink;
		}
		return false;
	}
}

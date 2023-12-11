/*
*Written by Andrew Davison
*/
public class ShapeBST <T extends Comparable<T>>//extends interface to type Comparable
{
	private class Node
	{
		Shape data;
		Node leftChild;
		Node rightChild;
		public Node(Shape aData)
		{
			data = aData;
			leftChild = rightChild = null;
		}
	}
	private Node root;//head
	public ShapeBST()
	{
		root = null;
	}
	public void add(Shape aData)
	{
		if(root == null)
			root = new Node(aData);
		else
			add(root, aData);
	}
	private Node add(Node aNode, Shape aData)
	{
		if(aNode == null)
			aNode = new Node(aData);
		else if(aData.compareTo(aNode.data)<0)//GO LEFT, data we are trying to add is less than data at the node
			aNode.leftChild = add(aNode.leftChild,aData);
		else if(aData.compareTo(aNode.data)>0)//GO RIGHT, data we are trying to add is greater than data at the node
			aNode.rightChild = add(aNode.rightChild,aData);
		return aNode;
	}
	public void printPreorder()
	{
		printPreorder(root);
	}
	private void printPreorder(Node aNode)
	{
		if(aNode == null)
			return;
		System.out.println(aNode.data);//PROCESS
		printPreorder(aNode.leftChild);//LEFT
		printPreorder(aNode.rightChild);//RIGHT
	}
	public void printInorder()
	{
		printInorder(root);
	}
	private void printInorder(Node aNode)
	{
		if(aNode == null)
			return;
		printInorder(aNode.leftChild);//LEFT
		System.out.println(aNode.data);//PROCESS
		printInorder(aNode.rightChild);//RIGHT
	}
	public void printPostorder()
	{
		printPostorder(root);
	}
	private void printPostorder(Node aNode)
	{
		if(aNode == null)
			return;
		printPostorder(aNode.leftChild);//LEFT
		printPostorder(aNode.rightChild);//RIGHT
		System.out.println(aNode.data);//PROCESS
	}
	public boolean search(Shape aData)
	{
		return search(root, aData);
	}
	private boolean search(Node aNode, Shape aData)
	{
		if(aNode == null)
			return false;
		else if(aData.compareTo(aNode.data)<0)//GO LEFT
			return search(aNode.leftChild,aData);
		else if(aData.compareTo(aNode.data)>0)//GO RIGHT
			return search(aNode.rightChild,aData);
		else
			return true;
	}
	public void remove(Shape aData)
	{
		root = remove(root,aData);
	}
	private Node remove(Node aNode, Shape aData)
	{
		//Find the Node
		if(aNode == null)
			return null;
		else if(aData.compareTo(aNode.data)<0)
			aNode.leftChild = remove(aNode.leftChild,aData);
		else if(aData.compareTo(aNode.data)>0)
			aNode.rightChild = remove(aNode.rightChild,aData);
		else//Found the value
		{
			if(aNode.rightChild == null)
				return aNode.leftChild;
			else if(aNode.leftChild == null)
				return aNode.rightChild;
			aNode.data = findMinInTree(aNode.rightChild);
			Shape temp = aNode.data;
			aNode.rightChild = remove(aNode.rightChild,temp);
		}
		return aNode;
	}
	private Shape findMinInTree(Node aNode)
	{
		if(aNode == null)
			return null;
		else if(aNode.leftChild == null)
			return aNode.data;
		else
			return findMinInTree(aNode.leftChild);
	}
	private Shape findMaxInTree(Node aNode)
	{
		if(aNode == null)
			return null;
		else if(aNode.rightChild == null)
			return aNode.data;
		else
			return findMaxInTree(aNode.rightChild);
	}
	public Shape maxArea()
	{
		return findMaxInTree(root);
	}
	public void removeIfGreater(double area)
	{
		removeIfGreater(root,area);
	}
	private Node removeIfGreater(Node aNode, double area)
	{
		if(aNode == null)//not found
			return null;
		removeIfGreater(aNode.leftChild, area);
		removeIfGreater(aNode.rightChild, area);
		if(aNode.data.getArea()>area)
		{
			remove(aNode.data);
			return aNode;
		}
		return aNode;
	}
}

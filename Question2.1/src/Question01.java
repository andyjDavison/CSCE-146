/*
 * Andrew Davison
 * CSCE 146 S2022 Exam02 Question01
 * Provided code. Do not alter the code that says "Do not alter"
 * Make sure this at least compiles (no syntax errors)
 * You may write additional methods to help
 */
//Do not alter-----------------------------------------------------------------------
public class Question01 {

	public static void sort(PepperoniPizza[] pizzas)
	{
//-----------------------------------------------------------------------------------	
		//Write your solution here
		int size = pizzas.length;
		if(size < 2)
			return;
		int mid = size/2;
		int leftSize = mid;
		int rightSize = size-mid;
		PepperoniPizza[] left = new PepperoniPizza[leftSize];//new pepperoniPizza array of size/2
		PepperoniPizza[] right = new PepperoniPizza[rightSize];
		for(int i=0;i<mid;i++)
			left[i] = pizzas[i];//fill left array with the left elements of bigger array
		for(int i=mid;i<size;i++)
			right[i-mid] = pizzas[i];//fill right array with the right elements of 
		sort(left);
		sort(right);
		merge(left,right,pizzas);//once the arrays are recursively broken into single elements, they will be merged in order

	}//Do not alter this
	//Write any additional helper properties or methods here

	public static void merge(PepperoniPizza[] left, PepperoniPizza[] right, PepperoniPizza[] pizzas)
	{
		int leftSize = left.length;
		int rightSize = right.length;
		int i=0;
		int j=0;
		int k=0;
		while(i<leftSize && j<rightSize)
		{
			if(left[i].getPepperonis() > right[j].getPepperonis())//if the left is greater add it to new array first
			{
				pizzas[k] = left[i];
				i++;
				k++;
			}
			else
			{
				pizzas[k] = right[j];
				j++;
				k++;
			}
		}
		while(i<leftSize)
		{
			pizzas[k] = left[i];
			i++;
			k++;
		}
		while(j<rightSize)
		{
			pizzas[k] = right[j];
			j++;
			k++;
		}
	}
	//--------------------------------------------------------------------------------
	//Test your code here. You may alter this as needed.
	public static void main(String[] args)
	{
		PepperoniPizza[] array = {new PepperoniPizza(10),
				new PepperoniPizza(5),
				new PepperoniPizza(3),
				new PepperoniPizza(1),
				new PepperoniPizza(8),
				new PepperoniPizza(6)};
		sort(array);
		for(PepperoniPizza w : array)
			System.out.println(w);
	}
	//--------------------------------------------------------------------------------
}//Do not alter this

/*Solution Description
 * 
 */
/*
*Written by Andrew Davison
*/
public class ReversePolishCalculator {
	
	private StackI<Integer> ValueStack;
	public int calculate(String expression)
	{
		ValueStack = new LLStack<Integer>();
		String input = "";
		for(int i=0;i<expression.length();i+=2)
		{
			try
			{
				if(i == expression.length()-1)
				{
					input = expression.substring(i);
				}
				else
				{
					input = expression.substring(i,i+1);
				}
				int num = Integer.parseInt(input);
				ValueStack.push(num);
			}
			catch(Exception e)
			{
				if(ValueStack.size() < 2)
				{
					System.out.println("This was not properly formatted. There were too many operators and not enough numbers");
					return 0;
				}
				else
				{
					int b = ValueStack.pop();
					int a = ValueStack.pop();
					if(input.equals("+"))
					{
						ValueStack.push(a+b);
					}
					else if(input.equals("-"))
					{
						ValueStack.push(a-b);
					}
					else if(input.equals("*"))
					{
						ValueStack.push(a*b);
					}
					else if(input.equals("/"))
					{
						if(b == 0)
						{
							System.out.println("Cannot divide by 0");
							return 0;
						}
						ValueStack.push(a/b);
					}
					else
					{
						System.out.println("Not a valid Operator");
						return 0;
					}
				}
			}
		}
		if(ValueStack.size() > 1)
		{
			System.out.println("This was not properly formatted. There were too many numbers and not enough operators");
			return 0;
		}
		return ValueStack.pop();
	}
}

/*
*Written by Andrew Davison
*/
public class DLLTest {

	public static void main(String[] args) {
		DoubleDoubleLL dLL;
		dLL = new DoubleDoubleLL();
		
		for(int i=4;i>=0;i--) 
		{
			dLL.add((double)i);
		}
		dLL.print();
		dLL.gotoEnd();
		System.out.println(dLL.getCurrent());
		dLL.add(15.0);
		dLL.print();
		dLL.gotoEnd();
		System.out.println(dLL.getCurrent());
		dLL.reset();
		dLL.gotoNext();
		System.out.println(dLL.getCurrent());
		dLL.gotoNext();
		//System.out.println(dLL.getCurrent());
		dLL.removeCurrent();
		dLL.print();
	}

}

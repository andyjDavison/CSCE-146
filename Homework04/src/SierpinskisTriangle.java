/*
*Written by Andrew Davison
*/
import java.awt.*;
import javax.swing.*;
import java.util.*;
public class SierpinskisTriangle extends Canvas{

	public static final int PIXEL_LIMIT = 4;
	public static void main(String[] args) 
	{
		JFrame frame = new JFrame("Sierpinski's Triangle");
		frame.setSize(500,500);
		SierpinskisTriangle sp = new SierpinskisTriangle();
		frame.add(sp);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void paint(Graphics g)
	{
		drawTriangle(0,0,this.getSize().width,g,true);
	}
	public void drawTriangle(int x, int y, int side, Graphics g, boolean isFirst)
	{
		int[] xPoints = new int[3];
		int[] yPoints = new int[3];
		int sub = side/4;
		//draw first triangle
		if(isFirst)
		{
			//draws triangle from point to point starting from top
			//Top Middle Point
			xPoints[0] = side/2;
			yPoints[0] = 0;
			//Bottom Left Point
			xPoints[1] = 0;
			yPoints[1] = side;
			//Bottom Right Point
			xPoints[2] = side;
			yPoints[2] = side;
			g.setColor(Color.BLACK);
			g.fillPolygon(xPoints, yPoints, 3);
		}
		//draw inner triangle (reverse of outer triangle)
		//Top Left Point
		xPoints[0] = x+(side/4);
		yPoints[0] = y+(side/2);
		//Bottom Middle Point
		xPoints[1] = x+(side/2);
		yPoints[1] = y+side;
		//Top Right Point
		xPoints[2] = x+(3*side/4);
		yPoints[2] = y+(side/2);
		g.setColor(getBackground());
		g.fillPolygon(xPoints, yPoints, 3);
		
		//Recursion
		if(sub >= PIXEL_LIMIT)//bigger than 4 pixels
		{
			//3 times for each empty space left over
			drawTriangle(x+sub,y,2*sub,g,false);//fill in the Top Piece of each inner triangle
			drawTriangle(x+(2*sub),y+(2*sub),2*sub,g,false);//Bottom Right Piece
			drawTriangle(x,y+(2*sub),2*sub,g,false);//Bottom Left Piece
		}
	}

}

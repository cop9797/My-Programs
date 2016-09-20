package pong;

import java.awt.Color;
import java.awt.geom.Rectangle2D;

public class Paddles extends Rectangle2D.Double {
		private Color rectColor;
		private int dx, dy;
		private int acceleration=10;
		
		public Paddles(int x,int y, Color c)
		{
			
			super(x,y,10,150);
			rectColor = c;
			dx = 1;
			dy = 1;
			if(y < 725)
			{
				moveup();
			}
			if(y > 75)
			{
				movedown();
			}
				
			
			
			//Called the parent class's constructor
			//to initialize the values but I 
			//could've done this as below
			//this.x=x;
			//this.y=y;
			//this.width=50;
			//this.height=50;
		}
		
		public void moveup()
		{
			if(y < 0)
				movedown();
			y -= dy*acceleration;
		}
		public void movedown()
		{
			if(y >620)
				moveup();
			y += dy*acceleration;
		}
		
		public Color getRectColor()
		{
			return rectColor;
		}
		public void setRectColor(int i, int j,int x)
		{
			rectColor = new Color(i,j,x);
			
		}
		public double getx()
		{
			return x;
			
		}
		public double gety()
		{
			return y;
			
		}
		public void acceleration()
		{
			acceleration += 2; 
		}
		public void accelerationReset()
		{
			acceleration = 10;
		}


}

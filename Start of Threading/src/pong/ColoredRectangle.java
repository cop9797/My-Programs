package pong;
import java.awt.Color;
import java.awt.geom.Ellipse2D;


public class ColoredRectangle extends Ellipse2D.Double
{
	private Color rectColor;
	private double dx, dy;
	private int acceleration = 10;
	private int score1 = 0;
	private int score2 = 0;
	
	public ColoredRectangle(int x,int y, Color c)
	{
		super(x,y,50,50);
		rectColor = c;
		dx = 1;
		dy = 1;
		//Called the parent class's constructor
		//to initialize the values but I 
		//could've done this as below
		//this.x=x;
		//this.y=y;
		//this.width=50;
		//this.height=50;
	}
	
	public void move()
	{
		if(x+50 > 800)
		{
			x = 375;
			y = 375;
			acceleration = 5;
			score1++;
		}	
		if(x+50 < -50)
		{
			x = 375;
			y = 375;
			acceleration = 5;
			score2++;
		}	
		if(y > 750)
			dy = -1;
		if(y < 0)
			dy = 1;
		x+=dx*acceleration;
		y+=dy*acceleration;
	}
	public int getScore1()
	{
		return score1;
	}
	public int getScore2()
	{
		return score2;
	}
	public void resetScore1()
	{
		score1 = 0;
	}
	public void resetScore2()
	{
		score2 = 0;
	}
	
	public Color getRectColor()
	{
		return rectColor;
	}
	public void setRectColor(int i, int j,int x)
	{
		rectColor = new Color(i,j,x);
		
	}
	public void accelerator()
	{
		acceleration += 2;

	}
	public void reset()
	{
		acceleration = 10;
	}
	public double getx()
	{
		return x;
	}
	public double gety()
	{
		return y;
	}
	public void reverser()
	{
		dx = -1* dx;
	}
	
	

}


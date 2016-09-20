package Drawingsrc;
import java.util.*;
import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.awt.geom.*;
public class BrickWall {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable(){
			public void run()
			{
				JFrame frame = new DrawCustomFrame();
				frame.setTitle("shapes");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				frame.setSize(400, 400);
				}
			});
			}

		
		
		

	}
class DrawCustomFrame extends JFrame
{
	public DrawCustomFrame()
	{
		//add(new DrawComponent());
		add(new DrawComponent());
		pack();
	}
}


class DrawComponent extends JComponent
{
	
	final double BRICKS_PER_ROW = 25;
	final double NUM_OF_ROWS = 50;
	
	
	public static final int MESSAGE_X = 75;
	public static final int MESSAGE_Y = 100;
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 300;
	@Override
	public void paintComponent(Graphics g)
	{
		Graphics2D g2d = (Graphics2D)g;
		for(int row = 0; row < NUM_OF_ROWS; row++)
		{
		for(int col = 0; col < BRICKS_PER_ROW; col++)
		{

				if(row % 2 == 0)
				{
					Brick brick = new Brick(col*(getWidth()/BRICKS_PER_ROW),row*(getHeight()/NUM_OF_ROWS),getWidth()/BRICKS_PER_ROW,getHeight()/NUM_OF_ROWS);
					g2d.setColor(brick.getBrickColor());
					
					g2d.setStroke(new BasicStroke(brick.getBorderWidth()));
					
					g2d.fill(brick);
					g2d.setColor(brick.getBorderColor());
					g2d.draw(brick);
					
				}
				else
				{
					if(col == 24)
					{
						
					
						Brick brick = new Brick(col*(getWidth()/BRICKS_PER_ROW)-((getWidth()/BRICKS_PER_ROW)/2),row*(getHeight()/NUM_OF_ROWS),getWidth()/BRICKS_PER_ROW,getHeight()/NUM_OF_ROWS);
					
					
						g2d.setColor(brick.getBrickColor());
					
						g2d.setStroke(new BasicStroke(brick.getBorderWidth()));
					
						g2d.fill(brick);
						g2d.setColor(brick.getBorderColor());
						g2d.draw(brick);
					}
					else
					{
						Brick brick = new Brick(col*(getWidth()/BRICKS_PER_ROW)+((getWidth()/BRICKS_PER_ROW)/2),row*(getHeight()/NUM_OF_ROWS),getWidth()/BRICKS_PER_ROW,getHeight()/NUM_OF_ROWS);
						
						
						g2d.setColor(brick.getBrickColor());
						
						g2d.setStroke(new BasicStroke(brick.getBorderWidth()));
						
						g2d.fill(brick);
						g2d.setColor(brick.getBorderColor());
						g2d.draw(brick);
					}
				}
			}
		}
		
		g2d.drawString("There are " + Brick.getBrickCount() , 50, 100);
		Brick.setBrickCount();
		
	}
	
	@Override
	public Dimension getPreferredSize()
	{
		return new Dimension(400,600);
	}
	
	

	
	
	
	
	
}
class Car
{
private int speed = 0;
private String model = "";
public Car() {
}

public Car(int speed = 0, String model = ""){
	
}

} 
class Brick extends Rectangle2D.Double
{
	
	private Color brickColor;
	private Color borderColor;
	private float borderWidth;
	private static int brickCount = 1;
	
	
	Random generator = new Random(System.nanoTime());
	int red = 0, blue = 0, green = 0;
	/*public Brick()
	{
		super();
		x=5;
		y=4;
		width=3;
		height=2;
		borderWidth = 2.0f;
		brickCount++;
	}*/
	public Brick(double x, double y, double width, double height)
	{
		super(x,y,width,height);
	
		red = generator.nextInt(256);
		blue = generator.nextInt(256);
		green = generator.nextInt(256);
		brickColor = new Color(red,blue,green);
		borderWidth = 3.0f;
		setBorderColor(Color.BLACK);
		brickCount++;
		
	}
	public Color getBrickColor() 
	{
		return brickColor;
	}
	public void setBrickColor(Color brickColor) {
		this.brickColor = brickColor;
	}
	public float getBorderWidth()
	{
		return borderWidth;
	}
	public void setBorderWidth(float borderWidth)
	{
		this.borderWidth = borderWidth;
	}
	
	public static int getBrickCount()
	{
		return brickCount;
	}
	public static void setBrickCount()
	{
		brickCount = 0;
	}
	public Color getBorderColor()
	{
		return borderColor;
	}
	public void setBorderColor(Color borderColor)
	{
		this.borderColor = borderColor;
	}
}
package memGame;

import java.awt.*;
import java.awt.event.*;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Stack;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;




public class MemGame
{
	public static void main(String[] args)
	{
		 EventQueue.invokeLater(new Runnable()
         {
            public void run()
            {
               JFrame frame = new MemFrame();
               frame.setTitle("WRC Rally Memory");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
	}
}
	

class MemFrame extends JFrame
{
	public MemFrame()
	{
		add(new MemPanel(this));
		pack();
	}
}
	

class MemPanel extends JPanel implements MouseListener
{
	
	int noMatchYet = 0;
	int k = 0;
	int l = 0;
	int allMatch = 0;
	int Matched = 0;
	JFrame frame;

	MemCard cards[][] = new MemCard[4][4];
	int i = 0;
		
	public MemPanel(JFrame frame)
	{
		this.frame = frame;
			
		for(int y = 0; y < 4; y++)
		{
			
			for(int x = 0; x < 4; x++)
			{
				
				i++;
				String imageString;
					
				imageString = "Rally0"+i+".jpg";
		
				//System.out.println(imageString);
				//System.out.println("Making card");
				cards[x][y] = new MemCard();
				if(i%2==0)
				{
					cards[x][y].setID(i-1);

					System.out.println(imageString + " At ID: " + cards[x][y].getID());
				}
				else
				{
					cards[x][y].setID(i);
					System.out.println(imageString + " At ID: " + cards[x][y].getID());
				}
				System.out.println(cards[x][y].getID());
				cards[x][y].setFaceUpImage(new ImageIcon(imageString).getImage());
					


				
					
					
			}
		}
		RandomizeMe();
		this.addMouseListener(this);
		
	}
	public void RandomizeMe()
	{
		Random rand = new Random();
		//cards = new MemCard[4][4];
		for(int j = 0; j < 4; j++)
		{
			for(int i = 0; i < 4; i++)
			{
				int randomInteger1 = rand.nextInt(4);
				int randomInteger2 = rand.nextInt(4);
				MemCard newCard = cards[i][j];
				cards[i][j] = cards[randomInteger1][randomInteger2];
				cards[randomInteger1][randomInteger2] = newCard;
				System.out.println("Hi I'm here");
			}	
		}
	}
	@Override
	public void paintComponent(Graphics g)
	{
		
		
		if(allMatch == 8)
		{
			Object[] options = {"Reshuffle and replay",
	                "Replay without reshuffling",
	                "Exit Program"};
			int n = JOptionPane.showOptionDialog(this,
					"YOU WIN!!! What would you like to do now?",
							"YOU WIN!!!",
							JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.QUESTION_MESSAGE,
							null,
							options,
							options[2]);
			
			if(n == 0)
			{
				for(int j = 0; j < 4; j++)
				{
					for(int i = 0; i < 4; i++)
					{
						cards[j][i].setFaceUp(false);
						cards[j][i].match(false);
					
					}
				}
				noMatchYet = 0;
				k = 0;
				l = 0;
				Matched = 0;
				RandomizeMe();
				allMatch =0;
			}
			else if(n==1)
			{
				for(int j = 0; j < 4; j++)
				{
					for(int i = 0; i < 4; i++)
					{
						cards[j][i].setFaceUp(false);
						cards[j][i].match(false);
					
					}
				}
				noMatchYet = 0;
				k = 0;
				l = 0;
				Matched = 0;
				allMatch =0;
				
			}
			else if(n==2)
			{
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			}
			
		}
		Graphics2D g2D = (Graphics2D)g;
		//g2D.drawImage(cards[0].displayImage(),
			
		//175,175,175,175,null);
		g2D.setColor(Color.blue);
		g2D.fillRect(0,0,700,800);
		if(Matched == 1)
		{
			g2D.setColor(Color.yellow);
			g2D.setFont(new Font("TimesRoman", Font.PLAIN, 50));
			g2D.drawString("You found a match!", 0, 750);
		}
		else if(Matched == 2)
		{
			g2D.setColor(Color.yellow);
			g2D.setFont(new Font("TimesRoman", Font.PLAIN, 50));
			g2D.drawString("No Match!", 0, 750);
		}
		else
		{
			
		}
		
		for(int j = 0; j < 4; j++)
		{
			for(int i = 0; i < 4; i++)
			{
				g2D.drawImage(cards[i][j].displayImage(),i*175,j*175,175,175,null);
				cards[i][j].setX(i*175);
				cards[i][j].setY(j*175);
			}
		}
	}
		
	@Override
	public void mousePressed(MouseEvent e)
	{

		
		//System.out.println("The mouse was pressed!");
		//System.out.println("The mouse was pressed at: " + e.getX()+ " " + e.getY());
		//System.out.println(cards[3][3].getX() + " " + cards[3][3].getY());
	
		if(noMatchYet==0)
		{
			for(int y = 0; y < 4; y++)
			{
				for(int x = 0; x < 4; x++)
				{	
					System.out.println(cards[x][y].getX()+ " " +cards[x][y].getY());
					if(cards[x][y].contains(e.getX(), e.getY()) && !cards[x][y].isFaceUp())
					{
						Matched = 0;
						System.out.println("You are Here!");
						cards[x][y].setFaceUp(true);
						k = x;
						l = y;
						noMatchYet++;
					}
				}
			}
			
		}
		else
		{
			System.out.println("there is a no match yet in here");
			for(int y = 0; y < 4; y++)
			{
				for(int x = 0; x < 4; x++)
				{
					
					if(cards[x][y].contains(e.getX(), e.getY()) && cards[k][l].getID() == cards[x][y].getID() && cards[k][l] != cards[x][y] )
					{
						System.out.println("Match");
						System.out.println(cards[k][l].getID() +" " +cards[x][y].getID());
						cards[x][y].setFaceUp(true);
						cards[k][l].setFaceUp(true);
						cards[x][y].match(true);
						cards[k][l].match(true);
						allMatch++;
						noMatchYet=0;
						System.out.println(noMatchYet);
						Matched++;
						
					}
					else if(cards[x][y].contains(e.getX(), e.getY()) && cards[k][l].getID() != cards[x][y].getID() && !cards[x][y].match())
					{
						System.out.println("No Match");
						System.out.println(cards[k][l].getID() +" " + cards[x][y].getID());
						cards[x][y].setFaceUp(false);
						cards[k][l].setFaceUp(false);
						noMatchYet=0;
						System.out.println(noMatchYet);
						Matched = 2;
					} 
					else if(cards[x][y].contains(e.getX(), e.getY()) && cards[x][y] == cards[k][l] && !cards[x][y].match())
					{
						System.out.println("Same Card");
						cards[x][y].setFaceUp(false);
						cards[k][l].setFaceUp(false);
						noMatchYet=0;
						System.out.println(noMatchYet);
						Matched = 2;
					}
				}
			}
			
		}
		repaint();
		
		
	}
		
	@Override
	public Dimension getPreferredSize()
	{
		return new Dimension(700,800);
		
	}
	@Override
	public void mouseEntered(MouseEvent e)
	{
		// TODO Auto-generated method stub
			
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		// TODO Auto-generated method stub
	
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		// TODO Auto-generated method stub
			
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{

		// TODO Auto-generated method stub
	}
			

}
	
class MemCard 
{
	private int x;
	private int y;
	private int ID;
	private Image faceUpImage;
	private Image faceDownImage;
	private boolean isFaceUp;
	private boolean match;
	
	
	

	public MemCard()
	{
		x = 0;
		y = 0;
		ID = 0;
		faceUpImage = new ImageIcon("Rally016.jpg").getImage();
		faceDownImage = new ImageIcon("wrc.jpg").getImage();
		isFaceUp = false;
		match = false;
		
	}
	public void setFaceUpImage(Image faceUpImage)
	{
		this.faceUpImage = faceUpImage;
	}
	public void setFaceDownImage(Image faceDownImage)
	{
		this.faceDownImage = faceDownImage;
	}
	public int getX()
	{
		return x;
	}
	
	public void setX(int x)
	{
		this.x = x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	public boolean isFaceUp()
	{
		return isFaceUp;
	}
	public void match(boolean Match)
	{
		this.match = Match; 
		
	}
	public boolean match()
	{
		return match;
	}
	
	public Image displayImage()
	{
		//System.out.println("in display image");
		if(isFaceUp)
		{
				return faceUpImage;
		}
		else
		{
			//System.out.println("returning faceDownImage" + faceDownImage.getWidth(null));
			return faceDownImage;
		}
	}
	
	public boolean contains(int px, int py)
	{
		Rectangle bounds = new Rectangle(x,y,faceUpImage.getWidth(null),faceUpImage.getHeight(null));
		//System.out.println(bounds.toString());
		return bounds.contains(new Point(px, py));
	}
	public void setID(int ID)
	{
		this.ID = ID;
		
	}
	public int getID()
	{
		return ID;
	}

	
	public void setFaceUp(boolean isFaceUp)
	{
		this.isFaceUp = isFaceUp;
	}
	
}





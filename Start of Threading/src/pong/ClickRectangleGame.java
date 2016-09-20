package pong;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class ClickRectangleGame
{
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
        {
           public void run()
           {
              JFrame frame = new MemFrame();
              frame.setTitle("Colored Rectangle");               
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
		add(new ClickRectanglePanel(this));
		pack();
	}
}

class ClickRectanglePanel extends JPanel implements MouseListener, Runnable, ActionListener, KeyListener
{
	
	//A collection of rectangles
	JFrame frame;
	private List<ColoredRectangle> rects;
	private final int DELAY = 50;
	private Thread animator;
	boolean gameOn;
	private Paddles paddleLeft;
	private Paddles paddleRight;
	private List keyEvents = new ArrayList<KeyEvent>();
	private int score1 = 0;
	private int score2 = 0;

	public ClickRectanglePanel(MemFrame memFrame)
	{
		keyEvents.add(KeyEvent.VK_I);
		keyEvents.add(KeyEvent.VK_K);
		keyEvents.add(KeyEvent.VK_W);
		keyEvents.add(KeyEvent.VK_S);
		//instantiate this collection of rectangles 
		rects = Collections.synchronizedList(new ArrayList<ColoredRectangle>());
		//Load up the array with 20 random colored rectangles
		gameOn = true;
		System.out.println("I'm adding listener");
		this.addKeyListener(this);
		this.addMouseListener(this);
		int rR = new Random().nextInt(256);
		int rG = new Random().nextInt(256);
		int rB = new Random().nextInt(256);
		int x = new Random().nextInt(750);
		int y = new Random().nextInt(750);
		rects.add(new ColoredRectangle(x,y,new Color(rR,rG,rB)));
		paddleLeft = new Paddles(0,200,new Color(0,0,0));
		paddleRight = new Paddles(790,200,new Color(0,0,0));
		this.setFocusable(true);
	
		

		
	}
	
	@Override
	public void addNotify()
	{
		//The add notify method happens when the 
		//JPanel is created
		super.addNotify();
		animator = new Thread(this);
		animator.start();
		
		//addKeyListener(this);
		
		
	}
	
	
	
	public void cycle()
	{
		synchronized(rects)
		{
			for(ColoredRectangle cR : rects)
			{
				cR.move();
			}
		}
		
		
	}
	public void hitCheck()
	{
		synchronized(rects)
		{
			synchronized(paddleLeft)
			{
				for(ColoredRectangle Rectangle : rects)
				{
					
						if(Rectangle.intersects(paddleLeft))
						{
							Rectangle.accelerator();
							Rectangle.reverser();
						}
						if(Rectangle.intersects(paddleRight))
						{
							Rectangle.accelerator();
							Rectangle.reverser();
						}
				}
				
			}
		}
	}
	
	@Override
	public void run()
	{
		 long beforeTime, timeDiff, sleep;
		 beforeTime = System.currentTimeMillis();
		 while (gameOn) 
		 {
			 cycle();
			 hitCheck();
			 repaint();
			 
			 timeDiff = System.currentTimeMillis() - beforeTime;
	         sleep = DELAY - timeDiff;

            if (sleep < 0)
                sleep = 2;
            try 
            {
                Thread.sleep(sleep);
            } 
            catch(InterruptedException e) 
            {
                System.out.println("interrupted");
            }
            

            beforeTime = System.currentTimeMillis();
            
		 }
	
	}
	
	

	@Override
	public void paint(Graphics g) 
	{
		
			
		
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Color.white);
		g2d.fill(new Rectangle2D.Double(0,0,getWidth(),getHeight()));
		synchronized(rects)
		{
			for(ColoredRectangle cR : rects)
			{
				g.setColor(Color.black);
				g.setFont(new Font("Verdana", Font.BOLD, 50));
				int w = g.getFontMetrics().stringWidth(""+cR.getScore1());
				g.drawString(""+cR.getScore1(), (int)getWidth()/2-w-100, 100);
				w = g.getFontMetrics().stringWidth(""+cR.getScore2());
				g.drawString(""+cR.getScore2(), (int)getWidth()/2 + 100, 100);
				
				g2d.setColor(cR.getRectColor());
				g2d.fill(cR);
				if(cR.getScore1() == 5)
				{
					Object[] options = {"Replay",
			                "Exit Program"};
					int n = JOptionPane.showOptionDialog(this,
							"You Win!!!! What would you like to do now.",
							"You WIN!!!",
									JOptionPane.YES_NO_OPTION,
									JOptionPane.QUESTION_MESSAGE,
									null,
									options,
									options[1]);
					if(n == 0)
					{
						cR.resetScore1();
						cR.resetScore2();
					}
					else 
					{
						
						//frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
						//frame.dispose();
						System.exit(0);
					}
				}
				if(cR.getScore2() == 5)
				{
					Object[] options = {"Replay",
			                "Exit Program"};
					int n = JOptionPane.showOptionDialog(this,
							"Computer Wins. What would you like to do now?",
									"Computer Wins",
									JOptionPane.YES_NO_OPTION,
									JOptionPane.QUESTION_MESSAGE,
									null,
									options,
									options[1]);
					if(n == 0)
					{
						cR.resetScore1();
						cR.resetScore2();
					}
					else
					{
						//frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
						//frame.dispose();
						System.exit(0);
					}
				}
			}
		}
		synchronized(paddleLeft)
		{
			
				g2d.setColor(paddleLeft.getRectColor());
				g2d.fill(paddleLeft);
		}
		synchronized(paddleRight)
		{
			synchronized(rects)
			{
			g2d.setColor(paddleRight.getRectColor());
			g2d.fill(paddleRight);
			for(ColoredRectangle cR : rects)
			{
				if(!(cR.y > 650))
				{
					paddleRight.y = cR.y;
				}
				else if(!(cR.y < 0))
				{
					paddleRight.y = cR.y;
				}
				else
				{
					
				}
			}
			}
		}
		
	}
	
	@Override
	public void mousePressed(MouseEvent e)
	{
		ArrayList<ColoredRectangle>
			rectsToRemove = new ArrayList<ColoredRectangle>();
		synchronized(rects)
		{
			for(ColoredRectangle cR : rects)
			{
				if(cR.contains(e.getPoint()))
				{
					rectsToRemove.add(cR);
				}
			}
			for(ColoredRectangle cR : rectsToRemove)
			{
				int Color1 = new Random().nextInt(256);
				int Color2 = new Random().nextInt(256);
				int Color3 = new Random().nextInt(256);
				cR.setRectColor(Color1,Color2,Color3);
			}
		}
		
		
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0)
	{
		
		
	}
	
	
	
	@Override
	public Dimension getPreferredSize()
	{
		return new Dimension(800,800);
	}
	
	


	@Override
	public void mouseEntered(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseReleased(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}


	
	

	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_UP)
		{
			synchronized(paddleLeft)
			{
					paddleLeft.moveup();
					paddleLeft.acceleration();
			}
		}
		
		else if(e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			synchronized(paddleLeft)
			{
					paddleLeft.movedown();
					paddleLeft.acceleration();
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP)
		{
			synchronized(paddleLeft)
			{
					paddleLeft.moveup();
					paddleLeft.accelerationReset();
			}
		}
		
		else if(e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			synchronized(paddleLeft)
			{
					paddleLeft.movedown();
					paddleLeft.acceleration();
			}
		}
		
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("ASDFASDFASD");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}



}

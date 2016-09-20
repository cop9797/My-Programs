package shapes;
import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
public class shapes {

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
		add(new CheckBoxesPanel());
		pack();
	}
}

class CheckBoxesPanel extends JPanel implements ActionListener
{
	private String[] sizes = {"S","M","L","XL"};
	private String[] colors = {"Black", "White", "Red","Pink","Green","Yellow"};
	private String[] quantities = {"1","5","10","20","100"};
	private ImageIcon shirtImage = new ImageIcon("IWriteCodeStamp.jpg");
	private JLabel imageLabel;
	private JRadioButton mensRadioButton;
	private JRadioButton womensRadioButton;

	private JComboBox sizeCombo;
	private JComboBox colorCombo;
	private JLabel quantityLabel;
	private JLabel labelTitle;
	private JComboBox quantityCombo;
	private JCheckBox baseballSleeves;
	private JButton calcButton;
	private JLabel resultLabel;
	private JLabel sizeLabel;
	private JLabel colorLabel;
	
	
	public CheckBoxesPanel()
	{
		imageLabel = new JLabel(shirtImage);
		mensRadioButton = new JRadioButton("Mens");
		womensRadioButton = new JRadioButton("Womens");
		
		//clickButton = new JButton("Click Me!");
		//displayLabel = new JLabel("Clicked 0 times...");
		//checkBox = new JCheckBox("I'm a check box!");
		//radioButton = new JRadioButton("Radio Button here!");  
		sizeCombo = new JComboBox(sizes);
		colorCombo = new JComboBox(colors);
		quantityLabel = new JLabel("Quantity");
	    labelTitle = new JLabel("TShirt Orderform");
	    quantityCombo = new JComboBox(quantities);
	    baseballSleeves = new JCheckBox("Baseball Sleeves?");
	    sizeLabel = new JLabel("Size:");
	    colorLabel = new JLabel("Color:");
	    calcButton = new JButton("Total");
	    resultLabel = new JLabel("");
	    
	    labelTitle.setFont(new Font("Impact" ,Font.BOLD, 28));
	    labelTitle.setHorizontalAlignment(SwingConstants.CENTER);
	    resultLabel.setFont(new Font("Impact",Font.PLAIN,16));
	    resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    
	    mensRadioButton.setSelected(true);
	    ButtonGroup dept = new ButtonGroup();
	    dept.add(mensRadioButton);
	    dept.add(womensRadioButton);
	    
	    
	    
	    
	    
		this.setLayout(new BorderLayout());
		this.add(labelTitle, BorderLayout.NORTH);
		this.add(imageLabel, BorderLayout.WEST);
		
		
		
		
		JPanel centerPanel = new JPanel();
		this.add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new BoxLayout(centerPanel,BoxLayout.Y_AXIS));
		JPanel deptPanel = new JPanel();
		
		deptPanel.add(mensRadioButton);
		deptPanel.add(womensRadioButton);
		
		JPanel comboPanel = new JPanel();
		
		comboPanel.add(sizeLabel);
		comboPanel.add(sizeCombo);
		comboPanel.add(colorLabel);
		comboPanel.add(colorCombo);
		
		JPanel quantPanel = new JPanel();
		quantPanel.add(quantityLabel);
		quantPanel.add(quantityCombo);
		
		JPanel sleevesPanel = new JPanel();
		sleevesPanel.add(baseballSleeves);
		sleevesPanel.add(calcButton);
		
		centerPanel.add(deptPanel);
		centerPanel.add(comboPanel);
		centerPanel.add(quantPanel);
		centerPanel.add(sleevesPanel);
		centerPanel.add(Box.createGlue());
		add(resultLabel, BorderLayout.SOUTH);
		calcButton.addActionListener(this);
	}
	@Override
	public Dimension getPreferredSize()
	{
		return new Dimension(500, 300);
		
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		boolean mens = mensRadioButton.isSelected();
		boolean womens = womensRadioButton.isSelected();
		boolean sleeves = baseballSleeves.isSelected();
		String size = sizeCombo.getSelectedItem().toString();
		String color = colorCombo.getSelectedItem().toString();
		int quantity = Integer.parseInt(quantityCombo.getSelectedItem().toString());
		double total = 0;
		String orderDetails = (""+quantity+" ");
		if (womens==true)
		{
			orderDetails += ("Women's Shirt(s) in " + color);
			switch (size.toLowerCase()){
			
			case "s":
				total+=12;
				break;
			case "m":
				total+=13;
				break;
			case "l":
				total+=14;
				break;
			case "xl":
				total+=15;
				break;
				
			}
			if(sleeves==true)
			{
				orderDetails += (" with baseball sleeves.");
				total+=2;
			}
			if(color.equals("red")){
				total+=1;
			}
			switch (quantity){
			case 5:
				total *=5;
				total = total-(total*.05);
				break;
			case 10:
				total *=10;
				total = total-(total*.1);
				break;
			case 20:
				total *=20;
				total = total-(total*.15);
				break;
			case 100:
				total *=100;
				total = total-(total*.25);
				break;
			}
		}
		else
		{
			orderDetails += ("Men's Shirt(s) in " + color);
			switch (size.toLowerCase()){
			
			case "s":
				total +=13;
				break;
			case "m":
				total +=14;
				break;
			case "l":
				total +=15;
				break;
			case "xl":
				total +=16;
				break;
			
			}
			if(sleeves==true)
			{
				orderDetails += (" with baseball sleeves.");
				total +=2;
			}
			if(color.equals("red")){
				total +=1;
			}
			
			switch (quantity){
			case 5:
				total *=5;
				total = total-(total*.05);
				break;
			case 10:
				total *=10;
				total = total-(total*.1);
				break;
			case 20:
				total *=20;
				total = total-(total*.15);
				break;
			case 100:
				total *=100;
				total = total-(total*.25);
				break;
			}
			
		}
		orderDetails += (" \nTotal: "+total);
		resultLabel.setText(orderDetails); 
		
				
		
		
		
	}
}
/*class DrawComponent extends JComponent
{
	private int x=100;
	private int y=100;
	private int width=50;
	private int height=50;
	
	
	
	public static final int MESSAGE_X = 75;
	public static final int MESSAGE_Y = 100;
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 300;
	
	
	
	
	
	
	
	
}
*/


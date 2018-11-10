package Game;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Brick extends JPanel
{
	private int health;
	private JLabel healthLabel;
	
	public Brick(int h)
	{
		
		setLayout(new FlowLayout());
		
		health = h;
		healthLabel = new JLabel("" + health);
		
		add(healthLabel);
		
		setForeground(Color.white);
		setBackground(Color.orange);
		
		
		setVisible(true);
	
	}

}

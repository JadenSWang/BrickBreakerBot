package Game;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Brick extends JPanel{
	
	private int health;
	private JLabel healthLabel;
	
	public Brick(int h) {
		
		setLayout(new FlowLayout());
		
		health = h;
		
		
		healthLabel = new JLabel(health +"");
		healthLabel.setFont(new Font("Helvetica",Font.BOLD,22));
		healthLabel.setForeground(Color.white);
		
		
		setBackground(Color.BLACK);
		add(healthLabel);
		setVisible(true);
		
	}

}

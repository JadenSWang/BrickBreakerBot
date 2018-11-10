package Game;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Brick extends JPanel{
	
	private int health;
	private JLabel healthLabel;
	
	public Brick(int h) {
		
		health = h;
		healthLabel = new JLabel(health +"");
		
	}

}

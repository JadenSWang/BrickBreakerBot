package Game;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Brick extends JPanel
{

	private int health;
	private JLabel healthLabel;
	private Color bColor;
	private int xLoc;
	private int yLoc;
	public static final int BRICK_WIDTH = 30;
	public static final int BRICK_HEIGHT = 100;

	public Brick(int h)
	{

		bColor = new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
		health = h;
		healthLabel = new JLabel(health + "");

	}

	public Color getColor()
	{
		return bColor;
	}

	public int getXLoc()
	{
		return xLoc;
	}

	public int getYLoc()
	{
		return yLoc;
	}
}

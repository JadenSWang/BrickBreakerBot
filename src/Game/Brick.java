package Game;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Brick
{
	private int health;
	private Color bColor;
	private int xLoc;
	private int yLoc;
	public static final int BRICK_WIDTH = 30;
	public static final int BRICK_HEIGHT = 100;

	public Brick(int h, int x, int y)
	{

		bColor = new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
		health = h;

		xLoc = x;
		yLoc = y;
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

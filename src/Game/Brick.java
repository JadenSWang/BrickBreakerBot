package Game;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Brick
{
	private int health;
	private int xLoc;
	private int yLoc;
	
	public static final int BRICK_WIDTH = 30;
	public static final int BRICK_HEIGHT = 100;

	public Brick(int health, int xLoc, int y)
	{

		this.health = health;

		this.xLoc = xLoc;
		this.yLoc = y;
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

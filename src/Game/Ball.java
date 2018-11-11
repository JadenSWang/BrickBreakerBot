package Game;

import java.util.ArrayList;

import javax.swing.JFrame;

public class Ball
{
	private int xLoc;
	private int yLoc;
	private Velocity vel;

	public static final int DIAMETER = 15;

	public Ball(int xLoc, int yLoc)
	{
		this.xLoc = xLoc;
		this.yLoc = yLoc;
	}

	public boolean moveBall(int xChange, int yChange, JFrame frame)
	{
		int newXLoc = xLoc + xChange;
		int newYLoc = yLoc + yChange;

		if (newXLoc < frame.getHeight() && newYLoc < frame.getWidth())
		{
			xLoc = newXLoc;
			yLoc = newYLoc;

			return true;
		}

		return false;
	}

	public int getX()
	{
		return xLoc;
	}

	public int getY()
	{
		return yLoc;
	}

	public void hitHorizWall()
	{
		this.vel.yV *= -1;
	}

	public void hitVertWall()
	{
		this.vel.xV *= -1;
	}

	public void updateLoc()
	{
		this.xLoc += this.vel.xV;
		this.yLoc += this.vel.yV;
	}
	
	public void reverseXDir()
	{
		this.vel.xV *= -1;
	}
	
	public void reverseYDir()
	{
		this.vel.yV *= -1;
	}

	
	private class Velocity
	{
		int xV;
		int yV;
	}
}

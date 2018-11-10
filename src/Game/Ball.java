package Game;

import javax.swing.JFrame;

public class Ball
{
	private int xLoc;
	private int yLoc;

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

	public int nextX(Degree degree)
	{
		return 0;
	}

	public int nextY()
	{
		return 0;
	}
}

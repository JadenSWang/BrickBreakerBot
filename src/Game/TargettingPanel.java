package Game;

import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;

public class TargettingPanel extends BrickPanel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5959200934777656628L;
	private Point startingBallLoc;
	private boolean ballsInMotion;

	@Override
	public void paintComponent(Graphics g)
	{
		if (!ballsInMotion)
		{
			if (startingBallLoc == null)
			{
				return;
			}

			Point mouseLoc = MouseInfo.getPointerInfo().getLocation();
			g.drawLine(mouseLoc.x, mouseLoc.y, startingBallLoc.x, startingBallLoc.y);
		} else {
			
		}
	}

	public void setBallInMotion()
	{
		ballsInMotion = true;
	}

	public void setPointsVector(Point startingBallLoc)
	{
		this.startingBallLoc = startingBallLoc;
	}

	public boolean ballsInMotion()
	{
		return ballsInMotion;
	}
}

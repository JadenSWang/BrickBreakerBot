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

	@Override
	public void paintComponent(Graphics g)
	{
		if (!super.ballsinMotion)
		{
			if (startingBallLoc == null)
			{
				return;
			}

			Point mouseLoc = MouseInfo.getPointerInfo().getLocation();
			g.drawLine(mouseLoc.x, mouseLoc.y, startingBallLoc.x, startingBallLoc.y);
		}
	}

	public void setBallInMotion()
	{
		ballsinMotion = true;
	}

	public void setPointsVector(Point startingBallLoc)
	{
		this.startingBallLoc = startingBallLoc;
	}

	public boolean ballsInMotion()
	{
		return ballsinMotion;
	}
}

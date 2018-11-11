package Game;

import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;

import javax.swing.JPanel;

public class TargettingDrawPanel extends PaintablePanel
{

	private Point startingBallLoc;

	/**
	 * 
	 */
	private static final long serialVersionUID = 7321596843239612406L;

	public TargettingDrawPanel()
	{

	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		if (startingBallLoc == null)
		{
			throw new IllegalStateException("Must set starting point first");
		}

		Point mouseLoc = MouseInfo.getPointerInfo().getLocation();
		g.drawLine(mouseLoc.x, mouseLoc.y, startingBallLoc.x, startingBallLoc.y);
	}

	public void setPointsVector(Point startingBallLoc)
	{
		this.startingBallLoc = startingBallLoc;
	}
}
package Game;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Queue;

public class BallFiringPanel extends BrickPanel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1657039124610316038L;
	
	private Queue<Ball> balls = new LinkedList<Ball>();

	@Override
	public void paintComponent(Graphics g)
	{
		if (!super.ballsinMotion)
		{
			for(Ball ball : balls) {
				g.fillOval(ball.xLoc, ball.yLoc, 15, 15);
			}
		}
	}

	public void setBallInMotion()
	{
		ballsinMotion = true;
	}

	public boolean ballsInMotion()
	{
		return ballsinMotion;
	}
}

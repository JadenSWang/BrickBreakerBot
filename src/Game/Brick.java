package Game;

public class Brick
{
	private int health;
	private int xLoc;
	private int yLoc;

	public static final int BRICK_WIDTH = (BrickBreaker.PLAY_LENGTH - 10) / 6;
	public static final int BRICK_HEIGHT = (BrickBreaker.PLAY_LENGTH - 24) / 8;

	public Brick(int health, int xLoc, int y)
	{
		this.setHealth(health);

		this.xLoc = xLoc;
		this.yLoc = y;
	}

	// 0 is not hit, 1 is hit horizontal wall, 2 is hit vertical wall, 3 is hit
	// corner
	public int isHit(Ball ball)
	{
		int brickLeft = this.xLoc;
		int brickRight = this.xLoc + BRICK_WIDTH;
		int brickTop = this.yLoc;
		int brickBottom = this.yLoc + BRICK_HEIGHT;

		int ballLeft = ball.getX();
		int ballRight = ball.getX() + Ball.DIAMETER;
		int ballTop = ball.getY();
		int ballBottom = ball.getY() + Ball.DIAMETER;

		boolean hitX = ballLeft >= brickLeft && ballLeft <= brickRight
				|| ballRight >= brickLeft && ballRight <= brickLeft;
		boolean hitY = ballTop >= brickTop && ballTop <= brickBottom
				|| ballBottom >= brickTop && ballBottom <= brickBottom;

		boolean hit = hitX && hitY;

		int yDisp;
		int xDisp;

		// if the ball is traveling upwards
		if (ball.getVel().yV < 0)
		{
			yDisp = ballTop - brickBottom;
		}

		// if the ball is traveling downwards
		else
		{
			yDisp = brickTop - ballBottom;
		}

		// if the ball is traveling right
		if (ball.getVel().xV > 0)
		{
			xDisp = brickLeft - ballRight;
		}

		// if the ball is traveling left
		else
		{
			xDisp = ballLeft - brickRight;
		}

		if (!hit)
		{
			return 0;
		} else
		{
			this.health--;
		}

		if (Math.abs(Math.abs(xDisp) - Math.abs(yDisp)) <= 2)
		{
			return 3;
		} else if (Math.abs(xDisp) < Math.abs(yDisp))
		{
			return 2;
		} else
		{
			return 1;
		}
	}

	public int getXLoc()
	{
		return xLoc;
	}

	public int getYLoc()
	{
		return yLoc;
	}

	public void setYLoc(int y)
	{
		yLoc = y;
	}

	public void setXLoc(int x)
	{
		xLoc = x;
	}

	public int getHealth()
	{
		return health;
	}

	public void setHealth(int health)
	{
		this.health = health;
	}
}

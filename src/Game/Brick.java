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

	public boolean isHit(Ball ball)
	{
		if (xLoc >= ball.getX() && (xLoc + Brick.BRICK_WIDTH) <= (ball.getX() + Ball.DIAMETER))
		{
			if (yLoc >= ball.getY() && (yLoc + Brick.BRICK_WIDTH) <= (ball.getY() + Ball.DIAMETER))
			{
				return true;
			}
		}

		return false;
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

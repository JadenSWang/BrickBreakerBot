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
	public boolean isHit(Ball ball)
	{
		int brickLeft = this.xLoc;
		int brickRight = this.xLoc + BRICK_WIDTH;
		int brickTop = this.yLoc;
		int brickBottom = this.yLoc + BRICK_HEIGHT;

		int ballLeft = ball.getX();
		int ballRight = ball.getX() + Ball.DIAMETER;
		int ballTop = ball.getY();
		int ballBottom = ball.getY() + Ball.DIAMETER;

		boolean hitX = ballLeft >= brickLeft && ballLeft <= brickRight || ballRight >= brickLeft && ballRight <= brickLeft;
		boolean hitY = ballTop >= brickTop && ballTop <= brickBottom || ballBottom >= brickTop && ballBottom <= brickBottom;

		return hitX && hitY;

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

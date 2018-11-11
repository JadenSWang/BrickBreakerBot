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

	//0 is not hit, 1 is hit horizontally, 2 is hit vertically
	public int isHit(Ball ball)
	{
		if (!(((ball.getX() >= this.xLoc && ball.getX() <= this.xLoc + BRICK_WIDTH) || (ball.getX() + Ball.DIAMETER >= this.xLoc && ball.getX() + Ball.DIAMETER <= this.xLoc + BRICK_WIDTH) && (ball.getY() >= this.yLoc && ball.getY() <= this.yLoc + BRICK_HEIGHT)) || (ball.getY() + Ball.DIAMETER >= this.yLoc && ball.getY() + Ball.DIAMETER <= this.yLoc + BRICK_HEIGHT))) {
			return 0;
		}
		
		int xDisp = Math.min(Math.abs(this.xLoc - ball.getX()), Math.abs(this.xLoc - (ball.getX() + BRICK_WIDTH)));
		int yDisp = Math.min(Math.abs(this.yLoc - ball.getY()), Math.abs(this.yLoc - (ball.getY() + BRICK_HEIGHT)));
		if(xDisp < yDisp)
			return 2;
		else
			return 1;
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

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

	// 0 is not hit, 1 is hit horizontally, 2 is hit vertically, 3 is hit both
	public int isHit(Ball ball)
	{
		int brickLeftLoc = this.xLoc;
		int brickRightLoc = this.xLoc + BRICK_WIDTH;
		int brickTopLoc = this.yLoc;
		int brickBottomLoc = this.yLoc + BRICK_HEIGHT;
		
		int ballLeftLoc = ball.getX();
		int ballRightLoc = ball.getX() + Ball.DIAMETER;
		int ballTopLoc = ball.getY();
		int ballBottomLoc = ball.getY() + Ball.DIAMETER;
		
		
		boolean hitX = ballLeftLoc >= brickLeftLoc && ballLeftLoc <= brickRightLoc || ballRightLoc >= brickLeftLoc && ballRightLoc <= brickLeftLoc;
		boolean hitY = ballTopLoc >= brickTopLoc && ballTopLoc <= brickBottomLoc || ballBottomLoc >= brickTopLoc && ballBottomLoc <= brickBottomLoc;
		
		boolean hit = hitX && hitY;
		
		
		if(!hit)
		{
			return 0;
		}
		else
		{
			System.out.println("hit. Ball x:" + ball.getX() + " brick x: " +  this.xLoc + " ball y: " + ball.getY() + " brick y: " + this.yLoc);
		}

		int xDisp = Math.min(Math.abs(this.xLoc - ball.getX()), Math.abs(this.xLoc - (ball.getX() + BRICK_WIDTH)));
		int yDisp = Math.min(Math.abs(this.yLoc - ball.getY()), Math.abs(this.yLoc - (ball.getY() + BRICK_HEIGHT)));
		if (xDisp < yDisp)
		{
			return 1;
		} else if (xDisp == yDisp)
		{
			return 3;
		}
		else
		{
			return 2;
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

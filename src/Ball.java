public class Ball
{
	protected int xLoc;
	protected int yLoc;
	private Velocity vel;

	public static final int DIAMETER = 15;

	public Ball(int xLoc, int yLoc, int xVel, int yVel)
	{
		vel = new Velocity(xVel, yVel);
		this.xLoc = xLoc;
		this.yLoc = yLoc;
	}

	public int getX()
	{
		return xLoc;
	}

	public int getY()
	{
		return yLoc;
	}

	public void hitHorizWall()
	{
		this.vel.yV *= -1;
	}

	public void hitVertWall()
	{
		this.vel.xV *= -1;
	}

	public void updateLoc()
	{
		this.xLoc += this.vel.xV;
		this.yLoc += this.vel.yV;
	}

	public void reverseXDir()
	{
		this.vel.xV *= -1;
		updateLoc();
		System.out.println("xdir reversed");
	}

	public void reverseYDir()
	{
		this.vel.yV *= -1;
		updateLoc();
		System.out.println("ydir reversed");
	}

	public void reverseBothDir()
	{
		this.vel.xV *= -1;
		this.vel.yV *= -1;
	}

	public Velocity getVel()
	{
		return this.vel;
	}

	public class Velocity
	{
		int xV;
		int yV;

		public Velocity(int xV, int yV)
		{
			this.xV = xV;
			this.yV = yV;
		}
	}
}

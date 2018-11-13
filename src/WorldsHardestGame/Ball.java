package WorldsHardestGame;

public class Ball
{
	protected int xLoc;
	protected int yLoc;

	public static final int DIAMETER = 15;

	public Ball(int xLoc, int yLoc)
	{
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
	
	public void incX(int inc)
	{
		xLoc += inc;
	}
}

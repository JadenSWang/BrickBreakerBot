package Game;

public class Degree
{
	private int degree;

	public Degree(int degree)
	{
		if (degree < 0 || degree > 359)
			throw new IllegalArgumentException("Degree must be within 0 and 359");
		this.setDegree(degree);
	}

	public int getDegree()
	{
		return degree;
	}

	public void setDegree(int degree)
	{
		this.degree = degree;
	}
}

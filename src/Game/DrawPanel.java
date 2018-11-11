package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JPanel;

public class DrawPanel extends JPanel implements MouseListener
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8253100141533033512L;
	private ArrayList<Brick> allBricks;
	private ArrayList<Ball> allBalls;
	private int curScore;

	public DrawPanel()
	{
		allBalls = new ArrayList<Ball>();
		allBricks = new ArrayList<Brick>();
		this.addMouseListener(this);

		allBalls.add(new Ball(BrickBreaker.PLAY_LENGTH / 2 - Ball.DIAMETER / 2, BrickBreaker.PLAY_LENGTH - 21));
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		g.setColor(Color.ORANGE);
		for (Brick next : allBricks)
		{
			g.fillRect(next.getXLoc(), next.getYLoc(), Brick.BRICK_WIDTH, Brick.BRICK_HEIGHT);
		}

		g.setColor(Color.GREEN);
		for (Ball next : allBalls)
		{
			g.fillOval(next.getX(), next.getY(), Ball.DIAMETER, Ball.DIAMETER);
		}
	}

	// adds a new row of bricks
	public void addRow()
	{
		int numNewBricks = (int) (Math.random() * 4 + 1);

		ArrayList<Integer> possibleLocs = new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5));

		for (int i = 0; i < numNewBricks; i++)
		{

			int addLoc = possibleLocs.remove((int) (Math.random() * possibleLocs.size()));

			int x = 0;

			// always first row
			int y = 5;

			if (addLoc != 0)
				x = (Brick.BRICK_WIDTH * addLoc) + (2 * addLoc);

			allBricks.add(new Brick(curScore, x, y));
		}

		curScore++;
		moveDown();
		repaint();
	}

	public int getCurScore()
	{
		return curScore;
	}

	// moves all bricks down one row
	public void moveDown()
	{
		for (Brick b : allBricks)
			b.setYLoc(b.getYLoc() + Brick.BRICK_HEIGHT + 2);
	}

	public ArrayList<Brick> getAllBricks()
	{
		return this.allBricks;
	}

	public ArrayList<Ball> getAllBalls()
	{
		return this.allBalls;
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{

	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

}

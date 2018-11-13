package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JPanel;

public class DrawPanel extends JPanel
{
	private ArrayList<Brick> allBricks;
	private Ball ball;
	private int curScore;

	public DrawPanel()
	{
		allBricks = new ArrayList<Brick>();
		ball = new Ball(BrickBreaker.PLAY_LENGTH / 2 - Ball.DIAMETER, BrickBreaker.PLAY_LENGTH - 30);
		curScore = 0;
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
		g.fillOval(getBall().getX(), getBall().getY(), Ball.DIAMETER, Ball.DIAMETER);
	}

	// adds a new row of bricks
	public void addRow()
	{
		int numNewBricks = (int) (Math.random() * 2 + 1);

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

	public boolean step()
	{
		addRow();
		for (Brick brick : allBricks)
		{
			if (brick.isHit(getBall()))
			{
				System.out.println("game over");
				return false;
			}
		}
		return true;
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

	public Ball getBall()
	{
		return ball;
	}

	public void setBall(Ball ball)
	{
		this.ball = ball;
	}
}
package Game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BrickPanel extends DrawPanel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8253100141533033512L;
	private ArrayList<Brick> allBricks;
	private Queue<Ball> allBalls;
	private int curScore = 1;

	private BufferedImage[] brickColors;
	private ArrayList<JPanel> allBrickPics;

	public BrickPanel()
	{
		allBalls = new LinkedList<Ball>();
		allBricks = new ArrayList<Brick>();
		allBrickPics = new ArrayList<JPanel>();
		brickColors = new BufferedImage[7];

		try
		{
			for (int i = 0; i < 7; i++)
				brickColors[i] = ImageIO.read(new File("Color_" + i + ".png"));

		} catch (IOException ioe)
		{
			System.out.println("Could not read in the pic");
			System.exit(0);
		}

		allBalls.add(new Ball(BrickBreaker.PLAY_LENGTH / 2 - Ball.DIAMETER / 2, BrickBreaker.PLAY_LENGTH - 21, 1, -1));
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		g.setColor(new Color(255,255,255));

		Iterator<Brick> brickIter = allBricks.iterator();
		while (brickIter.hasNext()) {
			Brick next= brickIter.next();

			if(next.getHealth() == 0) {

				JPanel cover = new JPanel();
				cover.setBounds(next.getXLoc(), next.getYLoc(), Brick.BRICK_WIDTH, Brick.BRICK_HEIGHT);
				add(cover);
				g.fillRect(next.getXLoc(), next.getYLoc(), Brick.BRICK_WIDTH, Brick.BRICK_HEIGHT);

				brickIter.remove();

			}

			else {

				int colorLoc = (int) (next.getHealth() / ((double) (curScore) / 7));

				PicPanel pic = new PicPanel(Brick.BRICK_WIDTH, Brick.BRICK_HEIGHT, brickColors[0], next);

				pic.setBounds(next.getXLoc(), next.getYLoc(), Brick.BRICK_WIDTH, Brick.BRICK_HEIGHT);
				add(pic);
				allBrickPics.add(pic);

				g.fillRect(next.getXLoc(), next.getYLoc(), Brick.BRICK_WIDTH, Brick.BRICK_HEIGHT);

			}


		}

		// shade of blue
		g.setColor(new Color(99, 205, 255));

		for (Ball next : allBalls)
		{
			System.out.println(next.getX() + " " + next.getY());
			Random rand = new Random();

			g.setColor(new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat()));
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

	public void step()
	{
		for (Ball ball : allBalls)
		{
			ball.updateLoc();
			for (Brick brick : allBricks)
			{
				int hitDirection = brick.isHit(ball);

				if (hitDirection == 1)
				{
					// hit horizontal wall

					ball.reverseYDir();
				} else if (hitDirection == 2)
				{
					// hit vertically

					ball.reverseXDir();
				} else if (hitDirection == 3)
				{
					ball.reverseBothDir();
				}

				if (ball.getX() >= BrickBreaker.PLAY_LENGTH || ball.getX() <= 0)
				{
					ball.reverseXDir();
				}
				if (ball.getY() <= 0)
				{
					ball.reverseYDir();
				}

				if (ball.getX() >= BrickBreaker.PLAY_LENGTH)
				{
					ball.reverseXDir();
				}

				if (ball.getY() >= BrickBreaker.PLAY_LENGTH)
				{
					ball.reverseYDir();
				}
			}
		}
	}

	public void shootBall()
	{
		int mouseX = MouseInfo.getPointerInfo().getLocation().x;
		int mouseY = MouseInfo.getPointerInfo().getLocation().y;
		int xDisp = mouseX - BrickBreaker.PLAY_LENGTH / 2;
		int yDisp = BrickBreaker.PLAY_LENGTH - mouseY;
		int xVel = (int) (10.0 / ((double) yDisp / (double) xDisp));
		int yVel = 10;

		System.out.println("x vel: " + xVel + " y Vel: " + yVel);
		for (Ball ball : allBalls)
		{
			System.out.println(ball.getX() + " " + ball.getY());
		}

		allBalls.add(new Ball(BrickBreaker.PLAY_LENGTH / 2 - Ball.DIAMETER, BrickBreaker.PLAY_LENGTH - 5, xVel, yVel));
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

		for (int i = 0; i < allBrickPics.size(); i++)
		{

			JPanel j = allBrickPics.get(i);

			j.setBounds(j.getX(), j.getY() + Brick.BRICK_HEIGHT + 2, Brick.BRICK_WIDTH, Brick.BRICK_HEIGHT);
		}
	}

	public ArrayList<Brick> getAllBricks()
	{
		return this.allBricks;
	}

	public Queue<Ball> getAllBalls()
	{
		return this.allBalls;
	}

	public class PicPanel extends JPanel
	{

		private int width;
		private int height;
		private BufferedImage i;
		private Brick thisBrick;
		private JLabel healthLabel;

		public PicPanel(int w, int h, BufferedImage bI)
		{

			width = w;
			height = h;
			i = bI;

		}

		public PicPanel(int w, int h, BufferedImage bI, Brick b)
		{

			this(w, h, bI);

			thisBrick = b;
			healthLabel = new JLabel();

			healthLabel.setFont(new Font("Helvetica", Font.BOLD, 40));
			healthLabel.setForeground(Color.white);

			setLabel();

			add(healthLabel);

		}

		public void setLabel()
		{

			healthLabel.setText(thisBrick.getHealth() + "");

		}

		// called by the machine
		public Dimension getPreferredSize()
		{
			return new Dimension(width, height);
		}

		// called automatically by repaint
		public void paintComponent(Graphics g)
		{

			super.paintComponent(g);

			g.drawImage(i, 0, 0, this);
		}

	}
}

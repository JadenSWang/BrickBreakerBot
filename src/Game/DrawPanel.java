package Game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.imageio.ImageIO;
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

	private BufferedImage[] brickColors;
	private BufferedImage ballPic;

	private ArrayList<JPanel> allBrickPics;
	
	public DrawPanel()
	{
		allBalls = new ArrayList<Ball>();
		allBricks = new ArrayList<Brick>();
		allBrickPics = new ArrayList<JPanel>();
		brickColors = new BufferedImage[7];
		
		try {

			for(int i = 0; i < 7; i++) 
				brickColors[i] = ImageIO.read(new File("Color_" + i + ".png"));
			
			ballPic = ImageIO.read(new File("Ball.png"));

		} catch (IOException ioe) {
			System.out.println("Could not read in the pic");
			System.exit(0);
		}

		this.addMouseListener(this);

		allBalls.add(new Ball(BrickBreaker.PLAY_LENGTH / 2 - Ball.DIAMETER / 2, BrickBreaker.PLAY_LENGTH - 21));
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		g.setColor(Color.ORANGE);
		for (Brick next : allBricks)
		{

			int colorLoc = (int) (next.getHealth() / ((double)curScore/7));

			JPanel pic = getPic(Brick.BRICK_WIDTH, Brick.BRICK_HEIGHT, brickColors[colorLoc]);

			pic.setBounds(next.getXLoc(), next.getYLoc(), Brick.BRICK_WIDTH, Brick.BRICK_HEIGHT);
			add(pic);
			allBrickPics.add(pic);

			g.fillRect(next.getXLoc(), next.getYLoc(), Brick.BRICK_WIDTH, Brick.BRICK_HEIGHT);
		}

		g.setColor(Color.GREEN);
		for (Ball next : allBalls)
		{
			JPanel pic = getPic(Ball.DIAMETER, Ball.DIAMETER, ballPic);

			pic.setBounds(next.getX(), next.getY(), Ball.DIAMETER, Ball.DIAMETER);
			add(pic);

			g.fillOval(next.getX(), next.getY(), Ball.DIAMETER, Ball.DIAMETER);
		}
	}

	//returns the desired picture as a jpanel
	private JPanel getPic(int w, int h, BufferedImage i) {

		return new JPanel() {

			// called by the machine
			public Dimension getPreferredSize() {
				return new Dimension(w, h);
			}

			// called automatically by repaint
			public void paintComponent(Graphics g) {

				super.paintComponent(g);

				g.drawImage(i, 0, 0, this);
			}

		};
		

	}

	public void drawVector(int x, int y) {
		
		
		
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
		
		for(JPanel j : allBrickPics) 
			j.setBounds(j.getX(), j.getY() + Brick.BRICK_HEIGHT + 2, Brick.BRICK_WIDTH, Brick.BRICK_HEIGHT);
		
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

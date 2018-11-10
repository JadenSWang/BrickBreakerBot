package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class DrawPanel extends JPanel implements MouseListener
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8253100141533033512L;
	private ArrayList<Brick> allBricks;
	private ArrayList<Ball> allBalls;

	public DrawPanel()
	{
		allBricks = new ArrayList<Brick>();
		this.addMouseListener(this);
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

	@Override
	public void mouseClicked(MouseEvent e)
	{
		// TODO Auto-generated method stub

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

package Game;

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

	public DrawPanel()
	{
		allBricks = new ArrayList<Brick>();
		this.addMouseListener(this);
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		for (Brick next : allBricks)
		{
			g.setColor(next.getColor());
			g.fillRect(next.getXLoc(), next.getYLoc(), Brick.BRICK_WIDTH, Brick.BRICK_HEIGHT);

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

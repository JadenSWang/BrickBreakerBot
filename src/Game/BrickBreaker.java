package Game;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class BrickBreaker extends JFrame implements MouseListener
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1651012869660387679L;

	public BrickBreaker()
	{

		setSize(650, 900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		/*
		 * canvas = new DrawPanel(); canvas.setBounds(0, 0, 300, 575);
		 * canvas.setBackground(Color.white);
		 * canvas.setBorder(BorderFactory.createLineBorder(Color.black));
		 * 
		 * add(canvas);
		 * 
		 * canvas.repaint();
		 */

		setVisible(true);

	}

	public void actionPerformed(ActionEvent arg0)
	{

	}

	public static void main(String[] args)
	{
		new BrickBreaker();

	}

	@Override
	public void mouseClicked(MouseEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0)
	{
		// TODO Auto-generated method stub

	}
	
	

}

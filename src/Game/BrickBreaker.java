package Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class BrickBreaker extends JFrame implements ActionListener
{

	private Timer timer;

	public BrickBreaker()
	{

		setSize(650, 900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);


		setVisible(true);

	}

	public void actionPerformed(ActionEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	public static void main(String[] args)
	{

		new BrickBreaker();
		
		//test
		
		sdfjklsdjfklsd

	}

}

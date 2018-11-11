package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class BrickBreaker extends JFrame implements KeyListener
{
	private JLabel score;
	// private boolean isOver = false;

	private DrawPanel playArea; // area with all bricks and balls
	private Timer stepTimer;

	private Point movePoint;

	protected static final int PLAY_LENGTH = 650;

	public BrickBreaker()
	{
		setSize(665, 900);
		setTitle("Brick Breaker");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.white);
		setLayout(null);

		playArea = new DrawPanel();
		playArea.setBackground(Color.white);
		playArea.setBorder(BorderFactory.createMatteBorder(5, 0, 5, 0, Color.black));
		playArea.setBounds(0, 125, PLAY_LENGTH, PLAY_LENGTH);

		playArea.setLayout(null);

		add(playArea);

		score = new JLabel("SCORE    : " + playArea.getCurScore());

		score.setFont(new Font("Helvetica", Font.BOLD, 22));

		score.setBounds(225, 45, 200, 20);

		add(score);

		this.addKeyListener(this);

		playArea.addRow();

		stepTimer = new Timer(700, new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				if (!playArea.step())
					stepTimer.stop();
				updateScore();
				playArea.repaint();
			}
		});

		stepTimer.start();

		setVisible(true);
	}

	private void updateScore()
	{
		score.setText("SCORE    : " + playArea.getCurScore());
	}

	public static void main(String[] args)
	{
		new BrickBreaker();
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
		
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		int keyVal = e.getKeyCode();

		// if key is left
		if (e.getKeyChar() == 'j')
		{
			playArea.getBall().incX(-10);
			repaint();
		}
		// if key is right
		else if (e.getKeyChar() == 'k')
		{
			playArea.getBall().incX(10);
			repaint();
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		// TODO Auto-generated method stub

	}
}
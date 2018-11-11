package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class BrickBreaker extends JFrame implements MouseListener
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3946190460435085023L;
	private JLabel record;
	private JLabel score;
	private boolean isOver = true;

	private BrickPanel playArea; // area with all bricks and balls
	private TargettingPanel targetingPanel;
	private Timer stepTimer;
	private Timer targettingTimer;

	private int xMouseLoc;
	private int yMouseLoc;

	private boolean newRecord;

	private Point startingBallLoc;

	protected static final int PLAY_LENGTH = 650;

	public BrickBreaker()
	{
		setSize(665, 900);
		setTitle("Brick Breaker");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.white);
		setLayout(null);

		playArea = new BrickPanel();
		playArea.setBackground(Color.white);
		playArea.setBorder(BorderFactory.createMatteBorder(5, 0, 5, 0, Color.black));
		playArea.setBounds(0, 125, PLAY_LENGTH, PLAY_LENGTH);

		playArea.setLayout(null);

		add(playArea);

		targetingPanel = new TargettingPanel();
		targetingPanel.setBackground(Color.white);
		targetingPanel.setBorder(BorderFactory.createMatteBorder(5, 0, 5, 0, Color.black));
		targetingPanel.setBounds(0, 125, PLAY_LENGTH, PLAY_LENGTH);

		targetingPanel.setLayout(null);

		add(targetingPanel);

		record = new JLabel("RECORD : ");
		score = new JLabel("SCORE    : " + playArea.getCurScore());

		record.setFont(new Font("Helvetica", Font.BOLD, 22));
		score.setFont(new Font("Helvetica", Font.BOLD, 22));

		record.setBounds(225, 25, 200, 20);
		score.setBounds(225, 45, 200, 20);

		add(record);
		add(score);

		setVisible(true);
		playArea.addRow();

		this.addMouseListener(this);

		targettingTimer = new Timer(1, new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				targetingPanel.setPointsVector(startingBallLoc);
				targetingPanel.repaint();
				playArea.repaint();
			}
		});

		stepTimer = new Timer(1, new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				for (int i = 0; i < 20; i++)
				{
					if (!playArea.step(xMouseLoc, yMouseLoc))
					{
						targettingTimer.start();
						stepTimer.stop();
					}
				}
				playArea.repaint();
			}
		});

		targettingTimer.start();

		while (isOver)
		{
			score.setText("SCORE    : " + playArea.getCurScore());

			startingBallLoc = new Point(playArea.getAllBalls().peek().getX() + 5,
					playArea.getAllBalls().peek().getY() + 5);
		}

		System.exit(-1);
	}

	public static void main(String[] args)
	{
		new BrickBreaker();
	}

	@Override
	public void mouseClicked(MouseEvent arg0)
	{
		targettingTimer.stop();
		stepTimer.start();
		playArea.addRow();
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
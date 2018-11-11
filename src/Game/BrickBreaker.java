package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.Point;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class BrickBreaker extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3946190460435085023L;
	private JLabel record;
	private JLabel score;
	private boolean isOver = true;
	private boolean ballsInMotion;

	private DrawPanel playArea; // area with all bricks and balls

	protected static final int PLAY_LENGTH = 650;

	public BrickBreaker()
	{
		Timer lineupTimer;

		setSize(650, 900);
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

		record = new JLabel("RECORD : ");
		score = new JLabel("SCORE    : " + playArea.getCurScore());

		record.setFont(new Font("Helvetica", Font.BOLD, 22));
		score.setFont(new Font("Helvetica", Font.BOLD, 22));

		record.setBounds(225, 25, 200, 20);
		score.setBounds(225, 45, 200, 20);

		add(record);
		add(score);

		setVisible(true);

		while (isOver)
		{
			lineupTimer = new Timer(1, null);

			/*
			 * while (!ballsInMotion) { Point mouseLocation =
			 * MouseInfo.getPointerInfo().getLocation();
			 * playArea.drawVector(mouseLocation.x, mouseLocation.y); }
			 */

			new Scanner(System.in).nextLine();
			playArea.addRow();
			score.setText("SCORE    : " + playArea.getCurScore());
		}

		System.exit(-1);
	}

	public static void main(String[] args)
	{

		new BrickBreaker();
	}

}
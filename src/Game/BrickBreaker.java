package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.Timer;

public class BrickBreaker extends JFrame implements ActionListener
{

	private JLabel record;
	private JLabel score;
	private int curScore;

	private JPanel playArea; // area with all bricks and balls

	private Timer timer;

	public BrickBreaker()
	{

		setSize(650, 900);
		setTitle("Brick Breaker");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.white);
		setLayout(null);

		record = new JLabel("RECORD : ");
		score = new JLabel("SCORE    : " + curScore);

		record.setFont(new Font("Helvetica", Font.BOLD, 22));
		score.setFont(new Font("Helvetica", Font.BOLD, 22));

		record.setBounds(225, 25, 200, 20);
		score.setBounds(225, 45, 200, 20);

		add(record);
		add(score);

		playArea = new JPanel();
		playArea.setBackground(Color.white);
		playArea.setBorder(BorderFactory.createMatteBorder(5, 0, 5, 0, Color.black));
		playArea.setBounds(0, 125, 650, 650);
		add(playArea);

		setVisible(true);

	}

	public void actionPerformed(ActionEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	public static void main(String[] args)
	{

		new BrickBreaker();

		// test

	}

}
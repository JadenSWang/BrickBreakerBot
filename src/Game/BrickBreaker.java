package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;

public class BrickBreaker extends JFrame implements ActionListener
{

	private JLabel record;
	private JLabel score;
	private int curScore;

	private DrawPanel playArea; // area with all bricks and balls

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

		playArea = new DrawPanel();
		playArea.setBackground(Color.white);
		playArea.setBorder(BorderFactory.createMatteBorder(5, 0, 5, 0, Color.black));
		playArea.setBounds(0, 125, 650, 650);

		playArea.setLayout(null);

		add(playArea);

		addRow();
		setVisible(true);

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
			int y = 5;
			
			if(addLoc != 0)
				x = (Brick.BRICK_WIDTH  * addLoc) + (2*addLoc);
					
			
			
			//playArea.allBricks.add(new Brick(curScore, x, y));
		
			JPanel test = new JPanel();
			test.setBackground(Color.CYAN);

			test.setBounds(x,y,106,78);
			
			playArea.add(test);
			
		}

		this.repaint();
		
		ArrayList<Brick> allBricks = playArea.getAllBricks();
		
		for(int i =0; i < allBricks.size(); i++) {
			
			Brick toMove = allBricks.get(i);
			
			toMove.setYLoc(toMove.getYLoc() + Brick.BRICK_HEIGHT + 2);
			
		}

		
		
	}

	public void actionPerformed(ActionEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	public static void main(String[] args)
	{

		new BrickBreaker();
	}

}

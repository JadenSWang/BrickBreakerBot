package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;

public class BrickBreaker extends JFrame implements ActionListener {

	private JLabel record;
	private JLabel score;
	private int curScore;

	private JPanel playArea; // area with all bricks and balls
	private JPanel[][] panelHolder;	//allows me to change specific elements of the grid
	
	
	public BrickBreaker() {

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
		
		playArea.setLayout(new GridLayout(8,6,2,2));
		
		panelHolder = new JPanel[8][6];    
		
		for(int row = 0; row < panelHolder.length; row++) {
		   for(int col = 0; col < panelHolder[0].length; col++) {
		      panelHolder[row][col] = new JPanel();
		      playArea.add(panelHolder[row][col]);
		   }
		}
		
		add(playArea);

		
		addRow();
		setVisible(true);

	}
	
	public void addRow() {
		
		int numNewBricks = (int) (Math.random()*4 + 2);
		
		ArrayList<Integer> possibleLocs = new ArrayList<Integer>( Arrays.asList(0,1,2,3,4,5));
		
		for(int i = 0; i < numNewBricks; i++) {
			
			int addLoc = possibleLocs.remove((int)(Math.random() * possibleLocs.size()));
			
			panelHolder[0][addLoc] = new Brick(curScore);
			
			
		}
		
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {

		new BrickBreaker();
	}

}

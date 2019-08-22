/*
 * File: StoplightGraphics.java
 * ----------------------------
 * This program illustrates the construction of a simple GUI using a
 * GraphicsProgram as the main class.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This class displays four buttons at the south edge of the window. Pressing a
 * button lights the indicated lamp in the stoplight or advances the stoplight
 * to its next configuration.
 */

public class TestDie extends GraphicsProgram {

	private Die die1;
	private Die die2;
	private JButton roll1;
	private JButton roll2;

	/** Initialize the buttons and create the stoplight */
	public void init() {
        //Your code starts here
		die1 = new Die(Color.green);
		die2 = new Die(Color.red);
		add(die1, getWidth() / 4, getHeight() / 2);
		add(die2, 3 * getWidth() / 4, getHeight() / 2);
		roll1 = new JButton("roll 1");
		roll2 = new JButton("roll 2");
		add(roll1,SOUTH);
		add(roll2,SOUTH);
		JButton reset = new JButton("reset");
		add(reset,SOUTH);
		showStatus("Roll dice");
		addActionListeners();
        //Your code ends here
	}

	/** Listen for a button action */
	public void actionPerformed(ActionEvent e) {
        //Your code starts here
		
		String st = e.getActionCommand();
		if(e.equals("roll 1")){
			die1.roll();
			roll1.setEnabled(false);
		} else if (e.equals("roll 2")){
			die2.roll();
			roll2.setEnabled(false);
		} else {
			die1.reset();
			die2.reset();
			roll1.setEnabled(true);
			roll2.setEnabled(true);
			showStatus("Roll dice");
			
		}
		if (die1.isRolled() && die2.isRolled()) {

			if (die1.getFace() > die2.getFace())
				showStatus("Player 1 wins with " + die1.getFace());
			else if (die1.getFace() < die2.getFace())
				showStatus("Player 2 wins with " + die2.getFace());
			else
				showStatus("This is a tie");
		}
	}

				
        //Your code ends here
	}


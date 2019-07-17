/*
 * File: RandomCard.java
 * ---------------------
 * This program displays the name of a card chosen at
 * random from a standard deck of 52 playing cards.
 */

import acm.program.*;
import acm.util.*;

public class RandomCard extends ConsoleProgram {

	public void run() {
		println("This program displays a randomly chosen card.");
		println(chooseRandomCard());
	}

	/* Returns the name of a randomly chosen card */
	private String chooseRandomCard() {
		return chooseRandomRank() + " of " + chooseRandomSuit();
	}

	/* Returns the name of a randomly chosen rank (Ace to King) */
	private String chooseRandomRank() {
		// Your code starts here
		int rank = rgen.nextInt(1, 13);
		switch (rank) {
		case 1: return "Ace";
		case 2: case 3: case 4: case 5: case 6:
		case 7: case 8: case 9: case 10: return "" + rank;
		case 11: return "Jack";
		case 12: return "Queen";
		case 13: return "King";
		default: return "Illegal suit value";
		}
		// Your code ends here
	}

	/* Returns the name of a randomly chosen suit (Clubs to Spades) */
	private String chooseRandomSuit() {
		// Your code starts here
		switch (rgen.nextInt(0, 3)) {
		case 0: return "Clubs";
		case 1: return "Diamonds";
		case 2: return "Hearts";
		case 3: return "Spades";
		default: return "Illegal suit value";
		}
		// Your code ends here
	}

	/* Private instance variables */
	private RandomGenerator rgen = RandomGenerator.getInstance();

}

/*
 * File: WeightConverter.java
 * ---------------------------------
 * This program converts a weight in kilograms to its
 * English equivalent in pounds and ounces.
 * 
 * Class: WeightConverter.java
 * Score: (Simple)
 * Prerequisites: ACM Task Force Commands
 */

import acm.program.*;

public class WeightConverter extends ConsoleProgram {

	public void run() {
		println("This program converts kilos to pounds and ounces.");
		double kg = readDouble("Enter weight in kilograms: ");
		double pounds = kg * POUNDS_PER_KILO;
		double ounces = pounds - (int)pounds;
		pounds = (int)pounds;
		ounces = ounces * OUNCES_PER_POUND;
		println(kg + " kg = " + pounds + " pounds + " + ounces + " ounces");
	}

	/* Private constants */
	private static final double POUNDS_PER_KILO = 2.2;
	private static final int OUNCES_PER_POUND = 16;

}

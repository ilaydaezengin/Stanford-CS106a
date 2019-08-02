/*
 * File: PhoneNumbers.java
 * -----------------------
 * This program takes a phone number and extracts information from it.
 */

import acm.program.*;

public class PhoneNumbers extends ConsoleProgram {

	public void run() {
		// Your code starts here
		while (true) {
			String phone = readLine("enter a phone number ");
			int l = phone.length();
			if (l == 0) break;
			String number = phone.substring(l-7, l);
			String areaCode = phone.substring(l-10, l-7);
			String countryCode = phone.substring(0, l-10);
			
			println("Country code " + getCountryCode(countryCode));
			println("Area code " + areaCode);
			println("Phone number " + number);
		}
		
		
		// Your code ends here
	}

	/** Returns country code for country calling code */
	private String getCountryCode(String countryCode) {

		if( countryCode.equals("+90") ) {
			return "TR";
		}
		else if( countryCode.equals("+1") ) {
			return "US";
		}
		else if( countryCode.equals("+44") ) {
			return "UK";
		}

		return "Unknown Country";
	}
}

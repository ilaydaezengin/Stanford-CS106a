/*
 * File: PhoneNumbers.java
 * -----------------------
 * This program takes a phone number and extracts information from it.
 */

import acm.program.*;

public class PhoneNumbersSoln extends ConsoleProgram {

	public void run() {
		// Your code starts here
		while (true) {
			String phone = readLine("Enter a phone number: ");
			int length = phone.length();
			if (length == 0) break;

			String number = phone.substring(length-7,length);
			String areaCode = phone.substring(length-10,length-7);
			String countryCallingCode = phone.substring(0,length-10);

			println("Country Code: "+getCountryCode(countryCallingCode));
			println("Country Calling Code: "+countryCallingCode);
			println("Area Code: "+areaCode);
			println("Number: "+number);
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

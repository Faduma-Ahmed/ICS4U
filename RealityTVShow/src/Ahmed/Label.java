
package Ahmed;

import java.util.Calendar;

/**
 * 
 * This is a reality TV show program that formats the contestant's information
 * and verifies their eligibility This class formats the users info
 * 
 * @author Faduma Ahmed Sept 28, 2015
 * 
 */

public class Label {

	/**
	 * Constructor: Auto generated
	 */

	public Label() {
		// TODO Auto-generated constructor stub

	}

	/**
	 *  object of contestant information
	 */
	private ContestantInformation ci1;
	/**
	 * String to hold all the concatenated information of the contestant
	 */
	private String output;

	/**
	 * Constructor: Uses the information from reality TV show to format into a
	 * label
	 */

	public Label(ContestantInformation ci) {
		this.ci1 = ci;

		formatName();
		formatAdress();
		formatBirth();
		formatPhoneNumber();
		formatGender();

	}

	/**
	 * The contestants information needs to be in the format:
	 *
	 * Smith, John
	 * 123 King Road South Pleasantville,
	 * ON A1A 1A1 
	 * (555) 555-5555
	 * 
	 */

	/**
	 * this formats the users first and last name
	 * 
	 * @return name of contestant
	 */
	private String formatName()

	{
		String name = ("\n" + ci1.getFirstName() + " " + ci1.getLastName());

		return name;

	}

	/**
	 * This formats the address as StreetNumber, StreetName and on another line with Province and Postal Code
	 * 
	 * @return address of contestant
	 */
	private String formatAdress()

	{
		return ("\n" + ci1.getApartmentNumber() + " " + ci1.getStreetAdress() + " \n" + ci1.getCity() + ", "
				+ ci1.getProvinceName() + "\n" + ci1.getPostalCode());

	}

	/**
	 * This formats the birth as Year and Age ( on seperate Lines)
	 * 
	 * @return birthdate of contestant
	 */

	private String formatBirth()

	{
		return ("\nBirth Year:" + ci1.getBirthDate() + " \nAge:" + ci1.getAge());

	}

	/**
	 * this formats the phone number as (555) 555-5555
	 * 
	 * @return phonenumber
	 */

	private String formatPhoneNumber()

	{
		String phoneNumber = ci1.getPhoneNumber();

		return ("\n" + "(" + phoneNumber.charAt(0) + phoneNumber.charAt(1) + phoneNumber.charAt(2) + ")"
				+ phoneNumber.charAt(3) + phoneNumber.charAt(4) + phoneNumber.charAt(5) + "-" + phoneNumber.charAt(6)
				+ phoneNumber.charAt(7) + phoneNumber.charAt(8) + phoneNumber.charAt(9));

	}

	/**
	 * this formats the gender
	 * 
	 * @return gender of contestant as F or M
	 */

	private String formatGender()

	{
		return ("\nGender: " + ci1.getGender());
	}

	/**
	 * this concatenates all the variables in the proper format
	 * 
	 * @return concatenated String of all users info
	 */

	public String toString()

	{
		return formatName() + formatAdress() + formatPhoneNumber() + formatBirth() + formatGender();
	}
}

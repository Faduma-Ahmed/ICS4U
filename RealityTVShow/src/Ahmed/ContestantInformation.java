package Ahmed;

/**
 * 
 * This is a reality TV show program that formats the contestant's information
 * and verifies their eligibility
 * 
 * @author Faduma Ahmed 
 * Sept 28 - november 11 , 2015
 * 
 */

@SuppressWarnings("rawtypes")
public class ContestantInformation implements Comparable {

	/**
	 * String of the first Name of the user
	 */
	private String firstName;
	/**
	 *  String of the the apartment of the user in which they reside
	 */
	private String apartmentNumber; 
	/**
	 * String of the street address  of the user in which they reside
	 */
	private String streetAdress;
	/**
	 *  String of the last name of the user
	 */
	private String lastName;
	/**
	 * String  of the city of the user in which they reside
	 */
	private String city;
	/**
	 *  String of the postal code of the user in which they reside
	 */
	private String postalCode;
	/**
	 * String of the phone number of the user
	 */
	private String phoneNumber;
	/**
	 * Province of the province of the user in which they reside
	 */
	private Province provinceName;
	/**
	 *  Integer of the age of the user
	 */
	private int ageNumber;
	/**
	 *  String of the birth date of the user
	 */
	private String birthDate;
	/**
	 *  String of the gender of the user as F or M
	 */
	private String gender;

	/**
	 * 
	 * Constructor: initializes all the parameters in the class
	 * ContestantInformation.
	 * 
	 * @param firstName
	 *            String of the first Name of the user
	 * @param lastName
	 *            String of the last name of the user
	 * @param ageNumber
	 *            Integer of the age of the user
	 * @param birthdate
	 *            String of the birth date of the user
	 * @param apartmentNumber
	 *            String of the the apartment of the user in which they reside
	 * @param streetAdress
	 *            String of the street address  of the user in which they reside
	 * @param city
	 *            String  of the city of the user in which they reside
	 * @param provinceName
	 *            Province of the province of the user in which they reside
	 * @param postalCode
	 *            String of the postal code of the user in which they reside
	 * @param phoneNumber
	 *            String of the phone number of the user 
	 * @param gender
	 *            String of the gender of the user as F or M
	 * @throws InvalidInputException if there is one of the variables in the constructor are null
	 * 
	 */

	public ContestantInformation(String firstName, String lastName, String apartmentNumber, String streetAdress,
			String city, Province provinceName, String postalCode, String phoneNumber, int birthdate, int ageNumber,
			String gender) throws InvalidInputException {

		setFirstName(firstName);
		setLastName(lastName);
		setapartmentNumber(apartmentNumber);
		setstreetAdress(streetAdress);
		setcity(city);
		setProvince(provinceName);
		setPostalCode(postalCode);
		setphoneNumber(phoneNumber);
		setbirthDate(birthdate);
		setageNumber(ageNumber);
		setGender(gender);

	}

	/**
	 *  Constructor for the class ContestantInformation. All the variables are initialized in order to prevent run-time errors
	 */

	@SuppressWarnings("unused")
	public ContestantInformation()

	{
		String firstName = " ";
		String lastName = " ";
		int ageNumber = 0;
		int birthdate = 0;
		String apartmentNumber = " ";
		String streetAdress = " ";
		String city = " ";
		Province provinceName = null;
		String postalCode = " ";
		String phoneNumber = " ";
		String gender = " ";

	}

	/**
	 * 
	 * This will receive and format the users info and will then use the
	 * information to check if they are valid. Then all this information will
	 * then be returned to toString where it will be formatted
	 * 
	 * @param String
	 *            firstName
	 * @param String
	 *            lastName
	 * @param int
	 *            age
	 * @param int
	 *            birthDate
	 * @param String
	 *            apartmentNumber
	 * @param String
	 *            streetName
	 * @param String
	 *            city
	 * @param Province
	 *            province
	 * @param String
	 *            postalCode
	 * @param String
	 *            phoneNumber
	 * @return String formattedInformation of all the users name concatenated
	 *         into one string;
	 */

	/**
	 * 
	 * Sets and formats the gender from the received information
	 * 
	 * @param gender
	 *            string value of F or M
	 * @throws InvalidInputException
	 *             if the gender is more than one digit
	 */
	public void setGender(String gender) throws InvalidInputException {

		if (gender.length() > 1)

		{
			throw new InvalidInputException("Your gender is only 1 digit");
		}

		this.gender = gender;

	}

	/**
	 * Sets and formats the contestant's First Name using the received
	 * information.
	 * 
	 * @param firstName
	 *            String
	 * @throws InvalidInputException
	 *             if the name contains any numbers
	 */
	public void setFirstName(String firstName) throws InvalidInputException {

		for (int i = 0; i < firstName.length(); i++) {
			if (Character.isDigit(firstName.charAt(i))) {
				throw new InvalidInputException("Your name can't contain any numbers");
			}
		}

		firstName = firstName.toUpperCase().charAt(0) + firstName.substring(1);
		this.firstName = firstName;
	}

	/**
	 * Sets and formats the contestant's Last Name using the received
	 * information.
	 * 
	 * @param lastName
	 *            String
	 * @throws InvalidInputException
	 *             if the name contains any numbers
	 */

	public void setLastName(String lastName) throws InvalidInputException {

		for (int i = 0; i < lastName.length(); i++) {
			if (Character.isDigit(lastName.charAt(i)) == true) {
				throw new InvalidInputException("Your name can't contain any numbers");
			}
		}

		lastName = lastName.toUpperCase().charAt(0) + lastName.substring(1);
		this.lastName = lastName;
	}

	/**
	 * Initializes the contestant's age
	 * 
	 * @param ageNumber
	 *           Integer
	 * @throws InvalidInputException
	 *             if they are less than 18
	 */

	public void setageNumber(int ageNumber) throws InvalidInputException

	{

		if (ageNumber < 18) {
			throw new InvalidInputException("You need to be older than 18");
		}

		this.ageNumber = ageNumber;
	}

	/**
	 * sets the contestant's birth date to whatever was given.
	 * 
	 * @param birthDate
	 *            String
	 * @throws InvalidInputException
	 *             if their birth date has more 4 numbers
	 */

	public void setbirthDate(int birthDate) throws InvalidInputException

	{
		if (birthDate > 9999)

		{
			throw new InvalidInputException("Your birth year can only be 4 numbers ");
		}

		this.birthDate = "" + (birthDate);

	}

	/**
	 * Formats and verifies the contestant's apartment number
	 * 
	 * @param apartmentNumber
	 *            String
	 * @throws InvalidInputException
	 *             if the name contains any numbers
	 */
	public void setapartmentNumber(String apartmentNumber) throws InvalidInputException

	{
		for (int i = 0; i < apartmentNumber.length(); i++) {
			if (!Character.isDigit(apartmentNumber.charAt(i))) {
				throw new InvalidInputException("Your apartment number can't contain any letters");
			}
		}
		this.apartmentNumber = apartmentNumber;
	}

	/**
	 * Formats the contestant's street name.
	 * 
	 * @param streetAdress
	 *            String
	 * @throws InvalidInputException
	 *             if the name contains any numbers
	 */
	public void setstreetAdress(String streetAdress) throws InvalidInputException {

		for (int i = 0; i < streetAdress.length(); i++) {
			if (Character.isDigit(streetAdress.charAt(i))) {
				throw new InvalidInputException("Youstreet number cant contain any numbers");
			}
		}

		streetAdress = streetAdress.toUpperCase().charAt(0) + streetAdress.substring(1);
		this.streetAdress = streetAdress;
	}

	/**
	 * Formats the contestant's city.
	 * 
	 * @param city
	 *            String
	 * @throws InvalidInputException
	 *             if the name contains any numbers
	 */
	public void setcity(String city) throws InvalidInputException {
		for (int i = 0; i < city.length(); i++) {
			if (Character.isDigit(city.charAt(i))) {
				throw new InvalidInputException("Your city name cant contain any numbers");
			}
		}
		city = city.toUpperCase().charAt(0) + city.substring(1);
		this.city = city;
	}

	/**
	 * Formats and verifies the contestant's province.
	 * 
	 * @param provinceName
	 *            Province
	 * @throws InvalidInputException
	 *             if they dont have the proper canadian province or territory
	 */
	public void setProvince(Province provinceName) throws InvalidInputException

	{

		this.provinceName = provinceName;
	}

	/**
	 * Receives and verifies the contestant's postal code.
	 * 
	 * @param postalCode
	 *            String
	 * @throws InvalidInputException
	 *             if postal code is not in the format Y#Y#Y#
	 */

	public void setPostalCode(String postalCode) throws InvalidInputException

	{
		for (int i = 0; i < postalCode.length(); i += 2) {
			if (Character.isDigit(postalCode.charAt(i))) {
				throw new InvalidInputException("Your postal code needs to be in the format Y#Y#Y#");
			}
		}

		for (int i = 1; i < postalCode.length(); i += 2) {
			if (!Character.isDigit(postalCode.charAt(i))) {
				throw new InvalidInputException("Your postal code needs to be in the format Y#Y#Y#");
			}
		}

		this.postalCode = postalCode;
	}

	/**
	 * Formats the contestant's phone number.
	 * 
	 * @param phoneNumber
	 *            String
	 * @throws InvalidInputException
	 *             if phone number has letters
	 */
	public void setphoneNumber(String phoneNumber) throws InvalidInputException

	{

		
		if(!(phoneNumber.length()==10))
				
				throw new InvalidInputException("Your phone number must be 10 digits");	
		
		for (int i = 1; i < phoneNumber.length(); i += 2) {
			if (!Character.isDigit(phoneNumber.charAt(i))) {
				throw new InvalidInputException("Your phone number cant contain any letters");
			}
		}

		this.phoneNumber = phoneNumber;
	}

	/**
	 *
	 * Get the contestant's first name.
	 * 
	 * @return FirstName String
	 * 
	 */

	public String getFirstName()

	{
		return this.firstName;
	}

	/**
	 *
	 * Get the contestant's Last name.
	 * 
	 * @return LastName String
	 */

	public String getLastName()

	{
		return this.lastName;

	}

	/**
	 *
	 * Get the contestant's Age.
	 * 
	 * @return age Int
	 */

	public int getAge()

	{
		return this.ageNumber;

	}

	/**
	 * 
	 * Get the contestants gender
	 * 
	 * @return gender String as F or M
	 */
	public String getGender()

	{
		return this.gender;
	}

	/**
	 *
	 * Get the contestant's ApartmentNumber.
	 * 
	 * @return ApartmentNumber String
	 */

	public String getApartmentNumber()

	{
		return this.apartmentNumber;

	}

	/**
	 *
	 * Get the contestant's Street Address.
	 * 
	 * @return StreetAdress String
	 */

	public String getStreetAdress()

	{
		return this.streetAdress;

	}

	/**
	 *
	 * Get the contestant's City.
	 * 
	 * @return City String
	 */

	public String getCity()

	{
		return this.city;

	}

	/**
	 *
	 * Get the contestant's Province.
	 * 
	 * @return ProvinceName Province as one of the variables from the enum
	 */

	public Province getProvinceName()

	{
		return this.provinceName;

	}

	/**
	 *
	 * Get the contestant's Postal Code
	 * 
	 * @return PostalCode String
	 */

	public String getPostalCode()

	{
		return this.postalCode;

	}

	/**
	 *
	 * Get the contestant's Birth Date
	 * 
	 * @return BirthDate Calendar
	 */

	public String getBirthDate()

	{
		return this.birthDate;

	}

	/**
	 *
	 * Get the contestant's Phone Number
	 * 
	 * @return PhoneNumber String
	 */

	public String getPhoneNumber()

	{
		return this.phoneNumber;

	}

	/** 
	 * Override toString()
	 * 
	 * @return all concatenated variables from contestant info
	 */

	public String toString()

	{

		return (firstName + " " + lastName + " " + ageNumber + " " + birthDate + " " + apartmentNumber + " "
				+ streetAdress + " " + city + " " + provinceName + " " + postalCode + " " + phoneNumber);

	}

	/**
	 * 
	 * Override equals() and returns true if the first and the last name of the
	 * contestant match the target
	 * 
	 */

	
	public boolean equals(ContestantInformation ci) {

		if (ci.getFirstName().equals(this.firstName) && (ci.getLastName().equals(this.lastName))) {
			return true;
		}

		return false;

	}

	/**
	 * 
	 * Override compareTo() return a number depending on if the user first name
	 * and last name matches the target
	 * @see java.lang.Comparable#compareTo(java.lang.Object) 
	 */

	
	public int compareTo(Object arg0) {

		ContestantInformation ci = (ContestantInformation) arg0;
		if (ci.getFirstName().compareTo(this.firstName) == 0) {
			return 0;

		}

		else if (ci.getFirstName().compareTo(this.firstName) > 0) {
			return 1;

		}

		else // ( ci.getFirstName().compareTo(ci2.getFirstName()) < 0)
		{
			return -1;
		}

	}

}
			
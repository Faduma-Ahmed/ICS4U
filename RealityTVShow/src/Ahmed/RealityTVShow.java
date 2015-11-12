package Ahmed;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

/**
 * 
 *
 * This is a reality TV show program that formats the contestant's information
 * and verifies their eligibility This is the main class to controll all of the
 * users desired settings
 * 
 * @author Faduma Ahmed 
 * Sept 28 - november 11 , 2015
 * 
 *
 */

public class RealityTVShow {

	/**
	 * auto generated constructor
	 */
	public RealityTVShow() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * This method sorts the users information in the array list
	 * 
	 * @param contestants ArrayList<ContestantInformation>
	 *            arraylist of user informations
	 */
	@SuppressWarnings("unchecked")
	public static void sortContestants(ArrayList<ContestantInformation> contestants)

	{
		Collections.sort(contestants);

	}

	/**
	 *
	 * This method saves the users information to a file
	 * 
	 * @param contestants ArrayList<ContestantInformation>  arrayList of user informations
	 * @throws FileNotFoundException
	 *             if the file can't be reached or found or created
	 */
	public static void saveContestants(ArrayList<ContestantInformation> contestants)

	{

		// Scanner myInput = new Scanner(System.in);

		try {

			FileOutputStream fileOutputStream = new FileOutputStream("contestantsfile.txt");
			PrintStream filePrint = new PrintStream(fileOutputStream);
			filePrint.println(contestants.size());

			for (int i = 0; i < contestants.size(); i++) {

				filePrint.println(contestants.get(i).getFirstName());
				filePrint.println(contestants.get(i).getLastName());
				filePrint.println(contestants.get(i).getApartmentNumber());
				filePrint.println(contestants.get(i).getStreetAdress());
				filePrint.println(contestants.get(i).getCity());
				filePrint.println(contestants.get(i).getProvinceName());
				filePrint.println(contestants.get(i).getPostalCode());
				filePrint.println(contestants.get(i).getPhoneNumber());
				filePrint.println(contestants.get(i).getBirthDate());
				filePrint.println(contestants.get(i).getAge());
				filePrint.println(contestants.get(i).getGender());

				fileOutputStream.close();

			}

		} catch (FileNotFoundException fileExceptionNotFound) {
			System.out.println(
					"if the file exists but is a directory rather than a regular file, does not exist but cannot be created, or cannot be opened for any other reason");

		} catch (IOException inputOutputException)

		{
			System.out.println(" Sorry, but the input operation to save the contestants failed");
		}

	}

	/**
	 *
	 * This method loads the users information to a file
	 * 
	 * @param contestants
	 * @throws InvalidInputException
	 *             if the uses informations doesn't follow the format
	 * @throws FileNotFoundException
	 *             if the information file can't be derived or created or the
	 *             directory isn't working
	 */
	@SuppressWarnings("resource")
	public static void loadContestants(ArrayList<ContestantInformation> contestants)

	{

		Scanner myInput = new Scanner(System.in);
		try {
			BufferedReader file = new BufferedReader(new FileReader("contestantsfile.txt"));
			try {
				int size = Integer.parseInt(file.readLine());
				for (int i = 0; i < size; i++) {
					String firstName = file.readLine();
					String lastName = file.readLine();
					String apartmentNumber = file.readLine();
					String streetAdress = file.readLine();
					String city = file.readLine();
					String provinceName = file.readLine();
					Province province = null;

					if (provinceName.equalsIgnoreCase("ON") || provinceName.equalsIgnoreCase("Ontario")) {
						province = (Province.ON);
					}

					else if (provinceName.equalsIgnoreCase("NL")
							|| provinceName.equalsIgnoreCase("Newfoundland and Labrador")) {
						province = (Province.NL);
					}

					else if (provinceName.equalsIgnoreCase("NS") || provinceName.equalsIgnoreCase("Nova Scotia")) {
						province = (Province.NS);
					}

					else if (provinceName.equalsIgnoreCase("NB") || provinceName.equalsIgnoreCase("NewBrunswick")) {
						province = (Province.NB);
					}

					else if (provinceName.equalsIgnoreCase("QC") || provinceName.equalsIgnoreCase("Quebec")) {
						province = (Province.QC);
					}

					else if (provinceName.equalsIgnoreCase("MB") || provinceName.equalsIgnoreCase("Manitoba")) {
						province = (Province.MB);
					}

					else if (provinceName.equalsIgnoreCase("SK") || provinceName.equalsIgnoreCase("Saskatchewan")) {
						province = (Province.SK);
					} else if (provinceName.equalsIgnoreCase("AB") || provinceName.equalsIgnoreCase("Alberta")) {
						province = (Province.AB);
					} else
						if (provinceName.equalsIgnoreCase("BC") || provinceName.equalsIgnoreCase("British Colombia")) {
						province = (Province.BC);
					} else if (provinceName.equalsIgnoreCase("YT") || provinceName.equalsIgnoreCase("Yukon")) {
						province = (Province.YT);
					} else if (provinceName.equalsIgnoreCase("NT")
							|| provinceName.equalsIgnoreCase("Northwest Territories")) {
						province = (Province.NT);
					}

					else if (provinceName.equalsIgnoreCase("NU") || provinceName.equalsIgnoreCase("Nunavut")) {
						province = (Province.NU);
					}

					String postalCode = file.readLine();
					String phoneNumber = file.readLine();

					String birthDate1 = file.readLine();
					int birthDate = Integer.parseInt(birthDate1.trim());

					String age1 = file.readLine();

					int age = Integer.parseInt(age1.trim());

					String gender = file.readLine();

					// Add the variables in the constructor of the object

					try {
						ContestantInformation contestant = new ContestantInformation(firstName, lastName,
								apartmentNumber.trim(), streetAdress, city, province, postalCode, phoneNumber,
								birthDate, age, gender);
						contestants.add(contestant);
					}

					catch (InvalidInputException invalidInputException)

					{

						invalidInputException.printStackTrace();

						System.out.println(
								"Sorry but there was a problem with the format of the contestants information.");
					}

				}
			}

			catch (IOException inputOutputException)

			{
				System.out.println(" Sorry, but the output operation to load the contestants failed");
			}
		} catch (FileNotFoundException fileNotFoundException)

		{

			System.out.println(
					"if the file exists but is a directory rather than a regular file, does not exist but cannot be created, or cannot be opened for any other reason");

		}

	}

	/**
	 *
	 * This method gives the user the option of deleting a specific contestant
	 * or the entire array list of contestants
	 * 
	 * @param contestants ArrayList<ContestantInformation>
	 *            arrayList of user informations
	 */
	public static void deleteContestants(ArrayList<ContestantInformation> contestants)

	{

		Scanner myInput = new Scanner(System.in);

		System.out.println(
				"Would you like to \n1.delete a specific item  \n2.delete all contestants. \n please enter a number as your answer. ");
		int answer = myInput.nextInt();
		String extra = myInput.nextLine();

		// selection statements to search and delete a specific contestant
		if (answer == 1) {
			System.out.println("\nPlease enter the first name of the contestant you wish to find");
			String firstName = myInput.nextLine();
			System.out.println("\nPlease enter the last name of the contestant you wish to find");
			String lastName = myInput.nextLine();
			int output = Search.binarySearch(contestants, firstName, lastName);

			System.out.println(" \nThe contestant you were searching for was found at index " + output
					+ " . they will now be deleted");
			contestants.remove(output);
		}

		// selection statement to delete all conestants

		else if (answer == 2)

		{
			contestants.removeAll(contestants);
		}

	}

	/**
	 * 
	 * this method searches for a specific contestant(via binary or linear
	 * search) within an ArrayList
	 * 
	 * @param contestants ArrayList<ContestantInformation>
	 *            arrayList of user informations
	 */
	public static void searchContestants(ArrayList<ContestantInformation> contestants) {
		Scanner myInput = new Scanner(System.in);
		System.out.println(" Would you like to search  the contestant via \n1.Binary Search \n2.LinearSearch");

		int answer = myInput.nextInt();
		String extra = myInput.nextLine();
		if (answer == 1) {
			System.out.println("Please enter the first name of the contestant you wish to find");

			String firstName = myInput.nextLine();

			System.out.println("Please enter the last name of the contestant you wish to find");

			String lastName = myInput.nextLine();
			int output = Search.binarySearch(contestants, firstName, lastName);

			if (output != -1)

				System.out.println(" \nThe contestant you were searching for was found at index " + output + " ");

			else
				System.out.println("\nSorry! The contestant you were searching for was not found");
		}

		else if (answer == 2)

		{
			System.out.println("\nPlease enter the first name of the contestant you wish to find");
			String firstName = myInput.nextLine();
			System.out.println("\nPlease enter the last name of the contestant you wish to find");
			String lastName = myInput.nextLine();
			int output = Search.linearSearch(contestants, firstName, lastName);

			if (output != -1)

				System.out.println(" \nThe contestant you were searching for was found at index " + output + " ");

			else
				System.out.println("\nSorry! The contestant you were searching for was not found");
		}

	}

	/**
	 * this method prints the conestants that have been stored in the array list
	 * 
	 * @param contestants ArrayList<ContestantInformation>
	 *            arrayList of user informations
	 */
	public static void printContestants(ArrayList<ContestantInformation> contestants) {

		for (int i = 0; i <= contestants.size() - 1; i++) {

			Label label = new Label(contestants.get(i));

			System.out.println(label.toString());
		}
	}

	/**
	 * 
	 * this method adds a new contestant into the array list
	 * 
	 * @param contestants ArrayList<ContestantInformation>
	 *            arrayList of user informations
	 */

	public static void addContestant(ArrayList<ContestantInformation> contestants) {

		boolean answer = true;

		// creates a new object
		ContestantInformation contestant1 = new ContestantInformation();

		Scanner myInput = new Scanner(System.in);

		boolean flag;

		System.out.println("Welcome new contestant \nPlease Enter all the following Information in the correct format");

		do {

			flag = true;

			// this try method sees if the name had no numbers
			try {
				System.out.println("Please Enter Your First Name");
				String firstName = myInput.nextLine();
				contestant1.setFirstName(firstName);
				flag = false;
			}

			// it will print out an exception is there is a digit found in the
			// name
			catch (InvalidInputException firstNameException) {
				System.out.println(firstNameException.getMessage());
				flag = true;
			}

		} while (flag);

		do {

			flag = true;
			// this try method sees if the name had no numbers
			try {
				System.out.println("Please Enter Your  Last Name");
				String lastName = myInput.nextLine();
				contestant1.setLastName(lastName);
				flag = false;
			}
			// it will print out an exception is there is a digit found in the
			// name
			catch (InvalidInputException lastNameException) {
				System.out.println(lastNameException.getMessage());
				flag = true;
			}

		} while (flag);

		do {

			flag = true;
			// this try method sees if the name had no letters
			try {
				System.out.println("Please Enter Your Apartment/House Number");
				String apartmentNumber = myInput.nextLine();
				contestant1.setapartmentNumber(apartmentNumber);
				flag = false;
			}
			// it will print out an exception is there is a letter found in the
			// name
			catch (InvalidInputException apartmentNumberException) {
				System.out.println(apartmentNumberException.getMessage());
				flag = true;
			}

		} while (flag);

		do {

			flag = true;

			// this try method sees if the name had no numbers
			try {
				System.out.println("Please Enter Your Street Name");
				String streetAdress = myInput.nextLine();
				contestant1.setstreetAdress(streetAdress);
				flag = false;
			}
			// it will print out an exception is there is a digit found in the
			// name
			catch (InvalidInputException streetAdressException) {
				System.out.println(streetAdressException.getMessage());
				flag = true;
			}

		} while (flag);

		do {

			flag = true;

			// this try method sees if the name had no numbers
			try {
				System.out.println("Please Enter the name of your city");
				String city = myInput.nextLine();
				contestant1.setcity(city);
				flag = false;
			}

			// it will print out an exception is there is a digit found in the
			// name
			catch (InvalidInputException cityException) {
				System.out.println(cityException.getMessage());
				flag = true;
			}

		} while (flag);

		do {

			flag = true;

			// sets the users info as a province name (one from the variable
			// made in the enum province)

			try {
				System.out.println("Please Enter Province Name in the abbreviation format ex.AB");
				String provinceName = myInput.nextLine();

				if (provinceName.equalsIgnoreCase("ON") || provinceName.equalsIgnoreCase("Ontario")) {
					contestant1.setProvince(Province.ON);
				}

				else if (provinceName.equalsIgnoreCase("NL")
						|| provinceName.equalsIgnoreCase("Newfoundland and Labrador")) {
					contestant1.setProvince(Province.NL);
				}

				else if (provinceName.equalsIgnoreCase("NS") || provinceName.equalsIgnoreCase("Nova Scotia")) {
					contestant1.setProvince(Province.NS);
				}

				else if (provinceName.equalsIgnoreCase("NB") || provinceName.equalsIgnoreCase("NewBrunswick")) {
					contestant1.setProvince(Province.NB);
				}

				else if (provinceName.equalsIgnoreCase("QC") || provinceName.equalsIgnoreCase("Quebec")) {
					contestant1.setProvince(Province.QC);
				}

				else if (provinceName.equalsIgnoreCase("MB") || provinceName.equalsIgnoreCase("Manitoba")) {
					contestant1.setProvince(Province.MB);
				}

				else if (provinceName.equalsIgnoreCase("SK") || provinceName.equalsIgnoreCase("Saskatchewan")) {
					contestant1.setProvince(Province.SK);
				} else if (provinceName.equalsIgnoreCase("AB") || provinceName.equalsIgnoreCase("Alberta")) {
					contestant1.setProvince(Province.AB);
				} else if (provinceName.equalsIgnoreCase("BC") || provinceName.equalsIgnoreCase("British Colombia")) {
					contestant1.setProvince(Province.BC);
				} else if (provinceName.equalsIgnoreCase("YT") || provinceName.equalsIgnoreCase("Yukon")) {
					contestant1.setProvince(Province.YT);
				} else
					if (provinceName.equalsIgnoreCase("NT") || provinceName.equalsIgnoreCase("Northwest Territories")) {
					contestant1.setProvince(Province.NT);
				}

				else if (provinceName.equalsIgnoreCase("NU") || provinceName.equalsIgnoreCase("Nunavut")) {
					contestant1.setProvince(Province.NU);
				} else {
					throw new InvalidInputException("Sorry, that could not be found. Please try again ex.AB");

				}
				flag = false;

			}
			// will print out a message if there is no respective variable for
			// their given input
			catch (InvalidInputException provinceException) {
				System.out.println(provinceException.getMessage());
				flag = true;
			}

		}

		while (flag);

		do {

			flag = true;

			// checks if the postal code is in the correct format

			try {
				System.out.println("Please Enter your postal code");
				String postalCode = myInput.nextLine();
				contestant1.setPostalCode(postalCode);
				flag = false;
			}

			// will print out a message if they do not input the postal code in
			// the correct format
			catch (InvalidInputException postalCodeException) {
				System.out.println(postalCodeException.getMessage());
				flag = true;
			}

		} while (flag);

		do {

			flag = true;

			// checks if the phone number is in the correct format
			try {
				System.out.println("Please your phone Number");
				String phoneNumber = myInput.nextLine();
				contestant1.setphoneNumber(phoneNumber);

				flag = false;
			}

			// throws an error message if the phone number isn't in the correct
			// format
			catch (InvalidInputException phoneNumberException) {
				System.out.println(phoneNumberException.getMessage());
				flag = true;
			}

		} while (flag);

		do {

			flag = true;

			// checks if the user is older than 18 and that their inputted birth
			// year was in the correct format
			try {
				System.out.println("Please enter  your birth Year");
				int birthDate = Integer.parseInt(myInput.nextLine());
				contestant1.setbirthDate(birthDate);
				int verify = 2015 - birthDate;
				if (verify < 18)

				{
					flag = true;
					throw new InvalidInputException(" You need to be older than 18");
				}

				flag = false;
			}
			// throws an error message if they are less than 18 years
			catch (InvalidInputException birthDateException) {
				System.out.println(birthDateException.getMessage());
				flag = true;
			}

		} while (flag);

		do {

			flag = true;
			// checks if they user is older than 18
			try {
				System.out.println("Please your current age");
				String age = myInput.nextLine();
				contestant1.setageNumber(Integer.parseInt(age));

				flag = false;
			}

			// throws an error message if they are less than 18

			catch (InvalidInputException ageException) {
				System.out.println(ageException.getMessage());
				flag = true;
			}

		} while (flag);

		do {

			flag = true;
			// checks if they user is male or female
			try {
				System.out.println("Please your gender as F for Female or M for Male");
				String gender = myInput.nextLine();
				contestant1.setGender(gender);

				flag = false;
			}

			// throws an error message if they user doesnt write F or M

			catch (InvalidInputException genderException) {
				System.out.println(genderException.getMessage());
				flag = true;
			}

		} while (flag);

		int x = 0;
		// a critical thinking question

		do

		{
			System.out.println(
					" Please answer this critical thinking question : \n What is the last letter in the greek alphabet?");

			String criticalthinking = myInput.nextLine();

			if (criticalthinking.equalsIgnoreCase("Omega")) {
				System.out.println("You are correct!");
				x = 1;
			}
		} while (x == 0);

		Label label = new Label(contestant1);
		// print out the contestants Information

		System.out.println(label.toString());

		contestants.add(contestant1);

	}

	public static void main(String[] args) {

		// this is a main method that gives the user the option of adding a
		// contestant, searching a contestant and printing a contestant

		Scanner myInput = new Scanner(System.in);

		ArrayList<ContestantInformation> contestants = new ArrayList<ContestantInformation>();

		String options;

		do {

			System.out.println(
					"\n \n Welcome to the reality TV show game, Please choose from the following options \n1. Add a contestant \n2. search for a contestant \n3. Print contestant information \n4. Save the contestants \n5.Load all previous contestants to a text file \n6.Sort the contestants \n7.Delete Contestant Information \n8.Exit");

			options = myInput.nextLine();

			if (options.equals("1") || options.equalsIgnoreCase("one")) {
				addContestant(contestants);

			}

			else if (options.equals("2") || options.equalsIgnoreCase("two")) {

				searchContestants(contestants);

			}

			else if (options.equals("3") || options.equalsIgnoreCase("three")) {

				printContestants(contestants);

			}

			else if (options.equals("4") || options.equalsIgnoreCase("four")) {

				saveContestants(contestants);
			}

			else if (options.equals("5") || options.equalsIgnoreCase("five")) {

				loadContestants(contestants);

			}

			else if (options.equals("6") || options.equalsIgnoreCase("six")) {

				sortContestants(contestants);

			}

			else if (options.equals("7") || options.equalsIgnoreCase("seven")) {

				deleteContestants(contestants);

			}

		} while (!options.equalsIgnoreCase("eight") && !options.equals("8"));

		System.exit(0);

	}
}

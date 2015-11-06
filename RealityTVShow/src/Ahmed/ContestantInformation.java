package Ahmed;



import java.util.*;


/**
 * 
 * @author Faduma Ahmed
 * 
 *  Sept 28, 2015 
 * This is a reality TV show program that formats the contestant's information and verifies their eligibility
 *
 */

@SuppressWarnings("rawtypes")
public class ContestantInformation implements Comparable {


	private String firstName, apartmentNumber,streetAdress,lastName, city, postalCode,phoneNumber;
    private Province provinceName;
 	private int ageNumber;
    private String birthDate;
    private String gender;


	/**
	 * 
	 * Constructor: initializes all the parameters in the class ContestantInformation. 
	 * @param  String firstName
	 * @param String lastName
	 * @param int age
	 * @param String birthDate
	 * @param String apartmentNumber
	 * @param String streetName
	 * @param String city
	 * @param Province province
	 * @param String postalCode
	 * @param String phoneNumber
	 * @param String gender
	 * @throws InvalidInputException 
	 * 
	 */

	public ContestantInformation(String firstName, String lastName, int ageNumber, int birthdate, String apartmentNumber, String streetAdress, String city, Province provinceName, String postalCode, String phoneNumber, String gender ) throws InvalidInputException
		{

			setFirstName(firstName);
			setLastName(lastName);
			setageNumber(ageNumber);
			setbirthDate(birthDate);
			setapartmentNumber(apartmentNumber);
			setstreetAdress(streetAdress);
			setcity(city);
			setProvince(provinceName);
			setPostalCode(postalCode);
			setphoneNumber(phoneNumber);
			setGender(gender);
			
		}


	/**
	 * Second Constructor for the class ContestantInformation.
	 */
	
       @SuppressWarnings("unused")
	public ContestantInformation()

	 {
    	   String firstName = " ";
    	   String lastName = " ";
    	   int ageNumber =0;
    	   int birthdate = 0;
    	   String apartmentNumber = " ";
    	   String streetAdress = " ";
    	   String city = " ";
    	   Province provinceName= null;
    	   String postalCode= " ";
    	   String phoneNumber = " ";
    	   String gender = " ";
	
	 }
   
	/**
	 * 
	 * This will receive and format the users info and will then use the information to check if they are valid. Then all this information will then be returned to toString where it will be formatted
	 * @param  String firstName
	 * @param String lastName
	 * @param int age
	 * @param int birthDate
	 * @param String apartmentNumber
	 * @param String streetName
	 * @param String city
	 * @param Province province
	 * @param String postalCode
	 * @param  String phoneNumber
	 * @return String formattedInformation;
	 */

	


	
     /**
     * 
     * Sets and formats the gender from the received information
     * @param gender
     * @throws InvalidInputException
     */
    public void setGender (String gender)throws InvalidInputException
       {
	  
        if (gender.length()>1)
        	
        {
        	throw new InvalidInputException ("Your gender is only 1 digit");
        }
        
        this.gender=gender;
       
       
       }
	
       
       /**
   	 *  Sets and formats the contestant's First Name using the received information.
   	 *   
   	 * @param  String firstName
   	 * @throws InvalidInputException
   	 */
       public void setFirstName(String firstName) throws InvalidInputException
		{
		
		for (int i = 0; i<firstName.length(); i++) {
			if (Character.isDigit(firstName.charAt(i)))
			 {
				throw new InvalidInputException ("Your name can't contain any numbers");
			 }
		}

		firstName = firstName.toUpperCase().charAt(0) + firstName.substring(1);
		this.firstName = firstName;
	    }

	/**
	 *  Sets and formats the contestant's Last Name using the received information.
	 *   
	 * @param String lastName
	 * @throws InvalidInputException
	 */

	public void setLastName(String lastName) throws InvalidInputException
		 {
		
		for (int i = 0; i<lastName.length(); i++)
		{
			if (Character.isDigit(lastName.charAt(i)) == true)
			 {
				throw new InvalidInputException ("Your name can't contain any numbers");
			 }
		 }

		 	lastName = lastName.toUpperCase().charAt(0) + lastName.substring(1);
		 	this.lastName = lastName;
       	}

	/**
	 * Initializes the contestant's age 
	 * 
	 * @param int AgeNumber
	 * @throws InvalidInputException
	 */

	public void setageNumber(int ageNumber) throws InvalidInputException
		 
		{
		
			if (ageNumber<18)
	        {
				throw new InvalidInputException ("You need to be older than 18");
	        }
		
			this.ageNumber = ageNumber;
	   }


     /**
	 *  sets the contestant's birth date to whatever was given.
	 * @param  String birthDate
	 * @throws InvalidInputException
	 */

	public void setbirthDate(String birthDate) throws InvalidInputException
           
	{
		if (birthDate.length()>5)
			
		{
			throw new InvalidInputException ("Your birth year can only be 4 numbers ");
		}
		
		
		 this.birthDate= birthDate;
		 
		}
	

	/**
	 * Formats  and verifies the contestant's apartment number
	 * @param  String apartmentNumber
	 * @throws InvalidInputException 
	 */
	public void setapartmentNumber(String apartmentNumber) throws InvalidInputException
		 
	{
		for (int i = 0; i<apartmentNumber.length(); i++) 
		{
			if (!Character.isDigit(apartmentNumber.charAt(i)))
			 {
				throw new InvalidInputException ("Your apartment number can't contain any letters");
			 }
		}
				this.apartmentNumber = apartmentNumber;
	 }
	
	/**
	 * Formats the contestant's street name.
	 * @param String StreetAdress
	 * @throws InvalidInputException
	 */
	public void setstreetAdress (String streetAdress) throws InvalidInputException
		{
		
		for (int i = 0; i<streetAdress.length(); i++)
	    {
			if (Character.isDigit(streetAdress.charAt(i))) 
			{
				throw new InvalidInputException ("Youstreet number cant contain any numbers");
			}
		}
		
		streetAdress = streetAdress.toUpperCase().charAt(0) + streetAdress.substring(1);
		this.streetAdress = streetAdress;
	}
	
	/**
	 *Formats the contestant's city.
	 * @param String city
	 * @throws InvalidInputException
	 */
	public void setcity(String city) throws InvalidInputException
	{
		for (int i = 0; i<city.length(); i++) 
		{
			if (Character.isDigit(city.charAt(i))) 
			{
				throw new InvalidInputException ("Your city name cant contain any numbers");
			}
		}
			city = city.toUpperCase().charAt(0) + city.substring(1);
			this.city = city;
	}
	/**
	 * Formats and verifies the contestant's province.
	 * @param  Province ProvinceName
	 * @throws InvalidInputException
	 */
	public void setProvince (Province provinceName)throws InvalidInputException 
               
	{
		
		this.provinceName = provinceName;
	}
	/**
	 * Receives and verifies the contestant's postal code.
	 * @param  String postalCode
	 * @throws InvalidInputException
	 */

	public void setPostalCode(String postalCode) throws InvalidInputException
             
	
	{
		    for (int i = 0; i<postalCode.length(); i+=2)
		{
			  if (Character.isDigit(postalCode.charAt(i))) 
			{
				throw new InvalidInputException ("Your postal code needs to be in the format Y#Y#Y#");
			}
		}
		
		
	    for (int i = 1; i<postalCode.length(); i+=2) 
	    {
			if (!Character.isDigit(postalCode.charAt(i))) 
			{
				throw new InvalidInputException ("Your postal code needs to be in the format Y#Y#Y#");
			}
		}

		this.postalCode = postalCode;
	   }


        
    /**
	 * Formats the contestant's phone number.
	 * @param String phoneNumber
	 * @throws InvalidInputException
	 */
	public void setphoneNumber(String phoneNumber) throws InvalidInputException
	
	{
		
	     for (int i = 1; i<phoneNumber.length(); i+=2)
		 {
			if (!Character.isDigit(phoneNumber.charAt(i))) 
			{
				throw new InvalidInputException ("Your phone number cant cotain any letters");
			}
		}

		this.phoneNumber = ( "(" + phoneNumber.charAt(0) + phoneNumber.charAt(1) +phoneNumber.charAt(2) + ") " + phoneNumber.charAt(3) +phoneNumber.charAt(4) +phoneNumber.charAt(5) + "-" + phoneNumber.charAt(6) +phoneNumber.charAt(7) +phoneNumber.charAt(8)+phoneNumber.charAt(9) );
	}

    /**
	 *
	 * Get : the contestant's first name.
	 * @return  String FirstName
	 * 
	 */

	public String getFirstName() 

	{
		return this.firstName;
	}
	
	/**
	 *
	 * Get : the contestant's Last name.
	 * @return String LastName
	 */

	public String getLastName() 

	{
             return this.lastName;

	}

	/**
	 *
	 * Get : the contestant's Age.
	 * @return Int age
	 */

	public int getAge() 

	{
             return this.ageNumber;

	}
	
	 
	
	/**
	 * 
	 * Get: the contestants gender
	 * @return String gender
	 */
	public String getGender()
	 
	 {
		 return this.gender;
	 }

	/**
	 *
	 * Get : the contestant's ApartmentNumber.
	 * @return String ApartmentNumber
	 */

	public String getApartmentNumber() 

	{
             return this.apartmentNumber;

	}

	/**
	 *
	 * Get : the contestant's Street Address.
	 * @return  String  StreetAdress
	 */

	public String getStreetAdress() 

	{
             return this.streetAdress;

	}

	/**
	 *
	 * Get : the contestant's City.
	 * @return String  City
	 */

	public String getCity() 

	{
             return this.city;

	}

	/**
	 *
	 * Get : the contestant's Province.
	 * @return Province ProvinceName
	 */

	public Province getProvinceName() 

	{
             return this.provinceName;

	}

	/**
	 *
	 * Get : the contestant's Postal Code
	 * @return String PostalCode
	 */

	public String getPostalCode() 

	{
             return this.postalCode;

	}

	/**
	 *
	 * Get : the contestant's Birth Date
	 * @return  Calendar BirthDate
	 */

	public String getBirthDate() 

	{
             return this.birthDate;

	}

	/**
	 *
	 * Get : the contestant's Phone Number
	 * @return  String PhoneNumber
	 */

	public String getPhoneNumber() 

	{
             return this.phoneNumber;

	}
	
	/**
	 *
	 * @ Override toString
	 * @return  all concatenated variables
	 */
	
	public  String toString()

	{

		return  (firstName + " " + lastName + " " + ageNumber + " " + birthDate + " " + apartmentNumber + " " + streetAdress + " " + city + " " + provinceName + " " + postalCode + " " + phoneNumber);
		

	}
	
	/**
	 *
	 * @ Override equals
	 * 
	 */
	
	public boolean equals(ContestantInformation ci)
	{
		
		if (ci.getFirstName().equals(this.firstName) && (ci.getLastName().equals(this.lastName)))
		{
			return true;
		}
		
		
		
		return false;
		
	
	}
	
	/**
	 *
	 * @ Override compareTo
	 * 
	 */
	
	public int compareTo(Object arg0)
	{
		
		ContestantInformation ci= (ContestantInformation)arg0;
		if ( ci.getFirstName().compareTo(this.firstName) == 0)
		{
			return 0;
			
		}
		
		else if ( ci.getFirstName().compareTo(this.firstName) > 0)
		{
			return 1; 
			
		}
		
		else // ( ci.getFirstName().compareTo(ci2.getFirstName()) < 0)
		{
			return -1;
		}
	
		
		
	}


	

}
	
			
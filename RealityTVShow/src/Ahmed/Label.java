package Ahmed;
import java.util.Calendar;


public class Label {



	public Label() {
		// TODO Auto-generated constructor stub


	}
	private  ContestantInformation ci1;
	private String output;  
	
	
	
	public Label(ContestantInformation ci)
	{
		this.ci1=ci;

		formatName();
		formatAdress();
		formatBirth();
		formatAge();
		formatPhoneNumber();
		
	}
	


	/**
	 * The contestants information needs to be in the format:
	 *
	 * Smith, John
	 * 123 King Road South
	 * Pleasantville, ON
	 * A1A 1A1
	 * (555) 555-5555
	 * 
	 */


	private String formatName()

	{
		String name = ( "\n" + ci1.getFirstName() + " " + ci1.getLastName());

		return name;

	}

	/**
	 * 
	 * @return String
	 */
	private String formatAdress()

	{
		return ( "\n" + ci1.getApartmentNumber() + " " + ci1.getStreetAdress()+ " \n"  + ci1.getCity() +  ", " +ci1.getProvinceName()+ "\n" + ci1.getPostalCode() );

	}
	
	/**
	 * 
	 * @return ci1.getBirthDate
	 */

	private String formatBirth()

	{
		return ( "\n" + ci1.getBirthDate());
		
	}
	
	/**
	 * 
	 * @return ci1.getAge
	 */


	private String formatAge()
	{
		return  ( "\n" + ci1.getAge());
		
	}
	
	/**
	 * 
	 * @return ci1.getPhoneNumber
	 */
	
	private String formatPhoneNumber()
	
	{
		return ( "\n" + ci1.getPhoneNumber());
		
	}
	
	/**
	 * 
	 * @return concatenated String
	 */
	
	public String toString()
	
	{
		 return formatName() + formatAdress()+ formatPhoneNumber() ;
	}
	}
	
	











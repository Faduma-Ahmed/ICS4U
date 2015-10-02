import Ahmed.ContestantInformation;
import Ahmed.InvalidInputException;
import Ahmed.Label;
import Ahmed.Province;

import java.util.*;


/**
 * 
 */

/**
 * @author Faduma Ahmed
 *
 */
public class RealityTVShow {

	

	/**
	 * 
	 */
	public RealityTVShow() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		
		
		ContestantInformation contestant1 = new ContestantInformation();
		Scanner myInput = new Scanner(System.in);
		
		 boolean flag;
		 
		 ArrayList<ContestantInformation> contestants = new ArrayList<ContestantInformation>();
		 
		 
		 System.out.println( "Welcome to the Reality TV show Game \n Please Enter all the following Information in the correct format");
				 
	do{	
		
		flag = true;
				 try
				 {
					 System.out.println("Please Enter Your First Name");
					 String firstName = myInput.nextLine();
					 contestant1.setFirstName(firstName);
					 flag=false; 
				 }
		 
				 catch(InvalidInputException e )
				 {
					 System.out.println(e.getMessage());
					 flag = true;
				 }
				 
	} while(flag);
	
	
  do{	
		
		flag = true;
				 try
				 {
					 System.out.println("Please Enter Your  Last Name");
					 String lastName = myInput.nextLine();
					 contestant1.setLastName(lastName);
					 flag=false;
				 }
		 
				 catch(InvalidInputException e )
				 {
					 System.out.println(e.getMessage());
					 flag =true;
				 }
				 
	} while(flag);
  
  do{	
		
		flag = true;
				 try
				 {
					 System.out.println("Please Enter Your Apartment Number");
					 String apartmentNumber = myInput.nextLine();
					 contestant1.setapartmentNumber(apartmentNumber);
					 flag=false;
				 }
		 
				 catch(InvalidInputException e )
				 {
					 System.out.println(e.getMessage());
					 flag = true;
				 }
				 
	} while(flag);
		
  do{	
		
		flag = true;
				 try
				 {
					 System.out.println("Please Enter Your Street Name");
					 String streetAdress = myInput.nextLine();
					 contestant1.setstreetAdress(streetAdress);
					 flag=false;
				 }
		 
				 catch(InvalidInputException e )
				 {
					 System.out.println(e.getMessage());
					 flag = true;
				 }
				 
	} while(flag);
  
  do{	
		
		flag = true;
				 try
				 {
					 System.out.println("Please Enter the name of your city");
					 String city= myInput.nextLine();
					 contestant1.setcity(city);
					 flag=false;
				 }
		 
				 catch(InvalidInputException e )
				 {
					 System.out.println(e.getMessage());
					 flag = true;
				 }
				 
	} while(flag);
	
  
  
  do{	
		
		flag = true;
				 try
				 {
					 System.out.println("Please Enter Province Name in the abbreviation format ex.AB");
					String provinceName = myInput.nextLine();
					
					if (provinceName.equalsIgnoreCase("ON") || provinceName.equalsIgnoreCase("Ontario"))
					{
						 contestant1.setProvince(Province.ON);
					}
					
					else if (provinceName.equalsIgnoreCase("NL") || provinceName.equalsIgnoreCase("Newfoundland and Labrador"))
					{
						 contestant1.setProvince(Province.NL);
					}
					
					else if (provinceName.equalsIgnoreCase("NS") || provinceName.equalsIgnoreCase("Nova Scotia"))
					{
						 contestant1.setProvince(Province.NS);
					}
					
					else if (provinceName.equalsIgnoreCase("NB") || provinceName.equalsIgnoreCase("NewBrunswick"))
					{
						 contestant1.setProvince(Province.NB);
					}
					
					else if (provinceName.equalsIgnoreCase("QC") || provinceName.equalsIgnoreCase("Quebec"))
					{
						 contestant1.setProvince(Province.QC);
					}
					
					else if (provinceName.equalsIgnoreCase("MB") || provinceName.equalsIgnoreCase("Manitoba"))
					{
						 contestant1.setProvince(Province.MB);
					}
					
					else if (provinceName.equalsIgnoreCase("SK") || provinceName.equalsIgnoreCase("Saskatchewan"))
					{
						 contestant1.setProvince(Province.SK);
					}
					else if (provinceName.equalsIgnoreCase("AB") || provinceName.equalsIgnoreCase("Alberta"))
					{
						 contestant1.setProvince(Province.AB);
					}
					else if (provinceName.equalsIgnoreCase("BC") || provinceName.equalsIgnoreCase("British Colombia"))
					{
						 contestant1.setProvince(Province.BC);
					}
					else if (provinceName.equalsIgnoreCase("YT") || provinceName.equalsIgnoreCase("Yukon"))
					{
						 contestant1.setProvince(Province.YT);
					}
					else if (provinceName.equalsIgnoreCase("NT") || provinceName.equalsIgnoreCase("Northwest Territories"))
					{
						 contestant1.setProvince(Province.NT);
					}
					
					else if (provinceName.equalsIgnoreCase("NU") || provinceName.equalsIgnoreCase("Nunavut"))
					{
						 contestant1.setProvince(Province.NU);
					}
					else {
						throw new InvalidInputException ("Please Enter Province Name in the abbreviation format ex.AB");
					
					}
					flag=false;
					
				 }
				 catch(  InvalidInputException e )
				 {
					 System.out.println(e.getMessage());
					 flag = true;
				 }
				 
				 
	} while(flag);
  
    
  
  

	  
	  do{	
			
			flag = true;
					 try
					 {
						 System.out.println("Please Enter your postal code");
						 String postalCode= myInput.nextLine();
						 contestant1.setPostalCode(postalCode);
						 flag=false;
					 }
			 
					 catch(InvalidInputException e )
					 {
						 System.out.println(e.getMessage());
						 flag = true;
					 }
					 
		} while(flag);
	  
	  
	
	  
	 
	  
	  do{	
			
			flag = true;
					 try
					 {
						 System.out.println("Please Enter the name of your birth Year");
						 String birthDate= myInput.nextLine();
						 contestant1.setbirthDate(birthDate);
						 int verify = 2015 - Integer.parseInt(birthDate);
						 if ( verify <18 )
							 
						 {
							 flag = true; 
							 throw new InvalidInputException (" You need to be older than 18"); 
						 }
						 
						 
						 flag=false;
					 }
			 
					 catch(InvalidInputException e )
					 {
						 System.out.println(e.getMessage());
						 flag = true;
					 }
					 
		} while(flag);
	  
	  
	  do{	
			
			flag = true;
					 try
					 {
						 System.out.println("Please your current age");
						 String age= myInput.nextLine();
						 contestant1.setageNumber(Integer.parseInt(age));
						 
						 flag=false;
					 }
			 
					 catch(InvalidInputException e )
					 {
						 System.out.println(e.getMessage());
						 flag = true;
					 }
					 
		} while(flag);
	  
	  
	  do{	
			
			flag = true;
					 try
					 {
						 System.out.println("Please your phone Number");
						 String phoneNumber= myInput.nextLine();
						 contestant1.setphoneNumber(phoneNumber);
						 
						 flag=false;
					 }
			 
					 catch(InvalidInputException e )
					 {
						 System.out.println(e.getMessage());
						 flag = true;
					 }
					 
		} while(flag);
	  
	  
	  
	  Label label = new Label ( contestant1);
	  
	 
	   System.out.println(label.toString());
	   System.out.print ("Would you like to add another contestant");
	   String Answer = myInput.nextLine();
	   if (Answer.equalsIgnoreCase("Yes")|| Answer.equalsIgnoreCase("Y"))
	  
	 
	   {
	  
			  for ( int i = 0 ;i<= contestants.size(); i++)
			  
			  {
				  contestants.add(contestant1); 
			  
			  }
		
	   }



	}
}



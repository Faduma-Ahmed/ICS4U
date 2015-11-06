package Ahmed;

import java.util.ArrayList;
import Ahmed.ContestantInformation;


public class Search {



	public Search() {}
	// TODO Auto-generated constructor stub



	/**
	 *  Uses an array list to figure out at which index a target is within an array list
	 *   
	 * @param  Arraylist<ContestantInformation> contestants, ContestantInformation target 
	 */
	public static  int linearSearch(ArrayList<ContestantInformation> contestants, ContestantInformation target)

	{
		for (int x = 0; x < contestants.size()-1; x++)
		{

			if (contestants.get(x).equals(target))
			{
				return (x);

			}
			
		}

		return (-1);

	} 
	
	

	/**
	 *  Uses an array list to figure out at which index a target is within an array list
	 *   
	 * @param  Arraylist<ContestantInformation> contestants, String firstName, String lastName
	 * @return integer 
	 */

	public static  int linearSearch(ArrayList<ContestantInformation> contestants, String firstName, String lastName)


	{

		for (int x = 0; x < contestants.size(); x++)
		{

			if ((contestants.get(x).getFirstName()).equals(firstName))
			{
				
				if ((contestants.get(x).getLastName()).equals(lastName))
				
				{
				return (x);
				}

			}

		}

		return (-1);

	} 

	/**
	 *  Uses an array list to figure out at which which index in the array had a specific contestant
	 * @param  Arraylist<ContestantInformation> contestants, String firstName, String lastName
	 * @return integer 
	 */

	
	public static int  binarySearch(ArrayList<ContestantInformation>contestants , String firstName, String lastName)
	{
		int begin =0;
		int end = contestants.size()-1;
		int middle;
		int found = -1;

	
		do{
		{
			middle =  (end -begin)/2;

			

			if ( (contestants.get(middle).getFirstName().compareTo(firstName) ) ==-1)

			{
				end = middle -1;
				middle = end - (end -begin)/2;
				found = -1;

			}

			else if( (contestants.get(middle).getFirstName().compareTo(firstName) )==1 )
			{
				begin = middle+1;
				middle =  (end -begin)/2 + begin;
				found = -1;

			}
			
			else if ( (contestants.get(middle).getFirstName().compareTo(firstName) ) ==0 )
			{
				 begin =0;
				 end = contestants.size()-1;
				
				 found = -1;
				 
				 
				 if ( (contestants.get(middle).getLastName().compareTo(lastName) ) ==-1)

					{
						end = middle -1;
						middle = end - (end -begin)/2;
						found = -1;

					}

					else if( (contestants.get(middle).getLastName().compareTo(lastName) )==1 )
					{
						begin = middle+1;
						middle =  (end -begin)/2 + begin;
						found = -1;

					}
					
					else if ( (contestants.get(middle).getLastName().compareTo(lastName) ) ==0 )
					{
					  found = middle;
					}
				
			}

		}

		return found;
	}while (found != middle);
		
	}
	
	
	/**
	 *  Uses an array list to figure out at which index a target is within an array list
	 *   
	 * @param  Arraylist<ContestantInformation> contestants,ContestantInformation target
	 * @return integer 
	 */
	
	public int  binarySearch(ArrayList<ContestantInformation>contestants , ContestantInformation target)
	{
		int begin =0;
		int end = contestants.size()-1;
		int middle;

		
		while ( begin<=end)
		{
			middle =  (end+begin)/2;

			

			if ( (contestants.get(middle).compareTo(target)) <0)

			{
				begin = middle+1;

			}

			else if ( (contestants.get(middle).compareTo(target)) > 0)
			{
				end = middle-1;
			}
			
			else if ( (contestants.get(middle).compareTo(target)) == 0)
			{
				
				return (middle);
			}

		}

		return (-1);
		 
	}
	
	
	
	
	/**
	 * a helper method that sends values of end and begin to the method Binary Search
	 * @param al
	 * @param target
	 * @return
	 */
	public static int binarySearch(ArrayList<ContestantInformation>al,String target)
	
	
	
	{
		return binarySearch(al,target,0,al.size()-1);
	}
	
	
	 /**
	  * Recursive version of binary search
	 * @param  ArrayList<String> al
	 * @param  String target
	 * @param  int begin
	 * @param  int end
	 * @return Integer
	 */
	public static int binarySearch(ArrayList<ContestantInformation>al,String target, int begin,int end)
	
	{
		
		if (begin<end)
			return -1;
		
		 int mid = (begin +end)/ 2;
		 
		  if ( al.get(mid).getLastName().compareTo(target)== 0)
			   return mid;
		  
		  else if ( al.get(mid).getLastName().compareTo(target)< 0)
			  
			  return binarySearch(al,target, begin +1, end);
		  else //  ( al.get(mid).compareTo(target)>0)
			  return binarySearch(al,target, begin , end-1);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
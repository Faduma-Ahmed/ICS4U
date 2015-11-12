package Ahmed;

import java.util.ArrayList;
import Ahmed.ContestantInformation;

/**
 * 
 * This is a reality TV show program that formats the contestant's information
 * and verifies their eligibility This class searches and finds specified users
 * within an array/arrayList by using a target value
 * 
 * @author Faduma Ahmed Sept 28, 2015
 * 
 */

public class Search {

	/**
	 * auto generated constructor
	 */
	public Search() {
	}
	// TODO Auto-generated constructor stub

	/**
	 * This is a linear search that uses an array list to figure out at which
	 * index a target is
	 * 
	 * @param contestants
	 *            ArrayList<ContestantInformation> this is the arrayList that
	 *            contains all the contestants,
	 * @param target
	 *            ContestantInformation, this is the object that we are
	 *            searching for
	 * @return value where target is found. If the user isn't found then a value
	 *         of negative one is returned
	 */
	public static int linearSearch(ArrayList<ContestantInformation> contestants, ContestantInformation target)

	{
		for (int x = 0; x < contestants.size() - 1; x++) {

			if (contestants.get(x).equals(target)) {
				return (x);

			}

		}

		return (-1);

	}

	/**
	 * This is a linear search that uses an array list to figure out at which
	 * index a target. This cases uses the targets first and last name to search
	 * 
	 * @param contestants
	 *            ArrayList<ContestantInformation> this is the arrayList that
	 *            contains all the contestants,
	 * @param firstName String, lastName String
	 *            ContestantInformation, this is the object that we are
	 *            searching for
	 * @return value where target is found. If the user isn't found then a value
	 *         of negative one is returned
	 */

	public static int linearSearch(ArrayList<ContestantInformation> contestants, String firstName, String lastName)

	{

		for (int x = 0; x < contestants.size(); x++) {

			if ((contestants.get(x).getFirstName()).equals(firstName)) {

				if ((contestants.get(x).getLastName()).equals(lastName))

				{
					return (x);
				}

			}

		}

		return (-1);

	}

	/**
	 * This is a binary search that uses an array list to figure out at which
	 * index a target is.This case uses the target's first and last name to
	 * search
	 * 
	 * @param contestants
	 *            ArrayList<ContestantInformation> this is the arrayList that
	 *            contains all the contestants,
	 * @param firstName
	 *            String, the targets first Name
	 * @param lastName
	 *            String, the targets last Name
	 * @return value where target is found. If the user isn't found then a value
	 *         of negative one is returned
	 */

	public static int binarySearch(ArrayList<ContestantInformation> contestants, String firstName, String lastName) {
		int begin = 0;
		int end = contestants.size() - 1;
		int middle;
		int found = -1;

		do {
			{
				middle = (end - begin) / 2;

				if ((contestants.get(middle).getFirstName().compareTo(firstName)) == -1)

				{
					end = middle - 1;
					middle = end - (end - begin) / 2;
					found = -1;

				}

				else if ((contestants.get(middle).getFirstName().compareTo(firstName)) == 1) {
					begin = middle + 1;
					middle = (end - begin) / 2 + begin;
					found = -1;

				}

				else if ((contestants.get(middle).getFirstName().compareTo(firstName)) == 0) {
					begin = 0;
					end = contestants.size() - 1;

					found = -1;

					if ((contestants.get(middle).getLastName().compareTo(lastName)) == -1)

					{
						end = middle - 1;
						middle = end - (end - begin) / 2;
						found = -1;

					}

					else if ((contestants.get(middle).getLastName().compareTo(lastName)) == 1) {
						begin = middle + 1;
						middle = (end - begin) / 2 + begin;
						found = -1;

					}

					else if ((contestants.get(middle).getLastName().compareTo(lastName)) == 0) {
						found = middle;
					}

				}

			}

			return found;
		} while (found != middle);

	}

	/**
	 * This is a binary search that uses an array list to figure out at which
	 * index a target is.This case uses the target's first and last name to
	 * search
	 * 
	 * @param contestants
	 *            ArrayList<ContestantInformation> this is the arrayList that
	 *            contains all the contestants,
	 * @param target
	 *            ContestantInformation, the object that contains the
	 *            contestants information
	 * @return value where target is found
	 */

	public int binarySearch(ArrayList<ContestantInformation> contestants, ContestantInformation target) {
		int begin = 0;
		int end = contestants.size() - 1;
		int middle;

		while (begin <= end) {
			middle = (end + begin) / 2;

			if ((contestants.get(middle).compareTo(target)) < 0)

			{
				begin = middle + 1;

			}

			else if ((contestants.get(middle).compareTo(target)) > 0) {
				end = middle - 1;
			}

			else if ((contestants.get(middle).compareTo(target)) == 0) {

				return (middle);
			}

		}

		return (-1);

	}

	/**
	 * a helper method that sends values of the end and begin of the arrayList
	 * and also the arrayList itself and the target value we are searching for
	 * to the method Binary Search
	 * 
	 * @param contestants
	 *            arrayList of contestant information
	 * @param target
	 *            ContestantInformation, the object that holds the contestant
	 *            info
	 * @return binarySearch() recursion method to find value where target is
	 *         found
	 */
	public static int binarySearch(ArrayList<ContestantInformation> contestants, String target)

	{
		return binarySearch(contestants, target, 0, contestants.size() - 1);
	}

	/**
	 * Recusion method of binary search to find a contestant within the array
	 * 
	 * @param contestants
	 *            arrayList of contestant information
	 * @param target
	 *            String , that contains the contains we are looking for
	 * @param begin
	 *            Integer A point in the array we want to begin our search
	 * @param end
	 *            Integer A point in the array we want to end our search
	 * @return Integer value where target is found
	 */
	public static int binarySearch(ArrayList<ContestantInformation> contestants, String target, int begin, int end)

	{

		if (begin < end)
			return -1;

		int mid = (begin + end) / 2;

		if (contestants.get(mid).getLastName().compareTo(target) == 0)
			return mid;

		else if (contestants.get(mid).getLastName().compareTo(target) < 0)

			return binarySearch(contestants, target, begin + 1, end);
		else // ( al.get(mid).compareTo(target)>0)
			return binarySearch(contestants, target, begin, end - 1);

	}

	/**
	 * 
	 * Linear search to analyze an array of Integers in order to find at what
	 * index a target is located in a array
	 * 
	 * @param array
	 *            of Integers
	 * @param target
	 *            value that we are searching for
	 * @return integer value where target is found. If the target isn't found
	 *         within the array a value of -1 is returned
	 */

	public static int linearSearch(int[] array, int target)

	{

		for (int x = 0; x < array[array.length - 1]; x++) {

			if (array[x] == target) {
				return (x);

			}

		}

		return (-1);

	}

	/**
	 * 
	 * Linear search to analyze an array of doubles in order to find at what
	 * index a target is located in a array
	 * 
	 * @param array
	 *            of double
	 * @param target
	 *            value that we are searching for
	 * @return value where target is found. If the target isn't found within the
	 *         array a value of -1 is returned
	 */
	public static double linearSearch(double[] array, double target)

	{

		for (int x = 0; x < array[array.length - 1]; x++) {

			if (array[x] == target) {
				return (x);

			}

		}

		return (-1);

	}

	/**
	 * 
	 * Linear search to analyze an array of Strings in order to find at what
	 * index a target is located in a array
	 * 
	 * @param array
	 *            of Strings
	 * @param target
	 *            value that we are searching for
	 * @return integer value where target is found. If the target isn't found
	 *         within the array a value of -1 is returned
	 */
	public static String linearSearch(String[] array, String target)

	{

		for (int x = 0; x < (array.length - 1); x++) {

			if (array[x].equalsIgnoreCase(target)) {
				return (array[x]);

			}

		}

		return ("-1");

	}

	/**
	 * Binary search to analyze an array of Strings in order to find at what
	 * index a target is located in a array
	 * 
	 * @param array
	 *            of integer
	 * @param target
	 *            value that we are searching for
	 * @return integer value where target is found. If the target isn't found
	 *         within the array a value of -1 is returned
	 */
	public static int binarySearch(int[] array, int target)

	{
		int begin = 0;
		int end = array.length - 1;

		while (end >=begin) {

			int middle = ((begin + end) / 2);

			if (array[middle] < target)

			{
				begin = middle+1;
			}

			else if (array[middle] > target) {
				end = middle-1;
			}

			else if (array[middle] == target) {
				return (middle);
			}

		}

		return (-1);

	}

	/**
	 * 
	* Binary search to analyze an array of Integers in order to find at what
	 * index a target is located in a array
	 * @param array
	 *            of double
	 * @param target
	 *            value that we are searching for
	* @return value where target is found. If the target isn't found within the
	 *         array a value of -1 is returned
	 */

	public static int binarySearch(double[] array, double target)

	{
		int begin = 0;
		int end = array.length - 1;

		while (end >= begin) {

			int middle = ((begin + end) / 2);

			if (array[middle] < target)

			{
				begin = middle+1;
			}

			else if (array[middle] > target) {
				end = middle-1;
			}

			else if (array[middle] == target) {
				return (middle);
			}

		}

		return (-1);

	}

	/**
	 * 
	 * Binary search to analyze an array of Integers in order to find at what
	 * index a target is located in a array
	 * @param array
	 *            of String
	 * @param target
	 *            value that we are searching for
	* @return value where target is found. If the target isn't found within the
	 *         array a value of -1 is returned
	 */
	public static int binarySearch(String[] array, String target)

	{

		int begin = 0;
		int end = array.length - 1;

		while (begin <= end)

		{

			int middle = (end + begin) / 2;

			if ((array[middle].compareTo(target)) < 0)

			{
				begin = middle + 1;

			}

			else if ((array[middle].compareTo(target)) > 0) {
				end = middle - 1;
			}

			else if ((array[middle].compareTo(target)) == 0) {

				return (middle);
			}

		}

		return (-1);

	}

}
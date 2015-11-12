package Ahmed;

import Ahmed.Search;

/**
 * 
 * This is a reality TV show program that formats the contestant's information
 * This is the test class to check if the binary and linear searches are working
 * properly within an array/arrayList by using a target value
 * 
 * @author Faduma Ahmed 
 * Sept 28 - november 11 , 2015
 * 
 */

public class Driver {

	public Driver() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		
		// Array of Integers that are sent to a binary and linear search
		int intArray[] = { 1, 2, 3, 4, 6, 8, 9, 12, 15 };
		System.out.println(Search.linearSearch(intArray, 8));
		System.out.println(Search.binarySearch(intArray, 8));

		// Array of doubles that are sent to a binary and linear search
		double doubleArray[] = { 1, 2.5, 3, 4.89, 6, 8, 9.67, 12, 15.0 };
		System.out.println(Search.linearSearch(doubleArray, 15.0));
		System.out.println(Search.binarySearch(doubleArray, 2.5));

		// Array of Strings that are sent to a binary and linear search
		String sArray[] = { "Cat", "cow", "dog", "goat", "pig", "sheep" };
		System.out.println(Search.binarySearch(sArray, "goat"));
		System.out.println(Search.binarySearch(sArray, "horse"));

	}

}

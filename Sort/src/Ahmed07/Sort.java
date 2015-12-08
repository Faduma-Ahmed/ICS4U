package Ahmed07;
 import java.util.Arrays;



/**
 * 
 * The program utilizes several sort algorithms to sort an array from least top greatest  
 * November 22-27, 2015
 * @author Faduma Ahmed
 *
 */
public class Sort {
	/**
	 * In this selection sort, we look through each element in the array to find
	 * the smallest value, then swap it into its original place until the array
	 * is sorted
	 * 
	 * @param int[] the unsorted array
	 * @return int[]  a reference to a sorted array
	 */
	public static int[] selectionSort(int[] numbers)

	{
		for (int i = 0; i < numbers.length - 1; i++)

		{
			int minIndex = i;

			for (int element = i + 1; element < numbers.length; element++) {
				if (numbers[element] < numbers[minIndex])

					minIndex = element;
			}

			int temp = numbers[minIndex];
			numbers[minIndex] = numbers[i];
			numbers[i] = temp;

		}
		return numbers;

	}

	/**
	 * In insertion sort, elements in an array are sorted into a sublist until
	 * all elements are placed in their corresponding positions
	 * 
	 * @param  int[]  an unsorted array
	 * @return  int[] the sorted array
	 */
	public static int[] insertionSort(int[] numbers)

	{
		for (int i = 0; i < numbers.length; i++)

		{
			int key = numbers[i];
			int value = i - 1;

			while (value >= 0 && numbers[value] > key)

			{
				numbers[value + 1] = numbers[value];

				value--;

			}

			numbers[value + 1] = key;
		}

		return numbers;

	}

	/**
	 * THis is a helper method that calls on a recursive method to sort the
	 * array via Quick Sort
	 * 
	 * @param int[] the unsorted array
	 */
	public static void quickSort(int[] numbers) {
		recursiveQuickSort(numbers, 0, numbers.length - 1);
	}

	/**
	 * This is the recursive method that sorts the two parts of an array list
	 * using a pivot
	 * 
	 * @param  int[] numbers the unsorted array
	 * @param int startIndex the start of the array
	 * @param int endIndex the end of the array
	 */
	private static void recursiveQuickSort(int[] numbers, int startIndex, int endIndex)

	{
		int index = partition(numbers, startIndex, endIndex);
		// Sorts the left side of the partitioned array by using recursion
		if (startIndex < index - 1) {
			recursiveQuickSort(numbers, startIndex, index - 1);
		}
		// Sorts the right side of the partitioned array by using recursion
		if (endIndex > index) {
			recursiveQuickSort(numbers, index, endIndex);
		}
	}

	/**
	 * @param  int[] numbers the array to be sorted
	 * @param  int left the lower section of the array
	 * @param  int right the upper section of the array
	 * @return int[] left the sorted index
	 */
	private static int partition(int[] numbers, int left, int right)

	{
		// makes the first element as pivot
		int pivot = numbers[left];

		while (left <= right) {

			// Check if the number is greater than pivot
			while (numbers[left] < pivot) {
				left++;
			}

			// Checks if the number is less than pivot
			while (numbers[right] > pivot) {
				right--;
			}

			// Swaps the values in either side of pivot
			if (left <= right)

			{
				int temporary = numbers[left];
				numbers[left] = numbers[right];
				numbers[right] = temporary;
				left++;
				right--;
			}
		}
		return left;
		/**/

	}

	/**
	 * Uses bubble sort algorithm to check for lowest number and "bubble" it to
	 * the front of the array
	 * 
	 * @param numbers[],
	 *            the unsorted array
	 * @return numbers[] the sorted array
	 */
	public static int[] bubbleSort(int numbers[])

	{
		int temporary = 0;

		for (int outerCounter = 0; outerCounter < numbers.length - 1; outerCounter++)

		{

			for (int innerCounter = 0; innerCounter < numbers.length - 1 - outerCounter; innerCounter++) {

				if (numbers[innerCounter] > numbers[innerCounter + 1]) {
					temporary = numbers[innerCounter];
					numbers[innerCounter] = numbers[innerCounter + 1];
					numbers[innerCounter + 1] = temporary;
				}
			}

		}

		return numbers;
	}

	/**
	 * This method uses merge sort as it splits the array in half and sorts them
	 * 
	 * @param numbers[],
	 *            the unsorted array
	 */
	public static void mergeSort(int[] numbers) {
		int size = numbers.length;
		if (size < 2)
			return;
		int middle = size / 2;
		int leftLength = middle;
		int rightLength = size - middle;
		int[] left = new int[leftLength];
		int[] right = new int[rightLength];
		for (int i = 0; i < middle; i++) {
			left[i] = numbers[i];

		}
		for (int i = middle; i < size; i++) {
			right[i - middle] = numbers[i];
		}
		mergeSort(left);
		mergeSort(right);
		merge(left, right, numbers);
	}

	/**
	 * This method uses merge sort and merges the two sorted arrays together
	 * back into its original array
	 * 
	 * @param int[] left the upper bound of the array
	 * @param int[] right the lower bound of the array
	 * @param int[] numbers the array unsorted
	 */
	private static void merge(int[] left, int[] right, int[] numbers) {
		int leftSize = left.length;
		int rightSize = right.length;
		int i = 0, inner = 0, outer = 0;
		while (i < leftSize && inner < rightSize) {
			if (left[i] <= right[inner]) {
				numbers[outer] = left[i];
				i++;
				outer++;
			} else {
				numbers[outer] = right[inner];
				outer++;
				inner++;
			}
		}
		while (i < leftSize) {
			numbers[outer] = left[i];
			outer++;
			i++;
		}
		while (inner < leftSize) {
			numbers[outer] = right[inner];
			outer++;
			inner++;
		}
	}

}

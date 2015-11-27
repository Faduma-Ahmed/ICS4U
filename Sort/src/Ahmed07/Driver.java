package Ahmed07;

import java.util.Arrays;

public class Driver {

	public Driver() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int numbers[] =  new int[]{25,0,6,67,2,8,4,7,20,78};
		 
		
		 
		Sort.quickSort(numbers);

		System.out.println(Arrays.toString(numbers));

		Sort.selectionSort(numbers);

		System.out.println(Arrays.toString(numbers));

		Sort.insertionSort(numbers);

		System.out.println(Arrays.toString(numbers));
		Sort.bubbleSort(numbers);

		System.out.println(Arrays.toString(numbers));

		Sort.mergeSort(numbers);

		System.out.println(Arrays.toString(numbers));
		  }
		 

	}



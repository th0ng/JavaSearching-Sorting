package searching_sorting;

import java.util.Arrays;
import java.util.Random;

public class SortingPerformance {
	// Define the arrays gonna used during sorting
	private static final int n = 1000;
	private static int[] array1 = new int[n];
	private static int[] array2 = new int[n * 2];
	private static int[] array3 = new int[n * 3];
	private static int[] array4 = new int[n * 4];
	private static int[] array5 = new int[n * 5];
	private static int[] array6 = new int[n * 6];
	private static int[] array7 = new int[n * 7];
	private static int[] array8 = new int[n * 8];
	private static int[] array9 = new int[n * 9];
	private static int[] array10 = new int[n * 10];

	// Array of 10 arrays
	private static int[][] array = { array1, array2, array3, array4, array5, array6, array7, array8, array9, array10 };

	// Method to create array with random integer in it
	static void createRandomArray(int[] array) {
		Random rd = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = rd.nextInt();
		}
	}

	// O(n^2) sorting: Selection sorting and insertion sorting

	// Selection sorting function
	static int[] selectionSort(int[] array) {
		int n = array.length;
		int comparisonCount = 0;
		// Starting the timer
		long start = System.currentTimeMillis();
		for (int i = 0; i < n - 1; i++) {
			int min_index = i;
			// Find the minimum element in the unsorted array
			for (int j = i + 1; j < n; j++) {
				// Calculate the comparison being taken and added to the total
				comparisonCount++;

				if (array[j] < array[min_index])
					min_index = j;

				// Swap the minimum element with the first element
				int temp = array[min_index];
				array[min_index] = array[i];
				array[i] = temp;
			}
		}
		// Stopping the timer
		long end = System.currentTimeMillis();

		return new int[] { (int) (end - start), comparisonCount };
	}

	// Selection Sort interface
	static int[][] SelectionSort() {
		for (int[] ints : array) {
			createRandomArray(ints);
		}

		int[][] result = new int[10][];
		for (int i = 0; i < array.length; i++) {
			result[i] = selectionSort(array[i]);
		}
		return result;
	}

	// Insertion sorting function
	static int[] insertionSort(int[] array) {
		int length = array.length;
		int comparisonCount = 0;
		// Start the timer
		long start = System.currentTimeMillis();
		// Loop
		for (int index = 1; index < length; index++) {
			int key = array[index];
			int position = index;
			// shift larger values to the right
			while (position > 0 && array[position - 1] > key) {
				array[position] = array[position - 1];
				position--;
				comparisonCount++;
			}
			array[position] = key;
		}
		// Stop the timer
		long end = System.currentTimeMillis();
		return new int[] { (int) (end - start), comparisonCount };
	}

	// Insertion sorting interface
	static int[][] InsertionSort() {
		for (int[] ints : array)
			createRandomArray(ints);
		int[][] result = new int[10][];
		for (int i = 0; i < array.length; i++) {
			result[i] = insertionSort(array[i]);
		}
		return result;
	}

	// O(n*log(n)) sorting: merge sort and quick sort

	// Recursive merge sorting function
	static int mergeSort(int[] array) {
		int comparisonCount = 0;
		int n = array.length;
		if (n < 2)
			return 0;
		int mid = n / 2;
		int[] left = new int[mid];
		int[] right = new int[n - mid];

		for (int i = 0; i < mid; i++) {
			left[i] = array[i];

		}
		for (int i = mid; i < n; i++)
			right[i - mid] = array[i];

		// Recursive call on each half
		comparisonCount = mergeSort(left) + mergeSort(right);

		// Two iterators for traversing the two halves
		int i = 0, j = 0;
		// Iterator for the main list
		int k = 0;

		while (i < left.length && j < right.length) {
			comparisonCount++;
			if (left[i] <= right[j]) {
				// The value from the left half has been used
				array[k] = left[i];
				// Move the iterator forward
				i++;
			} else {
				array[k] = right[j];
				j++;
			}
			// Move to the next slot
			k++;
		}
		// For all the remaining value
		while (i < left.length) {
			array[k] = left[i];
			i++;
			k++;
		}
		while (j < right.length) {
			array[k] = right[j];
			j++;
			k++;
		}

		return comparisonCount;
	}

	// Merge sorting interface
	static int[][] MergeSort() {
		for (int[] ints : array)
			createRandomArray(ints);
		int[][] result = new int[10][];
		for (int i = 0; i < array.length; i++) {
			long start = System.currentTimeMillis();
			int counter = mergeSort(array[i]);
			long end = System.currentTimeMillis();
			result[i] = new int[] { (int) (end - start), counter };
		}
		return result;
	}

	// Quick sorting
	// Function
	static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	private static int partition(int[] array, int min, int max) {
		int partitionelement;
		int left, right;
		int middle = (min + max) / 2;

		//use the middle data element as the partition element
		partitionelement = array[middle];

		//move it out of the way right now
		swap(array, middle, min);

		left = min;
		right = max;

		while (left < right) {
			//search for an element that is > the partition element
			while (left < right && array[left] < partitionelement) {
				left++;
			}
			//search for an element that is < the partition element
			while (array[right] > partitionelement) {
				right--;
			}
			//swap the elements
			if (left < right)
				swap(array, left, right);
		}
		//move the partition element into place
		swap(array, min, right);
		return right;
	}

	static void quickSort(int[] array, int low, int high) {
		if (low < high) {
			int pi = partition(array, low, high);

			quickSort(array, low, pi -1);
			quickSort(array, pi + 1, high);
		}
	}

	static int[] QuickSort() {
		for (int[] ints : array)
			createRandomArray(ints);
		int[] result = new int[10];
		for (int i = 0; i < array.length; i++) {
			long start = System.currentTimeMillis();
			quickSort(array[i], 0, array[i].length -1);
			System.out.println(Arrays.toString(array[i]));
			long end = System.currentTimeMillis();
			result[i] = (int) (end - start);
		}
		return result;
	}


	public static void SortingPerformanceToString() {

		System.out.println(Arrays.deepToString(MergeSort()));
		System.out.println(Arrays.deepToString(InsertionSort()));
		System.out.println(Arrays.toString(QuickSort()));
	}
}

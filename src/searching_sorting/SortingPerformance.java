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

	private static int[] partition(int[] array, int min, int max) {
		int partitionelement;
		int left, right;
		int middle = (min + max) / 2;
		int comparisonCount = 0;
		// use the middle data element as the partition element
		partitionelement = array[middle];

		// move it out of the way right now
		swap(array, middle, min);

		left = min;
		right = max;

		while (left < right) {
			// search for an element that is > the partition element
			while (left < right && array[left] < partitionelement) {
				left++;
				comparisonCount++;
			}
			// search for an element that is < the partition element
			while (array[right] > partitionelement) {
				right--;
				comparisonCount++;
			}
			// swap the elements
			if (left < right)
				swap(array, left, right);
		}
		// move the partition element into place
		swap(array, min, right);
		return new int[] { right, comparisonCount };
	}

	static int quickSort(int[] array, int low, int high) {
		int comparisonCount = 0;
		if (low < high) {
			int pi = partition(array, low, high)[0];
			comparisonCount += partition(array, low, high)[1];
			comparisonCount += quickSort(array, low, pi - 1);
			comparisonCount += quickSort(array, pi + 1, high);
		}
		return comparisonCount;
	}

	static int[][] QuickSort() {
		for (int[] ints : array)
			createRandomArray(ints);
		int[][] result = new int[10][];
		for (int i = 0; i < array.length; i++) {
			long start = System.currentTimeMillis();
			int comparisonCount = quickSort(array[i], 0, array[i].length - 1);
			long end = System.currentTimeMillis();
			result[i] = new int[] { (int) (end - start), comparisonCount };
		}
		return result;
	}

	public static void SortingPerformanceToString() {
		int[][] selectionSort = SelectionSort();
		int[][] insertionSort = InsertionSort();
		int[][] mergeSort = MergeSort();
		int[][] quickSort = QuickSort();
		System.out.format("%32s%10d%10d%10d%10d%10d%10d%10d%10d%10d%10d\n", "", 1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000);
		System.out.format("%32s%10d%10d%10d%10d%10d%10d%10d%10d%10d%10d\n",
				"selectionSort.random.comparisons",
				selectionSort[0][1], selectionSort[1][1], selectionSort[2][1], selectionSort[3][1],
				selectionSort[4][1], selectionSort[5][1], selectionSort[6][1], selectionSort[7][1],
				selectionSort[8][1], selectionSort[9][1]
		);
		System.out.format("%32s%10d%10d%10d%10d%10d%10d%10d%10d%10d%10d\n",
				"selectionSort.random.ms",
				selectionSort[0][0], selectionSort[1][0], selectionSort[2][0], selectionSort[3][0],
				selectionSort[4][0], selectionSort[5][0], selectionSort[6][0], selectionSort[7][0],
				selectionSort[8][0], selectionSort[9][0]
		);
		System.out.format("%32s%10d%10d%10d%10d%10d%10d%10d%10d%10d%10d\n",
				"insertionSort.random.comparisons",
				insertionSort[0][1], insertionSort[1][1], insertionSort[2][1], insertionSort[3][1],
				insertionSort[4][1], insertionSort[5][1], insertionSort[6][1], insertionSort[7][1],
				insertionSort[8][1], insertionSort[9][1]
		);
		System.out.format("%32s%10d%10d%10d%10d%10d%10d%10d%10d%10d%10d\n",
				"insertionSort.random.ms",
				insertionSort[0][0], insertionSort[1][0], insertionSort[2][0], insertionSort[3][0],
				insertionSort[4][0], insertionSort[5][0], insertionSort[6][0], insertionSort[7][0],
				insertionSort[8][0], insertionSort[9][0]
		);
		System.out.format("%32s%10d%10d%10d%10d%10d%10d%10d%10d%10d%10d\n",
				"mergeSort.random.comparisons",
				mergeSort[0][1], mergeSort[1][1], mergeSort[2][1], mergeSort[3][1],
				mergeSort[4][1], mergeSort[5][1], mergeSort[6][1], mergeSort[7][1],
				mergeSort[8][1], mergeSort[9][1]
		);
		System.out.format("%32s%10d%10d%10d%10d%10d%10d%10d%10d%10d%10d\n",
				"mergeSort.random.ms",
				mergeSort[0][0], mergeSort[1][0], mergeSort[2][0], mergeSort[3][0],
				mergeSort[4][0], mergeSort[5][0], mergeSort[6][0], mergeSort[7][0],
				mergeSort[8][0], mergeSort[9][0]
		);
		System.out.format("%32s%10d%10d%10d%10d%10d%10d%10d%10d%10d%10d\n",
				"quickSort.random.comparisons",
				quickSort[0][1], quickSort[1][1], quickSort[2][1], quickSort[3][1],
				quickSort[4][1], quickSort[5][1], quickSort[6][1], quickSort[7][1],
				quickSort[8][1], quickSort[9][1]
		);
		System.out.format("%32s%10d%10d%10d%10d%10d%10d%10d%10d%10d%10d\n",
				"quickSort.random.ms",
				quickSort[0][0], quickSort[1][0], quickSort[2][0], quickSort[3][0],
				quickSort[4][0], quickSort[5][0], quickSort[6][0], quickSort[7][0],
				quickSort[8][0], quickSort[9][0]
		);
		System.out.println("");
	}
}

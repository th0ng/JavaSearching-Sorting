package searching_sorting;

import java.util.Random;

public class Sorting {
	static int[] array = new int[10];

	private static void createRandomArray(int[] array) {
		Random rd = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = rd.nextInt();
		}
	}

	private static void insertionSorting(int[] array) {
		for (int i = 0; i < array.length; i++) {
			int key = array[i];
			int j = i-1;
			while (j>0 && array[j] > key) {
				array[j+1] = array[j];
				j = j-1;
			}
			array[j+1] = key;
		}

	}

	public static void InsertionSorting() {
		createRandomArray(array);

		System.out.println("Data set before insertion sorting:");
		for (int j : array)
			System.out.print(j + " ");
		System.out.println("\n");

		insertionSorting(array);

		System.out.println("Data set after insertion sorting:");
		for (int j: array)
			System.out.print(j + " ");
		System.out.println("\n");
	}

	private static void heapSort(int[] arr)
	{
		int N = arr.length;

		// Build heap (rearrange array)
		for (int i = N / 2 - 1; i >= 0; i--)
			heapify(arr, N, i);

		// One by one extract an element from heap
		for (int i = N - 1; i > 0; i--) {
			// Move current root to end
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			// call max heapify on the reduced heap
			heapify(arr, i, 0);
		}
	}

	// To heapify a subtree rooted with node i which is
	// an index in arr[]. n is size of heap
	private static void heapify(int[] arr, int N, int i)
	{
		int largest = i; // Initialize largest as root
		int l = 2 * i + 1; // left = 2*i + 1
		int r = 2 * i + 2; // right = 2*i + 2

		// If left child is larger than root
		if (l < N && arr[l] > arr[largest])
			largest = l;

		// If right child is larger than largest so far
		if (r < N && arr[r] > arr[largest])
			largest = r;

		// If largest is not root
		if (largest != i) {
			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;

			// Recursively heapify the affected sub-tree
			heapify(arr, N, largest);
		}
	}

	public static void HeapSorting() {
		createRandomArray(array);

		System.out.println("Data set before insertion sorting:");
		for (int j : array)
			System.out.print(j + " ");
		System.out.println("\n");

		heapSort(array);

		System.out.println("Data set after insertion sorting:");
		for (int j: array)
			System.out.print(j + " ");
		System.out.println("\n");
	}

}

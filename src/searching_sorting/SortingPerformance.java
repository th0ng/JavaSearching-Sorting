package searching_sorting;
import java.util.Arrays;
import java.util.Random;

public class SortingPerformance {
	private static final int n = 1000;
	private static int[] array1 = new int[n];
	private static int[] array2 = new int[n*2];
	private static int[] array3 = new int[n*3];
	private static int[] array4 = new int[n*4];
	private static int[] array5 = new int[n*5];
	private static int[] array6 = new int[n*6];
	private static int[] array7 = new int[n*7];
	private static int[] array8 = new int[n*8];
	private static int[] array9 = new int[n*9];
	private static int[] array10 = new int[n*10];

	private static int[][] array = {array1, array2, array3, array4, array5, array6, array7, array8, array9, array10};

	static void createRandomArray(int[] array) {
		Random rd = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = rd.nextInt();
		}
	}

	// O(n^2) sorting: Selection sorting

	// Selection sorting
	static int[] selectionSort(int[] array) {
		int n = array.length;
		int comparisonCount = 0;
		//Starting the timer
		long start = System.currentTimeMillis();
		for (int i = 0; i < n -1; i++) {
			int min_index = i;
			//Find the minimum element in the unsorted array
			for (int j = i+1; j < n; j++) {
				//Calculate the comparison being taken and added to the total
				comparisonCount++;

				if (array[j] < array[min_index])
					min_index = j;

				//Swap the minimum element with the first element
				int temp = array[min_index];
				array[min_index] = array[i];
				array[i] = temp;
			}
		}
		//Stopping the timer
		long end = System.currentTimeMillis();

		return new int[] {(int) (end - start), comparisonCount};
	}

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

	public static void SortingPerformanceToString() {
		System.out.println(Arrays.deepToString(SelectionSort()));
	}
 }

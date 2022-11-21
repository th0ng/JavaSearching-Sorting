package searching_sorting;

public class Sorting {
	static final int[] array = new int[] {-93, -36, 25, 44, -30, -21, 34, 56, 82, 64};

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
		int[] arrayToSort = new int[array.length];
		System.arraycopy(array, 0, arrayToSort, 0, array.length);

		System.out.println("Data set before insertion sorting:");
		for (int j : array)
			System.out.print(j + " ");
		System.out.println("\n");

		insertionSorting(arrayToSort);

		System.out.println("Data set after insertion sorting:");
		for (int j: arrayToSort)
			System.out.print(j + " ");
		System.out.println("\n");
	}
}

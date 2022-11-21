package searching_sorting;

public class Searching {
	private static final int[] array = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
	public static int LinearSearching(int key) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == key) {
				return i;
			}
		}
		return -1;
	}

	public static int BinarySearching(int key) {
		int first = 0;
		int last = array.length - 1;
		int mid = (first + last)/2;
		while (first <= last) {
			if (array[mid] < key)
				first = mid + 1;
			else if (array[mid] == key)
				return mid;
			else
				last = mid - 1;

			mid = (first + last)/2;
		}
		return -1;
	}
}

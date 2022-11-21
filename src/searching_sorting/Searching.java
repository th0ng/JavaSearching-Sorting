package searching_sorting;
import java.util.Scanner;

public class Searching {
	private static final int[] array = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

	static Scanner scanner = new Scanner(System.in);

	private static int linearSearch(int[] array, int key) {
		for (int j : array) {
			if (j == key)
				return 1;
		}
		return -1;
	}

	public static void LinearSearching() {
		int[] arrayForSearching = new int[array.length];
		System.arraycopy(array, 0, arrayForSearching, 0, array.length);
		System.out.print("In the list are values 0, ..., 9; which value would you like to search with linear search? ");
		String input = scanner.next();
		int key = Integer.parseInt(input);
		System.out.println();

		int result = linearSearch(arrayForSearching, key);
		if (result == -1) System.out.println("Not found\n");
		else System.out.println("Found\n");
	}

	private static int binarySearch(int[] v, int item) {
		int lo = 0, hi = v.length - 1;
		while (hi - lo > 1) {
			int mid = (hi + lo) / 2;
			if (v[mid] < item) {
				lo = mid + 1;
			}
			else {
				hi = mid;
			}
		}
		if (v[lo] == item)
			return lo;
		else if (v[hi] == item)
			return hi;
		return -1;
	}

	public static void BinarySearching() {
		int[] arrayForSearching = new int[array.length];
		System.arraycopy(array, 0, arrayForSearching, 0, array.length);

		System.out.print("In the list are values 0, ..., 9; which value would you like to search with binary search? ");
		String input = scanner.next();
		int key = Integer.parseInt(input);
		System.out.println();

		int result = binarySearch(arrayForSearching, key);
		if (result == -1) System.out.println("Not found\n");
		else System.out.println("Found\n");
	}
}

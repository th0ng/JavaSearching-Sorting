package searching_sorting;

public class LinearSearching {
	public static String LinearSearching(int key) {
		int[] array = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		for (int j : array) {
			if (j == key) {
				return "Found";
			}
		}
		return "Not found";
	}
}

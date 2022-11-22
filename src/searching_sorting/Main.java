package searching_sorting;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		boolean quit = false;

		while (!quit) {
			// Menu
			System.out.println("Menu of Searching and Soring Testbed.\n\n");
			System.out.println("1)  Linear searching");
			System.out.println("2)  Binary searching");
			System.out.println("3)  O(n^2) type of sorting");
			System.out.println("4)  O(n*log(n)) type of sorting");
			System.out.println("5)  Sorting performance\n\n");
			System.out.println("q/Q)  Quit\n\n");

			System.out.print("Your choice: ");
			char userInput = scanner.next().charAt(0);
			System.out.println();


			//Switch loop for different user inputs
			switch (userInput) {
				case '1' -> Searching.LinearSearching();
				case '2' -> Searching.BinarySearching();
				case '3' -> Sorting.InsertionSorting();
				case '4' -> Sorting.HeapSorting();
				case '5' -> SortingPerformance.SortingPerformanceToString();
				case 'q', 'Q' -> quit = true;
				default -> System.out.println("Input invalid. Please try again below.");
			}
		}

	}
}

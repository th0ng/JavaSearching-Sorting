package searching_sorting;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("Test");

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

			switch (userInput) {
				case '1' -> {
					System.out.print("In the list are values 0, ..., 9; which value would you like to search with linear search? ");
					int linearSearchItem = (int) scanner.next().charAt(0);
					System.out.println();
					int result = Searching.LinearSearching(linearSearchItem);
					if (result == -1)
						System.out.println("Not found");
					else
						System.out.println("Found");
				}
				case '2' -> {
					System.out.println("In the list are values 0, ..., 9; which value would you like to search with linear search? ");
					int binarySearchItem = (int) scanner.next().charAt(0);
					System.out.println();
					int result = Searching.BinarySearching(binarySearchItem);
					if (result == -1)
						System.out.println("Not found");
					else
						System.out.println("Found");
				}
				case '3' -> System.out.println("O(n^2) type of sorting");
				case '4' -> System.out.println("O(n*log(n)) type of sorting");
				case '5' -> System.out.println("Sorting performance");
				case 'q', 'Q' -> quit = true;
				default -> System.out.println("Input invalid. Please try again below.");
			}
		}

	}
}

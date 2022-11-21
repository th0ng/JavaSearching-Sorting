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
				case '1':
					System.out.print("In the list are values 0, ..., 9; which value would you like to search with linear search? ");
					char linearSearchItem = scanner.next().charAt(0);
					System.out.println();
					int linearSearchedItemInt = Character.getNumericValue(linearSearchItem);
					System.out.println(LinearSearching.LinearSearching(linearSearchedItemInt) + "\n");
					break;
				case '2':
					System.out.println("Binary searching will be implement soon.");
					break;
				case '3':
					System.out.println("O(n^2) type of sorting");
					break;
				case '4':
					System.out.println("O(n*log(n)) type of sorting");
					break;
				case '5':
					System.out.println("Sorting performance");
					break;
				case 'q':
				case 'Q':
					quit = true;
					break;
				default:
					System.out.println("Input invalid. Please try again below.");
					break;
			}
		}

	}
}

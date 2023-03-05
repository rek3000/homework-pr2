package Ex1;

import java.util.Scanner;

public class Arrays {
	static Scanner initScan = new Scanner(System.in);

	public static void main(String[] args) {
		while (true) {
			System.out.println("1. Count the negative elements");
			System.out.println("2. Count the even elements of an array of positive integers");
			System.out.println("3. Divide the elements by a real number");
			System.out.println("4. Find the minimum int element");
			System.out.println("5. Determine if an array of integers is int ascending order");
			System.out.println("6. Find the length of an array of CHARs");
			System.out.println("7. Find the median of an array of reals");
			System.out.println("8. Compare two arbitrary arrays of reals, a and b");
			System.out.println("9. Compute the frequencies of each element of an array of reals");
			System.out.println("0. Exit");
			System.out.print("> ");

			int choice;
			try {
				choice = initScan.nextInt();
			} catch (Exception e) {
				initScan.nextLine();
				System.out.println("INVALID!");
				continue;
			}

			if ((choice < 0) || (choice > 9)) {
				continue;
			} else if (choice == 0) { 
				break;
			}
			initScan.nextLine();
			// initScan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			switch (choice) {
				case 1:
					countNegatives();
					break;

				case 2:
					countEvens();
					break;

				case 3:
					divArray();
					break;

				case 4:
					min();
					break;

				case 5:
					isAscSorted();
					break;

				case 6:
					length();
					break;

				case 7:
					break;

				case 8:
					break;

				case 9:
					break;

				default:
					break;
			}
		}
	}

	/**
	 *
	 */
	public static void countNegatives() {
		System.out.println("Enter the length of the array");
		System.out.print("> ");
		int len = initScan.nextInt();
		int[] arr = new int[len];

		for (int i = 0; i < arr.length; i++) {
			System.out.print(i + " element: ");
			arr[i] = initScan.nextInt();
		}

		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 0) {
				count++;
			}
		}

		System.out.println("The number of elements of an array of integers that are negative: " + count);
		System.out.println();
	}

	/**
	 *
	 */
	public static void countEvens() {
		System.out.println("Enter the length of the array");
		System.out.print("> ");
		int len = initScan.nextInt();
		int[] arr = new int[len];

		for (int i = 0; i < arr.length; i++) {
			System.out.print(i + " element: ");
			arr[i] = initScan.nextInt();
		}

		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 0) {
				return;
			}

			if (arr[i]%2 == 0) {
				count++;
			}
		}

		System.out.println("The number of even elements: " + count);
		System.out.println();
	}

	/**
	 *
	 */
	public static void divArray() {
		System.out.println("Enter the length of the array");
		System.out.print("> ");
		int len = initScan.nextInt();
		double[] arr = new double[len];

		for (int i = 0; i < arr.length; i++) {
			System.out.print(i + " element: ");
			arr[i] = initScan.nextDouble();
		}

		System.out.println("Divisor");
		System.out.print("> ");
		double divisor = initScan.nextDouble(); 

		System.out.println("Before");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr[i]/divisor;
		}

		System.out.println();

		System.out.println("After");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	/**
	 *
	 */
	public static void min() {
		System.out.println("Enter the length of the array");
		System.out.print("> ");
		int len = initScan.nextInt();
		int[] arr = new int[len];

		for (int i = 0; i < arr.length; i++) {
			System.out.print(i + " element: ");
			arr[i] = initScan.nextInt();
		}

		int min = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (min < arr[i]) {
				min = arr[i];
			}
		}

		System.out.println("The minimum int element: " + min);
	}

	/**
	 *
	 */
	public static void isAscSorted() {
		System.out.println("Enter the length of the array");
		System.out.print("> ");
		int len = initScan.nextInt();
		int[] arr = new int[len];

		for (int i = 0; i < arr.length; i++) {
			System.out.print(i + " element: ");
			arr[i] = initScan.nextInt();
		}

		int min = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (min < arr[i]) {
				min = arr[i];
			}
		}
	}

	/**
	 *
	 */
	public static void length() {
		System.out.println("Enter the char array");
		System.out.print("> ");
		String str = initScan.nextLine().trim();

		if (str.contains("\\u0000")) {
			str = str.substring(0, str.indexOf("\\u0000"));
		} else if (str.contains("\\0")) {
			str = str.substring(0, str.indexOf("\\0"));
		}                      

		char[] array = str.toCharArray();
		System.out.println("The length of the array is " + array.length);
		System.out.println();                                                                             
	}

	/**
	 *
	 */
	public static void median() {

	}

	/**
	 *
	 */
	public static void compare() {

	}

	/**
	 *
	 */
	public static void freq() {

	}

}

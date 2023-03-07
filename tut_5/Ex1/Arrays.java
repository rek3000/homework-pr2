package Ex1;

import java.util.Scanner;

public class Arrays {
	static Scanner initScan = new Scanner(System.in);

	public static void main(String[] args) {
		menuLoop();
	}

	private static void menuLoop() {
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

			switch (choice) {
				case 1:
					countNegatives(initIntArray());
					break;

				case 2:
					countEvens(initIntArray());
					break;

				case 3:
					divArray(initDoubleArray());
					break;

				case 4:
					min(initIntArray());
					break;

				case 5:
					isAscSorted(initIntArray());
					break;

				case 6:
					System.out.println("Enter the char array");
					System.out.print("> ");
					String str = initScan.nextLine().trim();
					length(str);
					break;

				case 7:
					median(initDoubleArray());
					break;

				case 8:
					break;

				case 9:
					freq(initDoubleArray());
					break;

				default:
					break;
			}
		}
	}

	private static int[] initIntArray() {
		System.out.println("Enter the length of the array");
		System.out.print("> ");
		int len = initScan.nextInt();
		int[] arr = new int[len];

		for (int i = 0; i < arr.length; i++) {
			System.out.print("Array[" + i + "]: ");
			arr[i] = initScan.nextInt();
		}

		return arr;
	}

	private static double[] initDoubleArray() {
		System.out.println("Enter the length of the array");
		System.out.print("> ");
		int len = initScan.nextInt();
		double[] arr = new double[len];

		for (int i = 0; i < arr.length; i++) {
			System.out.print("Array[" + i + "]: ");
			arr[i] = initScan.nextDouble();
		}

		return arr;
	}
	/**
	 *
	 */
	public static void countNegatives(int[] arr) {
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
	public static void countEvens(int[] arr) {
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
	public static void divArray(double[] arr) {
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
	public static void min(int[] arr) {
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
	public static void isAscSorted(int[] arr) {
		int min = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (min > arr[i]) {
				System.out.println("This array is not in ascending order");
			} else {
				System.out.println("This array is in ascending order");
			}
		}
	}

	/**
	 *
	 */
	public static void length(String str) {
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
	public static void median(double[] arr) {
		int x = arr.length/2;

		if (arr.length%2 == 0) {
			System.out.println("Median: " + arr[x] + "," + arr[x + 1]);
		} else {
			System.out.println("Median: " + arr[x + 1]);
		}
	}

	/**
	 *
	 */
	public static void compare(double[] arr) {

	}

	/**
	 *
	 */
	public static void freq(double[] arr) {
		int[] freq = new int[arr.length];
		int existed = -1;

		for (int i = 0; i < arr.length; i++) {
			int count = 1; 
			
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					++count;
					freq[j] = existed;
				}
			}

			if (freq[i] != existed) {
				freq[i] = count;
			}
		}

		System.out.println("~ELEMENTS + FREQUENCY~");
		for (int i = 0; i < arr.length; i++) {
			if (freq[i] != existed) {
				System.out.print(arr[i] + " | " + freq[i]);
			}
			System.out.println();
		}
	}
}

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
					System.out.println("First array");
					double[] arr1 = initDoubleArray();
					System.out.println();
					System.out.println("Second array");
					double[] arr2 = initDoubleArray();
					compare(arr1, arr2);
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
	 * Count the negative numbers
	 * @requires arr is an integer arrray
	 * @effects Count then print the negative elements of arr
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
	 * Count the even numbers
	 * @requires arr is an array of positive integer numbers.
	 * @effects Count then print the even numbers of arr
	 */
	public static void countEvens(int[] arr) {
		int count = 0;
		// check if the array contains positive numbers or not
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 0) {
				System.out.println("Invalid array!");
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
	 * Divide each elements with an input divisor
	 * @requires an array of real numbers
	 * @modifiers arr
	 * @effects 
	 * 	Get the divisor from the input
	 * 	Each element is divided by the divisor
	 * 	Print the array before and after dividing to the console
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
	 * Compute the minimum elements
	 * @requires an array of integer numbers
	 * @effects 
	 *	Loop through the array then find 
	 * 	the minimum number
	 * 	Print the result to the console
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
	 * Check ascending order
	 * @requires an array of integer numbers
	 * @effects Check if the array is in ascending order or not
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
	 * @requires a string 
	 * @modifiers str
	 * @effects 
	 * 	Filt the terminator char
	 * 	Convert the string to a char array
	 * 	Calculate the length of the char array
	 * 	Print the result to the console
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
	 * @requires an array of real numbers
	 * @effects Find the median of the array
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
	 * Compare two arrays with respect to the criteria
	 * @requires two array (arr1 and arr2) of real numbers
	 * @effects
	 * 	Create three boolean var, isSubset, isEqual, isIntersect
	 *	arr1.length = arr2.length -> compare each element
	 *	arr1.length > arr2.length \/ arr1.length < arr2.length -> 
	 *		determine with one is a subset of another
	 *	Print the final result to the console
	 */
	public static void compare(double[] arr1, double[] arr2) {
		boolean isSubset = false;
		boolean isEqual = false;
		boolean isIntersect = false;

		if (arr1.length == arr2.length) {
			int count = 0;
			for (int x = 0; x < arr1.length; x++) {
				if (arr1[x] == arr2[x]) {
					count++;
				}
			}
			
			if (count == arr1.length) {
				isEqual = true;
			} else if (count > 0) {
				isIntersect = true;
			}
		}

		if (arr1.length > arr2.length) {
			isSubset = true;

			int[] temp = new int[arr1.length];
			int existed = -1;
			for (int i = 1; i < temp.length; i++) {
				temp[i] = 0;
			}

			int count = 0;
			for (int i = 0; i < arr2.length; i++) {
				for (int j = 0; j < arr1.length; j++) {
					if ((arr2[i] == arr1[j]) && temp[j] != existed) {
						count++;
						temp[j] = existed;
					}
				}
			}

			if (count != arr2.length) {
				isSubset = false;
			} else if (count > 0) {
				isIntersect = true;
			}
		}

		if (arr1.length < arr2.length) {
			isSubset = true;

			int[] temp = new int[arr2.length];
			int existed = -1;
			for (int i = 1; i < temp.length; i++) {
				temp[i] = 0;
			}

			int count = 0;
			for (int i = 0; i < arr1.length; i++) {
				for (int j = 0; j < arr2.length; j++) {
					if ((arr1[i] == arr2[j]) && temp[j] != existed) {
						count++;
						temp[j] = existed;
					}
				}
			}

			if (count != arr1.length) {
				isSubset = false;
			} else if (count > 0) {
				isIntersect = true;
			}
		}

		System.out.println("Result:");
		System.out.println("	>Subset: " + isSubset);
		System.out.println("	>Equal: " + isEqual);
		System.out.println("	>Intersect: " + isIntersect);
	}

	/**
	 * Find the frequency of each element
	 * @requires an array of real numbers
	 * @effects 
	 * 	Create a temporary array to store the frequency
	 * 	Loop through the array then count
	 * 	While in the loop, distinguish the dupplicate element 
	 * 	in order to not count the same element twice
	 * 	Print the result to the console
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

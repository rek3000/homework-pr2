package working_array_02;
import utils.TextIO;

public class Array {
	public static void main(String[] args) {
		System.out.println("Define the matrix");
		System.out.print("Row> ");
		int row = TextIO.getlnInt();
		System.out.print("Collumn> ");
		int collumn = TextIO.getlnInt();
		System.out.println(row + "|" + collumn);

		// initialize the matrix
		int[][] arr = new int[row][collumn];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < collumn; j++) {
				System.out.printf("Element[%d][%d]: ", i, j);
				arr[i][j]= TextIO.getlnInt();
			}
		}

		System.out.println();
		System.out.println("Created matrix");
		printMatrix(arr);

		int[][] transposed = transposeMatrix(arr);

		System.out.println("The matrix after transposed");
		printMatrix(transposed);
	}

	static void printMatrix(int[][] arr) {
		int row = arr.length;
		int collumn = arr[0].length;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < collumn; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println();
	}

	static int[][] transposeMatrix(int[][] arr) {
		int row = arr.length;
		int collumn = arr[0].length;
 
		int[][] transposed = new int[collumn][row];
		for (int i = 0; i < transposed.length; i++) {
			for (int j = 0; j < transposed[0].length; j++) {
				transposed[i][j]= arr[j][i];
			}
		}

		return transposed;
	}
}

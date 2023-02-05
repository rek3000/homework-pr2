package count_change_2_4;
import utils.TextIO;

public class CountChange {
	public static void main(String[] args) {
		int q, d, n, p;
		
		System.out.print("Enter your number of quarters: ");
		q = TextIO.getInt();
		System.out.print("Enter your number of dimes: ");
		d = TextIO.getInt();
		System.out.print("Enter your number of nickles: ");
		n = TextIO.getInt();
		System.out.print("Enter your number of pennies: ");
		p = TextIO.getInt();
		
		double total = (double) (25*q + 10*d + 5*n + 1*p) / 100;
		System.out.println("You have " + total + " dollars");

	}
}

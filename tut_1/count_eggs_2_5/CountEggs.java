package count_eggs_2_5;

import utils.TextIO;

public class CountEggs {
	public static void main(String[] args) {
		System.out.println("How many eggs do you have: ");
		int eggs = TextIO.getInt();
		
		int gross = eggs/144;
		int dozen = (eggs%144)/12;
		int left_over = eggs - gross*144 - dozen*12;
		
		System.out.println("You have:\n" + gross + " gross eggs\n" + dozen + " dozen eggs\n" + left_over + " left over eggs");
		System.out.println();
		
	}

}
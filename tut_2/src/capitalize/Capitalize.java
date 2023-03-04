package capitalize;

import java.util.Scanner;

public class Capitalize {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str = input.nextLine();
		printCapitalized(str);
	}

	public static void printCapitalized(String str) {
		char ch;
		char prev;
		prev = '.';

		for (int i = 0; i < str.length(); i++) {
			ch = str.charAt(i);
			if (Character.isLetter(ch) && ! Character.isLetter(prev)) {
				System.out.print(Character.toUpperCase(ch));
			} else {
				System.out.print(ch);
			}
			prev = ch;
		}
	}
}

package hexaValue;

import java.util.Scanner;

public class Hexa {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str = input.nextLine();
		str = str.trim();
		int value = 0;
		for (int i = 0; i < str.length(); i++) {
			value = value*16 + hexValue(str.charAt(i));
		}

		System.out.println(value);
	}
	
	public static int hexValue(char ch) {
		int result = -1;
		switch (ch) {
		case 'a': 
		case 'A': {
			result = 10;
			break;
		}
		case 'b': 
		case 'B': {
			result = 11;
			break;
		}
		case 'c': 
		case 'C': {
			result = 12;
			break;
		}
		case 'd': 
		case 'D': {
			result = 13;
			break;
		}
		case 'e': 
		case 'E': {
			result = 14;
			break;
		}
		case 'f': 
		case 'F': {
			result = 15;
			break;
		}
		default:
			result = Character.getNumericValue(ch);
			break;
		}
		if (result < 0 || result > 15) {
			return -1;
		} else {
			return result;
		}
	}
}

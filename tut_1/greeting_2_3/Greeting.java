package greeting_2_3;

import utils.TextIO;
public class Greeting {
	public static void main(String[] args) {

		String str = new String();
		System.out.println("Enter your name: ");
		str = TextIO.getln();
		System.out.println("Hello, " + str.toUpperCase() + ". Nice to meet you!");
	}
}

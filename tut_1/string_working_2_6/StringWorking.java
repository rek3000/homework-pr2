package string_working_2_6;
import utils.TextIO;

public class StringWorking {
	public static void main(String[] args) {
		System.out.println("Please enter your first name and last name, separated by space");
		System.out.print("> ");
		String fullName = TextIO.getln();
		System.out.println(fullName);
		
		int posOfSpace = fullName.indexOf(" ");
		String firstName = fullName.substring(0, posOfSpace);
		String lastName = fullName.substring(posOfSpace + 1);
		
		System.out.println("Your first name is " + firstName + ", which has " + firstName.length() + " characters");
		System.out.println("Your last name is " + lastName + ", which has " + lastName.length() + " characters");
		System.out.println("Your initials are " + firstName.charAt(0) + lastName.charAt(0));
		
	}
}

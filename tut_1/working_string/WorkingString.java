package working_string;
import java.util.Arrays;

public class WorkingString {
	public static void main(String[] args) {
		String str = "to be or not to be";
		char chars[] = str.toCharArray();
		String charsAsString = Arrays.toString(chars);

//		int len = chars.length;
		int len = str.length();

		String w1 = str.substring(3,5);
		String w2 = str.substring(16,18);

		boolean equal = w1.equals(w2);
//		boolean equal = (w1 == w2);
		
		System.out.println("string: " + str);
		System.out.println("length: " + len);
		System.out.println("word 1: " + w1);
		System.out.println("word 2: " + w2);
		System.out.println("word 1 is equal to word 2? " + equal);
		System.out.println("characters: " + charsAsString);
	}
}

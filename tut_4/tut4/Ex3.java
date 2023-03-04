package tut4;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import chapter03.TextIO;
import chapter03.TextIOPlus;

public class Ex3 {
	public static void main(String[] args) {
		
		String url = TextIO.getln();
		String result = TextIOPlus.readTextFromURL(url);

		try {
			CompilationUnit codeUnit = JavaParser.parse(result);
			System.out.println(codeUnit);
		} catch (Exception e) {
			System.out.println("Invalid url!");
		}
	}
}

package tut4;

import chapter03.TextIOPlus;
import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
public class Ex2 {
	public static void main(String[] args) {
		String result = TextIOPlus.readTextFileContent("/home/rek/Projects/java/tut_4/src/tut4/Hello.j");
		CompilationUnit codeUnit = JavaParser.parse(result);
		
		System.out.println(codeUnit);
	}
}

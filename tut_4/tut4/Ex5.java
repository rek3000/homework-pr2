package tut4;

import chapter03.TextIOPlus;
import chapter03.ASTPrinter;
import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;

public class Ex5 {
	public static void main(String[] args) {
		String fileContent = TextIOPlus.readTextFileContent("/home/rek/Projects/java/tut_4/src/tut4/Hello.java");
//		CompilationUnit codeUnit = JavaParser.parse(fileContent);
		
		ASTPrinter.print(fileContent);


		
	}

}

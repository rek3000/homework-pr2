package tut4;

import utils.TextIO;
import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;

public class ProgWriter {
	public static void main(String[] args) {
		String template = new String("public class _ClassName_ {"
				+ "public static void main(String[] args) {"
				+ "System.out.println(_Greeting_);"
				+ "}"
				+ "}");

		System.out.println("Print to console program template");
		System.out.println("Enter class name");
		System.out.print("> ");
		String className = utils.TextIO.getln().trim();

		System.out.println("Enter text to print");
		System.out.print("> ");
		String greet = utils.TextIO.getln().trim();

		template = template.replace("_ClassName_", className);
		template = template.replace("_Greeting_", greet);

		CompilationUnit result = JavaParser.parse(template);
		
		System.out.println(result);




	}

}

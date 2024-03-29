package calc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleCalc {

	   public static void main(String[] args) throws IOException {
	      String expression;
	      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	      System.out.print("Enter expression: ");
	      expression = br.readLine();

	      PostFixConverter pc = new PostFixConverter(expression);
	      System.out.print("Postfix: ");
	      pc.printExpression();

	      PostFixCalculator calc = new PostFixCalculator(pc.getPostfixAsList());
	      System.out.println();
	      System.out.println("Result: " + calc.result());
	   }
	}

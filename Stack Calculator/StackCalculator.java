// Name: Sridevi Nataraj 
// Student Id: 40005572 
// Stack Calculator: Add, subtract, divides and multiplies various types of expressions. 

import java.util.Scanner;
import java.util.Stack;

public class StackCalculator {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// Create stack arrays

		Stack<Integer> op = new Stack<Integer>();
		Stack<Double> op1 = new Stack<Double>();

		// create temporary stacks arrays for the operators and operands
		Stack<Integer> optmp = new Stack<Integer>();
		Stack<Double> op1tmp = new Stack<Double>();

		// Ask the user to enter the expression to be solved
		System.out.println("Enter expression");
		String input = scan.next();
		input = "0" + input;
		input = input.replaceAll("-", "+-");

		// Store operands and operators in respective stacks
		String temp = "";
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			if (ch == '-')
				temp = "-" + temp;
			else if (ch != '+' && ch != '*' && ch != '/' && ch != '^')
				temp = temp + ch;
			else {
				op1.push(Double.parseDouble(temp));
				op.push((int) ch);
				temp = "";
			}
		}

		op1.push(Double.parseDouble(temp));
		// Create char array of operators as per precedence

		char operators[] = { '/', '*', '+', '^' };

		for (int i = 0; i < 3; i++) {
			boolean it = false;
			while (!op.isEmpty()) {
				int optr = op.pop();
				double v1 = op1.pop();
				double v2 = op1.pop();
				double result = Math.pow(v1, v2);
				if (optr == operators[i]) {
					// if operator matches evaluate and store in temporary stack
					if (i == 0) {
						op1tmp.push(v2 / v1);
						it = true;
						break;
					} else if (i == 1) {
						op1tmp.push(v2 * v1);
						it = true;
						break;
					} else if (i == 2) {
						op1tmp.push(v2 + v1);
						it = true;
						break;
					}

					else if (i == 3)

						op1tmp.push(Math.pow(v2, v1));
					it = true;
					break;
				} else {
					op1tmp.push(v1);
					op1.push(v2);
					optmp.push(optr);
				}
			}
			// Push back all elements from temporary stacks to main stacks
			while (!op1tmp.isEmpty())
				op1.push(op1tmp.pop());
			while (!optmp.isEmpty())
				op.push(optmp.pop());
			//Iterate again for same operator
			if (it)
				i--;
		}
		System.out.println("\nResult = " + op1.pop());
	}
}
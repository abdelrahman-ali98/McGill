import acm.program.ConsoleProgram;

/**
 * This class responsible for user dialog
 * to convert a mathematical expression from 
 * Infix to postFix and then show the result
 * of the postFix expression.
 * 
 * @author Abdelrahman Ali
 * McGill Id #260903307
 * This is part of assignment 4 for McGill ECSE 202 winter 2021.
 *
 */
public class JCalc extends ConsoleProgram {

	public void run() {
		
		println("Infix to Postfix conversion, enter expression of blank line to exit.");
		postFix pf = new postFix();
		
		while (true) {
			
			String userInput = readLine("expr: ");
			if (userInput.equals("")) break;													// Terminate when the user input empty field
			
			String input = "";
			for (char c : userInput.toCharArray() )												// remove all empty spaces from the user input
				if (c != ' ')
					input +=c;
			
			
			Queue<String> tokens = pf.parse(input);												// Convert User Input to  set of tokens
			Queue<String> postFixResult = pf.In2Post(tokens);									// Convert tokens to a postFix
			
			println(userInput + " => " + postFixResult.toString());								// print postFix expression to the user
			println(postFixResult.toString() + "evaluates to " + pf.PostEval(postFixResult));	// show Final Results to the user
		}
		
		println("Program terminated.");
	}
}

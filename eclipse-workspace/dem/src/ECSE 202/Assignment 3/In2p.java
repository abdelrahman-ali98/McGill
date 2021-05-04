import acm.program.ConsoleProgram;
/**
 * This class responsible for user dialog
 * to convert a mathematical expression from 
 * Infix to postFix
 * 
 * @author Abdelrahman Ali
 * McGill Id #260903307
 * This is part of assignment 3 for McGill ECSE 202 winter 2021.
 *
 */
public class In2p extends ConsoleProgram {
	
	public void run () {
		
		println ("Infix to Postfix conversion, enter expression of blank line to exit.");
		
		postFix pf = new postFix();								// create new postFix instance

		while(true) {
			
			String userInput = readLine("expr: ");
			if (userInput.equals("")) break;						// Terminate when the user input empty field
			
			String input = "";
			for (char c : userInput.toCharArray() )					// remove all empty spaces from the user input
				if (c != ' ')
					input +=c;
			
			Queue<String> q = pf.parse(input);						// parse the input into tokens

			println(userInput + " ==> "+ pf.In2Post(q).toString());	// show the result in postFix form

		
		}
		
		println("Program terminated.");
	}
}

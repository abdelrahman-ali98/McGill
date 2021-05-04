import acm.program.ConsoleProgram;
/**
 * @author Abdelrahman Ali
 * McGill Id #xxxxxxx
 * This is assignment 1 for McGill ECSE 202 winter 2021.
 *
 */
public class BaseConversion extends ConsoleProgram {

	private int base;
	private int number;
	private static final char[] LUT = ("0123456789ABCDEF").toCharArray();
	
	
	/*
	 * Entry point of the program and contains
	 *  user prompts for the program.
	 * 
	 */
	public void run() {
		
		println("Base Conversion Program; converts +ve integers to a target base.");
		println("Enter number to be converted and target base on separate lines following the prompts.");
		println("A blank entry for either input terminates the program.");
		
		while(true) {
			String userInput = readLine("Number > ");
			if(userInput.equals("")) break;
			
			number = string2Int(userInput);
			if (number < 0) {
				println("Error! " + userInput + " does not correspond to a positive integer.");
				continue;
				}
			
			userInput = readLine("Target base > ");
			if(userInput.equals("")) break;
			
			base = string2Int(userInput);
			if (base < 2 || base >16 ) {
				println("The base must be between 2 and 16 inclusive.");
				continue;
				}
			String result = baseConv(number, base);
			println( number +" experessed in base " + base + " is " + result);			
		}		
		println("Program terminated.");
		
	}
	
	/**
	 * You may use this method to convert a user String input
	 *  to corresponding integer value.
	 *  Any blank entry is considered as invalid input.
	 *  + sign before the number is considered as invalid as well
	 * @param input The user input to be converted to integer if possible
	 * @return -1 if invalid input was entered by user
	 */
	private int string2Int(String input) {
				
		// define the input as int and start looping for each char 
		int inputInt = 0;
		
		for (char c : input.toCharArray()) 
			// making sure that the input is a number 
			if (c >= '0' && c <= '9' &&
			(inputInt < Integer.MAX_VALUE/10 || 
					(inputInt == Integer.MAX_VALUE/10 && c - '0' < 8))) 
					inputInt = inputInt*10 + (c-'0');
			else return -1;
		
		return  inputInt ;
	}
	
	/**
	 * @param number The Number to be converted
	 * @param base The target base for the Number
	 * @return The Number as String after converting to the target base
	 */
	private String baseConv(int number, int base) {
		
	//	if (number <= 0) return "0"; // corner case
		String output = "";
		while (number > 0) {
			output = LUT[number%base] + output;
			number = number/base;
		}
				return output;
	}
}

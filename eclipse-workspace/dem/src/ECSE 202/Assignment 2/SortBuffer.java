import acm.program.ConsoleProgram;

/**
 * This class implements a program to read user inputs Text and print them
 * in ascending order and descending order with respect to alphabets.
 * B-tree Structure is being used.
 * 
 * @author Abdelrahman Ali
 * McGill Id #XXXXXXXX
 * This is part of assignment 2 for McGill ECSE 202 winter 2021.
 * 
 */
public class SortBuffer extends ConsoleProgram {

	/**
	 * Entry point for this program
	 */
	public void run() {
		
		println("Text sorting Program:   (ECSE 202 - Assignment 2)");
		println("Enter text to be sorted, line by line. A blank line terminates.");
		println("You can cut and paste text into this window:\n");
		
		bTree<String> myTree = new bTree<String>();     //create and parameterize bTree Object 
		myTree.setDisplay(this);						// set the display to this consleProgram

		while(true) {
			String input = readLine();					//Take user input
			if (input.equals("")) break;				// Terminate when empty value entered
			myTree.addNode(input);						// add node to the tree
		}
		
		println("Text in sort order: \n");
		myTree.displayInOrder();						//Print values in order
		
		println("");
		
		println("Text in reverse sort order: \n");
		myTree.displayInReverseOrder();					//Print values in reverse order
		println("");

		println("Program terminated.");
		
	}
	public void test() {
		
	}
}

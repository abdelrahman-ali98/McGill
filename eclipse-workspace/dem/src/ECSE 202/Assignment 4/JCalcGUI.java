import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JTextField;

import acm.gui.TableLayout;
import acm.program.Program;


/**
 * This class creates a user GUI with buttons
 * to convert a mathematical expression from 
 * Infix to postFix and then show the result
 * of the postFix expression.
 * 
 * @author Abdelrahman Ali
 * McGill Id #260903307
 * This is part of assignment 4 for McGill ECSE 202 winter 2021.
 *
 */
public class JCalcGUI extends Program {

	/* User Input Field */
	private JTextField infixField;
	/* Field to show the result to the user */
	private JTextField resultField;
	
	/* create postFix instance to be used across the program */
	postFix post = new postFix();	
	
	/**
	 * Entry point to the program
	 */
	public void init() {
		
		setLayout(new TableLayout(9, 4));				// set a TableLayout Manager to take care of the UI 
		
		infixField = new JTextField();					// set the TextField where the user will enter values
		infixField.setActionCommand("=");				// when user hit enter, will be treated as =
		infixField.addActionListener(this);				// add Listener to the TextField
		add(infixField, "gridwidth=4");					// add to the layout and fill all the row
		
		resultField = new JTextField();					// set a plain TextField to show result
		add(resultField, "gridwidth=4");				// add to the layout and fill all the row
		
		addButtons();									// set the rest of the layout
		addActionListeners(this);;						// set Listeners for the actions
		setBackground(new Color(122, 166, 253));		// set the background color
		
	}
	
	/**
	 * when call this method, all buttons will
	 * be added to the layout
	 * 
	 */
	private void addButtons() {
		add(new JButton("C")); add(new JButton()); add(new JButton("%")); add(new JButton("/"));
		add(new JButton("7")); add(new JButton("8")); add(new JButton("9")); add(new JButton("x"));
		add(new JButton("4")); add(new JButton("5")); add(new JButton("6")); add(new JButton("-")); 
		add(new JButton("1")); add(new JButton("2")); add(new JButton("3")); add(new JButton("+"));
		add(new JButton("0")); add(new JButton(".")); add(new JButton("^")); add(new JButton("="));
		add(new JButton("(")); add(new JButton(")")); add(new JButton()); add(new JButton());
		add(new JButton()); add(new JButton()); add(new JButton()); add(new JButton("Quit"));
	}
	/**
	 * This method handles all actions when the
	 * user hits any button
	 */
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		switch(cmd) {
		case "x"   	: infixField.setText(infixField.getText() + "*"); break;	// append * to the TextField when user hit x button
		case "C"   	: infixField.setText(""); resultField.setText(""); break;	// Clear all text fields
		case "Quit"	: System.exit(0);  break;									// Kill the program, 0 indicates a normal termination
		case "="   	: printResult();											// show result for the input and continue switch statement
		case "+" 	:
		case "-" 	: 
		case "/" 	:
		case "%" 	:
		case "^" 	:
		case "*" 	:
		case "0" 	:
		case "1" 	:
		case "2" 	:
		case "3" 	:
		case "4" 	:
		case "5" 	:
		case "6" 	:
		case "7" 	:
		case "8" 	:
		case "9" 	:
		case "." 	:
		case "(" 	:	 
		case ")" 	: infixField.setText(infixField.getText() + cmd);			// Append digit or operator to the input
		}
	}
	/**
	 * This method handles the input and show 
	 * the results to the user
	 */
	private void printResult() {
		
		String userInput = infixField.getText();								// get user input as a String
		
		if (userInput.charAt(userInput.length()-1) == '=')						//Check if user hit = twice
			userInput = userInput.substring(0, userInput.length()-1);			// if yes, delete the '=' at the end of the text

		infixField.setText(userInput);			
		
		String input = "";		
		for (char c : userInput.toCharArray() )									// remove all empty spaces from the user input
			if (c != ' ')
				input +=c;
												
		
		Queue<String> tokens = post.parse(input);								// parse tokens
		Queue<String> postFixResult = post.In2Post(tokens);						// get postFix expression
		
		
		resultField.setText(String.valueOf(post.PostEval(postFixResult)));		// Calculate and show the result
	}
}

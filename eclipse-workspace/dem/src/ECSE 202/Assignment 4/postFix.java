import java.util.StringTokenizer;

/**
 * This class were designed to convert mathematical
 * InFix input and return the PostFix as a Queue.
 * 
 * @author Abdelrahman Ali
 * McGill Id #XXXXXXXX
 * This is part of assignment 3&4 for McGill ECSE 202 winter 2021.
 *
 */
public class postFix {

	/**
	 * @param arg mathematical InFix 
	 * @return queue of the numbers and operators in the input
	 */
	public Queue<String> parse(String arg) {
		
		StringTokenizer str = new StringTokenizer(arg, "*-+/()^%", true);	// define delims and returnDelims as well
		Queue<String> output = new Queue<String>();
		
		while (str.hasMoreTokens())
			output.enqueue(str.nextToken());								// enqueue all tokens
		return output;
	}
	
	/**
	 * @param Qin queue of numbers '0' to '9' and operators "*-+/()^%"
	 * @return queue of the PostFix expression
	 */
	public Queue<String> In2Post(Queue<String> Qin) {
		
		Stack<String> operator = new Stack<String>();						// temporally stack to hold operators
		Queue<String> output = new Queue<String>();							// this outputs holds the PostFix
		
		String front = Qin.dequeue();
		
		while(front != null) {												// check if there is anymore tokens
			if (isOperator(front) ) 										// check if its an operator
				
				if (front.equals("(") || front.equals(")"))					// check if parentheses
					pushParentheses(front, operator, output);				// deal with the parentheses 
				else
					pushOperator(front, operator, output);					// deal with the operator
				
			else output.enqueue(front);										// its a number >> enqueue to the output
				
			front = Qin.dequeue();
			}	
	
		/* Adding all remaining operator to the Queue */
		String pop = operator.pop();										
		while (pop != null) {
			output.enqueue(pop);
			pop = operator.pop();
			}
		return output;
	}
	
	/**
	 * @param front token to be added to the postFix expression
	 * @param operator stack to hold operators temporally before popping them to the output
	 * @param output the postFix expression so far
	 */
	private void pushOperator(String front, Stack<String> operator, Queue<String> output) {
		
		int precedence = getPrecedence(front);								// check precedence of the operator
		
		String topOperator = operator.pop();								// pop operator on top to compare with the current one
		
		while (topOperator !=null) {										// check if operator' stack is already empty
			if (precedence > getPrecedence(topOperator))  {					// check if current is greater than the one on top
				operator.push(topOperator);									// push the one top back to the stack 
				break;
			} else if (precedence <= getPrecedence(topOperator)) 			
				output.enqueue(topOperator);								// enqueue the operator to the output and repeat until its greater
			topOperator = operator.pop();
		}
		
		operator.push(front);												// add the current operator to the stack
	}
	
	/**
	 * @param front token to be added to the postFix expression
	 * @param operator stack to hold operators temporally before popping them to the output
	 * @param output the postFix expression so far
	 */
	private void pushParentheses(String front, Stack<String> operator, Queue<String> output) {
		
		if(front.equals("(")) 								// check if its an open or closed
			operator.push(front);							// push it to the operator stack
		
		else if (front.equals(")")) {						// if closed, pop all operator until you find "("
			String top = operator.pop();
			while (top != null && !top.equals("(")) {
				output.enqueue(top);
				top = operator.pop();
			}			
		}		
	}
	
	/**
	 * @param front the operator to check 
	 * @return integer represent the precedence of the operator +,- << *,/,% << ^
	 */
	private int getPrecedence(String front) {
		switch (front) {
		case "+" :
		case "-" : return 1;
		case "*" :
		case "/" :
		case "%" : return 2;
		case "^" : return 3;
		}
		return -1;
	}

	/**
	 * @param o takes a Character represented as a String
	 * @return if the argument is -+%/*^() will return true
	 */
	private boolean isOperator(String o) {
	
		switch (o) {
		case "*" : 
		case "/" : 
		case "-" : 
		case "+" : 
		case "(" : 
		case ")" : 
		case "^" : return true;
		}
		return false;
	}
	
	public double PostEval (Queue<String> PostFix) {
		
		Double output;
		Stack<String> stack = new Stack<String>();
		
		String token = PostFix.dequeue();
		
		while (token != null) {
			
			if (isOperator(token)) {
				Double d1 = Double.parseDouble(stack.pop());
				Double d2 = Double.parseDouble(stack.pop());
				switch (token) {
				case "+" : stack.push(String.valueOf((double)d2+d1)); break;
				case "-" : stack.push(String.valueOf((double)d2-d1)); break;
				case "*" : stack.push(String.valueOf((double)d2*d1)); break;
				case "/" : stack.push(String.valueOf((double)d2/d1)); break;
				case "%" : stack.push(String.valueOf((double)d2%d1)); break;
				case "^" : stack.push(String.valueOf((double)Math.pow(d2, d1)));
				}
			}
			else {
				stack.push(token);
			}
			
			token = PostFix.dequeue();
		}
		
		return Double.valueOf(stack.pop());
	}
}

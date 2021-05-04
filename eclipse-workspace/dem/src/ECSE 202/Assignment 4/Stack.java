/**
 * This is a generic standard Stack class
 * supporting push and pop methods.
 * 
 * @author Abdelrahman Ali
 *
 * @param <T> Any data type can be used 
 */
public class Stack<T> {
	
	/* Item on the top of the stack */
	private listNode<T> top;							
	
	/**
	 * This is a standard push method of the
	 *  stack which take arg of type T
	 * @param arg data to be pushed in the stack
	 */
	public void push(T arg) {
		listNode<T> node = new listNode<T>();		// Create new node
		node.value = arg;							// set data to the node
		node.next = top;							// place the node on top of the stack
		top = node;									// keep a ref to the top node
	}	
	
	/**
	 * This is method remove the most recently
	 * added data from the Stack
	 * @return the latest data added to the stack
	 */
	public T pop() {
		if (top == null) return null;				// Check if Stack is empty
		T output = top.value;						// otherwise save the data before deleting the node
		top = top.next;								// remove the node
		return output;
	}
}

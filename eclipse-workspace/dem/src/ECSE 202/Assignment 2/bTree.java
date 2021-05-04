import acm.program.ConsoleProgram;

/**
 * This class acts as B-tree data structure for any Comparable object 
 * it allows duplicates 
 *  
 * @author Abdelrahman Ali
 * McGill Id #XXXXXXXXX
 * This is part of assignment 2 for McGill ECSE 202 winter 2021.
 */
public class bTree <T extends Comparable<T>> {

	/* this is a root to the tree, initiated once  addNode is called */
	private bNode<T> root;
	
	/* reference where we show the output */
	private ConsoleProgram consleProgram;
	
	
	/**
	 * This method adds a new node to an existing tree if any, otherwise will create one
	 * @param data String to be stored
	 */
	public void addNode(T data) {
		
		bNode<T> node = new bNode<T>();				//create and parameterize bNode Object 
		node.value = data;							// set the value to the passed data
		node.right = null;							// keep right node null for the new node
		node.left = null;							// keep left node null for the new node
		
		
		if (root == null) root = node;				// Create tree if root is empty
		
		else addNode( root, node);					// add Node to the existing root
		
	}
	
	/**
	 * This method will add a node to an existing tree according to B-Tree rules,
	 * If a value is duplicated, the node will be added to the left child.
	 * @param root the root of the tree
	 * @param node node to be added to the tree
	 */
	private void addNode(bNode<T> root, bNode<T> node) {
		
		if(root.value.compareTo(node.value) > 0)	// Comparing values
			if (root.left == null)					// check if empty
				root.left = node;					// place the node if empty
			else addNode(root.left, node);			// keep recurring until reaching empty node
		
		else if (root.right == null)				// place on the right child even if a duplicate
			root.right = node;
		else addNode(root.right, node);				// keep recurring until reaching empty node
		
		
	}
	
	/**
	 * This method call an overloaded method with the root to traversal through.
	 */
	public void displayInOrder() {
		displayInOrder(root);
	}
	
	/**
	 * This method displaying the Objects in Ascending order
	 * @param root the root to start from
	 */
	private void displayInOrder(bNode<T> root) {
	
		if (root.left != null) 						// first, check for the left child node
			displayInOrder(root.left);
		
		consleProgram.println(root.value);			// print value
		
		if (root.right != null)						// second, check for the right child node
			displayInOrder(root.right);
	}
	
	/**
	 *  This method call an overloaded method with the root to traversal through.
	 */
	public void displayInReverseOrder() {
		displayInReverseOrder(root);
	}
	
	/**
	 *  This method displaying the Objects in Descending order
	 * @param root
	 */
	public void displayInReverseOrder(bNode<T> root) {
		
		if (root.right != null)						// first, check for the right child node
			displayInReverseOrder(root.right);
		
		consleProgram.println(root.value);			// print value
		
		if (root.left != null)
			displayInReverseOrder(root.left);		// second, check for the left child node
	}
	
	/**
	 * This method to set a reference to display the output to
	 * @param link this is where the data will be shown
	 */
	public void setDisplay(ConsoleProgram link) {
		this.consleProgram = link;					// set the reference for the applet viewer
	}
	
	
	/**
	 * This class define a node into a tree with two children and a single generic data value.
	 * @author Abdelrahman Ali
	 *
	 */
	
	 class bNode <U extends Comparable<U>> { 		//type U implies the Type T		
		
		/* value of the String object */
		U value;
		
		/* Reference to the left right children */
		bNode<U> left, right;

	
	}
	 
}

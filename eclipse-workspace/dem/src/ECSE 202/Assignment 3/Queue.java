/**
 * This is a generic standard Queue class
 * supporting enqueue and dequeue methods.
 * 
 * @author Abdelrahman Ali
 *
 * @param <T> Any data type can be used
 */
public class Queue <T> {
	
	 /* the least added node */
	private listNode<T> front;    
	
	/* the most added node */
	private listNode<T> rear;							
	
	/** 
	 * This method should be called to insert
	 * new data to the Queue
	 * @param arg Data to be enqueued
	 */
	public void enqueue(T arg) {
		listNode<T> node = new listNode<T>();
		node.value = arg;
		
		if (rear == null)						// Check if queue is empty
			front = node;				
		else rear.next = node;					// otherwise put the queue ahead of the node
		
		rear = node;							// move the most added node to the rear of the queue
	}
	
	/**
	 *  This method should be called to 
	 *  remove the least added data
	 *  if queue is empty, null object 
	 *  will be returned
	 * @return the data to be removed
	 */
	
	public T dequeue() {	
	
		if (front == null) return null;			// Check if Queue is empty
		if (front == rear) rear = null;		    // Check if this is the last node
		T output = front.value;	
		front = front.next;
		
		return output;
	}
	

	/**
	 * @return string representation of the Queue
	 */
	public String toString() {	
		return toString(front);
	}
	
	/**
	 * @param front node to start from 
	 * @return string representation of the Queue
	 */
	private String toString(listNode<T> front) {
		String output = "";
		while (front != null) {					// check if the queue is empty
			output += front.value + " ";		// append to the String
			front = front.next;	
		}
		return output;
	}
}

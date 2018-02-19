package project3;


/**
 * This class stores possible locations of SquarePosition object in a maze
 * using a reference based stack that uses a "linked list"-like storage for its nodes.
 * It provides appropriate methods needed to store the locations.  
 * By using stack, we add (push) and remove (pop) from the front of the list. 
 * --> last in, first out
 *
 * @author Gayeon Park
 */
public class PossibleLocationsStack implements PossibleLocations{

	/**
	 * Implementation of this Node class is modified from project 2, with its original 
	 * basis on class notes, lecture notes, and Code from 
	 * Chapter 3.6.2 Fundamental Data Structures, Cloning Data Structures (p.144)
	 * in "Data Structures and Algorithms in Java 6th Edition",
	 * written by Michael T. GoodRich, Roberto Tamassia, Michael H. Goldwasser.
	 * @author Gayeon_Park
	 *
	 * @param <E>
	 */
	private static class Node{
		private Location element;
		private Node next;

		/**
		 * A default constructor that initializes all the
		 * instance variables 
		 */
		public Node(){

		}

		/**
		 * Retrieves the element stored in the node
		 * @return element that is stored 
		 */
		public Location getElement(){
			return element;
		}

		/**
		 * Sets the element of the node to the element value passed in as parameter
		 * @param element passed in
		 */
		public void setElement(Location element){
			this.element = element;
		}	
	}

	private Node head = null;
	private int size = 0;

	/**
	 * Add a SquarePosition object to the top of the set.
	 * @param s Location object to be added
	 */
	public void add(Location s) {
		//nothing gets added
		if (s == null){
			return;
		}
		Node addedLocation = new Node();
		addedLocation.setElement(s);
		if (head == null){ //adding to an empty set
			head = addedLocation;
			size ++;
		} else{ 
			//adding to the top of a set that has at least one element stored in it
			addedLocation.next = head;
			head = addedLocation;
			size ++;
		}
	}

	/**
	 * Removes the most current SquarePosition object from the set of possible locations, 
	 * which is located at the top of the set, and returns the SquarePosition object removed.
	 * @return removed Location object that's been inside of the array for the longest time
	 *    		or null if set is empty
	 */
	public Location remove() {
		//empty set
		if (head == null){
			return null;
		}

		//removes and returns the SquarePosition object from the top of the set
		Location removedLocation = head.getElement();
		head = head.next;
		size --;
		return removedLocation;
	}

	/**
	 * Determines if set is empty or not.
	 * @return
	 *    true, if set is empty,
	 *    false, otherwise.
	 */
	public boolean isEmpty() {
		return (size == 0);
	}

}

package project3;

/**
 * This class stores possible locations of SquarePosition object in a maze
 * using queue that is implemented using an array.
 * It provides appropriate methods needed to store the locations.  
 * By using queue, we add (enqueue) to the back of the list and
 * remove (dequeue) from the front of the list (or removes the element that has been 
 * stored the longest). 
 * --> first in, first out
 *
 * @author Gayeon Park
 */
public class PossibleLocationsQueue implements PossibleLocations{
	private Location[] list;
	private int capacity;
	private int front = 0;
	private int back = 0;
	private int size = 0;
//	private int front;
//	private int back;
//	private int size;

	/**
	 * A default constructor that creates an empty array 
	 * of Location objects with length 10.
	 */
	public PossibleLocationsQueue(){
		capacity = 10;
		list = new Location[capacity];
//		front = 0;
//		back = capacity - 1;
//		size = 0;
	}
	
	/**
	 * A constructor that creates an empty array 
	 * of Location objects with length as the int 
	 * parameter passed into the constructor
	 * @param size
	 */
	public PossibleLocationsQueue(int size){
		capacity = size;
		//set the size to the size of default constructor 
		//if parameter is equal to or less than 0
		if (size <= 0){
			capacity = 10;
		}
		list = new Location[capacity];
//		front = 0;
//		back = capacity - 1;
//		size = 0;
	}
	
	/**
	 * Adds a SquarePosition object to the back of the set, 
	 * which is at the end of the array.
	 * @param s Location object to be added
	 */
	public void add(Location s) {
		if (s == null){
			return;
		}
		//adds Location object to the end of the array
		if (size < capacity){
			back = (front + size) % capacity;
			list[back] = s;
			size ++;
		} else{
			//new array is created and set to list
			//because the original array is completely filled
			list = makeLarger();
			//add Location object to the end of the newly created array
			list[++back] = s; 
			size ++;
		}
//		if (size == capacity) makeLarger();
//		else{
//			back = (back + 1) % capacity;
//			list[back] = s;
//			size ++;
//		}
	}
	
	/**
	 * Creates a new array that's twice larger than the original array
	 * that stores Location objects from the original array in the
	 * same order as in the original array. 
	 * @return a new array of Location objects that's larger
	 * and has every element copied from the original array with 
	 * all the elements in the same order as in the original array
	 */
	private Location[] makeLarger(){
		//creates a new array that's twice in size of the original array
		Location[] newList = new Location[capacity*2];
		//copy over all the elements in the original array
		//in correct order to the new array
		for (int i = 0; i < size; i ++){
			newList[i] = list[(front+i) % capacity];
		}
		front = 0; 
		back = size-1;
		capacity = newList.length;
		return newList;
	}

	/**
	 * Removes a SquarePosition object from the front of the set.
	 * In other words, the method removes the element that has been stored inside
	 * of the set for the longest. 
	 * @return
	 *    the next object, or null if set is empty
	 */
	public Location remove() {
		//empty set or a set with no element stored
		if (isEmpty()){
			return null;
		} 
		Location temp = list[front];
		list[front] = null;
		front = (front+1) % capacity;
		size --;
		return temp;

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
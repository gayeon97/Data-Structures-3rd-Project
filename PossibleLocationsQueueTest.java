package project3;

import static org.junit.Assert.*;

import org.junit.Test;


public class PossibleLocationsQueueTest {

	@Test
	public void testPossibleLocationsQueueConstructors() {
		//Test creating PossibleLocationsQueue object with different constructors
		try{
			//Test default constructor
			PossibleLocationsQueue list = new PossibleLocationsQueue();

			//Test constructor with valid parameter input
			PossibleLocationsQueue list1 = new PossibleLocationsQueue(20);

			//Test constructor with invalid parameter input of 0
			PossibleLocationsQueue list2 = new PossibleLocationsQueue(0);

			//Test constructor with invalid parameter input of a negative number
			PossibleLocationsQueue list3 = new PossibleLocationsQueue(-5);
		} catch (Exception e){
			fail("The constructor is not implemented correctly.");
		}
	}

	@Test
	public void testAdd1(){
		//Test adding to PossibleLocationsQueue object created from default constructor
		try{
			Location place = new Location(5,4);
			Location place1 = new Location(7,3);
			Location place2 = new Location(10,-2);
			Location place3 = new Location(6,13);
			Location place4 = new Location(-2,10);

			PossibleLocationsQueue list = new PossibleLocationsQueue();
			//check that nothing gets added to the list 
			//when null is added to the list
			list.add(null);
			assertTrue(list.isEmpty());
			
			//Add to the list
			list.add(place);
			list.add(null);
			//Then remove from the list
			list.remove();
			//And add to the list again. 
			list.add(place1);
			assertEquals(place1, list.remove());

			//empty the array
			while(!list.isEmpty()){
				list.remove();
			}

			//repopulate the array
			list.add(place1);
			list.add(place);
			list.add(place3);
			list.add(place2);
			list.add(place4);
			list.add(place4);
			list.add(place2);
			list.add(place);
			list.add(place3);
			list.add(place1);
			//Add 1 more than the original array size
			//this should run with assumption that makeLarger private method 
			//is implemented correctly 
			list.add(place1);

			//remove to see if Location objects have been added correctly 
			//in correct order
			assertEquals(place1,list.remove());
			assertEquals(place,list.remove());
			assertEquals(place3,list.remove());
			assertEquals(place2,list.remove());
			assertEquals(place4,list.remove());
			assertEquals(place4,list.remove());
			assertEquals(place2,list.remove());
			assertEquals(place,list.remove());
			assertEquals(place3,list.remove());
			assertEquals(place1,list.remove());
			assertEquals(place1,list.remove());
		} catch (Exception e){
			fail("testAdd1 failed: Exception thrown \n" + e.getClass()+ "\n" + e.getMessage());
		}	
	}

	@Test
	public void testAdd2(){
		//Test adding to PossibleLocationsQueue object created 
		//with constructor with parameter passed in
		try{
			Location place = new Location(5,4);
			Location place1 = new Location(7,3);
			Location place2 = new Location(10,-2);
			Location place3 = new Location(6,13);
			Location place4 = new Location(-2,10);

			PossibleLocationsQueue list = new PossibleLocationsQueue(4);
			//check that nothing gets added to the list 
			//when null is added to the list
			list.add(null);
			assertTrue(list.isEmpty());
			
			//Add to the list
			list.add(place);
			list.add(null);
			//Then remove from the list
			list.remove();
			//And add to the list again. 
			list.add(place1);
			assertEquals(place1, list.remove());

			//empty the array
			while(!list.isEmpty()){
				list.remove();
			}

			//repopulate the array. 
			list.add(place1);
			list.add(place);
			list.add(place3);
			list.add(place2);
			//Add 1 more than the original array size
			//this should run with assumption that makeLarger method 
			//is implemented correctly 
			list.add(place4);

			//remove to see if Location objects have been added correctly 
			//in correct order
			assertEquals(place1,list.remove());
			assertEquals(place,list.remove());
			assertEquals(place3,list.remove());
			assertEquals(place2,list.remove());
			assertEquals(place4,list.remove());
		} catch (Exception e){
			fail("testAdd2 failed: Exception thrown \n" + e.getClass()+ "\n" + e.getMessage());
		}	
	}

	@Test
	public void testRemove1(){
		//Test removing from PossibleLocationsQueue object created from default constructor
		try{		
			PossibleLocationsQueue list = new PossibleLocationsQueue();

			//try removing before anything's been added to array
			//null value should be returned because nothing's been
			//added to the list
			assertNull(list.remove());

			Location place = new Location(5,4);
			Location place1 = new Location(7,3);
			Location place2 = new Location(10,-2);
			Location place3 = new Location(6,13);
			Location place4 = new Location(-2,10);

			//When adding one Location object to empty list,
			//and then removing it, the Location object added should be returned
			list.add(place);
			assertEquals(place, list.remove());	
			//if removing again from the list, null should be returned
			//because the list has been emptied
			assertNull(list.remove());

			//repopulate the array
			list.add(place1);
			list.add(place);
			list.add(place3);
			list.add(place2);
			list.add(place4);
			list.add(place4);
			list.add(place2);
			list.add(place);
			list.add(place3);
			list.add(place1);
			//Add 1 more than the capacity of the original array
			//this should run with assumption that makeLarger method 
			//is implemented correctly 
			list.add(place1);

			//remove and see if objects are removed in order
			assertEquals(place1,list.remove());
			assertEquals(place,list.remove());
			assertEquals(place3,list.remove());
			assertEquals(place2,list.remove());
			assertEquals(place4,list.remove());
			assertEquals(place4,list.remove());
			assertEquals(place2,list.remove());
			assertEquals(place,list.remove());
			assertEquals(place3,list.remove());
			assertEquals(place1,list.remove());
			assertEquals(place1,list.remove());
			//removing more than the elements stored
			assertNull(null,list.remove());
		} catch (Exception e){
			fail("testRemove1 failed: Exception thrown \n" + e.getClass()+ "\n" + e.getMessage());
		}
	}

	@Test
	public void testRemove2(){
		//Test removing from PossibleLocationsQueue object created 
		//from constructor with parameter passed in
		try{
			PossibleLocationsQueue list = new PossibleLocationsQueue(3);

			//try removing before anything's been added to array
			//null value should be returned because nothing's been
			//added to the list
			assertNull(list.remove());

			Location place = new Location(5,4);
			Location place1 = new Location(7,3);
			Location place2 = new Location(10,-2);
			Location place3 = new Location(6,13);
			Location place4 = new Location(-2,10);

			//When adding one Location object to empty list,
			//and then removing it, the Location object added should be returned
			list.add(place);
			assertEquals(place, list.remove());	
			//if removing again from the list, null should be returned
			//because the list has been emptied
			assertNull(list.remove());

			//repopulate the array
			list.add(place3);
			list.add(place2);
			list.add(place4);
			//Add more than the capacity of the original array
			//this should run with assumption that makeLarger method 
			//is implemented correctly 
			list.add(place4);
			list.add(place2);
			list.add(place);
			list.add(place3);

			//remove and see if objects are removed in order
			assertEquals(place3,list.remove());
			assertEquals(place2,list.remove());
			assertEquals(place4,list.remove());
			assertEquals(place4,list.remove());
			assertEquals(place2,list.remove());
			assertEquals(place,list.remove());
			assertEquals(place3,list.remove());
			//removing more than the elements stored
			assertNull(null,list.remove());
		} catch (Exception e){
			fail("testRemove2 failed: Exception thrown \n" + e.getClass()+ "\n" + e.getMessage());
		}
	}

	@Test
	public void testIsEmpty1(){
		//this isEmpty1 test checks if the list is empty
		try{
			//Test with default constructor
			PossibleLocationsQueue list = new PossibleLocationsQueue();
			assertTrue("The list is empty.", list.isEmpty());

			//Test with constructor with valid parameter input
			PossibleLocationsQueue list1 = new PossibleLocationsQueue(10);
			assertTrue("The list is empty.", list1.isEmpty());

			//Test with constructor with invalid parameter input of 0
			PossibleLocationsQueue list2 = new PossibleLocationsQueue(0);
			assertTrue("The list is empty.", list2.isEmpty());

			//Test constructor with invalid parameter input of a negative number
			PossibleLocationsQueue list3 = new PossibleLocationsQueue(-7);
			assertTrue("The list is empty.", list3.isEmpty());
		} catch (Exception e){
			fail("testIsEmpty failed: Exception thrown \n" + e.getClass()+ "\n" + e.getMessage());
		}
	}

	@Test
	public void testIsEmpty2(){
		//this isEmpty2 test checks if the list is not empty
		try{
			Location place = new Location(1,1);
			
			//Test with default constructor
			PossibleLocationsQueue list = new PossibleLocationsQueue();
			list.add(place);
			assertFalse("The list is not empty.", list.isEmpty());

			//Test with constructor with valid parameter input
			PossibleLocationsQueue list1 = new PossibleLocationsQueue(10);
			list1.add(place);
			assertFalse("The list is not empty.", list1.isEmpty());

			//Test with constructor with invalid parameter input of 0
			PossibleLocationsQueue list2 = new PossibleLocationsQueue(0);
			list2.add(place);
			assertFalse("The list is empty.", list2.isEmpty());

			//Test constructor with invalid parameter input of a negative number
			PossibleLocationsQueue list3 = new PossibleLocationsQueue(-7);
			list3.add(place);
			assertFalse("The list is empty.", list3.isEmpty());	
		} catch(Exception e){
			fail("testIsEmpty2 failed: Exception thrown \n" + e.getClass()+ "\n" + e.getMessage());
		}
	}
}
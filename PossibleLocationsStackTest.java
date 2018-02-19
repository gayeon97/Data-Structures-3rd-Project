package project3;

import static org.junit.Assert.*;

import org.junit.Test;

public class PossibleLocationsStackTest {
	
	@Test
	public void testPossibleLocationsStackConstructor() {
		//Test creating PossibleLocationsStack object
		try{
			//Test default constructor, which is the only constructor of 
			//PossibleLocationsStack class
			PossibleLocationsStack list = new PossibleLocationsStack();
		} catch (Exception e){
			fail("The constructor is not implemented correctly. "
					+ "Exception thrown \n" + e.getClass()+ "\n" + e.getMessage());
		}
	}

	@Test
	public void testAdd(){
		//Test adding to PossibleLocationsStack object created
		try{
			Location place = new Location(5,4);
			Location place1 = new Location(7,3);
			Location place2 = new Location(10,-2);
			Location place3 = new Location(6,13);
			Location place4 = new Location(-2,10);

			PossibleLocationsStack list = new PossibleLocationsStack();
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
	
			//remove to see if Location objects have been added correctly 
			//in correct order
			assertEquals(place1,list.remove());
			assertEquals(place3,list.remove());
			assertEquals(place,list.remove());
			assertEquals(place2,list.remove());
			assertEquals(place4,list.remove());
			assertEquals(place4,list.remove());
			assertEquals(place2,list.remove());
			assertEquals(place3,list.remove());
			assertEquals(place,list.remove());
			assertEquals(place1,list.remove());
		} catch (Exception e){
			fail("testAdd failed: Exception thrown \n" + e.getClass()+ "\n" + e.getMessage());
		}	
	}

	@Test
	public void testRemove(){
		//Test removing from PossibleLocationsStack object created
		try{		
			PossibleLocationsStack list = new PossibleLocationsStack();

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
			list.add(place1);
	
			//remove and see if objects are removed in order
			assertEquals(place1,list.remove());
			assertEquals(place1,list.remove());
			assertEquals(place3,list.remove());
			assertEquals(place,list.remove());
			assertEquals(place2,list.remove());
			assertEquals(place4,list.remove());
			assertEquals(place4,list.remove());
			assertEquals(place2,list.remove());
			assertEquals(place3,list.remove());
			assertEquals(place,list.remove());
			assertEquals(place1,list.remove());
			//removing more than the elements stored
			assertNull(null,list.remove());
		} catch (Exception e){
			fail("testRemove failed: Exception thrown \n" + e.getClass()+ "\n" + e.getMessage());
		}
	}

	@Test
	public void testIsEmpty(){
		try{
			PossibleLocationsStack list = new PossibleLocationsStack();
			Location place = new Location(1,1);

			//checks if the list is empty
			assertTrue("The list is empty.", list.isEmpty());

			//checks if the list is NOT empty
			list.add(place);
			assertFalse("The list is not empty.", list.isEmpty());
		} catch (Exception e){
			fail("testIsEmpty failed: Exception thrown \n" + e.getClass()+ "\n" + e.getMessage());
		}
	}
}

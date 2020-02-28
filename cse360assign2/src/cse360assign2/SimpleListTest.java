/*	Jason White
	374
	Assignment 1
	
	SimpleListTest is a JUnit test to test that all the methods of the SimpleList class operate as expected.
*/

package cse360assign2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class SimpleListTest
{
	@BeforeEach
	public void before()
	{
		System.out.print("before ");
	}
	
	@AfterEach
	public void after()
	{
		System.out.println(" after");
	}
	
	@Test
	//test if SimpleList object is created
	public void testSimpleListCreated()
	{
		System.out.print("testSimpleListCreated");
		SimpleList actual = new SimpleList();
		assertNotNull(actual);
	}
	
	@Test
	//test if SimpleList.list is initialized to a size of 10
	public void testSimpleListLengthInitTo10()
	{
		System.out.print("testSimpleListIsLength10");
		SimpleList actual = new SimpleList();
		assertEquals(10,actual.getList().length);
	}
	
	@Test
	//test if count is initialized to 0
	public void testSimpleListCountInitTo0()
	{
		System.out.print("testSimpleListCountInitTo0");
		SimpleList actual = new SimpleList();
		assertEquals(0,actual.count());
	}

	@Test
	//test if SimpleList.add() adds an element of a given value
	public void testAddNorm()
	{
		System.out.print("testAddNorm");
		SimpleList actual = new SimpleList();
		actual.add(5);
		assertEquals(5, actual.getList()[0]);
	}

	@Test
	//test if SimpleList.add() adds the maximum integer value
	public void testAddMaxInt()
	{
		System.out.print("testAddMaxInt");
		SimpleList actual = new SimpleList();
		actual.add(Integer.MAX_VALUE);
		assertEquals(2147483647, actual.getList()[0]);
	}
	
	@Test
	//test if SimpleList.add() adds the minimum integer value
	public void testAddMinInt()
	{
		System.out.print("testAddMinInt");
		SimpleList actual = new SimpleList();
		actual.add(Integer.MIN_VALUE);
		assertEquals(-2147483648, actual.getList()[0]);
	}
	
	@Test
	//test if SimpleList.toString() returns elements of list with correct formatting
	public void testToStringNorm()
	{
		System.out.print("testToStringNorm");
		SimpleList actual = new SimpleList();
		actual.add(5);
		actual.add(6);
		actual.add(7);
		assertEquals("7 6 5", actual.toString());
	}
	
	@Test
	//test if SimpleList.toString() returns an empty String when list has no elements
	public void testToStringEmpty()
	{
		System.out.print("testToStringEmpty");
		SimpleList actual = new SimpleList();
		assertEquals("", actual.toString());
	}
	
	@Test
	//test if SimpleList.toString() prints all elements of list with correct formatting when list is full
	public void testToStringFull()
	{
		System.out.print("testToStringFull");
		SimpleList actual = new SimpleList();
		actual.add(2);
		actual.add(3);
		actual.add(4);
		actual.add(5);
		actual.add(6);
		actual.add(7);
		actual.add(8);
		actual.add(9);
		actual.add(10);
		actual.add(1);
		assertEquals("1 10 9 8 7 6 5 4 3 2", actual.toString());
	}
	
	@Test
	//test if SimpleList.toString() prints correct elements of list with correct formatting when more 
	//elements have been added than list can hold
	public void testToStringOverFull()
	{
		System.out.print("testToStringOverFull");
		SimpleList actual = new SimpleList();
		actual.add(77);
		actual.add(12);
		actual.add(40);
		actual.add(35);
		actual.add(26);
		actual.add(73);
		actual.add(85);
		actual.add(29);
		actual.add(10);
		actual.add(1);
		actual.add(8888);
		actual.add(343);
		assertEquals("343 8888 1 10 29 85 73 26 35 40 12 77", actual.toString());
	}
	
	@Test
	//test if SimpleList remains same when value is not found
	public void testRemoveNorm()
	{
		System.out.print("testRemoveNorm");
		SimpleList actual = new SimpleList();
		actual.add(2);
		actual.remove(8);
		assertEquals("2", actual.toString());
	}
	
	@Test
	//test if SimpleList.remove() removes element of matching value
	public void testRemoveValue()
	{
		System.out.print("testRemoveValue");
		SimpleList actual = new SimpleList();
		actual.add(6);
		actual.add(127);
		actual.add(3);
		actual.add(400);
		actual.remove(3);
		assertEquals("400 127 6", actual.toString());
	}
	
	@Test
	//test if SimpleList.remove() removes only the first of multiple elements matching a given value
	public void testDoNotRemoveDuplicates()
	{
		System.out.print("testRemoveValue");
		SimpleList actual = new SimpleList();
		actual.add(7);
		actual.add(5);
		actual.add(4);
		actual.add(5);
		actual.remove(5);
		assertEquals("4 5 7", actual.toString());
	}

	@Test
	//test if count starts at 0
	public void testCountEmpty()
	{
		System.out.print("testCountEmpty");
		SimpleList actual = new SimpleList();
		assertEquals(0, actual.count());
	}
	
	@Test
	//test if count matches number of elements added to SimpleList
	public void testCountAdd4()
	{
		System.out.print("testCountAdd4");
		SimpleList actual = new SimpleList();
		actual.add(6);
		actual.add(127);
		actual.add(3);
		actual.add(400);
		assertEquals(4, actual.count());
	}
	
	@Test
	//test if count matches number of elements in SimpleList after adding and removing multiple
	public void testCountAdd4Remove3()
	{
		System.out.print("testCountAdd4Remove3");
		SimpleList actual = new SimpleList();
		actual.add(68);
		actual.add(127);
		actual.remove(68);
		actual.add(3);
		actual.add(400);
		actual.remove(400);
		actual.remove(3);
		assertEquals(1, actual.count());
	}
	
	@Test
	//test if count stays at 0 when attempting to remove more elements than added
	public void testCountAdd2Remove5()
	{
		System.out.print("testCountAdd4Remove3");
		SimpleList actual = new SimpleList();
		actual.add(68);
		actual.add(127);
		actual.remove(3);
		actual.remove(127);
		actual.remove(68);
		actual.remove(400);
		actual.remove(3);
		assertEquals(0, actual.count());
	}

	@Test
	//test if SimpleList.search() returns correct index of found value
	public void testSearchNorm()
	{
		System.out.print("testSearchNorm");
		SimpleList actual = new SimpleList();
		actual.add(55);
		actual.add(24);
		actual.add(223);
		actual.add(4980);
		assertEquals(2, actual.search(24));
	}

	@Test
	//test if SimpleList.search() returns -1 when value is not found
	public void testSearchEmpty()
	{
		System.out.print("testSearchEmpty");
		SimpleList actual = new SimpleList();
		assertEquals(-1, actual.search(0));
	}
	
	@Test
	//test that SimpleList.search() doesn't return the index of a value outside of count
	public void testSearchRemovedValues()
	{
		System.out.print("testSearchRemovedValues");
		SimpleList actual = new SimpleList();
		actual.add(5);
		actual.add(4);
		actual.add(3);
		actual.add(2);
		actual.add(1);
		actual.remove(1);
		assertEquals(-1, actual.search(1));
	}
	
	@Test
	//test that SimpleList size returns correct initialized amount (10)
	public void testSizeInit()
	{
		System.out.print("testSizeInit");
		SimpleList actual = new SimpleList();
		assertEquals(10, actual.size());
	}
	
	@Test
	//test that SimpleList.add() increases by 50%
	public void testSizeIncrease()
	{
		System.out.print("testSizeIncrease");
		SimpleList actual = new SimpleList();
		actual.add(11);
		actual.add(10);
		actual.add(9);
		actual.add(8);
		actual.add(7);
		actual.add(6);
		actual.add(5);
		actual.add(4);
		actual.add(3);
		actual.add(2);
		actual.add(1);
		assertEquals(15, actual.size());
	}
	
	@Test
	//test that SimpleList.add() rounds the 50% to add by down
	public void testSizeIncreaseRounding()
	{
		System.out.print("testSizeIncreaseRounding");
		SimpleList actual = new SimpleList();
		actual.add(16);
		actual.add(15);
		actual.add(14);
		actual.add(13);
		actual.add(12);
		actual.add(11);
		actual.add(10);
		actual.add(9);
		actual.add(8);
		actual.add(7);
		actual.add(6);
		actual.add(5);
		actual.add(4);
		actual.add(3);
		actual.add(2);
		actual.add(1);
		assertEquals(22, actual.getList().length);
	}
	
	@Test
	//test that SimpleList.remove() rounds the 25% to decrease by down
	public void testSizeDecreaseRounding()
	{
		System.out.print("testSizeDecreaseRounding");
		SimpleList actual = new SimpleList();
		actual.add(11);
		actual.add(10);
		actual.add(9);
		actual.add(8);
		actual.add(7);
		actual.add(6);
		actual.add(5);
		actual.add(4);
		actual.add(3);
		actual.add(2);
		actual.add(1);
		actual.remove(7);
		assertEquals(12, actual.size());
	}
	
	@Test
	//test that SimpleList.remove() doesn't decrease to less than 1 after even if the non-rounded amount to decrease by would
	public void testSizeDecreaseBottom()
	{
		System.out.print("testSizeDecreaseBottom");
		SimpleList actual = new SimpleList();
		actual.remove(10);
		actual.remove(9);
		actual.remove(8);
		actual.remove(7);
		actual.remove(6);
		actual.remove(5);
		actual.remove(4);
		actual.remove(3);
		actual.remove(2);
		actual.remove(1);
		assertEquals(3, actual.size());
	}
	
	@Test
	//test that SimpleList size rounding is correct after multiple changes (11 adds, 3 removes, 2 adds, & 1 remove)
	public void testSizeMultiRounding()
	{
		System.out.print("testSizeMultiRounding");
		SimpleList actual = new SimpleList();
		actual.add(11);
		actual.add(10);
		actual.add(9);
		actual.add(8);
		actual.add(7);
		actual.add(6);
		actual.add(5);
		actual.add(4);
		actual.add(3);
		actual.add(2);
		actual.add(1);
		actual.remove(7);
		actual.remove(2);
		actual.remove(3);
		actual.add(18);
		actual.add(76);
		actual.remove(4);
		assertEquals(10, actual.size());
	}
	
	@Test
	//test that SimpleList.append() appends an element of a given value in an empty list
	public void testAppendEmpty()
	{
		System.out.print("testAppendEmpty");
		SimpleList actual = new SimpleList();
		actual.append(11);
		assertEquals("11", actual.toString());
	}
	
	@Test
	//test that SimpleList.append() appends an element of a given value in a non-empty list
	public void testAppendExisting()
	{
		System.out.print("testAppendExisting");
		SimpleList actual = new SimpleList();
		actual.append(5);
		actual.append(47);
		assertEquals("5 47", actual.toString());
	}
	
	@Test
	//test that SimpleList.add() increases by 50% rounding down
	public void testAppendSizeIncrease()
	{
		System.out.print("testAppendSizeIncrease");
		SimpleList actual = new SimpleList();
		actual.append(5);
		actual.append(2);
		actual.append(3);
		actual.append(4);
		actual.append(5);
		actual.append(6);
		actual.append(7);
		actual.append(8);
		actual.append(9);
		actual.append(10);
		actual.append(11);
		actual.append(12);
		actual.append(13);
		actual.append(14);
		actual.append(15);
		actual.append(47);
		assertEquals(22, actual.size());
	}
	
	@Test
	//test that SimpleList.first() returns -1 for an empty list
	public void testFirstEmpty()
	{
		System.out.print("testFirstEmpty");
		SimpleList actual = new SimpleList();
		assertEquals(-1, actual.first());
	}
	
	@Test
	//test that SimpleList.first() returns the first element of a non-empty list
	public void testFirstNorm()
	{
		System.out.print("testFirstNorm");
		SimpleList actual = new SimpleList();
		actual.add(10);
		actual.add(1);
		assertEquals(1, actual.first());
	}
	
	@Test
	//test that SimpleList.last() returns -1 for an empty list
	public void testLastEmpty()
	{
		System.out.print("testLastEmpty");
		SimpleList actual = new SimpleList();
		assertEquals(-1, actual.last());
	}
	
	@Test
	//test that SimpleList.first() returns the first element of a non-empty list
	public void testLastNorm()
	{
		System.out.print("testLastNorm");
		SimpleList actual = new SimpleList();
		actual.add(10);
		actual.add(1);
		assertEquals(10, actual.last());
	}
}

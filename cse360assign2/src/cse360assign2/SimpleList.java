/*	Jason White
	374
	Assignment 2
	
	SimpleList is a class containing a list of up to as many elements will fit in memory. Elements are pushed in the bottom with add()
	and on top with append(), but can be removed from any point if they are found in the list. Adding elements beyond the limit will
	increase the size of the SimpleList by 50% (or the nearest integer below 50%). Attempting to remove an element, whether successful
	or not, will decrease the size of the SimpleList by 25% (or the nearest integer below 25%) if more than 25% of the spaces are empty.
	The first and last elements can be read without modifying the list. The current total number of possible locations can also be read.
*/

package cse360assign2;

public class SimpleList
{
	private int[] list;//array to hold elements of SimpleList
	private int count;//number of elements in list
	
	//constructor
	public SimpleList()
	{
		list = new int[10];//creates integer array with 10 slots
		count = 0;//initializes count to 0
	}
	
	//adds elements to bottom of list increasing the list by an amount of 50% rounded down if already full
	public void add(int x)
	{
		count++;//increment count when adding an element
		if(count == list.length + 1)//if list is full
		{
			int[] temp = new int[list.length*3/2];//create new array with size increased by 50% of it's size rounded down
			for(int i = 0; i < count - 1; i++)
			{
				temp[i]= list[i];//copy values to new array
			}
			list = new int[temp.length];//resize list to be increased by 50% of it's size rounded down
			for(int i = 0; i < list.length; i++)
			{
				list[i]= temp[i];//copy values back
			}
		}
		for(int i = count - 1; i > 0; i--)
		{
			list[i] = list [i - 1];//shift all existing elements up one
		}
		list[0] = x;//place new element in bottom slot
	}
	
	//removes the bottom-most element from list that contains passed value if it exists
	//decreases list by an amount of 25% rounded down if more than 25% of the spaces are empty
	public void remove(int x)
	{
		int foundAt = search(x);//if value exists in list
		boolean remove = foundAt != -1;//it needs to be removed
		if(remove)//if removing an element
		{
			count--;//decrement count
			for(int i = foundAt; i < count; i++)
			{
				list[i] = list[i+1];//shift all existing elements down one overwriting removed element
			}
		}
		if( count * 100 / list.length < 75)//if 25% or more spaces are empty
		{
			int[] temp = new int[list.length - list.length*1/4];//create new array with size decreased by 25% of it's size rounded down
			for(int i = 0; i < count; i++)
			{
				temp[i]= list[i];//copy values to new array
			}
			list = new int[temp.length];//resize list to be decreased by 25% of it's size rounded down
			for(int i = 0; i < list.length; i++)
			{
				list[i]= temp[i];//copy values back
			}
		}
	}
	
	//returns the number of elements in list
	public int count()
	{
		return count;
	}
	
	//prints the elements of list
	public String toString()
	{
		String out = "";//start with empty String
		if(count > 0)//if there are elements in list
		{
			for(int i = 0; i < count-1; i++)
			{
				out += list[i] + " ";//concatenate all existing elements except last with following space
			}
			out += list[count-1];//concatenate last element
		}
		return out;//return resulting String
	}
	
	//check if passed value exist in list and return first occurrence
	public int search(int x)
	{
		int found = -1;//flag to exit loop when value is found
		for(int i = 0; i < count && found == -1; i++)
		{
			if(list[i] == x)//if element matches value
			{
				found = i;//set flag to index
			}
		}
		return found;//return index or -1 if value not found
	}
	
	//returns list for asserting using elements
	public int[] getList()
	{
		return list;
	}
	
	//adds elements to top of list increasing the list by an amount of 50% rounded down if already full
	public void append(int x)
	{
		count++;//increment count when appending an element
		if(count == list.length + 1)//if list is full
		{
			int[] temp = new int[list.length*3/2];//create new array with size increased by 50% of it's size rounded down
			for(int i = 0; i < count - 1; i++)
			{
				temp[i]= list[i];//copy values to new array
			}
			list = new int[temp.length];//resize list to be increased by 50% of it's size rounded down
			for(int i = 0; i < list.length; i++)
			{
				list[i]= temp[i];//copy values back
			}
		}
		list[count-1] = x;//place new element in top slot
	}
	
	//return first element or -1 if there are no elements in the list
	public int first()
	{
		int firstEl = -1;
		if(count > 0)
		{
			firstEl = list[0];
		}
		return firstEl;
	}
	
	//return last element or -1 if there are no elements in the list
	public int last()
	{
		int lastEl = -1;
		if(count > 0)
		{
			lastEl = list[count-1];
		}
		return lastEl;
	}
	
	//return the current number of possible locations in the list
	public int size()
	{
		return list.length;
	}
}

/*	Jason White
	374
	Assignment 2
	
	SimpleList is a class containing a list of up to 10 elements. Elements are pushed in the bottom, but can be removed
	from any point if they are found in the list.
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
	
	//adds elements to bottom of list even when full 
	public void add(int x)
	{
		if(count < list.length)//unless list is already full
		{
			count++;//increment count when adding an element
		}
		for(int i = count - 1; i > 0; i--)
		{
			list[i] = list [i - 1];//shift all existing elements up one
		}
		list[0] = x;//place new element in bottom slot
	}
	
	//removes the bottom-most element from list that contains passed value if it exists
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
}

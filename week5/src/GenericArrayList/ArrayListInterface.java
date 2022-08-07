package GenericArrayList;

public interface ArrayListInterface<T> {
	
	//-- return the number of objects the list can hold (the capacity)
	public int capacity();
	
	//-- return the number of objects currently in the list
	public int size();
	
	//-- return true if the list is empty (size = 0), false otherwise
	public boolean isEmpty();
	
	//-- return true if the list contains object e, false 
	public boolean contains(T e);
	
	//-- return the list contents as an array. 
	// The length of the array is the same as the size in the list, not capacity 
	public T[] toArray();
	
	//-- grow the array to requested capacity c, throw an exception if the requested 
	// capacity c is smaller than the current size. copy data in the original array to the new array
	public void ensureCapacity(int c) throws IllegalArgumentException;
	
	//-- add object e to the end of list, increase the capacity of the list by 1 if nec
	public void add(T e);
	
	//-- insert object e at index (0 based), increase the capacity by 1
	// 	Items below the point of insertion should shift down
	//	Throw exception if index < 0 or index > size
	public void add(int index, T e) throws IndexOutOfBoundsException;
	
	// -- remove object at position index. All list items should shift to close the "gap" created.
    //    returns the removed value
    //    Throw exception if (index < 0) or (index >= size)
    public T remove(int index) throws IndexOutOfBoundsException;
    
	//-- remove first occurrence of object e, return true if successful
	//	return false if the object e is not found in the list
	//	All list items should shift to close the gap created
	public boolean removeFirst(T e);
	
	//-- remove last occurrence of object e, return true if successful
	//	return false if the object e is not found in the list
	//	All list items should shift to close the gap created
	public boolean removeLast(T e);
	
	//-- remove all objects from the list, set the size to 0
	public void clear();
	
	//-- returns object at position index
	//	Throw exception if index < 0 or index >= size
	public T get(int index) throws IndexOutOfBoundsException;
	
	//-- replace object at index with argument e, return original value from the list 
	//	Throw exception if index < 0 or index > size
	public T set(int index, T e) throws IndexOutOfBoundsException;
	
	//-- return index of first occurrence of object e, -1 if not e is not in the list 
	public int indexOf(T e);
	
	//-- return index of last occurrence of object e, -1 if not e is not in the list 
	public int lastIndexOf(T e);
	
	

}

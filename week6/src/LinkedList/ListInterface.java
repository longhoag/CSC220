package LinkedList;

public interface ListInterface<T> {
	//-- add value at position index (e.g. index of 0 adds to front of list)
	//- throw exception if index < 0 or index > size of list (e.g. if index = size, adds to back)
	public void add(int index, T value) throws IndexOutOfBoundsException;
	
	//-- adds value to front of list
	public void addfront(T value);
	
	//-- adds value to back of list
	public void addback(T value);
	
	//-- remove all elements from the list
	public void clear();
	
	//-- remove value at index (e.g. index = 0 remove front of the list)
	// returns the removed element. Note that this does not return a Node, just value stored in the Node
	// throw exception if index is not within the list range 
	public T remove(int index) throws IndexOutOfBoundsException;
	
	//-- remove the first value in the list
	// returns the removed element. Note that this does not return a Node, just value stored in the Node
	public T removefront();
	
	
	//-- remove the last value in the list
	// returns the removed element. Note that this does not return a Node, just value stored in the Node
	public T removeback();
	
	//-- returns true if value is in the list, false otherwise 
	public boolean contains(T value);
	
	//-- returns the index (location) of the first occurrence of value within the list, -1 if value is not in the list
	// e.g. if value is the first item, returns 0
	public int indexOf(T value);
	
	//-- returns the index (location) of the last occurrence of value within the list, -1 if value is not in the list
	// e.g. if value is the first item, returns 0
	public int lastIndexOf(T value);
	
	// -- returns true if the list is empty, false otherwise
    public boolean isEmpty();

    // -- returns the number of elements in the list
    public int size();
	
}

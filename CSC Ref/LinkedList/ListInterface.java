package LinkedList;

public interface ListInterface<T> {

    // -- add value at position index (e.g. index of 0 adds to front of list)
    //    throws exception if index < 0 or index > size of list (e.g. if index equal to size, adds to back)
    public void add(int index, T value) throws IndexOutOfBoundsException;

    // -- adds value to front of list
    public void addfront(T value);

    // -- adds value to back of list
    public void addback(T value);

    // -- gets the value at index of the list
    public T get(int index) throws IndexOutOfBoundsException;

    // -- removes all elements from the list
    public void clear();

    // -- remove value at index (e.g. index of 0 removes front of list)
    //    returns the removed element. Note that this does not return a Node,
    //    just the value stored in the Node.
    //    throws exception if index is not within the list range
    public T remove(int index) throws IndexOutOfBoundsException;

    // -- remove the first value in the list
    //    returns the removed element. Note that this does not return a Node,
    //    just the value stored in the Node.
    public T removefront();

    // -- remove the first value in the list
    //    returns the removed element. Note that this does not return a Node,
    //    just the value stored in the Node.
    public T removeback();

    // -- returns true if value is in the list, false otherwise
    public boolean contains(T value);

    // -- returns the index (location) of the first occurrence of value
    //    within the list, -1 if value is not in list
    //    (e.g. if value is first item, returns 0)
    public int indexOf(T value);

    // -- returns the index (location) of the last occurrence of value
    //    within the list, -1 if value is not in list
    //    (e.g. if value is first item, returns 0)
    public int lastIndexOf(T value);

    // -- returns true if the list is empty, false otherwise
    public boolean isEmpty();

    // -- returns the number of elements in the list
    public int size();
}


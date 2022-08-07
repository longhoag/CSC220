// Ryan Hoang

package arraylist;

public class ArrayList extends ArrayListAbstract implements ArrayListInterface {

	public ArrayList() {
		capacity = 10;
		size = 0;
		// declare array length
		data = new int[capacity];
	}
	
	public ArrayList(int cap) throws IllegalArgumentException {
		
		if (cap < 0) {
			throw new IllegalArgumentException("Capacity cannot smaller than 0!");
		}
		capacity = cap;
		data = new int[capacity];
		size = 0;
	
	}
	
	private void removeFunction( int[] array, int start, int end) {
		
		for (int i = start; i < end; i++) {
			array[i] = array[i + 1];
		}
	}
	
	private void Resize(int[] ls, int storage, int sz) {
		int[] temp = data;
		data = new int[storage];
		
		for (int i = 0; i < sz; i++) {
			data[i] = temp[i];
		}
	}
	
	@Override 
	public String toString() {
		String output = "";
		
		for (int i = 0; i < size; i++) {
			output = output + data[i] + " "; 
		}
		
		return output;
	}

	@Override
	public int capacity() {
		// TODO Auto-generated method stub
		return capacity;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (size == 0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean contains(int e) {
		// TODO Auto-generated method stub
		
		boolean status = false;
		
		for (int i = 0; i < size; i++) {
			if (data[i] == e) {
				status = true;
			}
		}
		return status;
	}

	@Override
	public int[] toArray() {
		// TODO Auto-generated method stub	
		return data;
	}

	@Override
	public void ensureCapacity(int c) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
		if (c < size) {
			throw new IllegalArgumentException("Capacity cannot be smaller than current size!");
		}
		
		int[] newdata = new int[c];
		
		capacity = c;
		
		for (int i = 0; i < size; i++) {
			newdata[i] = data[i];
		}
		
	}

	@Override
	public void add(int e) {
		// TODO Auto-generated method stub
		
		if (size == capacity) {
			capacity++;
		}
		
		// change the capacity of array 
		Resize(data, capacity, size);
		
		size++;
		
		data[size - 1] = e;
	}

	@Override
	public void add(int index, int e) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index is Invalid");
		}
		
		if (size == capacity) {
			capacity++;
		}
		
		Resize(data, capacity, size);
		
		// store data after index value
		int[] temp = new int[size - index];
		for (int i = 0; i < size - index; i++) {
			temp[i] = data[index + i];
		}
		
		size++;
		
		// change data at index and shift data up
		data[index] = e;
		for (int i = index + 1; i < size; i++) {
			data[i] = temp[i - index - 1];
		}
	}
	
	@Override
	public int remove(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index is Invalid!");
		}
		
		size--;
		// shift data up but keep capacity
		removeFunction(data, index, size);
		
		return data[index];
	}

	@Override
	public boolean removeFirst(int e) {
		// TODO Auto-generated method stub
		
		if (indexOf(e) == -1) {
			return false;
		}
		
		int del = indexOf(e);
	
		size--;
		removeFunction(data, del, size);
		
		return true;
	}

	@Override
	public boolean removeLast(int e) {
		// TODO Auto-generated method stub
		
		if (indexOf(e) == -1) {
			return false;
		}
		
		int del = lastIndexOf(e);
	
		size--;
		
		removeFunction(data, del, size);
		
		return true;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		int[] temp = new int[capacity];
		
		data = temp;
		
		size = 0;
	}

	@Override
	public int get(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index is Invalid!");
		}
		
		return data[index];
	}

	@Override
	public int set(int index, int e) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index is Invalid!");
		}
		
		int ori = data[index];
		
		data[index] = e;
		
		return ori;
	}

	@Override
	public int indexOf(int e) {
		// TODO Auto-generated method stub
		int pos = -1;
		for (int i = 0; i < size; i++) {
			if (data[i] == e) {
				pos = i;
				break;
			}
		}
		
		return pos;
	}

	@Override
	public int lastIndexOf(int e) {
		// TODO Auto-generated method stub
		int pos = -1;
		
		for (int i  = 0; i < size; i++) {
			if (data[i] == e) {
				pos = i;
			}
		}
		
		return pos;
	}
}

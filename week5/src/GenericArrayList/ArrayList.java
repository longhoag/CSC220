package GenericArrayList;

public class ArrayList<T> extends ArrayListAbstract<T> implements ArrayListInterface<T> {

	
	public ArrayList() {
		capacity = 10;
		size = 0;
		//declare array length 
		setCapa(capacity);
		//Object[] o = new Object[capacity];
		//data = (T[]) o;
		
	}
	
	public ArrayList(int cap) throws IllegalArgumentException {
		if (cap < 0) {
			throw new IllegalArgumentException("Capacity cannot smaller than 0!");
		}
		capacity = cap;
		setCapa(capacity);
		//Object[] o = new Object[capacity];
		//data = (T[]) o;
		//size = 0;
	}
	
	@SuppressWarnings("unchecked")
	private void setCapa(int usage) {
		Object[] o = new Object[usage];
		data = (T[]) o;
	}
	
	
	private void Resize(int storage, int sz) {
		T[] temp = data;
		setCapa(storage);
		
		for (int i = 0; i < sz; i++) {
			data[i] = temp[i];
		}	
	}
	
	private void removeFunction(T[] array, int start, int end) {
		for (int i = start; i < end; i++) {
			array[i] = array[i + 1];
		}
	}
	
	
	@Override
	public String toString() {
		String output = "";
		
		for (int i = 0; i < size; i++) {
			output += data[i] + " ";
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
	public boolean contains(T e) {
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
	public T[] toArray() {
		// TODO Auto-generated method stub
		return data;
	}

	@Override
	public void ensureCapacity(int c) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (c < size) {
			throw new IllegalArgumentException("Capcity cannot be smaller than current size!");
		}
		
		Object[] newdata = new Object[c];
		capacity = c;
		
		for (int i = 0; i < size; i++) {
			newdata[i] = data[i];
		}
	}

	@Override
	public void add(T e) {
		// TODO Auto-generated method stub
		if (size == capacity) {
			capacity++;
		}
		
		Resize(capacity, size);
		
		size++;
		
		data[size - 1] = e;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public void add(int index, T e) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index is Invalid");
		}
		
		if (size == capacity) {
			capacity++;
		}
		Resize(capacity, size);
		
		//store data after index value 
		Object[] t = new Object[size - index];
		T[] temp = (T[]) t;
		for (int i = 0; i < size - index; i++) {
			temp[i] = data[index + i];
		}
		
		size++;
		
		//change data at index and shift data up
		data[index] = e;
		for (int i = index + 1; i < size; i++) {
			data[i] = temp[i - index - 1];
		}
		
	}

	@Override
	public T remove(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index is Invalid!");
		}
		size--;
		//shift data up but keep capacity 
		removeFunction(data, index, size);
		
		return data[index];	
	}
	
	@Override
	public boolean removeFirst(T e) {
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
	public boolean removeLast(T e) {
		// TODO Auto-generated method stub
		if (indexOf(e) == - 1) {
			return false;
		}
		int del = lastIndexOf(e);
		size--;
		removeFunction(data, del, size);
		
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		Object[] o = new Object[capacity];
		T[] temp = (T[]) o;
		data = temp;
		size = 0;
	}

	@Override
	public T get(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index is Invalid!");
		}
		return data[index];
	}

	@Override
	public T set(int index, T e) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index is Invalid!");
		}
		
		T ori = data[index];
		data[index] = e;
		
		return ori;
	}

	@Override
	public int indexOf(T e) {
		// TODO Auto-generated method stub
		int pos = -1;
		for (int i = 0; i < size; i++) {
			if (data[i].equals(e)) {
				pos = i;
				break;
			}
		}
		return pos;
	}

	@Override
	public int lastIndexOf(T e) {
		// TODO Auto-generated method stub
		int pos = -1;
		
		for (int i = 0; i < size; i++) {
			if (data[i].equals(e)) {
				pos = i;
			}
		}
		return pos;
	}

}

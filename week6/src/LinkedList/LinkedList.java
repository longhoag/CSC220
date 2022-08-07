package LinkedList;

public class LinkedList<T> extends ListAbstract<T> implements ListInterface<T> {

	//-- get the value at index of the list
	@SuppressWarnings("unchecked")
	public T get(int index) throws IndexOutOfBoundsException {
		
		//-- if index == size cannot get that element to remove
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException("Index is Invalid!");
		}
		
		Node current = head;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		
		return (T) current.value;
	
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void add(int index, T value) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException("Index is Invalid!");
		}
		 
		if (index == 0) {
			addfront(value);
			return;
		}
		
		if (index == size()) {
			addback(value);
			return;
		}
	
		//-- if none of the special cases 
		
		Node newNode = new Node(value);
		Node current = head;
		int pos = 0;
		//-- loop through the list
		while (pos < index - 1) {
			current = current.next;
			pos++;
		}
		//-- point the new node to the previous node at that index
		newNode.next = current.next;
		//-- point the current node to the new value 
		current.next = newNode;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void addfront(T value) {
		// TODO Auto-generated method stub
		Node newHead = new Node(value);
		//-- point the new node added to the previous head
		newHead.next = head;
		//-- make the new node head
		head = newHead;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void addback(T value) {
		// TODO Auto-generated method stub
		if (head == null) {
			head = new Node(value);
			return;
		}
		//-- if head is not null
		Node current = head;
		
		//-- loop through the list till the last element
		while (current.next != null) {
			current = current.next;
		}
		
		current.next = new Node(value);
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		head = null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T remove(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		T out = null;
		
		//-- if index == size cannot get that element to remove
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException("Index is Invalid!");
		}
		
		if (index == 0) {
			return removefront();
		}
		
		
		//-- if none of the special cases 
		int pos = 0;
		Node current = head;
		
		while (pos < index - 1) {
			current = current.next;
			pos++;
		}
		out = (T) current.next.value;
		current.next = current.next.next;
		
		return out;

	}

	@SuppressWarnings("unchecked")
	@Override
	public T removefront() {
		// TODO Auto-generated method stub
		T out = (T) head.value;
		
		head = head.next;
		
		return out;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T removeback() {
		// TODO Auto-generated method stub
		
		//-- check for only 1 item i the list
		if (head.next == null) {
			T out = (T) head;
			head = null;
			return out;
		}
		
		//-- if regular list
		Node current = head;
		
		while (current.next.next != null) {
			current = current.next;
		}
		T out = (T) current.next.value;
		//-- point the 2nd last item to null
		current.next = null;
	
		return out;
	}

	@Override
	public boolean contains(T value) {
		// TODO Auto-generated method stub
		
		//-- list is null -> false
		if (head == null) {
			return false;
		}
		//-- if list has 1 element, check that e
		if (head.next == null) {
			if (head.next.value == value) {
				return true;
			}
		}
		
		boolean status = false;
		Node current = head;
		
		//-- no special cases 
		while (current.next != null) {
			//-- check the last item also
			if (current.value == value || current.next.value == value) {
				status = true;
				break;
			}
			current = current.next;
		}
		
		
		return status;
	}

	@Override
	public int indexOf(T value) {
		// TODO Auto-generated method stub
		int pos = 0;
		//-- if no list -> -1
		if (head == null) {
			return -1;
		}
		//-- if there is 1 e in the list
		if (head.next == null) {
			if (head.value == value) {
				return pos = 0;
			}
			else {
				return pos = -1;
			}
		}
		//-- if more than 1 e in the list
		Node current = head;
	
		while (current.next != null) {
			// if find the index
			if (current.value.equals(value)) {
				break;
			}
			// change the current and pos value
			current = current.next;
			pos++;
		}	
		//-- check the last item if no break is made
		if (current.value.equals(value)) {
			return pos;
		}
		else {
			return pos = -1;
		}

	}

	@Override
	public int lastIndexOf(T value) {
		// TODO Auto-generated method stub
		int pos = 0;
		int idex = 0;
		
		//-- if no list -> -1
		if (head == null) {
			return -1;
		}
		
		//-- if there is 1 e in the list
		if (head.next == null) {
			if (head.value == value) {
				return pos = 0;
			}
			else {
				return pos = -1;
			}
			
		}
		
		Node current = head;
		
		while (current.next != null) {
			if (current.value.equals(value)) {
				idex = pos;
			}
			current = current.next;
			pos++;
		}
		if (idex != 0) {
			return idex;
		}
		
		if (current.value.equals(value)) {
			return pos;
		}
		else {
			return pos = -1;
		}
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.size() == 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub	
		Node current = head;
		int number = 0;
		
		if (head == null) {
			return number;
		}
		
		while (current.next != null) {
			current = current.next;
			number++;
		}
		return number + 1;
	}
	

}

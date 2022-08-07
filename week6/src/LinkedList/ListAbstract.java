package LinkedList;

public abstract class ListAbstract<T> {
	Node head;
	
	public static class Node<T> {
		T value;   
		Node next;
		
		public Node(T value) {
			this.value = value;
			this.next = null;
		}
		
		@Override 
		public boolean equals(Object arg) {
			//-- compare Node to itself is true
			if (this == arg)
				return true;
			
			//-- compare Node to null is false
			if (arg == null)
				return false;
			
			//-- value in Node not the same type as arg returns false
			if (this.value.getClass() != arg.getClass())
				return false;
			
			// Node<?> otherNode = (Node<?>) other;
			
			
			//-- compare Node.value to the argument
			return (this.value.equals(arg));
		}
		
		@Override
		public String toString() {
			return value.toString();
		}
	}
	
	@Override 
	public String toString() {
		String s = "";
		Node ref = head;
		while (ref != null) {
			s += ref.toString() + " ";
			ref = ref.next;
		}
		return s;
	}
}

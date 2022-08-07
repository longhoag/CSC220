package HashMap;
import LinkedList.LinkedList;

public abstract class HashMapBase<KEYTYPE, DATATYPE> {
	
	//-- the table will hold 257 (default value) linked list 
	//-- (prime number larger than the number of items we want to store in the table, ideally 2 * num)
	
	//-- the default size of the hashmap array
	protected int N = 257;
	
	//-- a HashMap is an array of linked list of Node<KEYTYPE, DATATYPE> 
	// accessed through and index provided by a hash func 
	protected LinkedList<HashMapNode<KEYTYPE, DATATYPE>> hashmap[];
	
	//-- while it cannot be specified here (abstract class cannot contain a constructor,
	// the extending class should include a constructor where the argument is the size of the hashmap,
	// replacing the default value of N above 
	//-- the constructor must allocate the hashmap[] array and initialize each of its locations with LinkedList<Node<KEYTYPE, DATATYPE>>
	
	// public HashMap(int N)
	
	
	// -- the hash function 
	protected abstract int hash(KEYTYPE key);
	
	//-- adds a Node<KEYTYPE, DATATYPE> object to the hashmap
	// the node can be added anywhere anywhere in the specified linked list 
	public abstract void add(KEYTYPE key, DATATYPE e);
	
	//-- returns an array that contains the size (length) of each linked list in the hash map
	public abstract int[] getSizes();
	
	//-- returns the linked list at the specified key
	public abstract LinkedList<HashMapNode<KEYTYPE, DATATYPE>> getListAt(KEYTYPE key);
	
	@Override 
	public String toString() {
		String s = "";
		for (int i = 0; i < hashmap.length; i++) {
			if (!hashmap[i].isEmpty()) {
				int j;
				for (j = 0; j < hashmap[i].size() - 1; j++) {
					s += hashmap[i].get(j) + ", ";
				}
				s += hashmap[i].get(j) + "\n";
			}
		}
		return s;
	}
	
	//-- Inner generic class to define the node used by the linked list
	public class HashMapNode<KEYTYPE, DATATYPE> {
		//-- the object value
		private KEYTYPE key;
		private DATATYPE value;
		
		//-- parameter is assigned to value
		public HashMapNode(KEYTYPE key, DATATYPE value) {
			this.key = key;
			this.value = value;
		}
		
		//-- uses toString of object stored at value
		public String toString() {
			return "<" + key + ", " + value + ">";
		}
		
		@Override
		public boolean equals(Object o) {
			HashMapNode<KEYTYPE, DATATYPE> e = (HashMapNode<KEYTYPE, DATATYPE>) o;
			
			KEYTYPE lhsK = this.key;
			DATATYPE  lhsV = this.value;

			KEYTYPE rhsK = e.key;
			DATATYPE  rhsV = e.value;
			
			return lhsK.equals(rhsK) && lhsV.equals(rhsV);
			
		}
	}

}

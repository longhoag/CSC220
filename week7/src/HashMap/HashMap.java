package HashMap;

import LinkedList.LinkedList;

public class HashMap<KEYTYPE, DATATYPE> extends HashMapBase<KEYTYPE, DATATYPE> {

	//constructor
	@SuppressWarnings("unchecked")
	public HashMap(int N) {
		
		this.N = N;
		
		hashmap = new LinkedList[N];
		
		for (int i = 0; i < hashmap.length; i++) {
			hashmap[i] = new LinkedList<HashMapNode<KEYTYPE, DATATYPE>>();
		}
	}
	
	
	@Override
	// 1
//	protected int hash(KEYTYPE key) {
//		// TODO Auto-generated method stub
//		String s = key.toString();
//		int sum = 0;
//		//--Sum all char in the string
//		for (int i = 0; i < s.length(); i++) {
//			sum += s.charAt(i);
//		}
//		//--return the sum mod the table size
//		return sum % N;
//	}
	
	
	// 2
	protected int hash(KEYTYPE key) {
		String s = key.toString();
		int h = 0, high;
		for (int i = 0; i < s.length(); i++) {
			h = (h << 4) + s.charAt(i);
			if ((high = h & 0xF0000000) != 0) {
				h ^= high >> 24;
			}
			h &= ~high;
		}
		return h % N;
	}
	
	
	@Override
	public void add(KEYTYPE key, DATATYPE e) {
		// TODO Auto-generated method stub
		
		int hashcode = hash(key);
		
		LinkedList<HashMapNode<KEYTYPE, DATATYPE>> item = hashmap[hashcode];
		
		item.addback(new HashMapNode<KEYTYPE, DATATYPE>(key, e));
		
//		//--check if existing value in the array
//		if (item == null) {
//			item = new LinkedList<>();
//			item.addback(new HashMapNode(key, e));
//			return;
//		}
//		//-- if some nodes already exist
//		else {
//			for (int i = 0; i < item.size(); i ++) {
//				if (item.get(i).equals(key)) { 
//					item.add(i, new HashMapNode(key, e));
//					return;
//				}
//			}
//		}
//		
//		item.addback(new HashMapNode(key, e));
//		return;
		
	}

	@Override
	public int[] getSizes() {
		// TODO Auto-generated method stub
		
		int[] sz = new int[N];
		
		for (int i = 0; i < hashmap.length; i++) {
			sz[i] = hashmap[i].size();
		}
	
		return sz;
	}

	@Override
	public LinkedList<HashMapNode<KEYTYPE, DATATYPE>> getListAt(KEYTYPE key) {
		// TODO Auto-generated method stub
		
		int hashcode = hash(key);
		
		LinkedList<HashMapNode<KEYTYPE, DATATYPE>> item = hashmap[hashcode];
		
		return item;
		
	}

}

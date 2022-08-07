package generic;

public class GenericClass<T> {
	
	//-- T is an generic type 
	// when instantiated, T must extend Object
	
	
	T[] data; //-- we want data to be an array of references
	
	@SuppressWarnings("unchecked")
	public GenericClass() {
		Object o[] = new Object[10];
		
		data = (T[])o;
		
		for (int i = 0; i < o.length; i++) {
			data[i] = (T) new Object();
		}
		
		
		
	}
	

	@SuppressWarnings("unchecked")
	public GenericClass(int c) {
		Object o[] = new Object[c];
		
		//-- will generate an unchecked cast compiler warning, this is ok
		
		for (int i = 0; i < o.length; i++) {
			o[i] = (T)new Object();
		}
		
		data = (T[])o;
	}
	
	public void insert(T element, int i) {
		data[i] = element;
	}
	
	
	@Override
	public String toString() {
		
		if (data != null) {
			String s = "";
			for (int i = 0; i < data.length; i++) {
				s += data[i].toString() + "";
			}
			return s;
		}
		else {
			return "GenericClass<T> null";
		}
		
	}
	
	public T[] getData() {
		return data;
	}
	
	//public T add(T lhs, T rhs) {
		
//		if (lhs instanceof Integer && rhs )
//		Integer l = (Integer) lhs;
//		Integer r = (Integer) rhs;
//
//	
//		return ;
		
//	}
	
	public static void main(String[] args) {
		
		GenericClass<String> genericString = new GenericClass<String>();
		//System.out.println(genericString);
		
		for (int i = 0; i < 5; i++) {
			genericString.insert("string " + i, i);
		}
		System.out.println(genericString);
		
		
	}

}

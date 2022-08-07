package inheritance;

public class Entry {
	public static void main(String[] args) {
		AbstractBase ab;
		Implementation implementation = new Implementation();
		Implementation1 implementation1 = new Implementation1();
		
		ab = implementation;
		ab.concretemethod(0);
		ab = implementation1;
		ab.concretemethod(1);
		
		Object objectarray[] = new Object[2];
		
		System.out.println(objectarray[0]);
		
		AbstractBase abstractbasearray[] = new AbstractBase[2];
		abstractbasearray[0] = implementation;
		
		for ( int i = 0; i < abstractbasearray.length; i ++) {
			abstractbasearray[i].abstractmethod(i);	
		}
		
	}

}

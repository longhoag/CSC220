package inheritance;

public abstract class AbstractBase {
	
	protected int mebervariable;
	public static final int staticconstant = 42;
	
	public abstract void abstractmethod(int a);
	
	public AbstractBase() {
		
	}
	public void concretemethod(int a) {
		System.out.println("concretemethod(" + a + ")");
		
	
	}

}

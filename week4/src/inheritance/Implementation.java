package inheritance;

public class Implementation extends AbstractBase {
	
	public Implementation() {
		System.out.println("Implementation");
	}
	
	public Implementation(int a) {
		//super(a);
		System.out.println("Implementation" + a);
	}
	
	@Override
	public void abstractmethod(int a) {
		System.out.println("Implementation.abstractmethod(" + a);
	}
	
}

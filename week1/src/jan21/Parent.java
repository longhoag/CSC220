package jan21;

public class Parent {
	
	// -- Java initializes class varibles 
	//		numeric types  -- 0
	// boolean types  -- false
	
	
	// -- access modifier  examples 
	public int apublic;
	private int aprivate;
	protected int aprotected;
	
	int apackage;
	
	public Object areference;
	
	
	
	// -- static variables shared by all objects of Parent
	static public int astatic;
	
	// -- constructors 
	
	public Parent () {
		
	}
	
	public Parent(int apublic, int aprivate) {
		this.apublic = apublic;
		
	}
	
	// -- an entry point for the application 
	public static void main (String[] args) {
		System.out.println(astatic);
		Parent p = new Parent();
		
		
		System.out.println(p.apublic);
		
		Parent p1 = new Parent();
		
		System.out.println(p);
		
		
		String a = "hello";
		String b = "hello";
		
		if (a ==b) {
			System.out.println("a == b");
		}
	}
	@Override
	public String toString() {
		
		// -- create a string representation of a Parent object 
		String s = "Parent: " + apublic;
		
		return s;
		
	}
	
	@Override
	public boolean equals(Object o) {
		boolean equality = false;
		
		if ( o instanceof Parent) {
			Parent p = (Parent) o;
			
			return (p.apublic == this.apublic);
		}
		return equality;
		
	}
	
}

package Reflection;

public class Class1 implements Interface {

	private void privatemethod() {
		System.out.println("private method");
	}
	public int ifacefunction(int p) {
		System.out.println("Class 1 Interface Method");
		return 0;
	}

	  static int staticmethod(int x)
	{
		System.out.println("Class1.staticmethod() " + x);
		return x * 10;
	}
	
	public void Class1Method ()
	{
		System.out.println("Class 1 Method");
	}

}

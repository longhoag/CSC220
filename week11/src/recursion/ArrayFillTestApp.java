package recursion;

public class ArrayFillTestApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int h = 3;
		int w = 3;
		
		ArrayFill af = new ArrayFill(h, w); 
		System.out.println(af);
		af.fill(h / 2, w / 2);
		System.out.println(af);

		// -- add more tests here

		ArrayFill af1 = new ArrayFill(10, 8); 
		//System.out.println(af1);
		af1.fill(1, 4);
		System.out.println(af1);
		
		ArrayFill af2 = new ArrayFill(4, 3); 
		//System.out.println(af1);
		af2.fill(0, 1);
		System.out.println(af2);
	}

}

package guiThreading;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int have = 0;
		int p = 1;
		int count = 10; //-- from text field
		while (have < count) {
			//-- guesing
			long perfect = (long) (Math.pow(2,  p - 1) * (Math.pow(2, p) - 1));
			//-- verifying
			if (isPerfect(perfect)) {
				//-- display result
				System.out.println(perfect + "\n");
				have ++;
			}
			p++;
		}
	}
	


public static boolean isPerfect(long n) {
	long sum = 0;
	for (long i = 1; i < n; i++) {
		try {
			if (n % i == 0) {
				sum += i;
			}
			
		} catch (Exception e) {
			System.out.println(i);
		}
	}
	
	return sum == n;
}

}

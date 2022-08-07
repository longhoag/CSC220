package recursion;

public class Fibonacci {

	public static int Fib(int N) {
		if (N == 1) {
			return 1;
		}
		if (N == 2) {
			return 1;
		}
		else {
			return Fib(N - 1) + Fib(N - 2);
		}
		
		//return Fib(N - 1) + Fib(N - 2);
		
	}
	
	public static int Fib2(int N) {
		if (N == 1) {
			return 1;
		}
		if (N == 2) {
			return 1;
		}
			
		return 0;
	}

	
	
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
	
		System.out.println(Fib(100));

	}

}

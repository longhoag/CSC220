package SimpleThreads;

public class Main {

	public static void main(String[] args) {
		Thread0 t0 = new Thread0();
		Thread1 t1 = new Thread1();
		t0.start();
		t1.start();

	}

}

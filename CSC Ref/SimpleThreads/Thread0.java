package SimpleThreads;

public class Thread0 extends Thread {

	public void run() {
		for (int i = 0; i < 100; ++i) {
			System.out.println("thread0 " + i);
		}
	}
}

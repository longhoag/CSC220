package guiThreading;

public class MultiThreading extends Thread {
	
	@Override 
	public void run() {
		int have = 0;
		int p = 1;
		int count = PNumbers.perfectNum; //-- from text field
		while (have < count) {
			//-- guessing
			long perfect = (long) (Math.pow(2,  p - 1) * (Math.pow(2, p) - 1));
			//-- verifying
			if (isPerfect(perfect)) {
				//-- display result
				//numbers.add(perfect);
				
				PNumbers.PerfectPanel.textArea.append(perfect + "\n");
				
				try {
					Thread.sleep(2000);
					
				} catch (InterruptedException e) {
					
				}
				have ++;
			}
			p++;
		}
	}
	
	public boolean isPerfect(long n) {
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

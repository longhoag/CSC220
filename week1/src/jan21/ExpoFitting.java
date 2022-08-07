package jan21;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.Math;

public class ExpoFitting {

	public static double ln(double m) {
		
		return Math.log(m);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double x[], y[];
		File data = new File("/Users/longhai/Developer/csc220/week1/datafile(1).csv");
		
		try {
			// read the file
			Scanner sn = new Scanner(data);
			
			// get the first number in datafile
			int number = sn.nextInt();
			sn.nextLine();
			
			// store data into array
			x = new double[number];
			y = new double[number];
			
			for (int i = 0; i < number; i++) {
				String s = sn.nextLine();
				String pair[] = s.split(",");
				
				x[i] = Double.parseDouble(pair[0]);
				y[i] = Double.parseDouble(pair[1]);
				
			}
			sn.close();
			
			
			int n = x.length;
			
			double A, B;
			
			double m1 = 0, m2 = 0, m3 = 0, m4 = 0, m5 = 0;
			
			// calculate according to the second formula
			
			for (int i = 0; i < n; i++) {
				m1 += x[i] * x[i] * y[i];
			}
			for (int i = 0; i < n; i++) {
				m2 += y[i] * ln(y[i]);
			}

			for (int i = 0; i < n; i++) {
				m3 += x[i] * y[i];
			}
			for (int i = 0; i < n; i++) {
				m4 += x[i] * y[i] * ln(y[i]);
			}
			for (int i = 0; i < n; i++) {
				m5 += y[i];
			}
			
			
			double denom = m5 * m1 - m3 * m3;
			
			A = (m1 * m2 - m3 * m4) / denom;
			B = (m5 * m4 - m3 * m2) / denom;
			
			A = Math.exp(A);
			
			System.out.println(" A = " + A + ", B = " + B);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

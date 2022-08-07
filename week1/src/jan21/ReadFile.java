package jan21;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class ReadFile {
	
	public static void main (String[] args) {
		
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
			
			for (int i = 0; i < x.length; i++) {
				System.out.println(x[i] + "," + y[i]);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

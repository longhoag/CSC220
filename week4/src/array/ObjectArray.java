package array;

import java.util.ArrayList;
import java.util.Scanner;

public class ObjectArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Object obarray[] = new Object[5];
		for (int i = 0; i < obarray.length; i++) {
			obarray[i] = new Object();
		}
		obarray[0] = new Scanner(System.in);
		
		obarray[1] = new Integer(7);
		
		System.out.print(obarray[0]);
		
		ArrayList al = new ArrayList(100);
		
		al.add(0);
		al.add("Hello");
		al.add(32.2);
		
		for (int i = 0; i < al.size(); i ++) {
			System.out.println(al.get(i));
			
			if (al.get(i) instanceof Integer) {
				System.out.println(i + "Integer");
			}
			else if (al.get(i) instanceof Double) {
				System.out.println(i + "Double");
			}
			else if (al.get(i) instanceof String) {
				System.out.println(i + "String");
			}
		}
		
		

	}

}

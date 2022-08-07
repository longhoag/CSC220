package HashMap;

import java.io.FileWriter;
import java.io.IOException;

//import HashMap.HashMapBase.HashMapNode;
import LinkedList.LinkedList;

public class HashMapTestApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//-- construct a HashMap that uses a String as the key and Double as Data type
		System.out.println("HashMap<String, Double>");
		HashMap<String, Double> hmsd = new HashMap<String, Double>(37);
		
		//-- insert some values into the HashMap
		for (int i = 0; i < 1000; i++) {
			hmsd.add(i + "", (double) i);
		}
		//System.out.println(hmsd);
		// -- get the linked-list at key "500.0"
		LinkedList<HashMapBase<String, Double>.HashMapNode<String, Double>> lld = hmsd.getListAt("500.0");
		System.out.println("Linked-List at 500.0: ");
		System.out.println(lld.size() + ": " + lld);
		
		try {
			FileWriter csvwriter = new FileWriter("hashmap.csv");
			//-- get the sizes of the linked lists
			int s[] = hmsd.getSizes();
			
			//-- save them to a csv file
			for (int i : s) {
				csvwriter.write(i + "\n");
			}
			csvwriter.close();
			
		} catch (IOException e) {
			System.out.println(e);
		}
		
		//-- create another hash map with different key/value types to demonstrate generic
		System.out.println("HashMap<Double, Integer>");
		
		HashMap<Double, Integer> hmdi = new HashMap<Double, Integer>(17);
		
		//-- insert value
		for (int i = 0; i < 17; i++) {
			hmdi.add(i * 2.1, i);
		}
		
		//-- get the linked list at key 6.3
		LinkedList<HashMapBase<Double, Integer>.HashMapNode<Double, Integer>> lli = hmdi.getListAt(6.3);
		System.out.println("Linked-List at 6.3: ");
		System.out.println(lli.size() + ": " + lli);
		System.out.println();
		
		System.out.println("The entire has map");
		System.out.println(hmdi);
	}
}

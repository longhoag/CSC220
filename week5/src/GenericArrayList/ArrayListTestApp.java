package GenericArrayList;

public class ArrayListTestApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("STRING TEST! \n");
		
		ArrayList<String> aS = new ArrayList<String>();
		System.out.println("Size: " + aS.size() + " Capacity: " + aS.capacity());
		
		for (int i = 0; i < (aS.capacity() - 1); i++) {
			aS.add("Ver." + i);
		}
		
		System.out.println("Data: " + aS + "  " + "Size: " + aS.size() + " Capacity: " + aS.capacity());
		
		aS.add("Ver." + 9);
		System.out.println("Data: " + aS + "  " + "Size: " + aS.size() + " Capacity: " + aS.capacity());
		
		aS.add("Ver." + 10);
		System.out.println("Data: " + aS + "  " + "Size: " + aS.size() + " Capacity: " + aS.capacity());
		
		aS.add(5, "Ver." + 55);
		System.out.println("Data: " + aS + "  " + "Size: " + aS.size() + " Capacity: " + aS.capacity());
		
		aS.add(aS.size(), "Ver" + aS.size());
		System.out.println("Data: " + aS + "  " + "Size: " + aS.size() + " Capacity: " + aS.capacity());
		
		try {
			aS.add(aS.capacity() + 1, "Ver." + aS.capacity() + 1);
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println(e);
		}
		finally {
			//--nothing 
		}
		System.out.println("Data: " + aS + "  " + "Size: " + aS.size() + " Capacity: " + aS.capacity());
		
		aS.set(5, "Ver." + 66);
		System.out.println("Data: " + aS + "  " + "Size: " + aS.size() + " Capacity: " + aS.capacity());
		
		try {
			aS.add(aS.capacity() + 1, "Ver." + aS.capacity() + 1);
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println(e);
		}
		finally {
			//--nothing 
		}
		System.out.println("Data: " + aS + "  " + "Size: " + aS.size() + " Capacity: " + aS.capacity());
		System.out.println("Data[5]: " + aS.get(5));
		
		
		aS.set(10, "Ver." + 66);
		System.out.println("Data: " + aS + " " + "Size: " + aS.size() + " Capacity: " + aS.capacity());
		
		System.out.println("Ver. 66 at locations " + aS.indexOf("Ver." + 66) + " and " + aS.lastIndexOf("Ver." + 66));
		
		aS.removeLast("Ver." + 66);
		System.out.println("Data: " + aS + " " + "Size: " + aS.size() + " Capacity: " + aS.capacity());
		
		aS.set(10, "Ver." + 66);
		System.out.println("Data: " + aS + " " + "Size: " + aS.size() + " Capacity: " + aS.capacity());
		
		aS.removeFirst("Ver." + 66);
		System.out.println("Data: " + aS + " " + "Size: " + aS.size() + " Capacity: " + aS.capacity());
		
		aS.remove(3);
		System.out.println("Data: " + aS + " " + "Size: " + aS.size() + " Capacity: " + aS.capacity());
		
		System.out.println("Contains " + aS.get(2) + ": " + aS.contains(aS.get(2)));
        System.out.println("Contains Ver. 999: " + aS.contains("Ver." + 999));
        
        
        aS = new ArrayList<String>(5);
        try {
        	aS.add(3, "Ver." + 3);
        }
		catch (IndexOutOfBoundsException e) {
			System.out.println(e);
		}
        finally {
        	//-- nothing
        }
        System.out.println("finish \n");
		
        
        
        
        System.out.println("Double TEST! \n");
        
        ArrayList<Double> aD = new ArrayList<Double>();
		System.out.println("Size: " + aD.size() + " Capacity: " + aD.capacity());
			
		for (int i = 0; i < (aD.capacity() - 1); i++) {
			aD.add(i * 0.5);
		}
		System.out.println("Data: " + aD + " " + "Size: " + aD.size() + " Capacity: " + aD.capacity());
		
		aD.add(9 * 0.5);
		System.out.println("Data: " + aD + " " + "Size: " + aD.size() + " Capacity: " + aD.capacity());
		
		aD.add(10 * 0.5);
		System.out.println("Data: " + aD + " " + "Size: " + aD.size() + " Capacity: " + aD.capacity());
		
		aD.add(5, 55 * 0.5);
		System.out.println("Data: " + aD + " " + "Size: " + aD.size() + " Capacity: " + aD.capacity());
		
		aD.add(aD.size(), aD.size() * 0.5);
		System.out.println("Data: " + aD + " " + "Size: " + aD.size() + " Capacity: " + aD.capacity());
		
		try {
			aD.add(aD.capacity() + 1, (aD.capacity() + 1) * 0.5);
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println(e);
		}
		finally {
			//-- nothing 
		}
		System.out.println("Data: " + aD + " " + "Size: " + aD.size() + " Capacity: " + aD.capacity());
		
		aD.set(5, 66 * 0.5);
		System.out.println("Data: " + aD + " " + "Size: " + aD.size() + " Capacity: " + aD.capacity());
		
		try {
			aD.add(aD.capacity() + 1, (aD.capacity() + 1) * 0.5);
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println(e);
		}
		finally {
			//-- nothing 
		}
		System.out.println("Data: " + aD + " " + "Size: " + aD.size() + " Capacity: " + aD.capacity());
		System.out.println("Data[5]: " + aD.get(5));
		
		aD.set(10, 66 * 0.5);
		System.out.println("Data: " + aD + " " + "Size: " + aD.size() + " Capacity: " + aD.capacity());
		
		System.out.println("33.0 at locations " + aD.indexOf(33.0) + " and " + aD.lastIndexOf(33.0));
		
		aD.removeLast(66 * 0.5);
		System.out.println("Data: " + aD + " " + "Size: " + aD.size() + " Capacity: " + aD.capacity());
		
		aD.set(10, 66 * 0.5);
		System.out.println("Data: " + aD + " " + "Size: " + aD.size() + " Capacity: " + aD.capacity());
		
		aD.removeFirst(66 * 0.5);
		System.out.println("Data: " + aD + " " + "Size: " + aD.size() + " Capacity: " + aD.capacity());
		
		aD.remove(3);
		System.out.println("Data: " + aD + " " + "Size: " + aD.size() + " Capacity: " + aD.capacity());
		
		System.out.println("Contains " + aD.get(2) + ": " + aD.contains(aD.get(2)));
        System.out.println("Contains 499.5: " + aD.contains(999 * 0.5));
        
        
        aD = new ArrayList<Double>(5);
        try {
        	aD.add(3, 3 * 0.5);
        }
		catch (IndexOutOfBoundsException e) {
			System.out.println(e);
		}
        finally {
        	//-- nothing
        }
        System.out.println("finish");
        
        
	}

}

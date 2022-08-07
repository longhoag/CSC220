package arraylist;

public class ArrayListTestApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList al = new ArrayList();
		System.out.println("Size: " + al.size() + " Capacity: " + al.capacity());
			
		for (int i = 0; i < (al.capacity() - 1); i++) {
			al.add(i);
		}
		System.out.println("Data: " + al + " " + "Size: " + al.size() + " Capacity: " + al.capacity());
		
		al.add(9);
		System.out.println("Data: " + al + " " + "Size: " + al.size() + " Capacity: " + al.capacity());
		
		al.add(10);
		System.out.println("Data: " + al + " " + "Size: " + al.size() + " Capacity: " + al.capacity());
		
		al.add(5, 55);
		System.out.println("Data: " + al + " " + "Size: " + al.size() + " Capacity: " + al.capacity());
		
		al.add(al.size(), al.size());
		System.out.println("Data: " + al + " " + "Size: " + al.size() + " Capacity: " + al.capacity());
		
		try {
			al.add(al.capacity() + 1, al.capacity() + 1);
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println(e);
		}
		finally {
			//-- nothing 
		}
		System.out.println("Data: " + al + " " + "Size: " + al.size() + " Capacity: " + al.capacity());
		
		al.set(5, 66);
		System.out.println("Data: " + al + " " + "Size: " + al.size() + " Capacity: " + al.capacity());
		
		try {
			al.add(al.capacity() + 1, al.capacity() + 1);
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println(e);
		}
		finally {
			//-- nothing 
		}
		System.out.println("Data: " + al + " " + "Size: " + al.size() + " Capacity: " + al.capacity());
		System.out.println("Data[5]: " + al.get(5));
		
		al.set(10, 66);
		System.out.println("Data: " + al + " " + "Size: " + al.size() + " Capacity: " + al.capacity());
		
		System.out.println("66 at locations " + al.indexOf(66) + " and " + al.lastIndexOf(66));
		
		al.removeLast(66);
		System.out.println("Data: " + al + " " + "Size: " + al.size() + " Capacity: " + al.capacity());
		
		al.set(10, 66);
		System.out.println("Data: " + al + " " + "Size: " + al.size() + " Capacity: " + al.capacity());
		
		al.removeFirst(66);
		System.out.println("Data: " + al + " " + "Size: " + al.size() + " Capacity: " + al.capacity());
		
		al.remove(3);
		System.out.println("Data: " + al + " " + "Size: " + al.size() + " Capacity: " + al.capacity());
		
		System.out.println("Contains " + al.get(2) + ": " + al.contains(al.get(2)));
        System.out.println("Contains 999: " + al.contains(999));
        
        
        al = new ArrayList(5);
        try {
        	al.add(3, 3);
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

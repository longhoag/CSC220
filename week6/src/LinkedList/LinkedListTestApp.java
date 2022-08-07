package LinkedList;

public class LinkedListTestApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListInterface<String> lli = new LinkedList<String>();
        for (int i = 4; i >= 0; --i) {
            lli.addfront(i + "");
        }
        System.out.println(lli.size() + ": " + lli);
        
        lli.addback("2");
        System.out.println(lli.size() + ": " + lli);
        
        lli.add(1, "0.5");
        System.out.println(lli.size() + ": " + lli);
        
        lli.add(0, "-0.5");
        System.out.println(lli.size() + ": " + lli);
        
        lli.clear();
        System.out.println(lli.size() + ": " + lli);
        
        lli.add(0, "0");
        System.out.println(lli.size() + ": " + lli);
        
        lli.add(lli.size(), "1");
        System.out.println(lli.size() + ": " + lli);
        
        lli.add(lli.size(), "2");
        System.out.println(lli.size() + ": " + lli);
        
        boolean contains1 = lli.contains("1");
        System.out.println("Contains 1: " + contains1);

        boolean contains2 = lli.contains("2");
        System.out.println("Contains 2: " + contains2);
        
        boolean contains3 = lli.contains("3");
        System.out.println("Contains 3: " + contains3);
        
        lli.addfront("1");
        System.out.println(lli.size() + ": " + lli);
        
        int first = lli.indexOf("1");
        int last = lli.lastIndexOf("1");
        System.out.println("1 at " + first + " and " + last);

        String front = (String)lli.removefront();
        System.out.println("Removed: " + front + " from front");
        System.out.println(lli.size() + ": " + lli);
        
        front = (String)lli.removefront();
        System.out.println("Removed: " + front + " from front");
        System.out.println(lli.size() + ": " + lli);
        
        lli.clear();
        for (int i = 0; i < 5; ++i) {
            lli.addback(i + " ");
        }
        System.out.println(lli.size() + ": " + lli);
        
        String back = (String)lli.removeback();
        System.out.println("Removed: " + back + " from back");
        System.out.println(lli.size() + ": " + lli);
        
        String middle = (String)lli
        		.remove(2);
        System.out.println("Removed: " + middle + " from 2");
        System.out.println(lli.size() + ": " + lli);
        
        try {
            lli.remove(lli.size());
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }
        
        while (lli.size() > 0) {
            lli.removeback();
        }
        System.out.println(lli.size() + ": " + lli);

	}

}

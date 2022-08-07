package Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/*
Reflection is commonly used by programs which require the ability to examine or modify the runtime behavior 
of applications running in the Java virtual machine. This is a relatively advanced feature and should be used 
only by developers who have a strong grasp of the fundamentals of the language. With that caveat in mind, 
reflection is a powerful technique and can enable applications to perform operations which would otherwise be impossible.
 
 Java Decompiler: http://www.javadecompilers.com/result
 *
 */
public class ReflectionDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	
		try {
			// -- construct an object for test purposes only

			Class1 r = new Class1();
			//String r = "Hello, World!";
			// -- get the class from the object
			Class<?> cn = r.getClass();
			
			System.out.println("Classname");
			System.out.println("=========");

			// -- get Class object for the class named in String classname
			String clname = cn.getName();

			// -- you can put any fully qualified class name here
			//clname = "Reflection.Main"; //"javax.swing.JFrame";//"java.lang.Math";//"javax.swing.JFrame";
			
			// -- get the class descriptor for the class named in clname
			Class<?> c = Class.forName(clname);
			System.out.println(">>>>>" + c + "<<<<<");

			// -- get class access modifiers
			System.out.println("Access Modifiers");
			System.out.println("================");
			int m = c.getModifiers();
		    if (Modifier.isPublic(m)) System.out.println("public");
		    if (Modifier.isAbstract(m)) System.out.println("abstract");
		    if (Modifier.isFinal(m)) System.out.println("final");

		    // -- get inheritance structure
			System.out.println("Inheritance Tree");
			System.out.println("================");
		    Class<?> subclass = c;
		    Class<?> superclass = subclass.getSuperclass();
		    while (superclass != null) {
		       String className = superclass.getName();
		       System.out.println(className);
		       subclass = superclass;
		       superclass = subclass.getSuperclass();
		    }
		    
		    // -- get member variables
			System.out.println("Member Variables");
			System.out.println("================");
		    Field[] publicFields = c.getFields();
		    for (int i = 0; i < publicFields.length; i++) {
		       String fieldName = publicFields[i].getName();
		       Class<?> typeClass = publicFields[i].getType();
		       String fieldType = typeClass.getName();
		       System.out.println("Name: " + fieldName + ", Type: " + fieldType);
		    }
		    
		    // -- get constructors
			System.out.println("Class Constructors");
			System.out.println("==================");
		    Constructor<?>[] theConstructors = c.getConstructors();
		    for (int i = 0; i < theConstructors.length; i++) {
		       System.out.print(cn.getName() + "( ");
		       Class<?>[] parameterTypes = theConstructors[i].getParameterTypes();
		       for (int k = 0; k < parameterTypes.length; k++) {
		          String parameterString = parameterTypes[k].getName();
		          System.out.print(parameterString + " ");
		       }
		       System.out.println(")");
		   }
		    
		   // -- get method information
		    System.out.println("Class Methods");
			System.out.println("=============");
			Method[] theMethods = c.getMethods();
			for (int i = 0; i < theMethods.length; i++) {
				String methodString = theMethods[i].getName();
				System.out.println("Name: " + methodString);
				String returnString = theMethods[i].getReturnType().getName();
				System.out.println("   Return Type: " + returnString);
				Class<?>[] parameterTypes = theMethods[i].getParameterTypes();
				System.out.print("   Parameter Types:");
				for (int k = 0; k < parameterTypes.length; k ++) {
					String parameterString = parameterTypes[k].getName();
					System.out.print(" " + parameterString);
				}
				System.out.println();
			}
		    
		} 
		catch (ClassNotFoundException cnfe) {
			System.out.println(cnfe);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		

	}

}

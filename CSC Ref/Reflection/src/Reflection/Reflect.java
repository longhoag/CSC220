package Reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Locale;
import static java.lang.System.out;
import static java.lang.System.err;

public class Reflect<T> {

	private boolean testBar() {
		return true;
	}

	public static void main(String... args) {

		String classname = "Reflection.Class1";
				
		
		try {
			Class<?> c = Class.forName(classname);
			Object t = c;
			
			if (t instanceof Reflection.Class1) {
				System.out.println("Class is Reflection.Class1");
			}

			Method[] allMethods = c.getDeclaredMethods();
			for (Method m : allMethods) {
				// -- make sure it's the proper method (name and return type)
				String mname = m.getName();
				String returntype = m.getGenericReturnType().getTypeName();
				if (!mname.startsWith("staticmethod") || !returntype.equals("int")) {
					continue;
				}
				// -- make sure it has the proper arguments (int)
				Type[] pType = m.getGenericParameterTypes();
				String typename = pType[0].getTypeName();
				if ((pType.length != 1) || !typename.equals("int")) {
					continue;
				}

				// -- invoke the method
				System.out.println("invoking " + mname);
				try {
					Object o = m.invoke(t, 42);
					System.out.println(mname + " returned " + (Integer)o);

					// Handle any exceptions thrown by method to be invoked.
				} catch (InvocationTargetException x) {
					Throwable cause = x.getCause();
					err.format("invocation of %s failed: %s%n", mname, cause.getMessage());
				}
			}

			// production code should handle these exceptions more gracefully
		} catch (ClassNotFoundException x) {
			x.printStackTrace();

		} catch (IllegalAccessException x) {
			x.printStackTrace();
		}
	}
}
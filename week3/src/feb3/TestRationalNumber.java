package feb3;

public class TestRationalNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			RationalNumber rn = new RationalNumber(39, -6);
			System.out.println("Fraction = " + rn);
			rn = new RationalNumber();
			System.out.println("Fraction = " + rn);
			rn = new RationalNumber(1, 2);
			System.out.println("Fraction = " + rn);
			rn = new RationalNumber(-1, 2);
			System.out.println("Fraction = " + rn);
			rn = new RationalNumber(1, -2);
			System.out.println("Fraction = " + rn);
			rn = new RationalNumber(-1, -2);
			System.out.println("Fraction = " + rn);
			
			RationalNumber rhs, lhs;
			
			lhs = new RationalNumber(9, 8);
			rhs = new RationalNumber(1, 2);
			RationalNumber sum = rhs.add(lhs);
			System.out.println(rhs + " + " + lhs + " = " +  sum);
			
			lhs = new RationalNumber(3, 8);
			rhs = new RationalNumber(1, 2);
			RationalNumber diff = rhs.sub(lhs);
			System.out.println(rhs + " - " + lhs + " = " +  diff);
			
			lhs = new RationalNumber(3, 8);
			rhs = new RationalNumber(1, 2);
			RationalNumber prod = rhs.mult(lhs);
			System.out.println(rhs + " * " + lhs + " = " +  prod);
			
			lhs = new RationalNumber(3, 8);
			rhs = new RationalNumber(4, 3);
			RationalNumber quot = rhs.div(lhs);
			System.out.println(rhs + " / " + lhs + " = " +  quot);
			
			lhs = new RationalNumber(3, 8);
			rhs = new RationalNumber(3, 8);
			if (lhs.equals(rhs)) {
				System.out.println(lhs + " == " + rhs);
			}
			else {
				System.out.println(lhs + " != " + rhs);
			}
			
			rhs.setDenominator(4);
			if (lhs.equals(rhs)) {
				System.out.println(lhs + " == " + rhs);
			}
			else {
				System.out.println(lhs + " != " + rhs);
			}
		
		}
		catch (IllegalArgumentException e) {
			System.out.println(e);
		}
		catch(ArithmeticException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		// 
		try {
			RationalNumber rn = new RationalNumber(0, 0);
			
		}
		catch (IllegalArgumentException e) {
			System.out.println(e);
		}
		catch(ArithmeticException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		//
		try {
			RationalNumber lhs = new RationalNumber(1, 1);
			RationalNumber rhs = new RationalNumber();
			RationalNumber quot = lhs.div(rhs);
			
		}
		catch (IllegalArgumentException e) {
			System.out.println(e);
		}
		catch(ArithmeticException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		//
		try {
			RationalNumber lhs = new RationalNumber(1, 1);
			lhs.setDenominator(0);
			
		}
		catch (IllegalArgumentException e) {
			System.out.println(e);
		}
		catch(ArithmeticException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}

}

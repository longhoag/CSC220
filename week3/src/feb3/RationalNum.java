package feb3;

public class RationalNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//-- Ryan Hoang 
		//-- my test code but I deleted it to make it clean
		//-- you can paste your code in to test!

	}

}

class RationalNumber {
	
	private int numer;
	private int denom;
	
	public RationalNumber() {
		numer = 0;
		denom = 1;
	}
	
	public RationalNumber(int numer, int denom) {
		this.numer = numer;
		this.denom = denom;
		
		if (denom == 0) {
			throw new IllegalArgumentException("The denominator should not be 0");
		}
	}
	
	public RationalNumber(RationalNumber r) {
		numer = r.numer;
		denom = r.denom;
	}
	
	public void setNumerator(int numer) {
		this.numer = numer;
	}
	
	public void setDenominator(int denom) {
		this.denom = denom;
		if (denom == 0) {
			throw new IllegalArgumentException("The denominator should not be 0");
		}
	}
	
	public int getNumerator() {
		return numer;
	}
	public int getDenominator() {
		return denom;
	}
	
	
	@Override 
	public String toString() {
		
		String output = "";
		
		//-- don't care about the sign yet 
		int newNum = Math.abs(numer);
		int newDen = Math.abs(denom);
		
		// -- the whole number in mixed fraction
		int whole = (int) (newNum / newDen);
		// -- calculate the remainder
		int x = (int) ((double)newNum % newDen);

		//-- if not proper fraction
		if (newNum > newDen) {
			//-- if divisible
			if (newNum % newDen == 0) {
				output = "" + whole;
			}
			else {
				//-- if remainder and denominator can still be reduced	
				if (newDen % x == 0) {
					int temp = x;
					x = x / GCD(x, newDen);
					newDen = newDen / GCD(temp, newDen);
				}
 			}
			//-- take care of the sign (positive or negative)
			if (numer * denom < 0) {
				output = "-" + whole + " " + x + "/" + newDen;
			}
			else if (numer * denom > 0) {
				output = "" + whole + " " + x + "/" + newDen;
			
			}
		}
		//-- if equal, reduce to 1/1
		else if (newNum == newDen) {
			output = "1/1";
		}
		//-- if already proper fraction
		else if (newNum < newDen) {
			//-- take care of sign 
			if (numer * denom > 0) {
				output = newNum + "/" + newDen;
			}
			else {
				output = "-" + newNum + "/" + newDen;
			}
		}
		
		//-- output for initial value
		if (numer * denom == 0) {
			output = "0/1";
		}
		
		return output;

	}
	
	public RationalNumber add(RationalNumber rhs) {
		RationalNumber ans = new RationalNumber(0, 1);
		
		ans.numer = numer * rhs.denom + denom * rhs.numer;
		ans.denom = denom * rhs.denom;
		
		//-- reduced fraction
		ans.simplify();
		
		return ans;
	}
	
	public RationalNumber sub(RationalNumber rhs) {
		RationalNumber ans = new RationalNumber(0, 1);
		
		ans.numer = numer * rhs.denom - denom * rhs.numer;
		ans.denom = denom * rhs.denom;
		
		ans.simplify();
		
		return ans;
	}
	
	public RationalNumber mult(RationalNumber rhs) {
		RationalNumber ans = new RationalNumber(0, 1);
		
		ans.numer = numer * rhs.numer;
		ans.denom = denom * rhs.denom;
		
		ans.simplify();
		
		return ans;
	}
	
	public RationalNumber div(RationalNumber rhs) {
		RationalNumber ans = new RationalNumber(0, 1);
		
		ans.numer = numer * rhs.denom;
		ans.denom = denom * rhs.numer;
		
		if (ans.numer / ans.denom == 0) {
			throw new ArithmeticException("Something is Wrong Mathematically");
		}
		
		ans.simplify();
		
		return ans;
	}
	
	
	@Override
	public boolean equals(Object o) {
		
		RationalNumber s = ((RationalNumber) o);
		s.simplify();
		
		if (numer == s.numer && denom == s.denom) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private void simplify() {
		int temp = numer;
		
		//-- divide numer and denom by their GCD
		numer = numer / GCD(numer, denom);
		denom = denom / GCD(temp, denom);
	}
	
	private int GCD(int a, int b) {
		if (a == 0) {
			return b;
		}
		return GCD(b % a, a);
	}
	
	private int LCM(int a, int b) {
		return ((a * b) / GCD(a, b));
	}
	
}
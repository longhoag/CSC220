package recursion;

public abstract class ArrayFillAbstract {
	//-- the array to be filled
	protected int array[][];
	
	//-- counter for filling the array
	protected int current = 1;
	
	@Override
	// -- override of the toString() function
	public String toString() {
		
		String s = "";
		for (int i = 0; i < array.length; ++i) {
			for (int j = 0; j < array[i].length; ++j) {
				s += "\t" + array[i][j];
			}
			s += "\n";
		}
		return s;
	}
	
	// -- the recursive fill function
	//    the result is the array filled with
	//    consecutive values. Note that the order
	//    is dependent on how you implement your recursion
	//     7	6	5
	//     8	1	4
	//     9	2	3
	//
	//     row: the starting row for the fill
	//     col: the starting column for the fill
	public abstract void fill(int row, int col);
		
	
}

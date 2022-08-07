package recursion;

public class ArrayFill extends ArrayFillAbstract {

	//-- provide a constructor specifying size
	public ArrayFill(int h, int w) {
		array = new int[h][w];
	}
	
	//-- provide default constructor
	public ArrayFill() {
		array = new int[3][3];
	}
	
	@Override
	public void fill(int row, int col) {
		// TODO Auto-generated method stub
		
		if (row >= array.length || col >= array[0].length || row < 0 || col < 0) {
			return;
		}
		
		if (current == array.length * array[0].length + 1) {
			return;
		}
		
		if (array[row][col] != 0) {
			return;
		}
		
		array[row][col] = current;
		current++;
		
		//-- recursion travel in all 4 directions
		fill(row + 1, col);
		fill(row - 1, col);
		fill(row, col + 1);
		fill(row, col - 1);
	}

}

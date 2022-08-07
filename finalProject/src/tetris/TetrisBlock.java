package tetris;

import java.awt.Color;
import java.util.Random;

public class TetrisBlock {
	private int[][] shape;
	private Color color;
	private int x, y; 
	private int[][][] shapes;
	private int currentRotation;
	
	public TetrisBlock(int[][] shape) {
		this.shape = shape;
		this.color = color;
		
		initShapes();
		
	}
	
	private void initShapes() {
		shapes = new int[4][][];
		
		for(int i = 0; i < 4; i++) {
			int r = shape[0].length;
			int c = shape.length;	
			
			shapes[i] = new int[r][c];
			
			for(int y = 0; y < r; y++) {
				for(int x = 0; x < c; x++) {
					shapes[i][y][x] = shape[c - x - 1][y];
				}
			}
			
			shape = shapes[i];
		}
	}
	
	public void spawn(int gridWidth) {
		
		Random roll = new Random();
		
		currentRotation = roll.nextInt(shapes.length);
		shape = shapes[currentRotation];
		
		y = -getHeight();
		x = roll.nextInt(gridWidth - getWidth());
		
		color = new Color(roll.nextInt(255), roll.nextInt(255), roll.nextInt(255));
		
	}
	
	public int[][] getShape() {
		return shape;
	}
	
	public Color getColor() {
		return color;
	}
	
	public int getHeight() {
		return shape.length;
	}
	public int getWidth() {
		return shape[0].length;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int newX) {
		x = newX;
	}
	
	public void setY(int newY) {
		y = newY;
	}
	
	public void moveDown() {
		y++;
	}
	
	public void moveLeft() {
		x--;
	}
	
	public void moveRight() {
		x++;
	}
	
	public int getBottomEdge() {
		return y + getHeight();
	}
	
	public int getLeftEdge() {
		return x;
	}
	
	public int getRightEdge() {
		return x + getWidth();
	}
	
	
	public void rotate() {
		currentRotation++;
		if(currentRotation > 3) {
			currentRotation = 0;
		}
		shape = shapes[currentRotation];
		
	}
	public void counterRotate() {
		currentRotation--;
		if(currentRotation < 0) {
			currentRotation = 3;
		}
		shape = shapes[currentRotation];
	}
}

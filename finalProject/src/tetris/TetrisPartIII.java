package tetris;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

//-- extend to call easier
public class TetrisPartIII extends JFrame { 
	
	//-- Auto generated
	private static final long serialVersionUID = -4128374419991472184L;

	//-- size of window 
	private final int WIDTH = 870;
	private final int HEIGHT = 700;
	
	private int rowncol = 30;
	
	private int count = 0;
	
	private UIPanel uiPanel;
	private ControlPanel controlPanel;
	
	protected TetrisBlock block;
	
	protected Color[][] background;
	protected TetrisBlock[] blocks;

	protected TetrisBlock previousBlock;
	protected Color[][] previousBg;
	protected TetrisBlock[] previousBlocks;
	
	protected static int speed = 900;
	
	public TetrisPartIII() {
		
		//-- base of JFrame
		super();
		
		//-- set title 
		this.setTitle("Tetris");
		
		//-- initialize size of window 
		this.setSize(WIDTH, HEIGHT);
		
		//-- center the frame 
		this.setLocationRelativeTo(null);
		
		//-- shut down application when frame is closed 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//-- layout for border size 
		setLayout(new BorderLayout(5, 5));
		
		//-- construct panel for UI, and assign location
		uiPanel = new UIPanel();
		this.add(uiPanel, BorderLayout.CENTER);

		//-- construct panel for control center, and assign location
		controlPanel = new ControlPanel();
		controlPanel.setSize(getPreferredSize());
		this.add(controlPanel, BorderLayout.WEST);
		
		//-- cannot resize window 
		this.setResizable(false);
		
		//-- paint graphics
		uiPanel.repaint();
		
		//-- show frame
		this.setVisible(true);
		
		uiPanel.setFocusable(true);
		uiPanel.requestFocus();
	
		background = new Color[100][100];
		
		blocks = new TetrisBlock[] { new DashShape(), new DotShape(), new IShape(), new oTickShape(), new SquareShape(), new tickShape(), new UShape() };
		
		previousBg = new Color[100][100];
		
		previousBlocks = new TetrisBlock[] { new DashShape(), new DotShape(), new IShape(), new oTickShape(), new SquareShape(), new tickShape(), new UShape() };
		
		startGame();
	}
	
	public void startGame() {
		new GameThread(uiPanel, this, controlPanel).start();
	}
	
	public void updateScore(int score) {
		controlPanel.scoreBoard.setText("" + score);
	}
	
	
	public void spawnBlock() {
		 Random roll = new Random();
		 block = blocks[roll.nextInt(previousBlocks.length)];
		
		block.spawn(rowncol);
	}

	
	public class UIPanel extends JPanel {

		// auto generated
		private static final long serialVersionUID = 799337552754632496L;
		
		public UIPanel() {
			super();
			this.actionHandlers();
			this.requestFocus();
			this.setBackground(Color.LIGHT_GRAY);
			
		}
		
		private void actionHandlers() {
			this.addKeyListener(new KeyListener() {

				@Override
				public void keyTyped(KeyEvent e) {
				}

				@Override
				public void keyPressed(KeyEvent e) {
	            	switch (e.getKeyCode()) {
	            	case KeyEvent.VK_UP:
	            		System.out.println("UP");
	            		//-- clockwise
	            		rotate();
	            		break;
	            		
	            	case KeyEvent.VK_DOWN:
	            		System.out.println("DOWN");
	            		//-- counter
	            		counterRotate();
	            		//dropBlock();
	            		break;
	            		
	            	case KeyEvent.VK_RIGHT:
	            		System.out.println("RIGHT");
	            		moveRight();	
	            		break;
	            		
	            	case KeyEvent.VK_LEFT:
	            		System.out.println("LEFT");
	            		moveLeft();
	            		break;
	            		
	            	case KeyEvent.VK_SPACE:
	            		System.out.println("DROP");
	            		dropBlock();
	            		break;
	            		
	            	default: break;
	            	}
					
				}

				@Override
				public void keyReleased(KeyEvent e) {
	            	//System.out.println("key released: " + event.getKeyCode());
					
				}
				
			});
		}

		@Override 
		public void paintComponent(Graphics g) {

			super.paintComponent(g);
			
			int height = this.getHeight();
			int width = this.getWidth();
			
			Graphics2D graphicsContext = null;
			if (g instanceof Graphics2D) {
				graphicsContext = (Graphics2D) g;
			}
			else {
				System.out.println("You have an old JVM. Please update!");
				return;
			}
			
			drawBackground(g);
			

        	double spacing = height / (double) rowncol;
        	
        	double x0 = 0.0;
        	double y0 = 0.0;
        	graphicsContext.setColor(Color.DARK_GRAY);
        	for (int i = 0; i < rowncol; ++i) {
        		graphicsContext.drawLine(0, (int)y0, width, (int)y0);
        		y0 += spacing;	
        		
        		graphicsContext.drawLine((int)x0, 0, (int)x0, height);
        		x0 += spacing;
        	}
        	
        	if (previousBlock == null) {
        		return;
        	}
        	else {
            	int h = previousBlock.getHeight();
            	int w = previousBlock.getWidth();
            	Color c = previousBlock.getColor();
            	int[][] shape = previousBlock.getShape();
            	
            	for (int row = 0; row < h; row++) {
            		for (int col = 0; col < w; col++) {
            			if (previousBlock.getShape()[row][col] == 1) {
            				
            				int x = (int)((previousBlock.getX() + col) * spacing);
            				int y = (int)((previousBlock.getY() + row) * spacing);
            				
            				drawGridSquare(g, c, x, y);
            			}
            		}
            	}
        	}
		}		
		
		private void drawBackground(Graphics g) {
			
			Color color;
			int height = this.getHeight();
			double  spacing = (height / (double) rowncol);
			
			for (int r = 0; r < rowncol; r++) {
				for(int c = 0; c < rowncol; c++) {
					color = previousBg[r][c];
					
					if(color != null) {
						int x =(int)(c * spacing);
						int y =(int)(r * spacing);
						
						drawGridSquare(g, color, x, y);
						
					}
				}
			}
		}
		
		private void drawGridSquare(Graphics g, Color color, int x, int y) {
			
			double spacing = this.getHeight() / (double) rowncol;
			
			g.setColor(color);
			g.fillRect(x, y,(int)spacing, (int)spacing);
			
			g.setColor(Color.DARK_GRAY) ;
			g.drawRect(x, y,(int)spacing, (int)spacing);
		}

		
		public boolean isBlockOutOfBounds() {
			if(previousBlock.getY() < 0) {
				previousBlock = null;
				return true;
			}
			return false;
		}
		
		public boolean moveBlockDown() {
			
			if (checkBottom() == false) {
				return false ;
			}
			
			previousBlock.moveDown();
			uiPanel.repaint();
			
			return true;
		}
		
		protected void turnBlockToBackground() {
			
			int[][] shape = previousBlock.getShape();
			int h = previousBlock.getHeight();
			int w = previousBlock.getWidth();
			
			int xPos = previousBlock.getX();
			int yPos = previousBlock.getY();
			
			Color color = previousBlock.getColor();
			
			for(int r = 0; r < h; r++) {
				for (int c = 0; c < w; c++) {
					if (shape[r][c] == 1) {
						previousBg[r + yPos][c + xPos] = color;
						
					}
				}
			}
			
			//-- 
			previousBlock = block;
			previousBlocks = blocks;
			previousBg = background;
			
			
		}
		
		
		public int clearLine() {
			boolean lineFilled;
			int lineCleared = 0;
			
			for(int r = rowncol - 1; r >= 0; r--) {
				lineFilled = true;
				for(int c = 0; c < rowncol; c++) {
					if(previousBg[r][c] == null) {
						lineFilled = false;
						break;
					}
				}
				
				if(lineFilled) {
					
					lineCleared++;
					for(int i = 0; i < rowncol; i++) {
						previousBg[r][i] = null; 
					}
					
					shiftDown(r);
					for(int i = 0; i < rowncol; i++) {
						previousBg[0][i] = null; 
					}
					
					r++;
					repaint();
				}
			}
			
			return lineCleared;
		}
		
		
		private void shiftDown(int r) {
			for(int row = r; row > 0; row--) {
				for(int col = 0; col < rowncol; col++) {
					previousBg[row][col] = previousBg[row - 1][col];
				}
			}
		}
		
		private boolean checkBottom() {
			if (previousBlock == null) {
				return false;
			}
			if ( previousBlock.getBottomEdge() == rowncol) {
				
				return false;
			}
			
			int[][] shape = previousBlock.getShape();
			int w = previousBlock.getWidth();
			int h = previousBlock.getHeight();
			
			for(int col = 0; col < w; col++) {
				for(int row = h - 1; row >= 0; row--) {
					if(shape[row][col] != 0) {
						int x = col + previousBlock.getX();
						int y = row  + previousBlock.getY() + 1;
						if(y < 0) {
							break;
						}
						if(previousBg[y][x] != null) {
							return false;
							
						}
						break;
					}
				}
			}
			
			return true;
		}
		
		private boolean checkRight() {
			if ( previousBlock.getRightEdge() == rowncol) {
				
				return false;
			}
			
			int[][] shape = previousBlock.getShape();
			int w = previousBlock.getWidth();
			int h = previousBlock.getHeight();
			
			for(int row = 0; row < h; row++) {
				for(int col = w - 1; col >= 0; col--) {
					if(shape[row][col] != 0) {
						int x = col + previousBlock.getX() + 1;
						int y = row  + previousBlock.getY();
						if(y < 0) {
							break;
						}
						if(previousBg[y][x] != null) {
							return false;
							
						}
						break;
					}
				}
			}
			
			
			return true;
		}
		
		private boolean checkLeft() {
			if ( previousBlock.getLeftEdge() == 0) {
				
				return false;
			}

			int[][] shape = previousBlock.getShape();
			int w = previousBlock.getWidth();
			int h = previousBlock.getHeight();
			
			for(int row = 0; row < h; row++) {
				for(int col = 0; col < w; col++) {
					if(shape[row][col] != 0) {
						int x = col + previousBlock.getX() - 1;
						int y = row  + previousBlock.getY();
						if(y < 0) {
							break;
						}
						if(previousBg[y][x] != null) {
							return false;

						}
						break;
					}
				}
			}
			
			return true;
		}
		
		
		//-- keyboard func
		
		public void moveRight() {
			
			if(previousBlock == null) {
				return; 
			}
			
			if(checkRight() == false ) {
				return;
			}
			previousBlock.moveRight();
			repaint();
		}
		
		public void moveLeft() {
			if(previousBlock == null) {
				return; 
			}
			
			if( checkLeft() == false) {
				return;
			}
			previousBlock.moveLeft();
			repaint();
			
		}
		public void dropBlock() {
			if(previousBlock == null) {
				return; 
			}
			while(checkBottom()) {
				previousBlock.moveDown(); 
				repaint();
			}
		}
		
		public void rotate() {
			if(previousBlock == null) {
				return; 
			}
			previousBlock.rotate();
			
			if(previousBlock.getLeftEdge() < 0) {
				previousBlock.setX(0);
			}
			
			if(previousBlock.getRightEdge() >= rowncol) {
				previousBlock.setX(rowncol - previousBlock.getWidth());
			}
			if(previousBlock.getBottomEdge() >= rowncol) {
				previousBlock.setY(rowncol - previousBlock.getHeight());
			}
			repaint();  
		}
		
		public void counterRotate() {
			if(previousBlock == null) {
				return; 
			}
			previousBlock.counterRotate();
			
			if(previousBlock.getLeftEdge() < 0) {
				previousBlock.setX(0);
			}
			
			if(previousBlock.getRightEdge() >= rowncol) {
				previousBlock.setX(rowncol - previousBlock.getWidth());
			}
			if(previousBlock.getBottomEdge() >= rowncol) {
				previousBlock.setY(rowncol - previousBlock.getHeight());
			}
			repaint();  
		}
		
	}
	
	
	public class ControlPanel extends JPanel implements ChangeListener, ActionListener {
		
		// auto generated 
		private static final long serialVersionUID = 6766254193885992516L;
		
		//-- button
		private JButton setGridButton;
		private JButton actionButton;
		
		//--text field 
		private JTextField rowncolTextField;
		private JTextField scoreBoard;
		
		private JTextField countingField;
		
		private JSlider slider;
		private JLabel sliderLabel;
		
		//-- label 
		private JLabel rowLabel = new JLabel("Enter Number of Rows");
		private JLabel scoreLabel = new JLabel("Your Score");
		
		private smallGraphicArea smallGraphic;
		
		
		public ControlPanel() {
			
			//--button function
			functionalityHandlers();
			
			//-- layout of control center
			setLayout(new FlowLayout());
			
			//-- text field 5 characters wide
			rowncolTextField = new JTextField("1", 10);
			
			scoreBoard = new JTextField("0", 10);
			scoreBoard.setFocusable(false);
				
			//-- add item in order 
			this.add(setGridButton);
			
			this.add(rowLabel);
			this.add(rowncolTextField);
			
			this.add(scoreLabel);
			this.add(scoreBoard);
			
			//--slider put here 
			this.add(slider);
			this.add(sliderLabel);
			
			this.add(actionButton);
			
			//-- small graphic area, JPanel within JPanel 
			smallGraphic = new smallGraphicArea(120,120);
			this.add(smallGraphic);
			
			//-- int text box
			countingField = new JTextField("0", 5);
			countingField.setFocusable(false);
			this.add(countingField);
			
		}
		
		private void functionalityHandlers() {
			
			//-- construct button and event handlers 
			setGridButton = new JButton("Set Grid");
			setGridButton.addActionListener(
					new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent arg) {
							// -- do not do anything that is time consuming
							
							//-- get number from row, col text field
							String rowncolString = rowncolTextField.getText();
							
							try {
								rowncol = Integer.parseInt(rowncolString);
								
							} catch (Exception e) {
								System.out.println("Not a number");
							}
							System.out.println(rowncolString + "!");
							
							//-- set focus back to graphic panel
							uiPanel.requestFocus();
							uiPanel.repaint();
							
							startGame();
						}
						
					}
			);
			
			sliderLabel = new JLabel();
			
			//-- min, max, current value
			slider = new JSlider(0, 200, 120);
			
			slider.setValue(120);
			
			// paint the ticks and tracks
	        slider.setPaintTrack(true);
	        slider.setPaintTicks(true);
	        slider.setPaintLabels(true);
	        
	        //-- set ticks
	        slider.setMajorTickSpacing(50);
	        slider.setMinorTickSpacing(5);
	        
	        //-- track changes
	        slider.addChangeListener(this);
	       
	        sliderLabel.setText("Position of pointer is = " + slider.getValue());
	        
			actionButton = new JButton("Stop");
			actionButton.addActionListener(
					new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							count++;
							
							if (count % 2 == 0) {
	
								actionButton.setText("Stop");
								GameThread.running = true;
				
							} 
							else {
								actionButton.setText("Go");
								GameThread.running = false;

							}
							countingField.setText("" + count);
							uiPanel.requestFocus();
						}
					}
				);
		}
		//-- set the size of JPanel 
		public Dimension getPreferredSize() {
			return new Dimension(190, 190);
		}

		@Override
		public void stateChanged(ChangeEvent e) {
			// TODO Auto-generated method stub
			 sliderLabel.setText("Position of pointer is = " + slider.getValue());
			 System.out.println("Position of pointer is = " + slider.getValue());
			
			 //-- avoid 0
			 speed = (int) (slider.getValue() * 10 + 10);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}	
	}
	
	//-- small graphic area. JPanel within JPanel
	public class smallGraphicArea extends JPanel {

		//*
		private static final long serialVersionUID = 5474173258185987331L;
		
		private int height, width;
		
		public smallGraphicArea(int height, int width) {
			this.height = height;
			this.width = width;
			
			this.setLayout(new FlowLayout());
			this.setBackground(Color.CYAN);
		}
		
		//-- set size of JPanel 
		public Dimension getPreferredSize() {
			return new Dimension(this.width, this.height);
		}
		
		@Override 
		public void paint(Graphics gp) {
			super.paintComponent(gp);
			
			Graphics2D gp2d = (Graphics2D) gp;
		
		
		int height = this.getHeight();
		int width = this.getWidth();

    	double spacing = height / (double) 5;
    	
    	if (block == null) {
    		return;
    	}
    	
    	int h = block.getHeight();
    	int w = block.getWidth();
    	Color c = block.getColor();
    	int[][] shape = block.getShape();
    	
    	for (int row = 0; row < h; row++) {
    		for (int col = 0; col < w; col++) {
    			if (block.getShape()[row][col] == 1) {
    				
    				int x = (int)(( col) * spacing);
    				int y = (int)(( row) * spacing);
    				
    				uiPanel.drawGridSquare(gp, c, x, y);
    				}
    			}
    		}   	
		}
	}

	public static void main (String[] args) {
		
		new TetrisPartIII();
		System.out.println("Program is kicking off");
	}
}


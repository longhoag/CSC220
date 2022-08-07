package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

//-- extend to call easier
public class TetrisPartII extends JFrame { 
	
	//-- Auto generated
	private static final long serialVersionUID = -4128374419991472184L;

	//-- size of window 
	
	private final int WIDTH = 712;
	private final int HEIGHT = 740;
	
	private int row = 1;
	private int col = 1;
	
	private int count = 0;
	
	private UIPanel uiPanel;
	private ControlPanel controlPanel;

	private List<Point> fillCells;
	
	public TetrisPartII() {
		
		//-- base of JFrame
		super();
		
		//-- set title 
		this.setTitle("Java Basic Swing GUI Application");
		
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

		//-- cell data
		fillCells = new ArrayList<>(25);
	
	}

	
	public class UIPanel extends JPanel {

		// auto generated
		private static final long serialVersionUID = 799337552754632496L;
		
		public UIPanel() {
			super();
			this.actionHandlers();
			this.requestFocus();
			this.setBackground(Color.BLACK);
			
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
	            		break;
	            		
	            	case KeyEvent.VK_DOWN:
	            		System.out.println("DOWN");
	            		break;
	            		
	            	case KeyEvent.VK_RIGHT:
	            		System.out.println("RIGHT");
	            		break;
	            		
	            	case KeyEvent.VK_LEFT:
	            		System.out.println("LEFT");
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

		// -- this override is where all the painting should be done. 
				//    DO NOT call it directly. Consider it an event handler.
				//    Rather, call repaint() and let the
				//    event handling system decide when to call it
				//    DO NOT put graphics function calls elsewhere in the code, although
				//    legal, it's bad practice and could destroy the integrity of the display
				//    This function is used for all "permanent" painting
		@Override 
		public void paintComponent(Graphics g) {
			// -- the base class paintComponent(g) method ensures 
			//    the drawing area will be cleared properly. Do not
			//    modify any attributes of g prior to sending it to
			//    the base class
			super.paintComponent(g);
			// -- for legacy reasons the parameter comes in as type Graphics
			//    but it is really a Graphics2D object. Cast it up since the
			//    Graphics2D class is more capable
			
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
			
			int h = row;
        	double hSpacing = height / (double) row;
        	double y0 = 0.0;
        	graphicsContext.setColor(Color.RED);
        	for (int i = 0; i < h; ++i) {
        		graphicsContext.drawLine(0, (int)y0, width, (int)y0);
        		y0 += hSpacing;
        	}
        	
        	int v = col;
        	double vSpacing = width / (double) col;
        	double x0 = 0.0;
        	graphicsContext.setColor(Color.RED);
        	for (int i = 0; i < v; ++i) {
        		graphicsContext.drawLine((int)x0, 0, (int)x0, height);
        		x0 += vSpacing;
        	}

        	//-- fill cell
        	for (Point fillCell: fillCells) {
				int CellX = (int)(vSpacing + (fillCell.x * vSpacing));
				int cellY = (int) (hSpacing + (fillCell.y * hSpacing));
				
				g.setColor(Color.BLUE);
				g.fillRect(CellX, cellY, (int)vSpacing, (int)hSpacing);
			}
        	//-- clear data
        	fillCells.clear();
		}
		
	}
	
	public class ControlPanel extends JPanel implements ChangeListener, ActionListener {
		
		// auto generated 
		private static final long serialVersionUID = 6766254193885992516L;
		
		//-- button
		private JButton setGridButton;
		private JButton actionButton;
		
		//--text field 
		private JTextField rowTextField;
		private JTextField colTextField;
		
		private JTextField countingField;
		
		private JSlider slider;
		private JLabel sliderLabel;
		
		//-- label 
		private JLabel rowLabel = new JLabel("Enter Number of Rows");
		private JLabel colLabel = new JLabel("Enter Number of Columns");
		
		private smallGraphicArea smallGraphic;
		
		//-- timer 
		Timer timer;
		
		public ControlPanel() {
			
			//--button function
			functionalityHandlers();
			
			//-- layout of control center
			setLayout(new FlowLayout());
			
			//-- text field 5 characters wide
			rowTextField = new JTextField("1", 10);
			colTextField = new JTextField("1", 10);
				
			//-- add item in order 
			this.add(setGridButton);
			
			this.add(rowLabel);
			this.add(rowTextField);
			
			this.add(colLabel);
			this.add(colTextField);
			
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
			
			//-- timer
			timer = new Timer((int)(120 * 10), this);
			
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
							String rowString = rowTextField.getText();
							String colString = colTextField.getText();
							
							try {
								row = Integer.parseInt(rowString);
								col = Integer.parseInt(colString);
								
							} catch (Exception e) {
								System.out.println("Not a number");
							}
							System.out.println(rowString + ", " + colString);
							
							//-- set focus back to graphic panel
							uiPanel.requestFocus();
							uiPanel.repaint();
							
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
	        
			actionButton = new JButton("Go");
			actionButton.addActionListener(
					new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							count++;
							
							if (count % 2 == 0) {
								
								actionButton.setText("Go");
								timer.stop();
							} 
							else {
								actionButton.setText("Stop");
								timer.start();
								
					
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
			
			 //-- real time action on slider changes
			if (actionButton.getText() == "Stop") {
				timer.stop();
				timer = new Timer((int)(slider.getValue() * 10), this);
				timer.start();
			}
			else {
				timer = new Timer((int)(slider.getValue() * 10), this);
			}
		
		}
		
		//-- timer action
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			for (int i = 0; i < (row + col) * 0.5; i++) {
        		fillCells.add(new Point(random(0, col) - 1, random(0, row) - 1));
        		
        	}
			uiPanel.repaint();
			smallGraphic.repaint();
		}
		
	}
	
	private int random(int min, int max) {
		
		return (int)(Math.random()*(max - min + 1) + min);
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
			int w = this.getWidth();
			int h = this.getHeight();
			
			Graphics2D gp2d = (Graphics2D) gp;
			
			int change = random(1, 10);
			int location = random(0, 120);
			
			gp2d.setColor(new Color(random(0, 255), random(0, 255), random(0, 255)));
			gp2d.fillRect(location, location, w/change, h/change);
			
		}
	}
	
	public static void main (String[] args) {
		
		new TetrisPartII();
		System.out.println("Program is kicking off");
	}

}

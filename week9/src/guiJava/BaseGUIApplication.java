package guiJava;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

//-- extend to call easier
public class BaseGUIApplication extends JFrame { 
	
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
	
	public BaseGUIApplication() {
		
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
		
	}
	
	public class UIPanel extends JPanel {

		// auto generated
		private static final long serialVersionUID = 799337552754632496L;
		
		public UIPanel() {
			super();
			this.setBackground(Color.YELLOW);
			
		}

		// -- this override is where all the painting should be done. 
				//    DO NOT call it directly. Consider it an event handler.
				//    Rather, call repaint() and let the
				//    event handling system decide when to call it
				//    DO NOT put graphics function calls elsewhere in the code, although
				//    legal, it's bad practice and could destroy the integrity of the display
				//    This function is used for all "permanent" painting
		@Override 
		public void paint(Graphics g) {
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
        	graphicsContext.setColor(Color.BLUE);
        	for (int i = 0; i < v; ++i) {
        		graphicsContext.drawLine((int)x0, 0, (int)x0, height);
        		x0 += vSpacing;
        	}
			
		}
		
	}
	
	public class ControlPanel extends JPanel implements ChangeListener {
		
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
			this.add(new smallGraphicArea(120,120));
			
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
							String rowString = rowTextField.getText();
							String colString = colTextField.getText();
							
							try {
								row = Integer.parseInt(rowString);
								col = Integer.parseInt(colString);
;								
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
							} 
							else {
								actionButton.setText("Stop");
							}
							countingField.setText("" + count);
							
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
			int w = this.getWidth();
			int h = this.getHeight();
			
			Graphics2D gp2d = (Graphics2D) gp;
			
			gp2d.setColor(Color.GRAY);
			gp2d.fillOval(0, 0, w/2, h/2);
			
		}
		
	}
	
	
	public static void main (String[] args) {
		
		new BaseGUIApplication();
		System.out.println("Program is kicking off");
	}
}

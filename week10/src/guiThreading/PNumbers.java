package guiThreading;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PNumbers extends JFrame {

	private static final long serialVersionUID = -2576035282533850003L;
	
	//-- size of window
	private final int WIDTH = 360;
	private final int HEIGHT = 370;
	
	protected static int perfectNum = 0;
	private int primeNum = 0;
	
	private PerfectPanel perfectPanel;
	private PrimePanel primePanel;
	
	
	public PNumbers() {
		super();
		
		//-- set title
		this.setTitle("Perfect and Prime Numbers");
		
		//-- initialize window size
		this.setSize(WIDTH, HEIGHT);
		
		//-- center the frame
		this.setLocationRelativeTo(null);
		
		//-- shut application when frame is closed 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//-- layout for border size 
		setLayout(new BorderLayout(50, 50));
		
		//-- construct panel for 2 panels
		perfectPanel = new PerfectPanel();
		perfectPanel.setPreferredSize(getPreferredSize());
		this.add(perfectPanel, BorderLayout.WEST);
		
		primePanel = new PrimePanel();
		primePanel.setPreferredSize(getPreferredSize());
		this.add(primePanel, BorderLayout.EAST);
		
		//-- cannot resize window 
		this.setResizable(false);
		
		//-- show frame
		this.setVisible(true);
		
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(150, 100);
	}
	
	
	public class PerfectPanel extends JPanel {

		private static final long serialVersionUID = 5845677736758764869L;
		
		private JTextField perfectTextField;
		private JButton getPerfect;
		
		//-- scrollable field
		protected static JTextArea textArea;
		private JScrollPane scrollableTextArea;
		
		private JLabel perfect = new JLabel("    Perfect    ");
		
		public PerfectPanel() {
			//-- set up elements
			functionalityHandlers();
			
			setLayout(new FlowLayout());			
			
			this.add(perfect);
			
			// -- construct the JTextField, 5 characters wide
			perfectTextField = new JTextField("0", 5);
			
			//-- add items
			this.add(perfectTextField);
			this.add(getPerfect);

			
			textArea = new JTextArea(10, 8);
			textArea.setFocusable(false);
			scrollableTextArea = new JScrollPane(textArea);
			scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
	        scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
	        this.add(scrollableTextArea);    
	        
		}
		
		private void functionalityHandlers() {
			getPerfect = new JButton("Get");
			getPerfect.addActionListener(
				new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg) {
						// TODO Auto-generated method stub
						String perfectString = perfectTextField.getText();
						
						try {
							perfectNum = Integer.parseInt(perfectString);
							
							MultiThreading prog = new MultiThreading();
							prog.start();

						} 
						catch (Exception e) {
							System.out.println("not a number");
						}
						System.out.println(perfectTextField);
					}
					
				}
					
			);
		}
		
		
	}
	
	public class PrimePanel extends JPanel {
		
		private static final long serialVersionUID = -7092733756929450669L;
		
		private JTextField primeTextField;
		private JButton getPrime;
		private JTextArea primeArea;
		private JScrollPane scrollableTextArea;
		
		
		private JLabel prime = new JLabel("      Prime      ");
		
		public PrimePanel() {
			//-- set up elements
			primeHandlers();
			
			setLayout(new FlowLayout());	
			
			this.add(prime);
			
			// -- construct the JTextField, 5 characters wide
			primeTextField = new JTextField("0", 7);
		
			//-- add items
			this.add(primeTextField);
			this.add(getPrime);
			
			
			primeArea = new JTextArea(10, 8);
			primeArea.setFocusable(false);
			scrollableTextArea = new JScrollPane(primeArea);
			scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
	        scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
	        this.add(scrollableTextArea);    
	        
		}
		
		public void primeHandlers() {
			getPrime = new JButton("Get");
			getPrime.addActionListener(
				new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg) {
						// TODO Auto-generated method stub
						String primeString = primeTextField.getText();
						
						try {
							primeNum = Integer.parseInt(primeString);
							
							// number of 2s that divide n
							while (primeNum % 2 == 0) {
								primeArea.append("2\n");
								primeNum /= 2;
							}
							
							//-- n is odd 
							for (int i = 3; i < Math.sqrt(primeNum); i += 2) {
								//-- while i divides n, get i and divide n
								while (primeNum % i == 0 ) {
									primeArea.append(i + "\n");
									primeNum /= i;
								}
							}
							
							//-- if it is prime already and > 2
							if (primeNum > 2) {
								primeArea.append(primeNum + "\n");
							}

						} 
						catch (Exception e) {
							System.out.println("not a number");
						}
						System.out.println(primeTextField);
					}
					
				}
					
			);
		}
	}
	
	public static void main (String[] args) {
		
		new PNumbers();
		
		System.out.println("Main thread terminating");
	}
	
	
}

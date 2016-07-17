package eg.edu.alexu.csd.oop.calculator;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Color;

import javax.swing.JTextField;

import java.awt.SystemColor;

import javax.swing.JButton;

import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import java.awt.Font;

public class Gui {
	private String text ="";
	private JFrame frame;
	static private JTextField textField;
//	CalculatorDummyEngine newCalculator= new CalculatorDummyEngine();
	private CalculatorDummyEngine newCalculator= CalculatorDummyEngine.getInstance();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	 class buttonHandler implements ActionListener {					//Command pattern for all buttons 

		@Override
		public void actionPerformed(ActionEvent e) {			
			// TODO Auto-generated method stub
			String s = ((JButton) e.getSource()).getText();
			Gui.textField.setText(Gui.textField.getText()+s);
			
		}
	  }
	  private buttonHandler x =new buttonHandler ();
	
	public Gui() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBounds(100, 100, 450, 477);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		textField.setBackground(SystemColor.textHighlight);
		textField.setBounds(21, 11, 392, 99);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		 final JButton button = new JButton("0");
		button.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		button.addActionListener(x);
		button.setBounds(21, 386, 128, 41);
		frame.getContentPane().add(button);
		
		JButton btnNewButton = new JButton("1");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnNewButton.addActionListener(x);
		btnNewButton.setBounds(21, 334, 81, 41);
		frame.getContentPane().add(btnNewButton);
		
		JButton button_2 = new JButton("2");
		button_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		button_2.addActionListener(x);
		button_2.setBounds(117, 332, 83, 41);
		frame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("3");
		button_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		button_3.addActionListener(x);
		button_3.setBounds(210, 334, 72, 41);
		frame.getContentPane().add(button_3);
		
		JButton button_4 = new JButton("4");
		button_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		button_4.addActionListener(x);
		button_4.setBounds(21, 282, 81, 41);
		frame.getContentPane().add(button_4);
		
		JButton button_5 = new JButton("5");
		button_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		button_5.addActionListener(x);
		button_5.setBounds(117, 280, 81, 41);
		frame.getContentPane().add(button_5);
		
		JButton button_6 = new JButton("6");
		button_6.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		button_6.addActionListener(x);
		button_6.setBounds(210, 282, 72, 41);
		frame.getContentPane().add(button_6);
		
		JButton button_7 = new JButton("7");
		button_7.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		button_7.addActionListener(x);
		button_7.setBounds(21, 230, 81, 41);
		frame.getContentPane().add(button_7);
		
		JButton button_8 = new JButton("8");
		button_8.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		button_8.addActionListener(x);
		button_8.setBounds(117, 229, 81, 43);
		frame.getContentPane().add(button_8);
		
		JButton button_9 = new JButton("9");
		button_9.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		button_9.addActionListener(x);
		button_9.setBounds(210, 228, 72, 43);
		frame.getContentPane().add(button_9);
		
		JButton button_10 = new JButton("=");
		button_10.setBackground(new Color(255, 0, 0));
		button_10.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 27));
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(text==""){
					text+= textField.getText();
				}
				try{
					newCalculator.input(text);
				}catch(RuntimeException e){
					textField.setText("ERROR !");
				}
				
				try{
					textField.setText(text+" = "+newCalculator.getResult());
				}catch(RuntimeException e){
					textField.setText("ERROR !");
				}
				
				text="";
				
			}
		});
		button_10.setBounds(292, 386, 123, 41);
		frame.getContentPane().add(button_10);
		
		JButton button_11 = new JButton("+");
		button_11.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
		button_11.setForeground(Color.BLUE);
		button_11.setBackground(Color.CYAN);
		button_11.addActionListener(x);
		button_11.setBounds(292, 332, 57, 41);
		frame.getContentPane().add(button_11);
		
		JButton button_12 = new JButton("-");
		button_12.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 39));
		button_12.setForeground(Color.BLUE);
		button_12.setBackground(Color.CYAN);
		button_12.addActionListener(x);
		button_12.setBounds(359, 334, 57, 41);
		frame.getContentPane().add(button_12);
		
		JButton btnX = new JButton("*");
		btnX.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		btnX.setForeground(Color.BLUE);
		btnX.setBackground(Color.CYAN);
		btnX.addActionListener(x);
		btnX.setBounds(292, 281, 57, 41);
		frame.getContentPane().add(btnX);
		
		
		JButton button_14 = new JButton("/");
		button_14.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
		button_14.setForeground(Color.BLUE);
		button_14.setBackground(Color.CYAN);
		button_14.addActionListener(x);
		button_14.setBounds(359, 280, 57, 41);
		frame.getContentPane().add(button_14);
		
		JButton button_15 = new JButton("(");
		button_15.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		button_15.setForeground(Color.BLUE);
		button_15.setBackground(Color.CYAN);
		button_15.addActionListener(x);
		button_15.setBounds(292, 175, 57, 45);
		frame.getContentPane().add(button_15);
		
		JButton button_16 = new JButton(")");
		button_16.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		button_16.setForeground(Color.BLUE);
		button_16.setBackground(Color.CYAN);
		button_16.addActionListener(x);
		button_16.setBounds(363, 175, 57, 45);
		frame.getContentPane().add(button_16);
		
		JButton btnAc = new JButton("AC");
		btnAc.setBackground(Color.RED);
		btnAc.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnAc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				text="";
				textField.setText("");
			}
		});
		btnAc.setBounds(168, 386, 114, 41);
		frame.getContentPane().add(btnAc);
		
		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		btnSave.setForeground(Color.BLUE);
		btnSave.setBackground(Color.YELLOW);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				newCalculator.save();
				textField.setText("SAVED");
				text="";
			}
		});
		btnSave.setBounds(21, 177, 114, 42);
		frame.getContentPane().add(btnSave);
		
		JButton btnLoad = new JButton("Load");
		btnLoad.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		btnLoad.setForeground(Color.BLUE);
		btnLoad.setBackground(Color.YELLOW);
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					newCalculator.load();
					textField.setText("Loaded Sucsessfully !");
				}catch(RuntimeException e){
					text="";
					textField.setText("ERROR !");
				}
			}
		});
		btnLoad.setBounds(168, 176, 114, 42);
		frame.getContentPane().add(btnLoad);
		
		JButton btnNext = new JButton("Next");
		btnNext.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		btnNext.setForeground(Color.BLUE);
		btnNext.setBackground(Color.YELLOW);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				text=newCalculator.next();
				if(text==null){
					textField.setText("ERROR !");
				}else{
					textField.setText(text);
				}
			}
		});
		btnNext.setBounds(306, 121, 114, 43);
		frame.getContentPane().add(btnNext);
		
		JButton btnPrev = new JButton("Prev");
		btnPrev.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		btnPrev.setForeground(Color.BLUE);
		btnPrev.setBackground(Color.YELLOW);
		btnPrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				text=newCalculator.prev();
				if(text==null){
					textField.setText("ERROR !");
				}else{
					textField.setText(text);
				}
			
				
			}
		});
		btnPrev.setBounds(21, 123, 114, 43);
		frame.getContentPane().add(btnPrev);
		
		JButton btnCurrent = new JButton("Current");
		btnCurrent.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		btnCurrent.setForeground(Color.BLUE);
		btnCurrent.setBackground(Color.YELLOW);
		btnCurrent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					text=newCalculator.current();
					textField.setText(text);
				}catch(RuntimeException e){
					textField.setText("ERROR");
				}
			}
		});
		btnCurrent.setBounds(168, 124, 114, 41);
		frame.getContentPane().add(btnCurrent);
		
		JButton button_17 = new JButton("%");
		button_17.addActionListener(x);
		button_17.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 19));
		button_17.setForeground(Color.BLUE);
		button_17.setBackground(Color.CYAN);
		button_17.setBounds(292, 230, 57, 41);
		frame.getContentPane().add(button_17);
		
		JButton button_18 = new JButton("^");
		button_18.addActionListener(x);
		button_18.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
		button_18.setForeground(Color.BLUE);
		button_18.setBackground(Color.CYAN);
		button_18.setBounds(359, 228, 61, 41);
		frame.getContentPane().add(button_18);
	}
	
}

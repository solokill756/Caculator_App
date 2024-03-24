
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;
import java.util.concurrent.ForkJoinPool.ManagedBlocker;

import javax.management.loading.PrivateClassLoader;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

public class Caculator extends JFrame {
	public Caculator() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // cho chọn nút X để thoát
		this.setSize(500 , 500); // đặt chiều dài và chiều rộng cho trang
		this.setLayout(new BorderLayout());
		Stack<String> stack = new Stack<String>();
		JTextField jTextField = new JTextField();
	     jTextField.setEditable(false);
	     jTextField.setHorizontalAlignment(JTextField.RIGHT);
	     jTextField.setFont(new Font("Times new Roman" , Font.PLAIN , 80));
	 	this.getContentPane().add(BorderLayout.NORTH , jTextField);
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(5 , 4));
		JButton ceButton = new JButton("CE");
		ceButton.setContentAreaFilled(false);
		ceButton.setFocusPainted(false);
		ceButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jTextField.setText("");
			}
		});
		mainPanel.add(ceButton);
		JButton cButton = new JButton("C");
		cButton.setFocusPainted(false);
		cButton.setContentAreaFilled(false);
		cButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jTextField.setText("");
				stack.clear();
				
			}
		});
		mainPanel.add(cButton);
		JButton bButton = new JButton("Back");
		bButton.setContentAreaFilled(false);
		bButton.setFocusPainted(false);
		bButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String textString = jTextField.getText();
				String resultString = "";
				if(textString.length() > 1) resultString = textString.substring(0, textString.length() - 2);
				jTextField.setText(resultString);
			}
		});
		mainPanel.add(bButton);
		JButton chiaButton = new JButton("/");
		chiaButton.setContentAreaFilled(false);
		chiaButton.setFocusPainted(false);
		chiaButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				chiaButton.setBackground(Color.BLUE);
				String textString = jTextField.getText();
				while(textString.compareTo("") == 0 &&  stack.size() > 0 && (stack.getLast().compareTo("+") == 0 || stack.getLast().compareTo("-") == 0 || stack.getLast().compareTo("X") == 0 || stack.getLast().compareTo("/") == 0)) {
					stack.pop();
				}
				if(!(textString.compareTo("") == 0)) {
					stack.add(textString);
				} else {
					stack.add("/");
					return;
				}
				jTextField.setText("");
				if(stack.getLast().compareTo("/") != 0) {
					stack.add("/");
				}
			}
		});
		mainPanel.add(chiaButton);
		JButton bayButton = new JButton("7");
		bayButton.setFocusPainted(false);
		bayButton.setContentAreaFilled(false);
		bayButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String textString = jTextField.getText();
				textString = textString + "7";
				jTextField.setText(textString);
			}
		});
		mainPanel.add(bayButton);
		JButton tamButton = new JButton("8");
		tamButton.setFocusPainted(false);
		tamButton.setContentAreaFilled(false);
		tamButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String textString = jTextField.getText();
				textString = textString +("8");
				jTextField.setText(textString);
			}
		});
		mainPanel.add(tamButton);
		JButton chinButton = new JButton("9");
		tamButton.setFocusPainted(false);
		chinButton.setContentAreaFilled(false);
		chinButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String textString = jTextField.getText();
				textString = textString +("9");
				jTextField.setText(textString);
			}
		});
		mainPanel.add(chinButton);
		JButton nhanButton = new JButton("X");
		nhanButton.setFocusPainted(false);
		nhanButton.setContentAreaFilled(false);
		nhanButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				nhanButton.setBackground(Color.BLUE);
				String textString = jTextField.getText();
				while(textString.compareTo("") == 0 &&  stack.size() > 0 && (stack.getLast().compareTo("+") == 0 || stack.getLast().compareTo("-") == 0 || stack.getLast().compareTo("X") == 0 || stack.getLast().compareTo("/") == 0)) {
					stack.pop();
				}
				if(!(textString.compareTo("") == 0)) {
					stack.add(textString);
				} else {
					stack.add("X");
					return;
				}
				jTextField.setText("");
				if(stack.getLast().compareTo("X") != 0) {
					stack.add("X");
				}
			}
		});
		mainPanel.add(nhanButton);
		JButton bonButton = new JButton("4");
		bonButton.setFocusPainted(false);
		bonButton.setContentAreaFilled(false);
		bonButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String textString = jTextField.getText();
				textString = textString +("4");
				jTextField.setText(textString);
			}
		});
		mainPanel.add(bonButton);
		JButton namButton = new JButton("5");
		namButton.setFocusPainted(false);
		namButton.setContentAreaFilled(false);
		namButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String textString = jTextField.getText();
				textString = textString +("5");
				jTextField.setText(textString);
			}
		});
		mainPanel.add(namButton);
		JButton sauButton = new JButton("6");
		sauButton.setFocusPainted(false);
		sauButton.setContentAreaFilled(false);
		sauButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String textString = jTextField.getText();
				textString = textString +"6";
				jTextField.setText(textString);
			}
		});
		mainPanel.add(sauButton);
		JButton truButton = new JButton("-");
		truButton.setFocusPainted(false);
		truButton.setContentAreaFilled(false);
		truButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				truButton.setBackground(Color.BLUE);
					String textString = jTextField.getText();
					while(textString.compareTo("") == 0 &&  stack.size() > 0 && (stack.getLast().compareTo("+") == 0 || stack.getLast().compareTo("-") == 0 || stack.getLast().compareTo("X") == 0 || stack.getLast().compareTo("/") == 0)) {
						stack.pop();
					}
					if(!(textString.compareTo("") == 0)) {
						stack.add(textString);
					} else {
						stack.add("-");
						return;
					}
					while(stack.indexOf("X") != -1 || stack.indexOf("/") != -1) {
						if(stack.size() >= 3) {
							String number1 = stack.getLast();
							stack.pop();
							String phepTinh = stack.getLast();
							stack.pop();
							String number2 = stack.getLast();
							stack.pop();
							if(phepTinh.equals("/")) {
								String sumString = String.valueOf(Double.parseDouble(number1) / Double.parseDouble(number2));
								 stack.add(sumString);
							}
							else if(phepTinh.equals("X")) {
								String sumString = String.valueOf(Double.parseDouble(number1) * Double.parseDouble(number2));
								stack.add(sumString);
							}
						}
					}
					jTextField.setText("");
					if(stack.getLast().compareTo("-") != 0) {
						stack.add("-");
					}
			  }
		});
		mainPanel.add(truButton);
		JButton motButton = new JButton("1");
		motButton.setFocusPainted(false);
		motButton.setContentAreaFilled(false);
		motButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String textString = jTextField.getText();
				textString = textString + "1";
				jTextField.setText(textString);
			}
		});
		mainPanel.add(motButton);
		JButton haiButton = new JButton("2");
		haiButton.setContentAreaFilled(false);
		haiButton.setFocusPainted(false);
		haiButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String textString = jTextField.getText();
				textString = textString +"2";
				jTextField.setText(textString);
			}
		});
		mainPanel.add(haiButton);
		JButton baButton = new JButton("3");
		baButton.setFocusPainted(false);
		baButton.setContentAreaFilled(false);
		baButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String textString = jTextField.getText();
				textString = textString +"3";
				jTextField.setText(textString);
			}
		});
		mainPanel.add(baButton);
		JButton congButton = new JButton("+");
		congButton.setFocusPainted(false);
		congButton.setContentAreaFilled(false);
		congButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				congButton.setBackground(Color.RED);
				String textString = jTextField.getText();
					while(textString.compareTo("") == 0 &&  stack.size() > 0 && (stack.getLast().compareTo("+") == 0 || stack.getLast().compareTo("-") == 0 || stack.getLast().compareTo("X") == 0 || stack.getLast().compareTo("/") == 0)) {
						stack.pop();
					}
					if(!(textString.compareTo("") == 0)) {
						stack.add(textString);
					} else {
						stack.add("+");
						return;
					}
					while(stack.indexOf("X") != -1 || stack.indexOf("/") != -1) {
					if(stack.size() >= 3) {
						String number1 = stack.getLast();
						stack.pop();
						String phepTinh = stack.getLast();
						stack.pop();
						String number2 = stack.getLast();
						stack.pop();
						if(phepTinh.equals("/")) {
							String sumString = String.valueOf(Double.parseDouble(number1) / Double.parseDouble(number2));
							 stack.add(sumString);
						}
						else if(phepTinh.equals("X")) {
							String sumString = String.valueOf(Double.parseDouble(number1) * Double.parseDouble(number2));
							stack.add(sumString);
						}
					}
				}
					if(stack.getLast().compareTo("+") != 0) {
						stack.add("+");
					}
				jTextField.setText("");
			}
		});
		mainPanel.add(congButton);
		JButton doidauButton = new JButton("-/+");
		doidauButton.setFocusPainted(false);
		doidauButton.setContentAreaFilled(false);
		doidauButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String textString = jTextField.getText();
				try {
					double number = Double.parseDouble(textString);
					 number *= -1;
					String resultString = String.valueOf(number);
					jTextField.setText(resultString);
				} catch (Exception e1) {
					jTextField.setText("");
				}
			}
		});
		mainPanel.add(doidauButton);
		JButton khongButton = new JButton("0");
		khongButton.setFocusPainted(false);
		khongButton.setContentAreaFilled(false);
		khongButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String textString = jTextField.getText();
				textString = textString + "0";
				jTextField.setText(textString);
			}
		});
		mainPanel.add(khongButton);
		JButton chamButton = new JButton(".");
		chamButton.setFocusPainted(false);
		chamButton.setContentAreaFilled(false);
		chamButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String textString = jTextField.getText();
				if(textString.indexOf(".") == -1 && textString.length() > 0) {
					textString = textString + ".";
				}
				jTextField.setText(textString);
			}
		});
		mainPanel.add(chamButton);
		JButton bangButton = new JButton("=");
		bangButton.setFocusPainted(false);
//		bangButton.setContentAreaFilled(false);
		Color lightBlue = new Color(173, 216, 230); // RGB: (173, 216, 230)
		bangButton.setBackground(lightBlue);
		bangButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String textString = jTextField.getText();
					if(textString != "") {
						stack.add(textString);
					}
					double ans = 0;
					if(stack.size() >= 3) {
						while(stack.size() >= 3) {
							double number1 =  Double.parseDouble(stack.getLast());
							stack.pop();
							String phepTinh = stack.getLast();
							stack.pop();
							double number2 = Double.parseDouble(stack.getLast());
							stack.pop();
							if(phepTinh.equals("+")) {
								stack.add(String.valueOf(number1 + number2));
							}
							else if(phepTinh.equals("-")) {
								stack.add(String.valueOf(number2 - number1));
							}
							else if(phepTinh.equals("/")) {
								stack.add(String.valueOf(number2 / number1));
							}
							else if(phepTinh.equals("X")) {
								stack.add(String.valueOf(number1 * number2));
							}
						}
					}
					if(stack.size() > 0) {
						ans = ans + Double.parseDouble(stack.getLast());
						stack.pop();
					}
					jTextField.setText(String.valueOf(ans));
				}
				catch (Exception e1) {
					stack.clear();
					jTextField.setText("Error!");
				}
			}
		});
		mainPanel.add(bangButton);
		
		this.getContentPane().add(BorderLayout.CENTER , mainPanel);
		
		this.setVisible(true); 
	}
	public static void main(String[] args) {
		new Caculator();
	}
}

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class Main {
	
	public static void main(String args[]) {
		/*ButtonLayout buttonLayout = new ButtonLayout();
		buttonLayout.makeButton();*/
		Calculator calculator = new Calculator();
		calculator.setText();
		calculator.makeButtons();
	}
}

class Calculator extends JFrame implements ActionListener {
	
	JPanel panel = new JPanel();
	JPanel textPanel = new JPanel();
	JPanel buttonPanel = new JPanel();
	JLabel label = new JLabel("");
	JButton[] button = new JButton[20];
	
	boolean operatorOverlap = true;
	String result = "";
//	int operator = 0;
	String operator = "";
	int a = 0, b = 0, start = 0, num = 0;
	String[] btn = {"AC", "%", "/", "←",
					"7", "8", "9", "*",
					"4", "5", "6", "-",
					"1", "2", "3", "+",
					"0", ".", "( )", "="};
	
	public Calculator() {
		textPanel.setLayout(null);
		textPanel.setSize(400, 150);
		textPanel.setBackground(Color.DARK_GRAY);
		buttonPanel.setLayout(new GridLayout(5, 4, 1, 1));
		buttonPanel.setBackground(Color.DARK_GRAY);
		buttonPanel.setSize(400, 500);
		buttonPanel.setBounds(0, 150, 400, 500);
		panel.setBackground(Color.DARK_GRAY);
		panel.setLayout(null);
		panel.add(textPanel);
		panel.add(buttonPanel);
		panel.setSize(400, 650);
		add(panel);
		setSize(415, 688);
		setTitle("Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void setText() {
		label.setText(result);
		label.setBounds(-15, 0, 400, 250);
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(JLabel.SOUTH_EAST);
		textPanel.add(label);
	}
	
	public void makeButtons() {
		for (int i=0; i<button.length; i++) {
			button[i] = new JButton(btn[i]);
			button[i].setForeground(Color.WHITE);
			button[i].setBackground(Color.getColor("#00ffffff"));
			button[i].addActionListener(this);
			buttonPanel.add(button[i]);
		}
	}
	
	public void clear() {
		operator = "";
		a = 0;
		b = 0;
		operatorOverlap = true;
		result = "";
		label.setText(result);
	}
	
	public void operator(String val) {
		if (!operatorOverlap) {
			if (!operator.equals("")) {
				b = Integer.valueOf(result);
				switch (operator) {
				case "+": 
					a += b;
					break;
				case "-":
					a -= b;
					break;
				case "*":
					a *= b;
					break;
				case "/":
					a /= b;
					break;
				case "%":
					a %= b;
					break;
				}
			}
			operator = val;
			if (a == 0) {
				a = Integer.valueOf(result);
			}
			if (operator == "=") {
				result = "= " + a;
				label.setText(result);
				a = 0;
				b = 0;
			} else {
				result = a + "";
				label.setText(result);
				result = "";
			}
		}
		operatorOverlap = true;
	}
	
	public void change(String val) {
		if (operator == "=") {
			operator = "";
			result = "";
		}
		result = result + val;
		label.setText(result);
		if (operatorOverlap) {
			operatorOverlap = !operatorOverlap;
		}
	}
	
	public void delete() {
		if (result.length() > 0) {
			result = result.substring(0, result.length()-1);
			label.setText(result);
		}
	}
	
	public void result() {
		/*if ((result.charAt(0) >= '0' && result.charAt(0) <= '9') && (result.charAt(result.length()-1) >= '0' && result.charAt(result.length()-1) <= '9')) {
			if (start != 0) { 
				start = 0;
				operator = 0;
			}
			for (int i=0; i<result.length(); i++) {
				if ('9' < result.charAt(i)) {
					if (operator == 0) {
						operator = i;
					}
					else {
						if (a == 0)
							a = Integer.valueOf(result.substring(start, operator));
						System.out.println(a);
						start = operator + 1;
						b = Integer.valueOf(result.substring(start, i));
						switch (result.charAt(operator)) {
						case '+':
							a = a+b;
							break;
						case '-':
							a = a-b;
							break;
						case '*':
							a = a*b;
							break;
						case '/':
							a = a/b;
							break;
						case '%':
							a = a%b;
							break;
						}
						operator = i;
					}
				}
				else if (i == result.length()-1) {
					start = operator + 1;
					System.out.println(a);
					b = Integer.valueOf(result.substring(start+1, i+1));
					System.out.println(result.charAt(operator+1));
					switch (result.charAt(operator+1)) {
					case '+':
						a = a+b;
						break;
					case '-':
						a = a-b;
						break;
					case '*':
						a = a*b;
						break;
					case '/':
						a = a/b;
						break;
					case '%':
						a = a%b;
						break;
					}
					result = String.valueOf(a);
					label.setText(result);
				}
			}
		}*/
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton b = (JButton) e.getSource();
		switch (b.getText().toString()) {
		case "1":
			change("1");
			break;
		case "2":
			change("2");
			break;
		case "3":
			change("3");
			break;
		case "4":
			change("4");
			break;
		case "5":
			change("5");
			break;
		case "6":
			change("6");
			break;
		case "7":
			change("7");
			break;
		case "8":
			change("8");
			break;
		case "9":
			change("9");
			break;
		case "+":
//			change("+");
			operator("+");
			break;
		case "-":
//			change("-");
			operator("-");
			break;
		case "*":
//			change("*");
			operator("*");
			break;
		case "/":
//			change("/");
			operator("/");
			break;
		case "=":
//			result();
			operator("=");
			break;
		case "←":
			delete();
			break;
		case "AC":
			clear();
			break;
		case "( )":
//			change("(");
			break;
		case ".":
//			change(".");
			break;
		case "%":
//			change("%");
			operator("%");
			break;
		}
	}
	
}

class ButtonLayout extends JFrame {
	
	JPanel panel = new JPanel();
	
	public ButtonLayout() {
		setSize(300, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("주린이 바보");
		setVisible(true);
		panel.setLayout(null);
		add(panel);
	}
	
	public void makeButton() {
		JButton btnPlus = new JButton("+");
		btnPlus.setSize(50, 50);
		panel.add(btnPlus);
	}
	
}
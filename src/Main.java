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
	
	String result = "";
	int operator = (Integer) null;
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
		result = "";
		label.setText(result);
	}
	
	public void change(String val) {
		result = result + val;
		label.setText(result);
	}
	
	public void delete() {
		if (result.length() > 0) {
			result = result.substring(0, result.length()-1);
			label.setText(result);
		}
	}
	
	public void result() {
		if (start != 0) 
			start = 0;
		for (int i=0; i<result.length(); i++) {
			if ('9' < result.charAt(i)) {
				if (operator == (Integer)null) {
					operator = i;
				}
				else {
					a = Integer.valueOf(result.substring(start, operator));
					start = operator + 1;
					b = Integer.valueOf(result.substring(start, i));
					switch (result.charAt(operator)) {
					case '+':
						num = a+b;
						break;
					case '-':
						num = a-b;
						break;
					case '*':
						num = a*b;
						break;
					case '/':
						num = a/b;
						break;
					case '%':
						num = a%b;
						break;
					}
					operator = i;
					
				}
			}
		}
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
			change("+");
			break;
		case "-":
			change("-");
			break;
		case "*":
			change("*");
			break;
		case "/":
			change("/");
			break;
		case "=":
			result();
			break;
		case "←":
			delete();
			break;
		case "AC":
			clear();
			break;
		case "( )":
			change("(");
			break;
		case ".":
			change(".");
			break;
		case "%":
			change("%");
			break;
		}
	}
	
}

class ButtonLayout extends JFrame {
	
	JPanel panel = new JPanel();
	
	public ButtonLayout() {
		setSize(300, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("룰루랄라");
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
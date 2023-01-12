package Guipackage;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorEx2 extends JFrame {

	String numStr = "";

	public CalculatorEx2() {
		setTitle("계산기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		c.add(panel1, BorderLayout.NORTH);
		c.add(panel2, BorderLayout.SOUTH);
		c.add(panel3);
		panel1.setLayout(new FlowLayout());
		panel1.add(new JLabel("수식입력 :"));
		JTextField inPuttext = new JTextField(10);
		panel1.add(inPuttext);
		panel2.setLayout(new FlowLayout());
		panel2.add(new JLabel("계산결과 :"));
		JTextField outPuttext = new JTextField(10);
		panel2.add(outPuttext);
		panel3.setLayout(new GridLayout(4, 4));
		for (int i = 0; i < 16; i++) {
			JButton b = new JButton();
			b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					JButton jb = (JButton) e.getSource();
					String str = jb.getText();
					if (str.equals("계산")) {
						StringTokenizer st = new StringTokenizer(numStr, "+-*/", true);
						int i = 0;
						int num = 0;
						int num1 = Integer.parseInt(st.nextToken());
						String kind = st.nextToken();
						int num2 = Integer.parseInt(st.nextToken());
						if (kind.equals("+")) {
							outPuttext.setText(num1 + num2 + "");
						} else if (kind.equals("-")) {
							outPuttext.setText(num1 - num2 + "");
						} else if (kind.equals("/")) {
							outPuttext.setText(num1 / num2 + "");
						} else if (kind.equals("*")) {
							outPuttext.setText(num1 * num2 + "");
						}
						numStr = "";
						inPuttext.setText("");
					}else if(str.equals("CE")) {
						numStr = "";
						inPuttext.setText("");
					}
					else {
						numStr += str;
						inPuttext.setText(numStr);
					}
				}
			});

			String str[] = { "CE", "계산", "+", "-", "*", "%" };
			panel3.add(b);
			if (i < 10) {
				b.setText(i + "");
			} else {
				b.setText(str[i - 10]);
			}
		}

		setSize(500, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new CalculatorEx2();

	}

}

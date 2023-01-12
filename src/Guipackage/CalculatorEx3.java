package Guipackage;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorEx3 extends JFrame {

	String numStr = "";

	public CalculatorEx3() {
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
						int sum = 0;
						int sum1 = 1;
						int sumx = 0;
						int sumy = 0;
						StringTokenizer st = new StringTokenizer(numStr, "+-*/", true);
						ArrayList<String> array = new ArrayList<>();
						while (st.hasMoreTokens()) {
							array.add(st.nextToken());
						}
						for (int i = 0; i < array.size(); i++) {

							if (i % 2 == 1 && array.get(i).equals("*")) {
								
//								sum1 *= Integer.parseInt(array.get(i - 1));
								sum1 = sum1*Integer.parseInt(array.get(i + 1));
							}
							
							else if(i % 2 == 1 && array.get(i).equals("/")) {
//								sum1 /= Integer.parseInt(array.get(i - 1));
								sum1 = sum1/Integer.parseInt(array.get(i + 1));
							}
							else {
								
							}

//							if(i % 2 == 1 && array.get(i).equals("+")) {
//								sum += Integer.parseInt(array.get(i-1)) + Integer.parseInt(array.get(i+1));
//							}else if(i % 2 == 1 && array.get(i).equals("-")) {								
//								sum1 -= Integer.parseInt(array.get(i-1));
//							}
						}
						outPuttext.setText((sum1 + sum) + "");

						numStr = "";
						inPuttext.setText("");
					} else if (str.equals("CE")) {
						numStr = "";
						outPuttext.setText("");
					} else {
						numStr += str;
						inPuttext.setText(numStr);
					}
				}
			});

			String str[] = { "CE", "계산", "+", "-", "*", "/" };
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
		new CalculatorEx3();

	}

}

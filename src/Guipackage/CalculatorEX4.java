package Guipackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorEX4 extends JFrame implements ActionListener {
	String[] str = { "CE", "계산", "+", "-", "*", "/" };
	JTextField text = null;
	JTextField text2 = null;
	String numStr = "";

	public CalculatorEX4() {
		setTitle("계산기 프레임");
		setSize(300, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container c = getContentPane();
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();

		panel1.setBackground(Color.LIGHT_GRAY);
		panel2.setBackground(Color.LIGHT_GRAY);
		panel3.setLayout(new GridLayout(4, 4, 2, 2));
		c.add(panel1, BorderLayout.NORTH);
		c.add(panel2, BorderLayout.SOUTH);
		c.add(panel3);

		panel1.add(new JLabel("수식입력 : "));
		text = new JTextField(10);
		panel1.add(text);

		panel2.add(new JLabel("계산결과 : "));
		text2 = new JTextField(10);
		panel2.add(text2);

		for (int i = 0; i < 16; i++) {
			JButton b = new JButton();
			b.addActionListener(this);
			panel3.add(b);
			if (i < 10) {
				b.setText(i + "");
			} else {
				b.setText(str[i - 10]);
			}
		}
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CalculatorEX4();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton jb = (JButton) e.getSource();
		String str = jb.getText();

		if (str.equals("계산")) {
			StringTokenizer st = new StringTokenizer(numStr, "+-*/", true);
			ArrayList<Integer> array = new ArrayList<Integer>();
			ArrayList<String> kindArray = new ArrayList<String>();
			int count = 1;
			while (st.hasMoreTokens()) {
				if (count % 2 == 1) {
					array.add(Integer.parseInt(st.nextToken()));
				} else {
					kindArray.add(st.nextToken());
				}
				count++;
			}

			for (int i = 0; i < kindArray.size(); i++) {
				if (kindArray.get(i).equals("*") || kindArray.get(i).equals("/")) {
					int temp = 0;
					if (kindArray.get(i).equals("*"))
						temp = array.get(i) * array.get(i + 1);
					else
						temp = array.get(i) / array.get(i + 1);

					kindArray.remove(i);
					array.remove(i + 1);
					array.remove(i);
					array.add(i, temp);
					i--;
				}
			}
//			System.out.println(array);
//			System.out.println(kindArray);
			int v = array.get(0);
			for (int i = 0; i < kindArray.size(); i++) {
				if (kindArray.get(i).equals("+")) {
					v += array.get(i + 1);
				} else if (kindArray.get(i).equals("-")) {
					v -= array.get(i + 1);
				}
			}
			text2.setText(v + "");

		} else if (str.equals("CE")) {
			numStr = "";
			text.setText("");
			text2.setText("");
		} else {
			numStr += str;
			text.setText(numStr);
		}

	}

}
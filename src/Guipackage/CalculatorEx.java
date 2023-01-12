package Guipackage;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//class MyAction implements ActionListener {
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//		JButton jb = (JButton) e.getSource();
//		CalculatorEx.text1.setText(jb.getText());
//	}
//
//}

public class CalculatorEx extends JFrame implements ActionListener {
	static JTextField text1 = null;

	public CalculatorEx() {
		setTitle("계산기프레임");
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
		JTextField text = new JTextField(10);
		panel1.add(text);

		panel2.setLayout(new FlowLayout());
		panel2.add(new JLabel("계산결과 :"));
		 text1 = new JTextField(10);
		panel2.add(text1);

		panel3.setLayout(new GridLayout(4, 4));
//		String array [] = {"0","1","2","3","4","5","6","7","8","9","CE","계산","+","-","x","%"};
//		for(int i  = 0; i <16 ; i++) {
//			JButton b =new JButton(array[i]);
//			panel3.add(b);
//		}
//		
		for (int i = 0; i < 16; i++) {
			JButton b = new JButton();
//			b.addActionListener(new ActionListener() {                     //무명클래스
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					// TODO Auto-generated method stub
//					JButton jb = (JButton) e.getSource();
//					text.setText(jb.getText());
//				}
//
//			});
//			b.addActionListener(new MyAction());
//			text1.setText(b.getText());
			b.addActionListener(this);
			String str[] = { "CE", "계산", "+", "-", "x", "%" };
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
		new CalculatorEx();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton jb = (JButton) e.getSource();
		text1.setText(jb.getText());
	}
}

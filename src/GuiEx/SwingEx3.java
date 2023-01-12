package GuiEx;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SwingEx3 extends JFrame {

	public SwingEx3() {

		Container c = getContentPane();
		
		JPanel jp4 =new JPanel();
		jp4.setLayout(new GridLayout(2,1));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel jp1 = new JPanel();
		jp1.setLayout(new FlowLayout(FlowLayout.CENTER, 90, 2));
		jp1.add(new JLabel("Type ID:"));
		jp1.add(new JTextField(10));
		jp1.setBackground(Color.yellow);
		jp4.add(jp1);
		
		JPanel jp2 = new JPanel();
		jp2.setLayout(new FlowLayout(FlowLayout.CENTER, 90, 2));
		jp2.add(new JLabel("체크박스 :"));
		jp2.add(new JCheckBox("C#"));
		jp2.add(new JCheckBox("C++"));
		jp2.setBackground(Color.green);
		jp4.add(jp2);
	
		c.add(jp4,BorderLayout.NORTH);

		JPanel jp3 = new JPanel();
		jp3.setBackground(Color.CYAN);
		JButton jb = new JButton("JButton");
		jp3.add(jb);
		c.add(jp3, BorderLayout.CENTER);
		setSize(500, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new SwingEx3();
	}
}

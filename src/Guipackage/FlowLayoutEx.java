package Guipackage;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FlowLayoutEx extends JFrame {

	public FlowLayoutEx() {
		setTitle("FlowLayout Sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		
		c.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		c.add(new JButton("add"));
		c.add(new JButton("sub"));
		c.add(new JButton("mul"));
		c.add(new JButton("dlv"));
		c.add(new JButton("Calculate"));
		c.setSize(10, 700);
		
		setSize(300,200);
		setVisible(true);
		
	}
	public static void main (String[] args) {
		new FlowLayoutEx();
	}
}

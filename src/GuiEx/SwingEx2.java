package GuiEx;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SwingEx2 extends JFrame {
	public SwingEx2() {
		setTitle("test");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setBackground(Color.gray);
//		setResizable(false);
		
		Panel1 p1 = new Panel1();
		Panel2 p2 = new Panel2();
		
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(1,2, 10, 10));
		p.add(p1);
		p.add(p2);
		
//		c.add(p1);
		
		c.add(p);
		
		JButton btn = new JButton("OK");
		JPanel pSouth = new JPanel();
		pSouth.add(btn);
		c.add(pSouth, BorderLayout.SOUTH);
		
		setSize(350, 250);
		setVisible(true);
	}
	
	private class Panel1 extends JPanel {
		Panel1() {
			setBackground(Color.YELLOW);
			add(new JLabel("아이디"));
			add(new JTextField(15));
			add(new JLabel("비밀번호"));
			add(new JTextField(15));		
			
//			setLayout(new GridLayout(4,1));
		}
	}
	
	private class Panel2 extends JPanel {
		Panel2() {
			setBackground(Color.CYAN);
			add(new JLabel("       클릭       "));
			add(new JCheckBox("C# 체크박스"));
			add(new JCheckBox("C++ 체크박스"));			
		}
	}
	
	public static void main(String[] args) {
		new SwingEx2();
	}
}

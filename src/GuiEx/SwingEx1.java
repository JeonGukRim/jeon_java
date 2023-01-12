package GuiEx;

import javax.swing.*;
import java.awt.*;

public class SwingEx1 extends JFrame {
	public SwingEx1() {
		setTitle("test");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		setResizable(false); //컨테이너 사이즈 조정못하게함
		
		Panel1 p1 = new Panel1();
		p1.setSize(150,150);
		p1.setLocation(10,10);
		c.add(p1);
		Panel2 p2 = new Panel2();
		p2.setSize(150,150);
		p2.setLocation(170,10);
		c.add(p2);
		
		JButton btn = new JButton("OK");
		btn.setLocation(130, 170);
		btn.setSize(70, 30);
		c.add(btn);
		
		setSize(350, 250);
		setVisible(true);
	}
	
	private class Panel1 extends JPanel {
		Panel1() {
			setBackground(Color.YELLOW);
			add(new JLabel("아이디"));
			add(new JTextField(15));
			add(new JLabel("비밀번호"));
			add(new JPasswordField(15));						
		}
	}
	
	private class Panel2 extends JPanel {
		Panel2() {
			setBackground(Color.CYAN);
			add(new JLabel("     클릭     "));
			add(new JCheckBox("C# 체크박스"));
			add(new JCheckBox("C++ 체크박스"));			
		}
	}
	
	public static void main(String[] args) {
		new SwingEx1();
	}
}

package Guipackage;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SubstringEx extends JFrame {
	private JLabel la = new JLabel("JavaText");
			
	public SubstringEx() {
		la.setFont(new Font("serif",Font.BOLD,40));
		Container c = getContentPane();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.setLayout(new FlowLayout());
		c.addKeyListener(new MyKeyE());
		c.add(la);
		c.setFocusable(true);
		c.requestFocus();
		setSize(300, 200);
		setVisible(true);
	}

	class MyKeyE extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
//			int a = 0;
//			int b = 0;
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				la.setText(la.getText().substring(1) + 
						la.getText().substring(0, 1));
				
			} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				la.setText(la.getText().substring(la.getText().length()-1) +
						la.getText().substring(0, la.getText().length()-1));
			}

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SubstringEx();
	}

}

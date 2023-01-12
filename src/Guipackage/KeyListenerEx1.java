package Guipackage;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class KeyListenerEx1 extends JFrame {

	private JLabel keyMessage =new JLabel();
	Container c = getContentPane();

	public KeyListenerEx1() {

		setTitle("KeyListener  예제1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.setLayout(new FlowLayout());
		c.addKeyListener(new MyKeyListener());
		setSize(300, 150);
		setVisible(true);
		c.setFocusable(true);
		c.requestFocus();
	}

	class MyKeyListener extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
//			keyMessage.setText(e.getKeyText(e.getKeyCode()));

			if (e.getKeyChar() == '%') {
				c.setBackground(Color.YELLOW);
			} else if (e.getKeyCode () == KeyEvent.VK_F1) {
//				keyMessage.setText(" F1키가 입력되였음 ");
				c.setBackground(Color.GREEN);
			}
		}
	}

	public static void main(String[] args) {
		new KeyListenerEx1();
	}

}

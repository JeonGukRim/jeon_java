package test1;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class KeyLIstenerEx1 extends JFrame {

	public KeyLIstenerEx1() {
		JLabel jl = new JLabel();
		Container c = getContentPane();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		c.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				Container c1 = (Container) e.getSource();

				jl.setText(KeyEvent.getKeyText(e.getKeyCode()) + "키가 입력되였습니다");
				if (e.getKeyCode() == KeyEvent.VK_F1)
					c1.setBackground(Color.CYAN);
				else if (e.getKeyChar() == '%')
					c1.setBackground(Color.YELLOW);
				
			}
		});
		c.add(jl);
		setSize(500, 500);
		setVisible(true);
		c.setFocusable(true);
		c.requestFocus();
	}

	public static void main(String[] args) {
		new KeyLIstenerEx1();
	}
}

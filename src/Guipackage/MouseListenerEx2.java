package Guipackage;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MouseListenerEx2 extends JFrame {

	public MouseListenerEx2() {
		JLabel la = new JLabel("No Mouse Event");
		la.setSize(200, 50);
		setTitle("MouseListener와 MouseMotionListener 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		la.addMouseListener(new MyMouseL());
		la.addKeyListener(new MyKey());
		la.setFocusable(true);
		c.requestFocus();
		c.add(la);
		setSize(300, 200);
		setVisible(true);
	}

	class MyMouseL extends MouseAdapter {
		public void mouseEntered(MouseEvent e) {
			JLabel l = (JLabel) e.getSource();
			l.setText("마우스 올라왔습니다.");
		}

		public void mouseExited(MouseEvent e) {
			JLabel l = (JLabel) e.getSource();
			l.setText("마우스 내려갔습니다.");
		}
	}

	class MyKey extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			JLabel l = (JLabel) e.getSource();
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				l.setText("ENTER를 입력.");
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MouseListenerEx2();
	}
}

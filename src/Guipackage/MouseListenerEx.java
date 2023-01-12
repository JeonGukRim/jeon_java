package Guipackage;

import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MouseListenerEx extends JFrame {
	private JLabel la = new JLabel("Hello");

	public MouseListenerEx() {
		setTitle("Action 이벤트 리스너 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.addMouseListener(new MyMouseListener());
		c.setLayout(null);
		la.setSize(50, 20);
		la.setLocation(30, 30);
		c.add(la);
		setSize(250, 250);
		setVisible(true);
	}

	class MyMouseListener extends MouseAdapter{
		public void mousePressed(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			la.setLocation(x, y);
		}
	}
//	class MyMouseListener implements MouseListener {
//		public void mousePressed(MouseEvent e) {
//			int x = e.getX();
//			int y = e.getY();
//			la.setLocation(x, y);
//		}
//
//		public void mouseReleased(MouseEvent e) {
//		}
//
//		public void mouseClicked(MouseEvent e) {
//		}
//
//		public void mouseEntered(MouseEvent e) {
//		}
//
//		public void mouseExited(MouseEvent e) {
//		}
//
//	}  어댑터로 필요없는 추상메소드 생략해도 됨;
	public static void main(String[] args) {
		new MouseListenerEx();
	}
}

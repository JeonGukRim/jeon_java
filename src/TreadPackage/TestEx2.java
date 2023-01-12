package TreadPackage;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestEx2 extends JFrame {
	private MyPanel ovpanel = new MyPanel();

	public TestEx2() {

		setTitle("랜덤 원");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(ovpanel);

		setSize(1000, 1000);
		setVisible(true);

	}

	class MyPanel extends JPanel implements Runnable {
		private int x = 100;
		private int y = 100;

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawOval(x, y, 50, 50);

		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			 x = (int) Math.random() * 1000;
			 y = (int) Math.random() * 1000;
			 repaint();
		}
	}

	public static void main(String[] args) {
		new TestEx2();
	}
}

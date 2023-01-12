package GuiPackage1;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ClipEx extends JFrame {

	private MyPanel1 panel = new MyPanel1();
	private int x = 0;
	private int y = 0;

	public ClipEx() {
		setTitle("JPanel 의 paintComponent() 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setSize(500, 500);
		setVisible(true);
		panel.setFocusable(true);
		panel.requestFocus();
	}

	class MyPanel1 extends JPanel {
		// 이미지 그리기
		private ImageIcon icon = new ImageIcon("images/image0.jpg");
		private Image img = icon.getImage(); // 이미지 객체

		public MyPanel1() {

			addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_UP) {
						y -= 10;
						if (y < 0)
							y = 0;
					} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
						if (!(y > getHeight() - 100))
							y += 10;

					} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
						x = x - 10;
						if (x < 0)
							x = 0;
					} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
						if (!(x > getHeight() - 100))
						x = x + 10;

					}
					repaint();
				}

			});

		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setClip(x, y, 100, 100);
			g.drawImage(img, 0, 0, getWidth(), getHeight(), this);

		}

	}

	public static void main(String[] args) {
		new ClipEx();
	}
}

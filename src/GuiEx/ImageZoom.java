package GuiEx;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImageZoom extends JFrame {
	public ImageZoom() {
		super("test");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setContentPane(new MyPanel());
		setSize(300, 300);
		setVisible(true);

		getContentPane().setFocusable(true);
		getContentPane().requestFocus();
	}

	class MyPanel extends JPanel {
		private ImageIcon icon = new ImageIcon("images/apple.jpg");
		private Image img = icon.getImage();
		private int width, height;

		public MyPanel() {
			width = img.getWidth(this);
			height = img.getHeight(this);

			addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if (e.getKeyChar() == '+') {
//						width = (int) (width * 1.1);
//						height = (int) (height * 1.1);
						width = (int) (width +10);
						height = (int) (height + 10);
						repaint();
					} else if (e.getKeyChar() == '-') {
							width = (int) (width * 0.9);
							height = (int) (height * 0.9);
							repaint();
					}
				}
			});
		}

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, 10, 10, width, height, this);
		}
	}

	static public void main(String[] args) {
		new ImageZoom();
	}
}

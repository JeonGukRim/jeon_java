package GuiEx;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MouseMoveEx extends JFrame {
//	private NewPanel panel = new NewPanel();

	public MouseMoveEx() {
		setTitle("마우스 드래그");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new NewPanel());
		setSize(500, 500);
		setVisible(true);

	}

	class NewPanel extends JPanel {
		private ImageIcon icon = new ImageIcon("images/back.jpg");
		private Image img = icon.getImage();
		private int xO = 200, yO = 200;
//		private Vector<Point> xP = new Vector<Point>();
		public NewPanel() {
			addMouseMotionListener(new MouseAdapter() {
				@Override
				public void mouseDragged(MouseEvent e) {
					xO = e.getX();
					yO = e.getY();
//				Point x = e.getPoint();
//				xP.add(x);
					repaint();
				}
			});
		}

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
			g.setColor(Color.RED);
			
//			for(int i = 0; i<xP.size();i++) {
//			Point s = xP.elementAt(i);
//			g.fillOval((int)s.getX(),(int)s.getY(), 50, 50);
//			}
			
			g.fillOval(xO, yO, 50, 50);
			
		}
	}

	public static void main(String[] args) {
		new MouseMoveEx();
	}
}

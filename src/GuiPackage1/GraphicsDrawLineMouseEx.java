package GuiPackage1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class GraphicsDrawLineMouseEx extends JFrame {
	private MyPanel panel = new MyPanel();

	public GraphicsDrawLineMouseEx() {
		setTitle("JPanel 의 paintComponent() 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setSize(1000,1000);
		setVisible(true);
	}
	class MyPanel extends JPanel {
		private Vector<Point> vStart = new Vector<Point>();
		private Vector<Point> vEnd = new Vector<Point>();
		public MyPanel() {
			addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					Point startP = e.getPoint();
					vStart.add(startP);
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					Point endP = e.getPoint();
					vEnd.add(endP);
					repaint();
				}
			});
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.BLUE);
			for (int i = 0; i < vStart.size(); i++) {
				Point s = vStart.elementAt(i);
				Point e = vEnd.elementAt(i);
				g.drawLine((int)s.getX(), (int)s.getY(), 
						   (int)e.getX(), (int)e.getY());
//				System.out.println(vStart);
			}
		}
	}

	public static void main(String[] args) {
		new GraphicsDrawLineMouseEx();
	}
}

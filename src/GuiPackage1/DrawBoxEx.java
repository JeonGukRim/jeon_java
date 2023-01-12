package GuiPackage1;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawBoxEx extends JFrame {
	private MyP panel = new MyP();

	public DrawBoxEx() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);

		setSize(1000, 1000);
		setVisible(true);

	}

	class MyP extends JPanel {

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
//			int s = 50;
//			for (int i = 0; i < 1000; i++) {
//				g.drawLine(0, s ,getWidth(), s);
//				g.drawLine(s, 0, s, getHeight());
//				s += 50;
//			}
			
			//역시침 방향
//			int [] x = {500,0,500,1000};
//			int [] y = {0,500,1000,500};
//			for (int i = 0; i < 10; i++) {
//				g.drawPolygon(x,y,4);
//				y[0] = y[0] + 10;
//				x[1] = x[1] + 10;
//				y[2] = y[2] - 10;
//				x[3] = x[3] - 10;
//				
//			}
			
			// 순시침 방향
			int [] x = new int [4];
			int [] y = new int [4];
			x[0] = getWidth()/2;
			y[0] = 0;
			x[1] = getWidth();
			y[1] = getHeight()/2;
			x[2] = x[0];
			y[2] = getHeight();
			x[3] = 0;
			y[3] = y[1];
			
			for(int i = 0 ; i <10 ; i++) {
				g.setColor( new Color((int)(Math.random()*256), 
						(int)(Math.random()*256),(int)(Math.random()*256)));
				g.fillPolygon(x,y,4);
				y[0] = y[0] + 30;
				x[1] = x[1] - 30;
				y[2] = y[2] - 30;
				x[3] = x[3] + 30;
			}
			
			
			
			
		}

	}

	public static void main(String[] args) {
		new DrawBoxEx();
	}

}

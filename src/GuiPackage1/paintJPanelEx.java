package GuiPackage1;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class paintJPanelEx extends JFrame {
	private MyPanel panel = new MyPanel();
	
	public paintJPanelEx () {
	setTitle("JPanel 의 paintComponent() 예제");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setContentPane(panel);
	setSize(250,220);
	setVisible(true);
	}
	class MyPanel extends JPanel{
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.RED);
			g.drawRect(10, 10, 50, 50);  //x축,y축,높이,너비
			g.setColor(Color.YELLOW);
			g.drawRect(50, 50, 50, 50);
			g.setColor(Color.GREEN);
			g.drawRect(90, 90, 50, 50);
		}
	}
	public static void main (String[] args) {
		new paintJPanelEx();
	}
}

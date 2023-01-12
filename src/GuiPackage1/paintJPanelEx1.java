package GuiPackage1;


import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class paintJPanelEx1 extends JFrame {
	private MyPanel panel = new MyPanel();
	
	public paintJPanelEx1 () {
	setTitle("JPanel 의 paintComponent() 예제");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setContentPane(panel);
	setSize(250,220);
	setVisible(true);
	}
	class MyPanel extends JPanel{
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.GRAY);
			g.drawString("자바는 재밌다~~",30,30 );
			g.setColor(Color.BLACK);
			g.drawString("얼마나? 하늘만큼 땅만큼!!!!",60,60 );
		}
	}
	public static void main (String[] args) {
		new paintJPanelEx1();
	}
}

package GuiPackage1;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class paintJPanelEx2 extends JFrame {
	private MyPanel panel = new MyPanel();
	
	public paintJPanelEx2 () {
	setTitle("JPanel 의 paintComponent() 예제");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setContentPane(panel);
	setSize(5000,4200);
	setVisible(true);
	}
	class MyPanel extends JPanel{
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.BLUE);
			g.drawString("I Love Java~~",30,30 );
			g.setColor(new Color(255,0,0));
			g.setFont(new Font("Arial",Font.ITALIC,30));
			g.drawString("How much?",30,60 );
			g.setColor(new Color(0x00ff00ff));
			for(int i =1 ;i<=5 ; i++) {
				g.setFont(new Font("Jokerman",Font.ITALIC,i*10));
				g.drawString("This much!!", 30, 60+i*60);
			}
			// x,y,z,h    x,y 좌표에서 시작하여 z,h에서 끝남 선그리기
			g.setColor(Color.RED);
			g.drawLine(300, 100, 100, 100); 
		}
	}
	public static void main (String[] args) {
		new paintJPanelEx2();
	}
}

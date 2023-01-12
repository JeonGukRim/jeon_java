package Guipackage;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GuiEx1 extends JFrame {
	public GuiEx1() {

		setTitle("GridLayout Sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GridLayout grid = new GridLayout(1,10);  //row,col
		Container c = getContentPane();
		c.setLayout(grid);
		Color [] color = {Color.red,Color.orange,Color.yellow,Color.green,Color.magenta,Color.blue,Color.darkGray,Color.black,Color.pink,Color.cyan};
		for(int i = 0 ; i<10 ; i++) {
			JButton b = new JButton(Integer.toString(i)); //버튼 생성
//			b.setBackground(new Color((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256))); 랜덤으로 색상 출력
		b.setBackground(color[i]);  //지정색으로 출력
			c.add(b); //버튼을 컨텐트팬에 부착
		}
		
		
		setSize(500,400);
		setVisible(true);
		
	}
	public static void main (String[] args) {
		new GuiEx1();
	}
}

package Guipackage;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class GuiEx2 extends JFrame {

	public GuiEx2() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		for (int i = 1; i <= 20; i++) {
			JLabel b = new JLabel((int)(Math.random()*100)+ ""); // 라벨 생성
			b.setLocation((int) (Math.random() * 200)+50, (int) (Math.random() * 200)+50);
			b.setSize(20, 20);
			b.setOpaque(true); // 라벨은 해단 문구 있어야 색상이 들어감
			b.setBackground(Color.red);
			c.add(b); // 버튼을 컨텐트팬에 부착
		}
		setSize(300, 300);
		setVisible(true);

	}

	public static void main(String[] args) {
		new GuiEx2();
	}

}

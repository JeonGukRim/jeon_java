package Guipackage;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
//////////라벨 랜덤으로 출력
public class GuiEx3 extends JFrame {

	public GuiEx3() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		for (int i = 0; i < 20; i++) {
			JLabel jr = new JLabel(i+ "" );
			jr.setSize(20, 20);
			jr.setOpaque(true);
			jr.setBackground(Color.red);
			jr.setLocation((int) (Math.random() * 250 + 50), (int) (Math.random() * 250 + 50));
			c.add(jr);
		}

		setSize(300, 300);
		setVisible(true);

	}

	public static void main(String[] args) {
		new GuiEx3();
	}
}
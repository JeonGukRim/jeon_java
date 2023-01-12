package TreadPackage;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class TestEx3_1 extends JFrame {
	private JLabel timerLabel = new JLabel();
	public TestEx3_1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		timerLabel.setFont(new Font("",Font.ITALIC,40));
//		timerLabel.setForeground(Color.red); 라벨 색상 설정;
		c.add(timerLabel);

		TestEx03 runnable = new TestEx03 (timerLabel);
		Thread th = new Thread(runnable);
		
		
		setSize(300, 100);
		setVisible(true);

		th.start();
	}

	public static void main(String[] args) {
		new TestEx3_1();
	}

}

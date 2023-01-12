package TreadPackage;

import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class RandomThreadEx extends JFrame {
	private RandomThread th;

	public RandomThreadEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);

		c.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				th.finish(e.getPoint());
			}
		});
		setSize(300, 200);
		setVisible(true);
		th = new RandomThread(c);
		th.start();
	}

	public static void main(String[] args) {
		new RandomThreadEx();
	}
}

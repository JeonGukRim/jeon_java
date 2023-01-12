package TreadPackage;

import java.awt.Color;
import java.awt.Container;
import java.awt.Point;

import javax.swing.JLabel;

public class RandomThread extends Thread {
	private Container contentPane;
	private Point p;
	private boolean flag = false;

	public RandomThread(Container contentPane) {
		this.contentPane = contentPane;
	}

	public void finish(Point p) {
		flag = true;
		this.p = p;
	}

	public void run() {
		while (true) {
			int x = (int) (Math.random() * contentPane.getWidth());
			int y = (int) (Math.random() * contentPane.getHeight());
			JLabel label = new JLabel("java");
			label.setSize(80, 30);
			label.setLocation(x, y);
			contentPane.add(label);
			contentPane.repaint();
			try {
				Thread.sleep(300);
				if (flag == true) {
					contentPane.removeAll();
					label = new JLabel("finish");
					label.setSize(80, 30);
					label.setLocation(this.p.x, this.p.y);
					label.setForeground(Color.red);
					contentPane.add(label);
					contentPane.repaint();
					return;
				}
			} catch (InterruptedException e) {
				return;
			}

		}

	}

}

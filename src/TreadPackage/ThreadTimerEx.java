package TreadPackage;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ThreadTimerEx extends JFrame {
	public ThreadTimerEx() {
		setTitle("Thread를 상속받은 타이머 스래드 예제;");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		JLabel timerLabel = new JLabel();
		timerLabel.setFont(new Font("Gothc", Font.ITALIC, 80));
		c.add(timerLabel);

		TimerThread th = new TimerThread(timerLabel);

		setSize(300, 170);
		setVisible(true);

		th.start();
	}

	public class TimerThread extends Thread {
		private JLabel timerLabel;
		public TimerThread(JLabel timerLabel) {
			this.timerLabel = timerLabel;
		}

		public void run() {
			int n =0;
			while (true) {
				timerLabel.setText(Integer.toString(n));
				n++;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					return;
				}

			}
		}
	}

	public static void main(String[] args) {
		new ThreadTimerEx();
	}
}
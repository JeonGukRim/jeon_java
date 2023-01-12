package TreadPackage;

import javax.swing.JLabel;

public class TestEx03 implements Runnable {

	private JLabel timerLabel;
	
	public TestEx03(JLabel timerLabel) {
		this.timerLabel = timerLabel;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int n = 8100;
		while(true) {
			timerLabel.setText(Integer.toString(n));
			n--;
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				return;
			}
		}
	}
	
}

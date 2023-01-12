package TreadPackage;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class RunnableTimerEx extends JFrame {

	public RunnableTimerEx() {
		setTitle("Runnable를 구현한 타이머 스래드 예제;");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		JLabel timerLabel = new JLabel();
		timerLabel.setFont(new Font("Gothc", Font.ITALIC, 80));
		c.add(timerLabel);

		TimerRunnable runnable = new TimerRunnable(timerLabel);
		Thread th = new Thread(runnable);

		//버튼을 생성하고 action 리스너 등록
		JButton btn = new JButton("kill Timer");
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				th.interrupt();//타이머 스레드 강제 종료
				JButton btn = (JButton)e.getSource();
				btn.setEnabled(false); // 버튼 비활성화
			}
		});
		c.add(btn);
		
		
		
		
		
		setSize(300, 170);
		setVisible(true);

		th.start();
	}

	public static void main(String[] args) {
		new RunnableTimerEx();
	}
}

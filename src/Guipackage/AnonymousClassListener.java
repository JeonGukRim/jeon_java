package Guipackage;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class AnonymousClassListener extends JFrame {

	public AnonymousClassListener() {

		setTitle("Action 이벤트 리스너 작성");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		JButton bt1 = new JButton("Action");
		c.add(bt1);

		bt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton) e.getSource(); // 갯소스는 이벤트가 발생한 해당 정보를 가져옴; 리턴이 오브젝트로 되여서 정의해줘야한다;
				if (b.getText().equals("Action"))
					b.setText("액션");
				else
					b.setText("Action");
//				setTitle(b.getText());
			}
		});
		setSize(350, 150);
		setVisible(true);

	}
}

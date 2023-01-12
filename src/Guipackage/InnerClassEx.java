package Guipackage;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class InnerClassEx extends JFrame {
	public InnerClassEx() {
		setTitle("Action 이벤트 리스너 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		JButton bt1 = new JButton("Action");
		bt1.addActionListener(new MyActionListener()); //Action 리스너에 달기
		c.add(bt1);
		setSize(350,150);
		setVisible(true);
	}
	private class MyActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JButton b =(JButton)e.getSource();  //갯소스는 이벤트가 발생한 해당 정보를 가져옴; 리턴이 오브젝트로 되여서 정의해줘야한다;
			if(b.getText().equals("Action") ){  
				b.setText("액션");
			}else {
				b.setText("Action");
			}
			InnerClassEx.this.setTitle(b.getText());
		}
	}
	public static void main (String[] args) {
		new IndepClassListener();
	}
	
	
}

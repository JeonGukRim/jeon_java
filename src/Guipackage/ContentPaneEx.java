package Guipackage;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ContentPaneEx extends JFrame {

	public ContentPaneEx() {
		setTitle("ContentPane 과 JFrame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //완전한 종료가 필요시 사용되는 문구 없으면 백그라운드에서 그냥 실행이 됨;

		Container contentPane = getContentPane(); //컨테이너의 위치 파악
		contentPane.setBackground(Color.ORANGE); //도화지에 오렌지색상
		contentPane.setLayout(new FlowLayout()); //버튼 배치 문구 이문구없으면 전부 겹쳐서 출력 됨 flowlayout은 만들걸 왼쪽부터 오른쪽으로 순차적으로 배치

		contentPane.add(new JButton("OK")); // JButton b = new JButton("OK") ; contentPane.add(b);
		contentPane.add(new JButton("Canncel"));
		contentPane.add(new JButton("Ignore"));

		setSize(300, 150);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ContentPaneEx();
	}
}

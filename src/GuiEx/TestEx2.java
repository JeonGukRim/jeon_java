package GuiEx;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TestEx2 extends JFrame {
	private JButton jb = new JButton("종료");
	private JPanel jp = new JPanel();
	private JPanel jp1 = new JPanel();
	private JLabel jl = new JLabel("학번 :");
	private JTextField tf = new JTextField(35);
	private MyKeyListener keylistener = new MyKeyListener();

	public TestEx2() {

		setTitle("메뉴 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		createMenu();  //1번 메뉴 생성 문제
		Container c = getContentPane();
		
		//2번 종료버튼 문제
//		jp.setLayout(new FlowLayout(FlowLayout.LEFT));
//		jp.add(jb);
//		c.add(jp, BorderLayout.NORTH);

		
		//3번 숫자이외 입력시 알림설정
		jp1.add(jl);
		jp1.add(tf);
		tf.addKeyListener(keylistener);
		jp1.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp1.setBackground(Color.WHITE);
		c.add(jp1, BorderLayout.SOUTH);

		setSize(500, 500);
		setVisible(true);

		jb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int result = JOptionPane.showConfirmDialog(null, "죵료하시겠습니까?", "예제", JOptionPane.YES_NO_OPTION);
				
			}
		});
	}

	class MyKeyListener extends KeyAdapter {
		public void keyPressed(KeyEvent e) {

			if (e.getKeyChar() < '0' || e.getKeyChar() > '9') {
				JOptionPane.showMessageDialog(null, e.getKeyChar() + "는 숫자 키가 아닙니다\n숫자를 입력하세요", "경고",
						JOptionPane.ERROR_MESSAGE);
				e.consume();
			}
		}
	}

	private void createMenu() {
		JMenuBar mb = new JMenuBar();
		JMenu view = new JMenu("보기");
		JMenuItem zoomP = new JMenuItem("화면확대");
		JMenuItem outL = new JMenuItem("폭윤곽");
		view.add(zoomP);
		view.add(outL);

		mb.add(new JMenu("파일"));
		mb.add(new JMenu("편집"));
		mb.add(view);
		mb.add(new JMenu("입력"));
		setJMenuBar(mb);
	}

	public static void main(String[] args) {
		new TestEx2();
	}
}

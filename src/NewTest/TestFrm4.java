package NewTest;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class TestFrm4 extends JFrame {
	private JButton enqubt, inbt, outbt, listbt, setbt;
	private JButton [] subBtn = new JButton[25];
//	private JPanel pNorth, pSouth, subMenuContainer;
	private JPanel pNorth, pSouth, subMenuContainer;
	private JScrollPane pCenter;
	private JButton[] btn = null;
	private static boolean expand = true;

	public TestFrm4() {
		enqubt = new JButton("조회");
		enqubt.setBackground(Color.CYAN);
		inbt = new JButton("입고");
		inbt.setBackground(Color.CYAN);
		outbt = new JButton("출고");
		outbt.setBackground(Color.CYAN);
		outbt.addActionListener(new ActionHandler());
		listbt = new JButton("상품리스트");
		listbt.setBackground(Color.CYAN);
		setbt = new JButton("설정");
		setbt.setBackground(Color.CYAN);
		pNorth = new JPanel();
		subMenuContainer = new JPanel();
		subMenuContainer.setLayout(new GridLayout(25, 1));
		for (int i = 0; i < 2; i++) {
			subBtn[i] = new JButton("[미니 메뉴" + i + "]");
			subBtn[i].setBackground(Color.WHITE);
		}
		
		pNorth.setLayout(new GridLayout(5, 1));
		pNorth.add(enqubt);
		pNorth.add(inbt);
		pNorth.add(outbt);
		pNorth.add(listbt);
		pNorth.add(setbt);
//		pNorth.setLocation(10,10);
//		pNorth.setSize(300,400);
		
//		this.setLayout(null);
		this.add(new JScrollPane(pNorth));
		this.setVisible(true);
		this.setSize(500, 600);
		this.setResizable(false); // 창크기 조절 가능 여부
		this.setLocationRelativeTo(null); // 컨테이너 윈도스 가운데 출력
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private class ActionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (outbt == e.getSource()) {
				if (expand) {// 펼침
					pNorth.setLayout(new GridLayout(31, 1));
					pNorth.remove(listbt);
					pNorth.remove(setbt);
					for (int i = 0; i < 2; i++) {
						pNorth.add(subBtn[i]);
					}
					pNorth.add(listbt);
					pNorth.add(setbt);
					validate();
					getContentPane().repaint();
					expand = false;
				} else {// 접힘
					for (int i = 0; i < 2; i++) {
						pNorth.remove(subBtn[i]);
					}
					pNorth.setLayout(new GridLayout(5, 1));
					pNorth.repaint();
					validate();
					getContentPane().repaint();
					expand = true;
				}
			}
		}

	}

	public static void main(String[] args) {

		new TestFrm4();
	}

}
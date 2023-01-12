package NewTest;

import java.awt.BorderLayout;
import java.awt.Color;
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
		pNorth.setLayout(new GridLayout(5, 1));
		
		
		pSouth = new JPanel();
//		pSouth.setLayout(new GridLayout(2, 1));
		
		
		subMenuContainer = new JPanel();
		subMenuContainer.setLayout(new GridLayout(25, 1));
		btn = new JButton[25];
		for (int i = 0; i < btn.length; i++) {
			btn[i] = new JButton("[미니 메뉴" + i + "]");
			btn[i].setBackground(Color.WHITE);
		}
//		subBtn = new JButton[25];
		for (int i = 0; i < subBtn.length; i++) {
			subBtn[i] = new JButton("[미니 메뉴" + i + "]");
			subBtn[i].setBackground(Color.WHITE);
		}
		
		
		this.setLayout(new BorderLayout());

		pNorth.add(enqubt);
		pNorth.add(inbt);
		pNorth.add(outbt);
		pNorth.add(listbt);
		pNorth.add(setbt);
//		for (int i = 0; i < btn.length; i++) {
//			subMenuContainer.add(btn[i]);
//		}
//		pCenter = new JScrollPane(subMenuContainer);
//		pSouth.add(listbt);
//		pSouth.add(setbt);
		this.add(pNorth, "North");

//		this.add(pCenter, "Center");
//
//		this.add(pSouth, "South");

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
//				for (int i = 0; i < btn.length; i++) {
//					subMenuContainer.add(btn[i]);
//				}
				if (expand) {// 펼침
					pNorth.setLayout(new GridLayout(31, 1));
					pNorth.remove(listbt);
					pNorth.remove(setbt);
					for (int i = 0; i < subBtn.length; i++) {
						pNorth.add(subBtn[i]);
					}
//					pNorth.add(new JScrollPane(subMenuContainer));
//					pCenter = new JScrollPane(subMenuContainer);
//					getContentPane().add(pNorth, "Center");
					pNorth.add(listbt);
					pNorth.add(setbt);
//					getContentPane().add(pSouth, "South");
//					pSouth.setLayout(new GridLayout(2, 1));
					validate();
					getContentPane().repaint();
					expand = false;
				} else {// 접힘
//					for (int i = 0; i < btn.length; i++) {
//						subMenuContainer.remove(btn[i]);
//					}
					for (int i = 0; i < subBtn.length; i++) {
						pNorth.remove(subBtn[i]);
					}
					pSouth.removeAll();
					pNorth.setLayout(new GridLayout(5, 1));
//					pNorth.add(listbt);
//					pNorth.add(setbt);
					pNorth.repaint();
//					pCenter.repaint();
//					pSouth.repaint();
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
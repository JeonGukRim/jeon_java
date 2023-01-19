package MyProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

//import MyProject.menuTree.ActionHandler;

public class ProjectDialog extends JDialog {
	private JButton btn1, btn2, btn3, btn4, btn5;
	private JButton[] menuBtn = new JButton[5];
	private JPanel menuL, pNorth, pSouth, subMenuContainer;
	private JLabel modeJl;
	private JScrollPane pCenter;
	private JButton[] subBtn = new JButton[10];
	private String[] btnname = { "재고현황조회", "검색", "입출고 이력조회", "발주서 생성", "입고", "Location정보", "출고오더생성", "출고", "상품정보조회",
			"ID정보관리" };
	private static boolean expand = false;
	private static boolean expand1 = false;
	private static boolean expand2 = false;
	private static boolean expand3 = false;
	private static boolean expand4 = false;
	private String loginid;
	public JFrame frame;
	private LoginUi l;
	
	public ProjectDialog() {}
	public ProjectDialog(JFrame frame, String title,String mode,String loginid) {
		super(frame, title, true);
		this.loginid = loginid;
		this.frame = frame;
		l = (LoginUi) frame;
		for (int i = 0; i < subBtn.length; i++) {
			subBtn[i] = new JButton(btnname[i]);
			subBtn[i].setBackground(Color.white);
		}
		
		modeJl = new JLabel(mode);
		modeJl.setFont(new Font("맑은 고딕",Font.BOLD,30));
		modeJl.setSize(300,200);
		modeJl.setLocation(90,20);
		
		pNorth = new JPanel();
		menuL = new JPanel();
//		Container c = getContentPane();
		setBackground(Color.WHITE);
		setResizable(false);
		setLocation(100, 100);
		setLayout(null);
		menuL.setSize(200, 500);
		menuL.setLocation(90, 200);
		menuL.setLayout(new BorderLayout());
		menuL.setBackground(Color.LIGHT_GRAY);

		menuBtn[0] = new JButton("조회");
		menuBtn[0].setFont(new Font("맑은 고딕", Font.BOLD, 20));
		menuBtn[0].setForeground(Color.white);
		menuBtn[0].setBackground(Color.BLACK);

		menuBtn[1] = new JButton("입고");
		menuBtn[1].setFont(new Font("맑은 고딕", Font.BOLD, 20));
		menuBtn[1].setForeground(Color.white);
		menuBtn[1].setBackground(Color.BLACK);

		menuBtn[2] = new JButton("출고");
		menuBtn[2].setFont(new Font("맑은 고딕", Font.BOLD, 20));
		menuBtn[2].setForeground(Color.white);
		menuBtn[2].setBackground(Color.BLACK);

		menuBtn[3] = new JButton("상품리스트");
		menuBtn[3].setFont(new Font("맑은 고딕", Font.BOLD, 20));
		menuBtn[3].setForeground(Color.white);
		menuBtn[3].setBackground(Color.BLACK);

		menuBtn[4] = new JButton("설정");
		menuBtn[4].setFont(new Font("맑은 고딕", Font.BOLD, 20));
		menuBtn[4].setForeground(Color.white);
		menuBtn[4].setBackground(Color.BLACK);

		pNorth.setLayout(new GridLayout(0, 1));

		for (int i = 0; i < menuBtn.length; i++) {
			pNorth.add(menuBtn[i]);
			menuBtn[i].addActionListener(new ActionHandlerR());
			if (i == 4) {
				for (int j = 0; j < subBtn.length; j++)
					subBtn[j].addActionListener(new ActionHandlerR());
			}
		}
		menuL.add(pNorth, "North");

		subMenuContainer = new JPanel();
		subMenuContainer.setSize(900, 500);
		subMenuContainer.setLocation(350, 200);

		add(menuL);
		add(new textPanel());
		add(modeJl);
		setSize(1500, 900);
		
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent w) {
				try{
					l.stmt.close(); // Statement 객체 닫기
					l.conn.close(); // Connection 객체 닫기
					setVisible(false); // 화면 닫기
					dispose(); // 자원 반납
					System.exit(0); // 종료 처리
				}catch(Exception e){

				}
			}
		});
	}

	private class ActionHandlerR implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			for (int i = 0; i < subBtn.length; i++) {
				if (subBtn[i] == e.getSource()) {
					if (i == 0) {
						new SubBtnListener(subMenuContainer, "재고현황조회",loginid,frame );
						getContentPane().add(subMenuContainer);

					} else if (i == 1) {
						new SubBtnListener(subMenuContainer, "검색",loginid,frame );
						getContentPane().add(subMenuContainer);
					} else if (i == 2) {
						new SubBtnListener(subMenuContainer, "입출고 이력조회",loginid,frame );
						getContentPane().add(subMenuContainer);
					} 
					else if (i == 3) {
						new SubBtnListener1(subMenuContainer, "발주서 생성",loginid,frame );
						getContentPane().add(subMenuContainer);
					} else if (i == 4) {
						new SubBtnListener1(subMenuContainer, "입고",loginid,frame );
						getContentPane().add(subMenuContainer);
					} else if (i == 5) {
						new SubBtnListener1(subMenuContainer, "Location정보",loginid,frame );
						getContentPane().add(subMenuContainer);
					}
				else if (i == 6) {
						new SubBtnListener2(subMenuContainer, "출고오더생성",loginid,frame );
						getContentPane().add(subMenuContainer);
					} else if (i == 7) {
						new SubBtnListener2(subMenuContainer, "출고",loginid,frame );
						getContentPane().add(subMenuContainer);
					} else if (i == 8) {
						new SubBtnListener(subMenuContainer, "상품정보조회",loginid,frame );
						getContentPane().add(subMenuContainer);
					} else {
						new SubBtnListener(subMenuContainer, "ID정보관리",loginid,frame );
						getContentPane().add(subMenuContainer);
					}
				}
				validate();
			}

			if (menuBtn[0] == e.getSource()) {
				expand = true;
				expand1 = false;
				expand2 = false;
				expand3 = false;
				expand4 = false;
				wind2();
				wind3();
				wind4();
				wind5();
				wind1();

			} else if (menuBtn[1] == e.getSource()) {
				expand = false;
				expand1 = true;
				expand2 = false;
				expand3 = false;
				expand4 = false;
				wind1();
				wind3();
				wind4();
				wind5();
				wind2();
			} else if (menuBtn[2] == e.getSource()) {
				expand = false;
				expand1 = false;
				expand2 = true;
				expand3 = false;
				expand4 = false;
				wind1();
				wind2();
				wind4();
				wind5();
				wind3();
			} else if (menuBtn[3] == e.getSource()) {
				expand = false;
				expand1 = false;
				expand2 = false;
				expand3 = true;
				expand4 = false;
				wind1();
				wind2();
				wind3();
				wind5();
				wind4();
			} else if (menuBtn[4] == e.getSource()) {
				expand = false;
				expand1 = false;
				expand2 = false;
				expand3 = false;
				expand4 = true;
				wind1();
				wind2();
				wind3();
				wind4();
				wind5();
			}
		}

	}

	// 접이식 메뉴
	public void wind1() {
		if (expand) {// 펼침
			for (int i = 1; i < 5; i++) {
				pNorth.remove(menuBtn[i]);
			}
			for (int i = 0; i < 3; i++) {
				pNorth.add(subBtn[i]);
			}
			for (int i = 1; i < 5; i++) {
				pNorth.add(menuBtn[i]);

			}
			validate();
			menuL.repaint();

			expand = false;
		} else {// 접힘
			for (int i = 0; i < 3; i++) {
				pNorth.remove(subBtn[i]);
			}
			validate();
			menuL.repaint();

			expand = true;
		}
	}

	public void wind2() {
		if (expand1) {// 펼침
			for (int i = 2; i < 5; i++) {
				pNorth.remove(menuBtn[i]);
			}
			for (int i = 3; i < 6; i++) {
				pNorth.add(subBtn[i]);
			}
			for (int i = 2; i < 5; i++) {
				pNorth.add(menuBtn[i]);

			}
			validate();
			menuL.repaint();
			expand1 = false;
		} else {// 접힘
			for (int i = 3; i < 6; i++) {
				pNorth.remove(subBtn[i]);
			}
			validate();
			menuL.repaint();
			expand1 = true;
		}
	}

	public void wind3() {
		if (expand2) {// 펼침
			for (int i = 3; i < 5; i++) {
				pNorth.remove(menuBtn[i]);
			}
			for (int i = 6; i < 8; i++) {
				pNorth.add(subBtn[i]);
			}
			for (int i = 3; i < 5; i++) {
				pNorth.add(menuBtn[i]);

			}
			validate();
			menuL.repaint();
			expand2 = false;
		} else {// 접힘
			for (int i = 6; i < 8; i++) {
				pNorth.remove(subBtn[i]);
			}
			validate();
			menuL.repaint();
			expand2 = true;
		}
	}

	public void wind4() {
		if (expand3) {// 펼침
			pNorth.remove(menuBtn[4]);
			pNorth.add(subBtn[8]);
			pNorth.add(menuBtn[4]);
			validate();
			menuL.repaint();
			expand3 = false;
		} else {// 접힘
			pNorth.remove(subBtn[8]);
			validate();
			menuL.repaint();
			expand3 = true;
		}
	}

	public void wind5() {
		if (expand4) {// 펼침
			pNorth.add(subBtn[9]);
			validate();
			menuL.repaint();
			expand4 = false;
		} else {// 접힘
			pNorth.remove(subBtn[9]);
			validate();
			menuL.repaint();
			expand4 = true;
		}
	}

}

class textPanel extends JPanel {
	textPanel() {
		setSize(900, 100);
		setLocation(380, 5);
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(new Color(132, 203, 52));
		g.setFont(new Font("Arial", Font.ITALIC, 40));
		g.drawString("This too shall pass.", 100, 70);
		g.setColor(Color.BLACK);
		g.setFont(new Font("휴먼매직체", Font.ITALIC, 20));
		g.drawString("– Et hoc transibit", 540, 100);
	}

}

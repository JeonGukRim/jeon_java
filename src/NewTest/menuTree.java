package NewTest;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class menuTree extends JFrame {
	private JButton btn1, btn2, btn3, btn4, btn5;
	private JButton [] menuBtn = new JButton[5];
	private JPanel menuL, pNorth, pSouth, subMenuContainer;
	private JScrollPane pCenter;
	private JButton [] subBtn =new JButton[9];
	private String [] btnname = {"재고현황조회","검색","입출고 이력조회","발주서 생성",
			"입고","Location정보","출고오더생성","재고이동","ID정보관리"};
	private static boolean expand = false;

	public menuTree() {
		for(int i =0; i< 9 ; i++) {
			subBtn[i]= new JButton(btnname[i]);
			subBtn[i].setBackground(Color.white);
		}
		pNorth = new JPanel();
		menuL = new JPanel();
		Container c = getContentPane();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocation(100, 100);
		setLayout(null);
		menuL.setSize(200, 700);
		menuL.setLocation(90, 100);
		menuL.setLayout(new BorderLayout());
		menuL.setBackground(Color.LIGHT_GRAY);

		
		menuBtn[0]=new JButton("조회");
		menuBtn[0].setFont(new Font("맑은 고딕",Font.BOLD,20));
		menuBtn[0].setForeground(Color.white);
		menuBtn[0].setBackground(Color.BLACK);
        
		menuBtn[1]=new JButton("입고");
		menuBtn[1].setFont(new Font("맑은 고딕",Font.BOLD,20));
		menuBtn[1].setForeground(Color.white);
		menuBtn[1].setBackground(Color.BLACK);

		menuBtn[2]=new JButton("출고");
		menuBtn[2].setFont(new Font("맑은 고딕",Font.BOLD,20));
		menuBtn[2].setForeground(Color.white);
		menuBtn[2].setBackground(Color.BLACK);
        
		menuBtn[3]=new JButton("상품리스트");
		menuBtn[3].setFont(new Font("맑은 고딕",Font.BOLD,20));
		menuBtn[3].setForeground(Color.white);
		menuBtn[3].setBackground(Color.BLACK);
        
		menuBtn[4]=new JButton("설정");
		menuBtn[4].setFont(new Font("맑은 고딕",Font.BOLD,20));
		menuBtn[4].setForeground(Color.white);
		menuBtn[4].setBackground(Color.BLACK);
        
		pNorth.setLayout(new GridLayout(0,1));
        
		for(int i =0 ; i < menuBtn.length ; i++) {
			pNorth.add(menuBtn[i]);
			menuBtn[i].addActionListener(new ActionHandler());
		}
        menuL.add(pNorth,"North");
		c.add(menuL);
		setVisible(true);
		setSize(1500, 900);
		
		subBtn[0].addActionListener(null);
	}
	
	
	
	private class ActionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (menuBtn[0] == e.getSource()) {
				if (expand) {// 펼침
					for(int i =1 ; i < 5; i++) {
						pNorth.remove(menuBtn[i]);
					}
					for(int i =0 ; i < 3; i++) {
						pNorth.add(subBtn[i]);
					}
					for(int i =1 ; i < 5; i++) {
						pNorth.add(menuBtn[i]);
						
					}
					validate();
					menuL.repaint();
					expand = false;
				} else {// 접힘
					for(int i =0 ; i < 3; i++) {
						pNorth.remove(subBtn[i]);
					}
					validate();
					menuL.repaint();
					expand = true;
				}
				
				
				
			}
		}

	}

	public static void main(String[] args) {

		new menuTree();
	}

}
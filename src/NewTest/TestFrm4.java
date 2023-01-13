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
	private JButton[] menuBtn = new JButton[5];
	private JPanel pSouth, subMenuContainer;
	private JScrollPane pCenter , pNorth ;
	private JButton[] btn = null;
	private JButton [] subBt1 =new JButton [3];     
	private String []  subTx1 = {"재고현황조회","검색","입출고 이력 조회"};
	private JButton [] subBt2 =new JButton [3]; 
	private String []  subTx2 = {"발주서 생성","입고","Location 정보"};
	private JButton [] subBt3 =new JButton [3];   
	private String []  subTx3 = {"출고 오더 생성","재고이동","출고 작업"};
	private JButton subBt4 =new JButton("상품정보조회");   
	private JButton subBt5 =new JButton ("리스트/추가/삭제");   
	private static boolean expand = true;

	public TestFrm4() {
		this.setSize(300, 500);
		pNorth = new JScrollPane();
		pNorth.setLayout(null);
		pNorth.setSize(this.getWidth(),450);
		setTing();
		
		
		this.add(pNorth);
		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	
	}
	public void setTing() {
				// 조회 버튼
				menuBtn[0] = new JButton("조회");
				menuBtn[0].setBackground(Color.CYAN);
				menuBtn[0].setLocation(0,0);
				menuBtn[0].setSize(pNorth.getWidth(),(int)(pNorth.getHeight()/5));
				
				// 입고 버튼
				menuBtn[1] = new JButton("입고");
				menuBtn[1].setBackground(Color.CYAN);
				menuBtn[1].setLocation(0,(int)(pNorth.getHeight()/5));
				menuBtn[1].setSize(pNorth.getWidth(),(int)(pNorth.getHeight()/5));

				// 출고 버튼
				menuBtn[2] = new JButton("출고");
				menuBtn[2].setBackground(Color.CYAN);
				menuBtn[2].setLocation(0,(int)((pNorth.getHeight()/5)*2));
				menuBtn[2].setSize(pNorth.getWidth(),(int)(pNorth.getHeight()/5));

				// 상품리스트 버튼
				menuBtn[3] = new JButton("상품 정보");
				menuBtn[3].setBackground(Color.CYAN);
				menuBtn[3].setLocation(0,(int)((pNorth.getHeight()/5)*3));
				menuBtn[3].setSize(pNorth.getWidth(),(int)(pNorth.getHeight()/5));

				// 설정 버튼
				menuBtn[4] = new JButton("설정");
				menuBtn[4].setBackground(Color.CYAN);
				menuBtn[4].setLocation(0,(int)((pNorth.getHeight()/5)*4));
				menuBtn[4].setSize(pNorth.getWidth(),(int)(pNorth.getHeight()/5));
				
				
//				pSouth = new JPanel();
				this.setLayout(null);
				
				for (int i = 0; i < menuBtn.length; i++) {
					pNorth.add(menuBtn[i]);
					menuBtn[i].addActionListener(new ActionHandler());
				}
}
	
	
	private class ActionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
		
			if (menuBtn[0] == e.getSource()) {
				if (expand) {// 펼침
					int n =3;
					for(int i = 1 ; i < 5 ; i++) {
						for(int j = 0; j< 3 ; j++) {
							subBt1[j] = new JButton(subTx1[j]);
							subBt1[j].setLocation(15,(int)((pNorth.getHeight()/5)*(j+1)));
							subBt1[j].setSize((pNorth.getWidth()-50),(int)(pNorth.getHeight()/5));
							pNorth.add(subBt1[j]);
						}
						menuBtn[i].setLocation(0,(int)((pNorth.getHeight()/5)*n));
						n++;
					}
//					pNorth.setLayout(new GridLayout(3, 1));
//					pNorth.remove(menuBtn[3]);
//					pNorth.remove(menuBtn[4]);
//
//					pSouth.add(menuBtn[3]);
//					pSouth.add(menuBtn[4]);
//					pSouth.setLayout(new GridLayout(2, 1));
//					getContentPane().add(pSouth, "South");
					validate();
//					getContentPane().repaint();
					expand = false;
				} else {// 접힘
//					for (int i = 0; i < btn.length; i++) {
//						subMenuContainer.remove(btn[i]);
//					}
//					pSouth.removeAll();
//					pNorth.setLayout(new GridLayout(5, 1));
//					pNorth.add(menuBtn[3]);
//					pNorth.add(menuBtn[4]);
//					pNorth.repaint();
//					pCenter.repaint();
//					pSouth.repaint();
//					validate();
					getContentPane().repaint();
					pNorth.removeAll();
//					for(int i = 0 ; i < 5 ; i++) {
//						pNorth.add(menuBtn[i]);
//					}
//					
					setTing();
					expand = true;
					
				}
			}
		}

	}

	public static void main(String[] args) {

		new TestFrm4();
	}

}
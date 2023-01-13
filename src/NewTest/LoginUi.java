package NewTest;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginUi extends JFrame {
	private MyPanel panel = new MyPanel();
	private JLabel idjl = new JLabel("ID :");
	private JLabel pwjl = new JLabel("PW :");
	private JTextField loginTf = new JTextField(20);
	private JPasswordField pwTf = new JPasswordField(30);
	private JButton login = new JButton("로그인");
	private JCheckBox ck, radio2;
	private ButtonGroup g = new ButtonGroup();
	private ImageIcon image2 = new ImageIcon("images/check.png");
	private ImageIcon image3 = new ImageIcon("images/check1.png");

	public LoginUi() {
		// 관리자 모드 여부 체크박스
//		ck = new JCheckBox("",image2);
//		ck.setSelectedIcon(image3);
		ck = new JCheckBox("관리자 모드");
		ck.setSize(300,80);
		ck.setLocation(800, 350);
		ck.setSelected(true);
		
		//로그인 정보
		idjl.setLocation(800,390);
		idjl.setSize(200,200);
		idjl.setFont(new Font("Arial", Font.ITALIC, 30));
		loginTf.setSize(200,40);
		loginTf.setBackground(Color.ORANGE);
		loginTf.setLocation(880,471);
		pwjl.setLocation(800,450);
		pwjl.setSize(200,200);
		pwjl.setFont(new Font("Arial", Font.ITALIC, 30));
		pwTf.setSize(200,40);
		pwTf.setBackground(Color.ORANGE);
		pwTf.setLocation(880,533);
		
		login.setSize(200,30);
		login.setLocation(840,620);
		
		
		panel.add(ck);
		panel.add(idjl); 
		panel.add(pwjl);
		panel.add(loginTf);
		panel.add(pwTf);
		panel.add(login);
		
		setTitle("W.M.S 로그인");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setContentPane(panel);
	
		setLayout(null);
		setBackground(Color.white);
	
		setSize(1500, 900);
		setVisible(true);

//		mode = new ModeBtn(this);
	}

	class MyPanel extends JPanel {
		private ImageIcon icon = new ImageIcon("images/warehouse.png");
		private Image img = icon.getImage();
		
		MyPanel(){
//			setLayout(null);
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			// 이미지
			g.drawImage(img, 200, 250, 450, 450, this);
			// 명언
			g.setColor(new Color(132, 203, 52));
			g.setFont(new Font("Arial", Font.ITALIC, 50));
			g.drawString("Being happy never goes out of style", 100, 80);
			g.setColor(Color.BLACK);
			g.setFont(new Font("휴먼매직체", Font.ITALIC, 30));
			g.drawString("즐거움은 영원히 유행에 뒤떨어지지 않는다", 620, 180);
			// 로고 위치
			g.setColor(new Color(73, 182, 155));
			g.fillRoundRect(800, 250, 500, 100, 40, 60);
			g.setColor(Color.WHITE);
			g.setFont(new Font("휴먼매직체", Font.BOLD, 50));
			g.drawString("더 조은  W . M . S", 860, 322);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new LoginUi();

	}

}

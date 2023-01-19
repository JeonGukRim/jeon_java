package MyProject;

import java.awt.BorderLayout;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SubBtnListener2 extends JFrame {
	private JPanel mainP = new JPanel(); // 메인패널
	private JPanel northP = new JPanel(); //
	private JPanel testP = new JPanel(); //
	private JPanel centerP = new JPanel(); //
	private JPanel southP = new JPanel(); //
	private ResultSet rs = null;
	private String text = null;
	private String loginid;
	private LoginUi l;
	
////////////////////////////발주서 생성기능//////////////////////////////////////
	private JLabel headname = new JLabel("발주서 생성");
	private JLabel order = new JLabel("오더번호");
	private JLabel ordernum = new JLabel();
	private JLabel skuCode = new JLabel("SKU코드:");
	private JTextField codeTf = new JTextField(20);
	private JLabel skuName = new JLabel("제품명:");
	private JLabel skuNamedata = new JLabel();
	private JLabel kind = new JLabel("분류:");
	private JLabel kinddata = new JLabel();
	private JLabel innum = new JLabel("입고예정수량:");
	private JTextField inTf = new JTextField(20);
	private JButton creatBtn = new JButton("생성");
	private JButton upBtn = new JButton("새로고침");
	private Boolean exp = true;
	private PreparedStatement pstmtInsert = null;
	private PreparedStatement pstmtUpdate = null;
	private PreparedStatement pstmtDelete = null;
	private String formatedNow = null;
	
	public SubBtnListener2(JPanel mainP, String text, String loginid, JFrame frame) {
		this.mainP = mainP;
		this.text = text;
		this.loginid = loginid;
		l = (LoginUi) frame;
		mainP.setLayout(new BorderLayout());
		LocalDateTime now = LocalDateTime.now();
		formatedNow = now.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
		
		
		
		
		
		
	}
}

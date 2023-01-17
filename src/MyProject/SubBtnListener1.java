package MyProject;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SubBtnListener1 extends JFrame {
	private JPanel mainP = new JPanel(); // 메인패널
	private JPanel northP = new JPanel(); //
	private JPanel testP = new JPanel(); //
	private JPanel centerP = new JPanel(); //
	private JPanel southP = new JPanel(); //

	private Connection conn;
	private Statement stmt = null;
	private ResultSet rs = null;
	private String text = null;
//	// 테이블에 조회될 데이터
//	private Vector data = null;
//	// 테이블 컬러 타이틀
//	private Vector title = null;
//	// 테이블 객체
//	private JTable table = null;
//	// 테이블과 내용 담는 객체
//	private DefaultTableModel model = null;
//	private Vector result;
//	private PreparedStatement pstmtAdd = null;

	private JLabel headname = new JLabel("발주서 생성");
	private JLabel order = new JLabel("오더번호");
	private JLabel ordernum;
	private JLabel skuCode = new JLabel("SKU코드:");
	private JTextField codeTf = new JTextField(20);
	private JLabel skuName = new JLabel("제품명:");
	private JLabel skuNamedata;
	private JLabel kind = new JLabel("분류:");
	private JLabel kinddata;
	private JLabel innum = new JLabel("입고예정수량:");
	private JTextField inTf = new JTextField(20);
	private JButton creatBtn = new JButton("생성");
	private JButton cancelBtn = new JButton("취소");

	public SubBtnListener1(JPanel mainP, String text) {
		this.mainP = mainP;
		this.text = text;
		mainP.setLayout(new BorderLayout());

		if (text.equals("발주서 생성")) {
			mainP.removeAll();
			DbClass();
			locationSetting();
			codeTf.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					try {
						rs = stmt.executeQuery("select * from productlist where sku_code ='" + codeTf.getText() + "';");
						if(rs.next()) {
						while (rs.next()) {
							skuNamedata.setText(rs.getString("sku_name"));
							kinddata.setText(rs.getString("sku_kind"));
						}
						}else {
							JOptionPane.showMessageDialog(null,"존재하지 않는 코드 입니다\n코드를 새로 생성후 진행하세요!","입력오류",1);
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			creatBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
			
//			model.setDataVector(result, title);
//			table = new JTable(model);
//			JScrollPane sp = new JScrollPane(table);
//			jp.add(sp, BorderLayout.CENTER);
//			jp.add(upPanel, BorderLayout.SOUTH);
//			result = null;
		}
	}

	public void locationSetting() {

		LocalDateTime now = LocalDateTime.now();
		String formatedNow = now.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
		// 현재 시간으로 오더번호 생성 입고는 IO,출고는 OP로 시작;
		ordernum = new JLabel("IO" + formatedNow);
		headname.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		mainP.add(headname, BorderLayout.NORTH);
		centerP.setLayout(new GridLayout(5, 2));
		order.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		ordernum.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		centerP.add(order, ordernum);
		centerP.add(ordernum);
		skuNamedata = new JLabel();
		kinddata = new JLabel();
		centerP.add(skuCode);
		centerP.add(codeTf);
		centerP.add(skuName);
		centerP.add(skuNamedata);
		centerP.add(kind);
		centerP.add(kinddata);
		centerP.add(innum);
		centerP.add(inTf);
		testP.add(centerP, BorderLayout.NORTH);
		southP.add(creatBtn);
		southP.add(cancelBtn);
		mainP.add(testP, BorderLayout.CENTER);
		mainP.add(southP, BorderLayout.SOUTH);
	}

	public void DbClass() {
		try {
			Class.forName("com.mysql.jdbc.Driver"); // MySQL 드라이버 로드
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myproject", "root", "test123"); // JDBC 연결
			stmt = conn.createStatement(); // SQL문 처리용 Statement 객체 생성
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 오류");
		} catch (SQLException e1) {
			System.out.println("실행오류");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		JLabel headname = new JLabel("발주서 생성");
//		System.out.print(headname.getText());

	}

}

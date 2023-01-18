package MyProject;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
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

	/*--------------------발주서 생성기능-------------------------------*/
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
	private JButton upBtn = new JButton("새로고침");
	private Boolean exp = true;
	private PreparedStatement pstmtInsert = null;
	private String formatedNow = null;
	/*---------------------입고---------------------------------*/
	private JButton view = new JButton("조회");
	private JComboBox<String> orderCombo;
	private JLabel realinNumJl = new JLabel("실제 입고수량:");
	private JLabel skuCodeJl, indata, skuLocation, skuLocationdata;
	private JTextField realinNumTf = new JTextField(20);
	private JButton inBtn = new JButton("입고완료");

	public SubBtnListener1(JPanel mainP, String text) {
		this.mainP = mainP;
		this.text = text;
		mainP.setLayout(new BorderLayout());
		LocalDateTime now = LocalDateTime.now();
		formatedNow = now.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
		DbClass();
		/*-------------------------------------------------------------------------------------------*/
		if (text.equals("발주서 생성")) {
			mainP.removeAll();
			locationSetting();
			codeTf.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					JTextField t = (JTextField) e.getSource();
					try {
						rs = stmt.executeQuery("select * from productlist where sku_code ='" + t.getText() + "';");
						if (rs.isBeforeFirst()) { // 데이터가 존재하면 true를 반환해줌
							while (rs.next()) {
								skuNamedata.setText(rs.getString("sku_name"));
								kinddata.setText(rs.getString("sku_kind"));
							}
							exp = false;
							t.setEditable(exp);
						} else {
							skuNamedata.setText("");
							kinddata.setText("");
							JOptionPane.showMessageDialog(null, "존재하지 않는 코드 입니다\n코드를 새로 생성후 진행하세요!", "입력오류", 1);
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			upBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					exp = true;
					skuNamedata.setText("");
					kinddata.setText("");
					codeTf.setEditable(exp);
				}
			});

			creatBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if (exp == false && inTf.getText().length() != 0) {
						creat(codeTf.getText(), skuNamedata.getText(), kinddata.getText(),
								Integer.parseInt(inTf.getText()), ordernum.getText());
						skuNamedata.setText("");
						kinddata.setText("");
						inTf.setText("");
						exp = true;
						codeTf.setText("");
						codeTf.setEditable(exp);

						// 발주내역 추가후 새로운 오더번호 받기
						LocalDateTime now = LocalDateTime.now();
						formatedNow = now.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
						ordernum.setText("IO" + formatedNow);
						JOptionPane.showMessageDialog(null, "발주신청이 생성되였습니다", "알림", 1);
					} else
						JOptionPane.showMessageDialog(null, "입력정보를 확인해주세요", "알림", 1);
				}
			});

		}

		/*-------------------------------------------------------------------------------------------*/
		if (text.equals("입고")) {
			resetP();
			locationSetting1();

		}

	}

	public void locationSetting() { // 발주서생성 세팅

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
		southP.add(upBtn);
		mainP.add(testP, BorderLayout.CENTER);
		mainP.add(southP, BorderLayout.SOUTH);
	}

	public void locationSetting1() { // 입고 세팅
		Vector orderlist = new Vector<>();
		try {
			rs = stmt.executeQuery("select * from iohistory where complete ='yet' and oder_kind ='입고'");
			while (rs.next()) {
				String orderNum = rs.getString("ordernum");
				orderlist.add(orderNum);
			}
			orderCombo = new JComboBox<String>(orderlist);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		northP.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 0));
		northP.add(order);
		northP.add(orderCombo);
		northP.add(view);
		mainP.add(northP, BorderLayout.NORTH);
		
		testP.setLayout(new GridLayout(6,2,40,40));
		testP.add(skuCode);
		testP.add(skuCode);
//		testP.add(skuCodeJl);
		testP.add(skuName);
		testP.add(skuName);
//		testP.add(skuNamedata);
		testP.add(kind);
		testP.add(kind);
//		testP.add(kinddata);
		testP.add(innum);
		testP.add(innum);
//		testP.add(indata);
		testP.add(innum);
		testP.add(innum);
//		testP.add(skuLocation);
//		testP.add(skuLocationdata);
		testP.add(realinNumJl);
		testP.add(realinNumTf);
		centerP.add(testP,BorderLayout.NORTH);
		mainP.add(centerP, BorderLayout.CENTER);
		
		
		
		

	}

	// 모드 패널 리셋
	public void resetP() {
		mainP.removeAll();
		northP.removeAll();
		southP.removeAll();
		centerP.removeAll();
		testP.removeAll();
		validate();
		mainP.repaint();
		northP.repaint();
		southP.repaint();
		centerP.repaint();
		testP.repaint();

	}

	// db에 연결
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

	// 발주서 추가
	public void creat(String sku, String name, String kind, int num, String order) {

		try {
			pstmtInsert = conn.prepareStatement(
					"insert into iohistory(sku_code,sku_name,sku_kind,ordernum,ex_num,oder_kind,complete) values( ?,? ,"
							+ "? ,?,?,?,?)");
			pstmtInsert.setString(1, sku);
			pstmtInsert.setString(2, name);
			pstmtInsert.setString(3, kind);
			pstmtInsert.setString(4, order);
			pstmtInsert.setInt(5, num);
			pstmtInsert.setString(6, "입고");
			pstmtInsert.setString(7, "yet");
			pstmtInsert.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

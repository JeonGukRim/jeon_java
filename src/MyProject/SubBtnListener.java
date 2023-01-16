package MyProject;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class SubBtnListener extends JFrame  {
	private JPanel jp = new JPanel();
	private Connection conn;
	private Statement stmt = null;
	private ResultSet rs = null;
	private String text = null;
	// 테이블에 조회될 데이터
	private Vector data = null;
	// 테이블 컬러 타이틀
	private Vector title = null;
	// 테이블 객체
	private JTable table = null;
	// 테이블과 내용 담는 객체
	private DefaultTableModel model = null;
	
	// 조회 메뉴하 재고현황조회,입출고이력,메모 수정 레이블 과 버튼
	private JLabel searchJl1 = new JLabel("SKU코드");
	private JLabel searchJl2 = new JLabel("제품명");
	private JTextField searchTf1 = new JTextField(20);
	private JTextField searchTf2 = new JTextField(20);
	private JButton searchBtn = new JButton("검색");
	private JPanel searchPanel = new JPanel();
	private JButton memoupBtn = new JButton("수정");
	private JTextField memoupTf = new JTextField(20);
	
	
	
	private Vector result;

//	{ "재고현황조회", "검색", "입출고 이력조회", "발주서 생성", "입고", "Location정보", "출고오더생성", "재고이동", "상품정보조회",
//	"ID정보관리" };
	public SubBtnListener(JPanel jp, String text) {
		this.jp = jp;
		this.text = text;
		DbClass();
		jp.setLayout(new BorderLayout());
		title = new Vector<>();
		data = new Vector<>();
		model = new DefaultTableModel();
		if (text.equals("재고현황조회") || text.equals("검색")) {
			title.add("SKU번호");
			title.add("제품명");
			title.add("분류");
			title.add("재고위치");
			title.add("수량");
			title.add("메모");
			
			if (text.equals("재고현황조회")) {
				jp.removeAll();
//				result = allData();
				re();
				model.setDataVector(result, title);
				table = new JTable(model);
				JScrollPane sp = new JScrollPane(table);
				jp.add(sp, BorderLayout.CENTER);
				result = null;
			} else if (text.equals("검색")) {
				jp.removeAll();
//				result = allData();
				re();
				model.setDataVector(null, title);
				table = new JTable(model);
				JScrollPane sp = new JScrollPane(table);
				searchPanel.add(searchJl1);
				searchPanel.add(searchTf1);
				searchPanel.add(searchJl2);
				searchPanel.add(searchTf2);
				searchPanel.add(searchBtn);
				jp.add(searchPanel, BorderLayout.NORTH);
				jp.add(sp, BorderLayout.CENTER);
//				jp.add();
				searchBtn.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub

//						result = allData();
						re();
						model.setDataVector(result, title);
					}
				});
				result = null;
			}
		}

	}

	// 데이터 받아 넣기
	public void re() {
		result = allData();
	}

	// 데이터 베이서 연결
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

	// 모든 데이터 조회
	public Vector allData() {
		data.clear();
		try {
			if (text.equals("재고현황조회")) {
				rs = stmt.executeQuery("select * from listdb order by sku_code");
			} else if (text.equals("검색")) {
				rs = stmt.executeQuery("select * from listdb where" + " sku_code = '" + searchTf1.getText() + "' or"
						+ " sku_name = '" + searchTf2.getText() + "';");
			}

			while (rs.next()) {
				Vector in = new Vector<String>(); //
				String sku_code = rs.getString("sku_code");
				String sku_name = rs.getString("sku_name");
				String sku_kind = rs.getString("sku_kind");
				String sku_location = rs.getString("sku_location");
				int sku_finalnum = rs.getInt("sku_finalnum");
				String menmo = rs.getString("memo");
//				벡터에 각각의 값 추가
				in.add(sku_code);
				in.add(sku_name);
				in.add(sku_kind);
				in.add(sku_location);
				in.add(sku_finalnum);
				in.add(menmo);
//				전체 데이터를 저장하는 벡터에 in 벡터 추가
				data.add(in);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data; // 전체 데이터 저장하는 data 벡터 리턴
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

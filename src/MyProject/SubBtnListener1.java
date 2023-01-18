package MyProject;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class SubBtnListener1 extends JFrame {
	private JPanel mainP = new JPanel(); // 메인패널
	private JPanel northP = new JPanel(); //
	private JPanel testP = new JPanel(); //
	private JPanel centerP = new JPanel(); //
	private JPanel southP = new JPanel(); //
	private ResultSet rs = null;
	private String text = null;




	/*--------------------발주서 생성기능-------------------------------*/
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
	private String formatedNow = null;
	/*---------------------입고---------------------------------*/
	private JButton view = new JButton("조회");
	private JComboBox<String> orderCombo;
	private JLabel realinNumJl = new JLabel("실제 입고수량:");
	private JLabel skuCodeJl = new JLabel();
	private JLabel indata = new JLabel();
	private JTextField realinNumTf = new JTextField(20);
	private JLabel skuLocation = new JLabel("재고위치:(Enter키로확인)");
	private JTextField skuLocationTf = new JTextField(20);
	private JButton inBtn = new JButton("입고완료");
	/*---------------------Location정보-------------------------*/
	private JButton addBtn = new JButton("추가");
	private JTextField loTf = new JTextField(20);
	private JButton delBtn = new JButton("삭제");
	private JButton seaBtn = new JButton("검색");
	private Vector data = null;
	private Vector title = null;
	private JTable table = null;
	private DefaultTableModel model = null;
	private Vector result;
	private PreparedStatement pstmtDel = null;
	
	
	
	
	
	private String loginid;
	private LoginUi l;
	
	public SubBtnListener1() {}
	public SubBtnListener1(JPanel mainP, String text,String loginid,JFrame frame) {
		this.mainP = mainP;
		this.text = text;
		this.loginid = loginid;
		l =(LoginUi)frame;
		mainP.setLayout(new BorderLayout());
		LocalDateTime now = LocalDateTime.now();
		formatedNow = now.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
//		DbClass();
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
						rs = l.stmt.executeQuery("select * from productlist where sku_code ='" + t.getText() + "';");
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
			view.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String select = orderCombo.getSelectedItem().toString();
					if (orderCombo != null) {
						try {
							ResultSet rs = l.stmt.executeQuery("select * from iohistory where ordernum ='"
									+ select + "'");
							while (rs.next()) {
								skuCodeJl.setText(rs.getString("sku_code"));
								skuNamedata.setText(rs.getString("sku_name"));
								kinddata.setText(rs.getString("sku_kind"));
								indata.setText(rs.getString("ex_num"));
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
					// 재고위치 정보 존재여부 판단
					skuLocationTf.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							try {
								ResultSet rs = l.stmt.executeQuery
										("select * from locationdb  where sku_location = '"+skuLocationTf.getText()+"'");
								if(!rs.isBeforeFirst()) {
									JOptionPane.showMessageDialog(null, "존재하지 않는 재고위치입니다", "입력오류", 1);
									skuLocationTf.setText("");
								}else {
									JOptionPane.showMessageDialog(null, "확인되였습니다", "OK", 1);
								}
							
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					});	
					
					//입고완료 저장
					inBtn.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
//							loginTf.getText();
//							LoginUi()
							LocalDateTime now = LocalDateTime.now();
							formatedNow = now.format(DateTimeFormatter.ofPattern("yyyy년MM월dd일HH시mm분"));
							try {
								
								//입출고 이력에 실제 입고수량 날짜 작업자 id 저장
								if(Integer.parseInt(realinNumTf.getText()) <= Integer.parseInt(indata.getText())&& !skuLocationTf.getText().equals("")) {
								pstmtUpdate = l.conn.prepareStatement(
										"update  iohistory set realnum = ?,complete = ?,worker_id = ?,work_date = ? where ordernum =?");
								pstmtUpdate.setInt(1,Integer.parseInt(realinNumTf.getText()));
								pstmtUpdate.setString(2,"over");  //작업끝났으면 오버로 표시
								pstmtUpdate.setString(3,loginid);
								pstmtUpdate.setString(4,formatedNow);
								pstmtUpdate.setString(5,select);
								pstmtUpdate.executeUpdate();
								
								}else {
									JOptionPane.showMessageDialog(null, "입력값을 확인해주세요", "에러", JOptionPane.ERROR_MESSAGE);
								}
								
								
								//리스트에 같은 제품과 재고위치에 재고가 존재한다면 재고 추가
								if(Integer.parseInt(realinNumTf.getText()) <= Integer.parseInt(indata.getText())&& !skuLocationTf.getText().equals("")) {
								rs=l.stmt.executeQuery
								("select * from listdb  where sku_location = '"+skuLocationTf.getText()+"' and sku_code='"+
								skuCodeJl.getText() +"'");
								if(rs.isBeforeFirst()) {
									int num = 0;
									pstmtUpdate = l.conn.prepareStatement
											("update listdb set sku_finalnum = ? where sku_location = ? and sku_code = ?");
									while(rs.next()) {
									num = rs.getInt("sku_finalnum");
									}
									
									num += Integer.parseInt(realinNumTf.getText());
									pstmtUpdate.setInt(1, num);
									pstmtUpdate.setString(2, skuLocationTf.getText());
									pstmtUpdate.setString(3, skuCodeJl.getText());
									pstmtUpdate.executeUpdate();
								}
								else{
									pstmtInsert = l.conn.prepareStatement(
											"insert into listdb(sku_code,sku_name,sku_kind,sku_location,sku_finalnum) values( ?,? ,"
													+ "? ,?,?)");
									int num1 = Integer.parseInt(realinNumTf.getText());
									pstmtInsert.setString(1,skuCodeJl.getText());
									pstmtInsert.setString(2,skuNamedata.getText());
									pstmtInsert.setString(3,kinddata.getText());
									pstmtInsert.setString(4,skuLocationTf.getText());
									pstmtInsert.setInt(5,num1);
									pstmtInsert.executeUpdate();
								}
								
								orderCombo.removeAll();
								skuCodeJl.setText("");
								skuNamedata.setText("");
								kinddata.setText("");
								indata.setText("");
								realinNumTf.setText("");
								skuLocationTf.setText("");
								resetP();
								locationSetting1();
								JOptionPane.showMessageDialog(null, "입고완료 되였습니다", "알림", 1);
								}
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						
					});
					
					
				}
			});
		}
		if (text.equals("Location정보")) {
			resetP();
			locationSetting2();
			
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
		creatComboBox();
		northP.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 0));
		northP.add(order);
		northP.add(orderCombo);
		northP.add(view);
		mainP.add(northP, BorderLayout.NORTH);

		testP.setLayout(new GridLayout(6, 2, 40, 40));
		testP.add(skuCode);
		testP.add(skuCodeJl);
		testP.add(skuName);
		testP.add(skuNamedata);
		testP.add(kind);
		testP.add(kinddata);
		testP.add(innum);
		testP.add(indata);
		testP.add(skuLocation);
		testP.add(skuLocationTf);
		testP.add(realinNumJl);
		testP.add(realinNumTf);
		centerP.add(testP, BorderLayout.NORTH);
		mainP.add(centerP, BorderLayout.CENTER);

		southP.add(inBtn);
		mainP.add(southP, BorderLayout.SOUTH);

	
	}

	public void locationSetting2() {// 재고위치 세팅
		
		northP.setLayout(new FlowLayout(FlowLayout.LEFT,40,0));
		northP.add(new JLabel("추가/삭제 재고위치 >>"));
		northP.add(loTf);
		northP.add(seaBtn);
		northP.add(addBtn);
		northP.add(delBtn);
		mainP.add(northP,BorderLayout.NORTH);
		
		title = new Vector<>();
		data = new Vector<>();
		model = new DefaultTableModel();
		model.setDataVector(result, title);
		table = new JTable(model);
		JScrollPane sp = new JScrollPane(table);
		
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

	public void creatComboBox() {
		Vector orderlist = new Vector<>();
		try {
			rs = l.stmt.executeQuery("select * from iohistory where complete ='yet' and oder_kind ='입고'");
			while (rs.next()) {
				String orderNum = rs.getString("ordernum");
				orderlist.add(orderNum);
			}
			orderCombo = new JComboBox<String>(orderlist);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// db에 연결
//	public void DbClass() {
//		try {
//			Class.forName("com.mysql.jdbc.Driver"); // MySQL 드라이버 로드
//			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myproject", "root", "test123"); // JDBC 연결
//			stmt = conn.createStatement(); // SQL문 처리용 Statement 객체 생성
//		} catch (ClassNotFoundException e) {
//			System.out.println("드라이버 로드 오류");
//		} catch (SQLException e1) {
//			System.out.println("실행오류");
//		}
//	}

	// 발주서 추가
	public void creat(String sku, String name, String kind, int num, String order) {

		try {
			pstmtInsert = l.conn.prepareStatement(
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

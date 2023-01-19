package MyProject;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class SubBtnListener2 extends JFrame {
	private JPanel mainP = new JPanel(); // 메인패널
	private JPanel northP = new JPanel(); //
	private JPanel testP = new JPanel(); //
	private JPanel centerP = new JPanel(); //
	private JPanel southP = new JPanel(); //
	private PreparedStatement pstmtInsert = null;
	private PreparedStatement pstmtUpdate = null;
	private PreparedStatement pstmtDelete = null;
	private String formatedNow = null;
	private ResultSet rs = null;
	private String text = null;
	private String loginid;
	private LoginUi l;
	private Vector data = null;
	private Vector title = null;
	private JTable table = null;
	private DefaultTableModel model = null;
	private Vector result;

////////////////////////////출고 오더 생성기능//////////////////////////////////////
	private JLabel headname = new JLabel("출고오더 생성");
	private JLabel order = new JLabel("오더번호");
	private JLabel ordernum = new JLabel();
	private JLabel skuCode = new JLabel("SKU코드:");
	private JTextField codeTf = new JTextField(20);
	private JLabel skuName = new JLabel("제품명:");
	private JLabel skuNamedata = new JLabel();
	private JLabel sku_location = new JLabel("재고위치:");
	private JLabel locationdata = new JLabel();
	private JLabel finalNum = new JLabel("출고 가능 수량:");
	private JLabel finalNumdata = new JLabel();
	private JLabel outnum = new JLabel("출고예정수량:");
	private JTextField outnumTf = new JTextField(20);
	private JButton creatBtn = new JButton("생성");
	private JButton upBtn = new JButton("새로고침");
	private Boolean exp = true;

	public SubBtnListener2(JPanel mainP, String text, String loginid, JFrame frame) {
		this.mainP = mainP;
		this.text = text;
		this.loginid = loginid;
		l = (LoginUi) frame;
		mainP.setLayout(new BorderLayout());
		LocalDateTime now = LocalDateTime.now();
		formatedNow = now.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
		
		if (text.equals("출고오더생성")) {
			mainP.removeAll();
			locationSetting1();
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
								outnumTf.setText(rs.getString("sku_finalnum"));
								locationdata.setText(rs.getString("sku_location"));
							}
							exp = false;
							t.setEditable(exp);
						} else {
							skuNamedata.setText("");
							outnumTf.setText("");
							locationdata.setText("");
							JOptionPane.showMessageDialog(null, "존재하지 않는 코드 입니다\n코드를 새로 생성후 진행하세요!", "입력오류", 1);
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
	
		
			
		
		
		}
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	public void locationSetting1() {
		ordernum = new JLabel("OP" + formatedNow);
		headname.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		mainP.add(headname, BorderLayout.NORTH);
		centerP.setLayout(new GridLayout(6, 2));
		order.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		ordernum.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		centerP.add(order, ordernum);
		centerP.add(ordernum);
		centerP.add(skuCode);
		centerP.add(codeTf);
		centerP.add(skuName);
		centerP.add(skuNamedata);
		centerP.add(sku_location);
		centerP.add(locationdata);
		centerP.add(finalNum);
		centerP.add(finalNumdata);
		centerP.add(outnum);
		centerP.add(outnumTf);

		title = new Vector<>();
		data = new Vector<>();
		model = new DefaultTableModel();
		result = allData();
		title.add("SKU번호");
		title.add("제품명");
		title.add("분류");
		title.add("재고위치");
		title.add("수량");
		title.add("메모");
		model.setDataVector(result, title);
		table = new JTable(model);
		JScrollPane sp = new JScrollPane(table);
		testP.add(new JLabel("출고가능 제품리스트(더블 클릭)", JLabel.CENTER), BorderLayout.NORTH);
		testP.add(sp, BorderLayout.WEST);
		southP.add(creatBtn);
		southP.add(upBtn);
		mainP.add(testP, BorderLayout.CENTER);
		mainP.add(centerP, BorderLayout.WEST);
		mainP.add(southP, BorderLayout.SOUTH);
		// 클릭하여 데이터 가져 오기
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//마우스 더블 클릭하면 데이터 전송
				if (e.getClickCount() == 2 && exp == true) {
					int index = table.getSelectedRow();
					Vector in = (Vector) data.get(index);
					String sku_code = (String) in.get(0);
					String sku_name = (String) in.get(1);
					String sku_location = (String) in.get(3);
					String sku_finalnum = (String) in.get(4);
					codeTf.setText(sku_code);
					skuNamedata.setText(sku_name);
					locationdata.setText(sku_location);
					finalNumdata.setText(sku_finalnum);
					exp = false;
					codeTf.setEditable(exp);
				}
			}
		});
		result = null;	
	}

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

	public Vector allData() {
		data.clear();
		try {
				rs =l.stmt.executeQuery("select * from listdb order by sku_code");
			while (rs.next()) {
				Vector in = new Vector<String>(); //
				String sku_code = rs.getString("sku_code");
				String sku_name = rs.getString("sku_name");
				String sku_kind = rs.getString("sku_kind");
				String sku_location = rs.getString("sku_location");
				int sku_finalnum = rs.getInt("sku_finalnum");
				String menmo = rs.getString("memo");
				in.add(sku_code);
				in.add(sku_name);
				in.add(sku_kind);
				in.add(sku_location);
				in.add(sku_finalnum);
				in.add(menmo);
				data.add(in);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data; // 전체 데이터 저장하는 data 벡터 리턴
	}
	
	
	
}

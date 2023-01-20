package MyProject;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

public class SubBtnListener3 extends JFrame {
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
	private Vector data = new Vector<>();
	private Vector title = new Vector<>();
	private JTable table = null;
	private DefaultTableModel model = new DefaultTableModel();
	private Vector result;

////////////////////////////상품정보조회//////////////////////////////////////	
	private JLabel skuName1 = new JLabel("제품명:");
	private JLabel skuName2 = new JLabel("제품명:");
	private JLabel check = new JLabel("(Enter로 중복체크)");
	private JLabel skuKind = new JLabel("분류:");
	private JLabel skuCode = new JLabel("SKU번호:");
	private JTextField searchTf = new JTextField(20);
	private JTextField skucodeTf = new JTextField(10);
	private JTextField skunameTf = new JTextField(10);
	private JTextField skukindTf = new JTextField(10);
	private JButton searchBtn = new JButton("검색");
	private JButton addBtn = new JButton("추가");
	private JButton upBtn = new JButton("수정");
	private JButton delBtn = new JButton("삭제");
	private JButton resetBtn = new JButton("초기화");
	private boolean popup = true;
	private String skucode = null;

	public SubBtnListener3(JPanel mainP, String text, String loginid, JFrame frame) {
		this.mainP = mainP;
		this.text = text;
		this.loginid = loginid;
		l = (LoginUi) frame;
		mainP.setLayout(new BorderLayout());
		if (text.equals("상품정보조회")) {
			resetP();
			locationSetting1();
			addBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String code = skucodeTf.getText();
					String name = skunameTf.getText();
					String kind = skukindTf.getText();
					if (code.trim().isEmpty() || name.trim().isEmpty() || kind.trim().isEmpty()) {
						JOptionPane.showMessageDialog(null, "입력값을 확인해주세요", "에러", JOptionPane.ERROR_MESSAGE);
						return;
					} else {
						add(code, name, kind);
						result = allData();
						model.setDataVector(result, title);
						if (popup) {
							JOptionPane.showMessageDialog(null, "추가 되였습니다", "알림", JOptionPane.DEFAULT_OPTION);
						}
					}
				}
			});

			searchBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String search = searchTf.getText();
					if (search.trim().isEmpty()) {
						JOptionPane.showMessageDialog(null, "검색할 내용을 입력해주세요", "알림", JOptionPane.DEFAULT_OPTION);
						return;
					} else {
						result = search(search);
						model.setDataVector(result, title);
					}
				}
			});
			resetBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					skucodeTf.setText("");
					skunameTf.setText("");
					skukindTf.setText("");
				}
			});

			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					// 마우스 더블 클릭하면 데이터 전송
					int index = table.getSelectedRow();
					Vector in = (Vector) data.get(index);
					skucode = (String) in.get(0);
				}
			});
			delBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					delete(skucode);
					skucode = null;
					result = allData();
					model.setDataVector(result, title);
				}
			});
			upBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String code = skucodeTf.getText();
					String name = skunameTf.getText();
					String kind = skukindTf.getText();
					update(code,name,kind);
					result = allData();
					model.setDataVector(result, title);
				}
			});
		}
	}

	public void locationSetting1() {
		northP.add(skuName1);
		northP.add(searchTf);
		northP.add(searchBtn);
		mainP.add(northP, BorderLayout.NORTH);
		title.add("SKU번호");
		title.add("제품명");
		title.add("분류");
		title.add("보유 재고수량");
		result = allData();
		model.setDataVector(result, title);
		table = new JTable(model);
		JScrollPane sp = new JScrollPane(table);
		mainP.add(sp, BorderLayout.CENTER);
		southP.add(skuCode);
		southP.add(skucodeTf);
		southP.add(skuName2);
		southP.add(skunameTf);
		southP.add(skuKind);
		southP.add(skukindTf);
		southP.add(addBtn);
		southP.add(upBtn);
		southP.add(delBtn);
		southP.add(resetBtn);
		mainP.add(southP, BorderLayout.SOUTH);

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

	public void add(String code, String name, String kind) {
		try {
			pstmtInsert = l.conn.prepareStatement("insert into productlist(sku_code,sku_name,sku_kind) values(?,?,?)");
			pstmtInsert.setString(1, code);
			pstmtInsert.setString(2, name);
			pstmtInsert.setString(3, kind);
			pstmtInsert.executeUpdate();
			popup = true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "이미존재하는 SKU번호입니다", "에러", JOptionPane.ERROR_MESSAGE);
			popup = false;
			e.printStackTrace();
		}
	}

	public void delete(String code) {
		try {
			rs = l.stmt.executeQuery("select * from listdb where sku_code ='" + code + "'");
			if (rs != null && rs.isBeforeFirst()) {
				JOptionPane.showMessageDialog(null, "현재 사용중인 코드입니다", "에러", JOptionPane.ERROR_MESSAGE);
			} else {
				pstmtDelete = l.conn.prepareStatement("delete from productlist where sku_code = ?");
				pstmtDelete.setString(1, code);
				pstmtDelete.executeUpdate();
				rs = l.stmt.executeQuery("select * from productlist where sku_code ='" + code + "'");
				if (rs != null &&rs.isBeforeFirst()) {
					return;
				} else {
					JOptionPane.showMessageDialog(null, "삭제되였습니다", "알림", JOptionPane.DEFAULT_OPTION);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void update(String code,String name ,String kind) {
			try{
				pstmtUpdate = l.conn.prepareStatement("update member set name = ?, address = ? where num = ?");
				pstmtUpdate.setString(1, code);
				pstmtUpdate.setString(2, name);
				pstmtUpdate.setString(3, kind);
				pstmtUpdate.executeUpdate();
			}catch(Exception e){
				e.printStackTrace();
		}	
	}
	
	
	
	public Vector search(String search) {
		data.clear();
		try {
			rs = l.stmt.executeQuery("select * from productlist p left join (select sku_code, SUM(sku_finalnum) as "
					+ "total from listdb group by sku_code) s on p.sku_code = s.sku_code where sku_name like '%"
					+ search + "%'");
			while (rs.next()) {
				Vector in = new Vector<String>(); //
				String sku_code = rs.getString("sku_code");
				String sku_name = rs.getString("sku_name");
				String sku_kind = rs.getString("sku_kind");
				String total_num = rs.getString("total");
				in.add(sku_code);
				in.add(sku_name);
				in.add(sku_kind);
				in.add(total_num);
				data.add(in);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data; // 전체 데이터 저장하는 data 벡터 리턴
	}

	public Vector allData() {
		data.clear();
		try {
			rs = l.stmt.executeQuery("select * from productlist p left join (select sku_code, SUM(sku_finalnum) as "
					+ "total from listdb group by sku_code) s on p.sku_code = s.sku_code");
			while (rs.next()) {
				Vector in = new Vector<String>(); //
				String sku_code = rs.getString("sku_code");
				String sku_name = rs.getString("sku_name");
				String sku_kind = rs.getString("sku_kind");
				String total_num = rs.getString("total");
				in.add(sku_code);
				in.add(sku_name);
				in.add(sku_kind);
				in.add(total_num);
				data.add(in);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data; // 전체 데이터 저장하는 data 벡터 리턴
	}

}

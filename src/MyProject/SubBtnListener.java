package MyProject;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class SubBtnListener extends JFrame {
	private JPanel jp = new JPanel();// 메인 패널
	private ResultSet rs = null;
	private String text = null;
	private Vector data = null;
	private Vector title = null;
	private JTable table = new JTable();
	private DefaultTableModel model = null;
	private Vector result;

	// 조회 메뉴하 재고현황조회,입출고이력,메모 수정 레이블 과 버튼
	private JLabel searchJl1 = new JLabel("SKU코드");
	private JLabel searchJl2 = new JLabel("제품명");
	private JTextField searchTf1 = new JTextField(20);
	private JTextField searchTf2 = new JTextField(20);
	private JButton searchBtn = new JButton("검색");
//	private JPanel searchPanel = new JPanel();
	private JLabel skuJl = new JLabel("SKU코드 :");
	private JTextField skuCode = new JTextField(20);
	private JLabel memoupJl = new JLabel("메모 수정");
	private JButton memoupBtn = new JButton("저장");
	private JTextField memoupTf = new JTextField(20);
	private JPanel upPanel = new JPanel();
	private PreparedStatement pstmtUpdate = null;
	private LoginUi l;
	// 입출고 내역 필요 객체 선언;
	private JRadioButton[] radio = new JRadioButton[3];
	private String[] colName = { "전체", "입고", "출고" };
	private JPanel centerPanel = new JPanel();
	private JPanel northP = new JPanel();
	private JPanel southP = new JPanel();
	public SubBtnListener() {
	}

	public SubBtnListener(JPanel jp, String text, String loginid, JFrame frame) {
		// TODO Auto-generated constructor stub
		this.jp = jp;
		this.text = text;
		l = (LoginUi) frame;
		jp.setLayout(new BorderLayout());
		title = new Vector<>();
		data = new Vector<>();
		model = new DefaultTableModel();
		if (text.equals("재고현황조회")) {
			resetP();
			title.clear();
			table.removeAll();
			title.add("SKU번호");
			title.add("제품명");
			title.add("분류");
			title.add("재고위치");
			title.add("수량");
			title.add("메모");
			southP.add(skuJl);
			southP.add(skuCode);
			southP.add(memoupJl);
			southP.add(memoupTf);
			southP.add(memoupBtn);
			// 조회된 내역에서 메모 내역 수정 버튼
			memoupBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String code = skuCode.getText();
					String memo = memoupTf.getText();
					update(code, memo);
					re(); // 데이터 값 가져오기
					model.setDataVector(result, title);
				}
			});
//			jp.removeAll();
			re(); // 데이터 값 가져오기
			model.setDataVector(result, title);
			table = new JTable(model);
			JScrollPane sp = new JScrollPane(table);
			jp.add(sp, BorderLayout.CENTER);
			jp.add(southP, BorderLayout.SOUTH);
			result = null;
		} else if (text.equals("입출고 이력조회")) {
			resetP();
			ButtonGroup g = new ButtonGroup();
			for (int i = 0; i < radio.length; i++) {
				radio[i] = new JRadioButton(colName[i]);
				g.add(radio[i]);
				upPanel.add(radio[i]);
				radio[i].addItemListener(new radioListener());
			}
			radio[0].setSelected(true);
			jp.add(upPanel, BorderLayout.NORTH);
			title.clear();
			table.removeAll();
			String[] colName1 = { "SKU코드", "제품명", "종류", "오더번호", "입/출", "작업일자", "예정수량", "실제수량","작업자", "작업현황", "재고위치" };
			for (int i = 0; i < colName1.length; i++) {
				title.add(colName1[i]);
			}
			result = allData();
			model.setDataVector(result, title);
			table = new JTable(model);
			JScrollPane sp = new JScrollPane(table);
			jp.add(sp, BorderLayout.CENTER);
		}

	}

	// 데이터 받아 넣기
	public void re() {
		result = allData();
	}

	private void update(String code, String memo) {
		try {
			pstmtUpdate = l.conn.prepareStatement("update listdb set memo = ? where sku_code = ?");
			pstmtUpdate.setString(1, memo);
			pstmtUpdate.setString(2, code);
			pstmtUpdate.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 모든 데이터 조회
	public Vector allData() {
		data.clear();
		try {
			if (text.equals("재고현황조회")) {
				rs = l.stmt.executeQuery("select * from listdb order by sku_code");
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

			} else {
				if(radio[0].isSelected())
				rs = l.stmt.executeQuery("select * from iohistory order by sku_code");
				else if(radio[1].isSelected())
					rs = l.stmt.executeQuery("select * from iohistory where oder_kind = '입고'");
				else
					rs = l.stmt.executeQuery("select * from iohistory where oder_kind = '출고'");
				
				while (rs.next()) {
					Vector in = new Vector<String>(); //
					String sku_code = rs.getString("sku_code");
					String sku_name = rs.getString("sku_name");
					String sku_kind = rs.getString("sku_kind");
					String ordernum = rs.getString("ordernum");
					String orderkind = rs.getString("oder_kind");
					String work_date = rs.getString("work_date");
					String ex_num = rs.getString("ex_num");
					String realnum = rs.getString("realnum");
					String worker_id = rs.getString("worker_id");
					String complete = rs.getString("complete");
					String sku_location = rs.getString("sku_location");
					in.add(sku_code);
					in.add(sku_name);
					in.add(sku_kind);
					in.add(ordernum);
					in.add(orderkind);
					in.add(work_date);
					in.add(ex_num);
					in.add(realnum);
					in.add(worker_id);
					in.add(complete);
					in.add(sku_location);
					data.add(in);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data; // 전체 데이터 저장하는 data 벡터 리턴
	}

//레디오 리스너
	class radioListener implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			if (e.getStateChange() == ItemEvent.DESELECTED) {
				return;
			}
			if (radio[0].isSelected()) {
				result = allData();
				model.setDataVector(result, title);
			} else if (radio[1].isSelected()) {
				result = allData();
				model.setDataVector(result, title);
			} else {
				result = allData();
				model.setDataVector(result, title);
			}
		}

	}

	public void resetP() {
		jp.removeAll();
		upPanel.removeAll();
		northP.removeAll();
		centerPanel.removeAll();
		southP.removeAll();
		validate();
		jp.repaint();
		upPanel.repaint();
		centerPanel.repaint();
		northP.repaint();
		southP.repaint();
	}

}

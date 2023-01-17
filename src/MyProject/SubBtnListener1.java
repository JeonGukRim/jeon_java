package MyProject;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SubBtnListener1 extends JFrame {
	private JPanel mainP = new JPanel(); // 메인패널
	private JPanel northP = new JPanel(); //
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

	public SubBtnListener1(JPanel jp, String text) {
		mainP = jp;
		this.text = text;
		long time = System.currentTimeMillis();
		mainP.setLayout(new BorderLayout());

		if (text.equals("발주서 생성")) {
			mainP.removeAll();
			SimpleDateFormat simpl = new SimpleDateFormat("IOyyyyMMddaahhmmss");
			String s = simpl.format(time);
			ordernum = new JLabel(s);
			northP.setLayout(new BorderLayout());
			northP.add(headname, BorderLayout.NORTH);
			northP.add(order, BorderLayout.SOUTH);
			northP.add(ordernum, BorderLayout.SOUTH);
			
			centerP.setLayout(new GridLayout(2,4));
			centerP.add(skuCode);
			centerP.add(codeTf);
			centerP.add(skuName);
			centerP.add(skuNamedata);
			centerP.add(kind);
			centerP.add(kinddata);
			centerP.add(innum);
			centerP.add(inTf);
			
			northP.add(creatBtn);
			northP.add(cancelBtn);
			
			mainP.add(northP,BorderLayout.NORTH);
			mainP.add(centerP,BorderLayout.CENTER);
			mainP.add(southP,BorderLayout.SOUTH);

//			model.setDataVector(result, title);
//			table = new JTable(model);
//			JScrollPane sp = new JScrollPane(table);
//			jp.add(sp, BorderLayout.CENTER);
//			jp.add(upPanel, BorderLayout.SOUTH);
//			result = null;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		JLabel headname = new JLabel("발주서 생성");
//		System.out.print(headname.getText());

	}

}

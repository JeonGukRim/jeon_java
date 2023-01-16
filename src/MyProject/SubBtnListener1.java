package MyProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class SubBtnListener1 extends JFrame {
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
	private Vector result;
	private PreparedStatement pstmtAdd = null;
	
	public SubBtnListener1(JPanel jp, String text) {
		this.jp = jp;
		this.text = text;
		
		
		
	}
	







	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

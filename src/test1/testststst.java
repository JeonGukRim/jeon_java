package test1;

import java.awt.Container;
import java.awt.FlowLayout;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class testststst extends JFrame {
	private JTextField tf = new JTextField(20);
	private JLabel jl = new JLabel("땡떙");

	testststst() {
		tf.setText("555");
		tf.setEditable(false);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.add(jl);
		c.add(tf);
		setSize(400, 400);
		setVisible(true);

	}

	public static void main(String[] args) {
//		Connection conn;
//		Statement stmt = null;
//		try {
//			Class.forName("com.mysql.jdbc.Driver"); 
//			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myproject", "root", "test123"); // JDBC 연결
//			stmt = conn.createStatement(); 
//			System.out.println("연결됨");
//		} catch (ClassNotFoundException e) {
//			System.out.println("드라이버 로드 오류");
//		} catch (SQLException e1) {
//			System.out.println("실행오류");
//		}
//		ResultSet rs = stmt.executeQuery("select * from masterid");
//		while(rs.next()) {
//		System.out.println(rs.getString("id"));
//		System.out.println(rs.getString("pw"));
//		}

		new testststst();
		long time = System.currentTimeMillis();
		SimpleDateFormat simpl = new SimpleDateFormat("yyyyMMddaahhmmss");
		String s = simpl.format(time);
		System.out.print(time);

	}

}

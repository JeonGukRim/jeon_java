package test1;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class testststst extends JFrame {
	private JTextField tf = new JTextField(20);
	private JLabel jl = new JLabel("땡떙");
	static Connection conn;
	static Statement stmt = null;
	private ResultSet rs = null;
	testststst() {
		tf.setText("3");
//		tf.setEditable(false);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		LocalDateTime now = LocalDateTime.now();
        String formatedNow = now.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
		jl.setText("IO"+formatedNow);
		c.add(jl);
		c.add(tf);
		setSize(400, 400);
		setVisible(true);
		 dbclass();
		 try {
				rs=stmt.executeQuery("select * from listdb");
//						("select * from listdb  where sku_location = 'A-4-2' and sku_code='k123'");
//				 num = Integer.parseInt(tf.getText());
				String num1=null;
				String num =null;
				while(rs.next()) {	
				num=rs.getString("sku_finalnum");
				num1 =rs.getString("sku_location");
				}
				 System.out.println(num);
				 System.out.println(num1);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
//		 tf.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				try {
//					rs=stmt.executeQuery("select * from listdb where sku_location = 'A-4-1'");
////							("select * from listdb  where sku_location = 'A-4-2' and sku_code='k123'");
////					 num = Integer.parseInt(tf.getText());
//					String num1=null;
//					while(rs.next()) {	
//					num=rs.getInt("sku_finalnum");
//						 num1 =rs.getString("sku_location");
//					}
//					 System.out.println(num);
//					 System.out.println(num1);
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//		});
		
		
		
	}
	public void dbclass() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myproject", "root", "test123"); // JDBC 연결
			stmt = conn.createStatement();
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 오류");
		} catch (SQLException e1) {
			System.out.println("실행오류");
		}
	}
	public static void main(String[] args) {

		new testststst();
		 	
		LocalDateTime now = LocalDateTime.now();
		String formatedNow = now.format(DateTimeFormatter.ofPattern("yyyy년MM월dd일HH시mm분"));
//	        System.out.println(formatedNow);  // 2021년 06월 17일 06시 43분 21초
		
		
		System.out.println(formatedNow);
		
	}

}

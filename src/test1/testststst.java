package test1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class testststst {
			
	public static void main (String [] args) throws SQLException {
		Connection conn;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myproject", "root", "test123"); // JDBC 연결
			stmt = conn.createStatement(); 
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 오류");
		} catch (SQLException e1) {
			System.out.println("실행오류");
		}
		ResultSet rs = stmt.executeQuery("select * from masterid");
		System.out.println(rs.getString("id"));
		System.out.println(rs.getString("pw"));
	}

}

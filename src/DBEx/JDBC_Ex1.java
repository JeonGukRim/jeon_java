package DBEx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC_Ex1 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver"); //,mysql 드라이버 로드
			Connection conn = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/sampledb", "root", "test123");
			System.out.println("DB 연결 완료");
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 로드 예러");
		} catch (SQLException e) {
			System.out.println("DB 연결 오류");
		}
	}

}

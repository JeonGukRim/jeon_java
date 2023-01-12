package DBEx;

import java.io.*;
import java.sql.*;

public class JDBC_Ex2 {
	public static void main(String[] args) {
		Connection conn;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver"); // MySQL 드라이버 로드
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb", "root", "test123"); // JDBC 연결
			System.out.println("DB 연결 완료");
			stmt = conn.createStatement(); // SQL문 처리용 Statement 객체 생성
//			ResultSet srs = stmt.executeQuery("select * from student"); // 테이블의 모든 데이터 검색
//			ResultSet srs = stmt.executeQuery("select * from student where id like '%0%'"); // id에 0이 들어간것만찾기
			ResultSet srs = stmt.executeQuery("select S.stu_no,S.stu_name,E.enr_grade,SUB.sub_name " + "from student2 S"
					+ " inner join enrol E on E.stu_no = S.stu_no"
					+ " inner join subject SUB on SUB.sub_no = E.sub_no");

			printData(srs);
//			printData(srs, "stu_no", "stu_name", "enr_grade", "sub_name");
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 로드 오류");
		} catch (SQLException e) {
			System.out.println("SQL 실행오류");
		}
	}

	// 레코드의 각 열의 값 화면에 출력
//	private static void printData(ResultSet srs, String col1, String col2, String col3) throws SQLException {
//		while (srs.next()) {
//			if (!col1.equals(""))
////				System.out.print(srs.getString(1)); // 인덱스로도 컬러 표현 가능하다
//			System.out.print(srs.getString("name"));
//			if (!col2.equals(""))
//				System.out.print("\t|\t" + srs.getString("id"));
//			if (!col3.equals(""))
//				System.out.println("\t|\t" + srs.getString("dept"));
//			else
//				System.out.println();
//		}
//	}

//	private static void printData(ResultSet srs, String col1, String col2, String col3,String col4) throws SQLException {
//		while (srs.next()) {
//			if (!col1.equals(""))
////				System.out.print(srs.getString(1)); // 인덱스로도 컬러 표현 가능하다
//			System.out.print(srs.getString("stu_no"));
//			if (!col2.equals(""))
//				System.out.print("\t|\t" + srs.getString("stu_name"));
//			if (!col3.equals(""))
//				System.out.print("\t|\t" + srs.getString("enr_grade"));
//			if (!col4.equals(""))
//				System.out.println("\t|\t" + srs.getString("sub_name"));
//			else
//				System.out.println();
//		}
//	}
	private static void printData(ResultSet srs) throws SQLException {
		while (srs.next()) {
			System.out.print(srs.getString("stu_no"));
			System.out.print("\t|\t" + srs.getString("stu_name"));
			System.out.print("\t|\t" + srs.getString("enr_grade"));
			System.out.println("\t|\t" + srs.getString("sub_name"));
		}
	}

}
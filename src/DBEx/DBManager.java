package DBEx;

import java.io.*;
import java.sql.*;
import java.util.Scanner;

public class DBManager {
	static Connection conn;
	static Statement stmt = null;
	static Scanner sin = new Scanner(System.in);

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver"); // MySQL 드라이버 로드
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb", "root", "test123"); // JDBC 연결
			System.out.println("DB 연결 완료");
			stmt = conn.createStatement(); // SQL문 처리용 Statement 객체 생성
			printTable(stmt); // 모든 데이터 출력
			int choice = 1;
			while (choice != 4) {
				System.out.print("추가(1),삭제(2), 수정(3), 끝내기(4)>>");
				choice = Integer.parseInt(sin.nextLine());
				switch (choice) {
				case 1:
					add();
					break;
				case 2:
					delete();
					break;
				case 3:
					update();
					break;
				case 4:
					break;
				default:
					System.out.println("잘못 입력하셨습니다.");
				}
			}
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 로드 에러");
		} catch (SQLException e) {
			System.out.println("SQL 실행 에러");
		}
	}

	private static void update() {
		try {
			System.out.print("수정할 속성 이름>>");
			String colName = sin.nextLine();
			System.out.print("수정할 속성의 현재값 >>");
			String oldValue = sin.nextLine();
			System.out.print("수정할 속성의 새로운 값 >>");
			String newValue = sin.nextLine();
			if (colName.equals("id"))
				stmt.executeUpdate(
						"update book set " + colName + "=" + newValue + " where " + colName + "=" + oldValue + ""); // 데이터
																													// 수정
			else
				stmt.executeUpdate(
						"update book set " + colName + "='" + newValue + "' where " + colName + "='" + oldValue + "'"); // 데이터
																														// 수정
			printTable(stmt);
		} catch (SQLException e) {
			System.out.println("레코드 수정 에러");
		}
	}

	private static void delete() {
		try {
			int choice2 = 1;
			System.out.println("삭제 조건을 선택해주세요");
			System.out.println("1.title (선택 => o,다른 문자 입력시 -> x");
			String tox = sin.nextLine();
			System.out.println("2.publisher (선택 => o,다른 문자 입력시 -> x");
			String pubox = sin.nextLine();
			System.out.println("3.author (선택 => o,다른 문자 입력시 -> x");
			String autox = sin.nextLine();
			String query = "";
		
			if (tox.equalsIgnoreCase("o")) {
				System.out.println("title를 입력하세요");
				String title = sin.nextLine();
				query = "delete from book where title = '" + title + "'";
			}
			if (pubox.equalsIgnoreCase("o")) {
				System.out.println("publisher를 입력하세요");
				String publisher = sin.nextLine();
				if (!query.equals(""))
					query += " and publisher='" + publisher + "'";
				else
					query = "delete from book where publisher='" + publisher + "'";
			}

			if (autox.equalsIgnoreCase("o")) {
				System.out.println("author를 입력하세요");

				String author = sin.nextLine();
				if (!query.equals(""))
					query += " and author='" + author + "'";
				else
					query = "delete from book where author='" + author + "'";
			}
			

//			System.out.print("id>>");
//			int id =  Integer.parseInt(sin.nextLine());
//			stmt.executeUpdate("delete from book where id="+id); // 레코드 삭제
//			int d = stmt.executeUpdate("delete from book where id= " + id); // 레코드 삭제
//			System.out.println(d + "개 삭제 되였습니다");
			int a = stmt.executeUpdate(query);
			System.out.println(a + "개 삭제 되였습니다");
			printTable(stmt);
		} catch (SQLException e) { //SQLException e
			System.out.println("레코드 삭제 에러");
		}
	}

	private static void add() {
		try {
			System.out.print("책 이름>>");
			String title = sin.nextLine();
			System.out.print("출판사>>");
			String publisher = sin.nextLine();
			System.out.print("작가>>");
			String author = sin.nextLine();
			stmt.executeUpdate("insert into book (title, publisher, author) values "
					+ "(" + "'" + title + "','" + publisher	+ "','" + author + "');"); // 레코드 추가

			printTable(stmt);
		} catch (SQLException e) {
			System.out.println("레코드 추가 에러");
		}
	}

	// 레코드의 각 열의 값 화면에 출력
	private static void printTable(Statement stmt) {
		ResultSet srs;
		System.out.printf("%4s|%-30s|%-30s|%-10s\n", "id", "title", "publisher", "author");
		try {
			srs = stmt.executeQuery("select * from book");
			while (srs.next()) {
				System.out.printf("%4s|%-30s|%-30s|%-10s\n", new String(srs.getString("id")), srs.getString("title"),
						srs.getString("publisher"), srs.getString("author"));
			}
		} catch (SQLException e) {
			System.out.println("SQL 실행 에러");
		}
	}
}
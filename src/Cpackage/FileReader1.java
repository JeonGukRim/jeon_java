package Cpackage;

import java.io.FileReader;
import java.io.IOException;

public class FileReader1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileReader fin = new FileReader("C:\\Users\\tj-bu-11\\Desktop\\test.txt");
//		FileReader fin = new FileReader ("C:/windows/system.ini"); //파일 경로 확인
		int c;
		while ((c = fin.read()) != -1) {
			System.out.print((char) c);
		}
		fin.close();
	}

}

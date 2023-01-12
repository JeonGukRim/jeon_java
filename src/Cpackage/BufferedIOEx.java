package Cpackage;

import java.io.BufferedOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class BufferedIOEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileReader fin = null;
		int c;
		try {
			fin = new FileReader("C:\\Users\\tj-bu-11\\Desktop\\test.txt");
			BufferedOutputStream out = new BufferedOutputStream(System.out,5);
			while ((c = fin.read())!=-1) {
//				System.out.println((char)c);
				out.write(c);   //버퍼가 꽉찰때 문자가 화면에 출력
			}
			new Scanner(System.in).nextLine();
			out.flush();// 버퍼에 남아 있던 모든 문자 출력
			fin.close();
			out.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}

package Cpackage;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamEX1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte b[] = new byte [6];
		try {
			FileInputStream fin = new FileInputStream("C:\\Users\\tj-bu-11\\Desktop\\test12.out");
			int n = 0,c ;
			while( (c = fin.read()) != -1) {
				b[n] = (byte)c;
				n++;
			}
			System.out.println("C:\\Users\\tj-bu-11\\Desktop\\test12.out 에서 읽은 배열을 출력합니다");
			for(int i = 0; i<b.length ; i++) {
				System.out.println(b[i] + " ");
//				System.out.println();
				fin.close();
			}
		}catch (IOException e) {
			System.out.println("C:\\Users\\tj-bu-11\\Desktop\\test12.out 에서 읽은 배열을 읽지 못했습니다 경로를 확인해보세요");
		}
		
		
		
		
	}

}

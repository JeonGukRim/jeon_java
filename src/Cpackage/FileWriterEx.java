package Cpackage;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWriterEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		FileWriter fout = null;
		int c;
		try {
			fout = new FileWriter("C:\\Users\\tj-bu-11\\Desktop\\test1.txt");
			while (true) {
				String line = scanner.nextLine();
				if (line.length() == 0) {
					break;
				}
				fout.write(line, 0, line.length()); 
				// line은 입력값; 숫자는 랭스 인덱스 숫자 2부터 출력을 원하면 
				//fout.write(line, 2, line.length()-2); 랭스에 -2를 안해주면 2부터 시작되여 2가 오버된다
				fout.write("\r\n", 0, 2); //윈도스에서 줄바꿈은 \r\n
			}
			fout.close();
		} catch (IOException e) {
			System.out.println("입출력 오류");
		}
		scanner.close();

	}

}

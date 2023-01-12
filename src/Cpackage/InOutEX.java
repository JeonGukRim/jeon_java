package Cpackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class InOutEX {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
		FileWriter fout = null;
		System.out.println("전화번호 입력 프로그램");
		int c;
		try {
			fout = new FileWriter("C:\\Temp\\phone.txt");
			while (true) {

				System.out.print("이름 전화번호 >> ");
				String text = sc.nextLine();
				if (text.equals("그만"))
					break;
				fout.write(text);
				fout.write("\r\n");
			}
			fout.close();
			System.out.print("C:\\Temp\\phone.txt에 저장하였습니다.");
		} catch (IOException e) {
			System.out.print("입출력 오류");
		}
		sc.close();
// 2번

//		File f = new File("C:\\Temp\\phone.txt");
//		FileReader fr = new FileReader(f);
		FileReader fr = new FileReader("C:\\Temp\\phone.txt");
		BufferedReader br1 = new BufferedReader(fr);
		System.out.println("C:\\Temp\\phone.txt를 출력합니다.");

		while (true) {
			String st = br1.readLine();
			if (st == null)
				break;
			System.out.println(st);
		}
// 3~4번

		File file = new File("c:\\windows\\system.ini");
		FileReader fr1 = new FileReader(file);
		try {
			int d;
			char array[] = new char[(int) file.length()];
			int i = 0;
			// 3번문제. 대문자
			while ((d = fr1.read()) != -1) {
				array[i++] = (char) d;
			} // fr.read(array);
			String str = new String(array);
			System.out.print(str.toUpperCase());

			// 4번 문제. 각 라인 번호
			System.out.println();
			String strArray[] = str.split("\n");
//			String strArray[] =(String)str;
			int sIdex = 1;
			for (String sb : strArray) {
				System.out.print(sIdex++ + " : " + sb);
			}

			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

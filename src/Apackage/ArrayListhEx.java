package Apackage;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListhEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<String> a = new ArrayList<String>();

		// 키보드로부터 4개의 이름 입력받아 ArrayList에 삽입
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < 4; i++) {
			System.out.print("이름을 입력하세요 >>");
			String s = scanner.next();
			a.add(s);
		}
		// ArrayList에 들어 있는 모든 이름출력
		for (int i = 0; i < a.size(); i++) {
			String name = a.get(i);
			System.out.print(name + " ");
		}
		// 가장 긴 이름 출력

		int longestindex = 0;
		for (int i = 0; i < a.size(); i++) {
			if (a.get(longestindex).length() < a.get(i).length()) {
				longestindex = i;
			}
		}
		System.out.println("\n가장 긴 이름은 :" + a.get(longestindex));

		scanner.close();

	}

}

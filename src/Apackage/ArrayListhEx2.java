package Apackage;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListhEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> a = new ArrayList<Integer>();

		// 키보드로부터 4개의 이름 입력받아 ArrayList에 삽입
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < 4; i++) {
			System.out.print("숫자를 입력하세요 >>");
			int s = scanner.nextInt();
			a.add(s);
		}
		// ArrayList에 들어 있는 모든 이름출력
		for (int i = 0; i < a.size(); i++) {
			int num = a.get(i);
			System.out.print(num + " ");
		}
		// 가장 긴 이름 출력

		int longestindex = 0;
		for (int i = 0; i < a.size(); i++) {
			if (a.get(longestindex)< a.get(i)) {
				longestindex = i;
			}
		}
		System.out.println("\n가장 큰 숫자는 :" + a.get(longestindex));

		scanner.close();
		
		
		
	}

}

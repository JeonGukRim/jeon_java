package Dec;

import java.util.Scanner;

public class Dec08_08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);

		int a;
		String name = " ";
		String name2 = " ";
		String acc = " ";
		int num = 0;
		while (true) {
			System.out.println("====================");
			System.out.println("1. 주소를 등록하세요");
			System.out.println("2. 주소 출력");
			System.out.println("3. 주소 검색");
			System.out.println("4. 프로그램 종료!");
			System.out.println("====================");
			System.out.print("메뉴를 선택하세요 :");
			a = s.nextInt();
			// 선택 1
			if (a == 1) {
				System.out.print("학생명을 입력하세요");
				name = s.next();
				System.out.print("전화번호를 입력하세요");
				num = s.nextInt();
				System.out.print("주소를 입력하세요");
				acc = s.next();
			}
			// 선택 2
			if (a == 2) {
				System.out.println("이름은 :" + name);
				System.out.println("전화 :" + num);
				System.out.println("주소 :" + acc);
			}

			// 선택 3
			if (a == 3) {
				System.out.print("검색 이름은 :");
				name2 = s.next();
				if (name2 == name) {
					System.out.println("전화 :" + name2);
					System.out.println("전화 :" + num);
					System.out.println("주소 :" + acc);
				} else {
					System.out.println("검색된 내용이 없습니다.");
				}
			}
			// 선택 4
			if (a == 4) {
				System.out.println("종료합니다");
				break;
			}
		}

	}
}

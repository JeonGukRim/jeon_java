package Bpackage;

import java.util.Scanner;

public class FruitMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FruitP f = new FruitP("바나나","노랑색",1500);
		f.run();

		Scanner scanner = new Scanner(System.in);
//================================== 2번재 문제
		System.out.println("과일 구매 서비스\n구매할 과일을 선택해주세요.");
		FruitP b; //사과
		FruitP e;  //키위
		FruitP g; //바나나
		System.out.println("사과-1000원(1), 키위-2000원(2), 바나나-1500원(3)");
		while (true) {
			int a = scanner.nextInt();
			if (a == 1) {
				b =new FruitP("사과", "빨간색", 1000);
				b.run2();
			} else if (a == 2) {
			e	= new FruitP("키위", "초록색", 2000);
				e.run2();
			} else if (a == 3) {
				g = new FruitP("바나나", "노랑색", 1500);
				g.run2();
			}
		//	int c = scanner.nextInt();
		//	if(c == 2) {
		//		break;
		//	}
		}
	}
}

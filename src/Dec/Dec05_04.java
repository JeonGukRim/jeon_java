package Dec;

import java.util.Random;
import java.util.Scanner;

public class Dec05_04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random ra = new Random();
		Scanner s = new Scanner(System.in);
		while (true) {
			System.out.print("총 몇문제를 진행하시겠습니까?");
			int n = s.nextInt();
			int count = 0;
			for (int i = 1; i <= n; i++) {
				System.out.println(i + " 번 문제입니다");
				int r1 = ra.nextInt(8) + 2;
				int r2 = ra.nextInt(8) + 2;
				System.out.print(r1 + "*" + r2 + "= ");
				int a = s.nextInt();
				if (a == r1 * r2) {
					System.out.println("정답니다.");
					count++;
				} else {
					System.out.println("오답니다. 정답은" + r1 * r2 + "입니다.");
				}
				System.out.println();
			}
			System.out.println(n + " 문제중" + count + "문제 정답");
			System.out.print("문제 풀이를 다시 원하시면 1번 종료하실려면 2번 눌러주세요");
			int c = s.nextInt();
			if (c == 2) {
				System.out.println("종료되였습니다.");
				break;
			}
		} // while 끝
	}

}

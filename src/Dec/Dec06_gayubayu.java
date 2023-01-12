package Dec;

import java.util.Random;
import java.util.Scanner;

public class Dec06_gayubayu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		Random ra = new Random();
		int pwin = 0;
		int cwin = 0;

		while (true) {
			System.out.print("가위 (1)  바위(2)  보(3) 숫자를 선택해주세요");
			int a = s.nextInt();
			if (a == 1) {
				System.out.println("도전자: 가위");
			} else if (a == 2) {
				System.out.println("도전자: 바위");
			} else if (a == 3) {
				System.out.println("도전자: 보");
			}
//			int r = ra.nextInt(3) + 1;
			
			int r =(int)(Math.random()*3);
		
		
			if (r == 1) {
				System.out.println("컴퓨터: 가위");
			} else if (r == 2) {
				System.out.println("컴퓨터: 바위");
			} else if (r == 3) {
				System.out.println("컴퓨터: 보");
			}
//			if (a == r) {
//				System.out.println("무승부");
//			} else if (a == 1 && r == 2) {
//				System.out.println("컴퓨터 win");
//				cwin++;
//
//			} else if (a == 1 && r == 3) {
//				System.out.println("Player win");
//				pwin++;
//			} else if (a == 2 && r == 1) {
//				System.out.println("Player win");
//				pwin++;
//			} else if (a == 2 && r == 3) {
//				System.out.println("컴퓨터: win");
//				cwin++;
//			} else if (a == 3 && r == 1) {
//				System.out.println("컴퓨터: win");
//				cwin++;
//			} else if (a == 3 && r == 2) {
//				System.out.println("Player win");
//				pwin++;
//			}
			if (a == r) {
				System.out.println("무승부");
			}else if ( a - r == -2 || a - r == 1 ) {
				System.out.println("Player win");
				pwin++;
			}else if ( a - r == -1 || a - r == 2) {
				System.out.println("컴퓨터 win");
				cwin++;
			}
			System.out.println("Player ==>" + pwin + "승" + cwin + " 패 ");
			System.out.println("(1) 재대결 (2) 종료 ");
			int re = s.nextInt();
			if( re == 2) {
				System.out.println("종료되였습니다");
				break;
			}
				
		}
		
	}

}

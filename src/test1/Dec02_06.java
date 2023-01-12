package test1;

import java.util.Scanner;

public class Dec02_06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		while(true) {
			System.out.print("숫자를 입력하세요:");
			int a = s.nextInt();
		if (a % 2 == 0) {
				System.out.println("짝수입니다");
		}
		else {
				System.out.println("홀수입니다");				
				}
		System.out.println("계속 (1),  종료(2)");
		int b = s.nextInt();
		if ( b == 2) {
		break;
	}
		
		}
		System.out.println("종료되였습니다.");
	
		
		
		
		
		
		
		
		
		
		
	}

}

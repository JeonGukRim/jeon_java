package test1;

import java.util.Scanner;

public class Dec01_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Scanner s = new Scanner(System.in);
//		System.out.print("숫자를 입력하세요:");
//		int a = s.nextInt();    //숫자를 입력 받는 메소드 
//			
//		 if (a % 2 == 0) {
//			System.out.println("홀수 입니다.");
//		}else {
//			System.out.println("짝수 입니다."); 
//		}
//		
//		Scanner s = new Scanner(System.in);
//		System.out.print("확인할 점수을 입력해주세요:");
//		int a =s.nextInt();
//		
//		if(a < 0 || a > 100) {
//			System.out.println("0~100 사이 숫자를 입력해주세요!");
//		}else {
//		if(a >= 90) {
//			System.out.println("A학점 입니다.");
//		}else if( a >= 80) {
//			System.out.println("B학점 입니다.");
//		}else if( a >= 70) {
//			System.out.println("C학점 입니다.");
//		}else {
//			System.out.println("F학점 입니다.");
//		}
//		}
		
		Scanner s = new Scanner(System.in);
		System.out.print("숫자를 입력해주세요:");
		int a = s.nextInt();
		if(a % 2 == 0) {
			if(a % 5 == 0) {
				System.out.println("홀수이면서 5의 배수입니다");
			}else {
				System.out.println("홀수 입니다");
			}
		}else {
			if(a % 3 == 0) {
				System.out.println("짝수이면서 3의 배수입니다");
			}else {
				System.out.println("짝수 입니다");
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

package test1;

import java.util.Scanner;

public class Dec01_04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int value = 0;
		Scanner s = new Scanner(System.in);
		System.out.print("첫번째 숫자를 입력해주세요:");
		int a = s.nextInt();
		System.out.print("두번째 숫자를 입력해주세요:");
		int b = s.nextInt();
		System.out.print("수식을 선택해 주세요: [ 1 => +, 2 => -, 3 => *, 4 => / ]");
//		int c = s.nextInt();
//		String cal = s.next();
		char t = s.next().charAt(0);
		
//		if(c == 1 || cal.equals("+")) {
//			System.out.println("두 수의 더하기는 "+ (a + b) + "입니다.");
//		}else if(c == 2 || cal.equals("-")) {
//			System.out.println("두 수의 빼기는 "+ (a - b) + "입니다. ");
//		}else if(c == 3 || cal.equals("*")) {
//			System.out.println("두 수의 곱셈은  " + ( a * b) + "입니다. ");
//		}else if(c == 4 || cal.equals("/")) {
//			System.out.println("두 수의 나누기는 " + (a / b) + "입니다. ");
//		}
//		
//		if( cal.equals("+")) {
//			System.out.println("두 수의 더하기는 "+ (a + b) + "입니다.");
//		}else if(cal.equals("-")) {
//			System.out.println("두 수의 빼기는 "+ (a - b) + "입니다. ");
//		}else if(cal.equals("*")) {
//			System.out.println("두 수의 곱셈은  " + ( a * b) + "입니다. ");
//		}else if(cal.equals("/")) {
//			System.out.println("두 수의 나누기는 " + (a / b) + "입니다. ");
//		}
//		
		switch (t) {
//			case '+':
//				System.out.println("두 수의 더하기는 "+ (a + b) + "입니다.");
//			break;
//			case '-':
//				System.out.println("두 수의 빼기는 "+ (a - b) + "입니다. ");
//			break;
//			case '*':
//				System.out.println("두 수의 곱셈은  " + ( a * b) + "입니다. ");
//			break;
//			case '/':
//				System.out.println("두 수의 나누기는 " + (a / b) + "입니다. ");
//			break;
			case '+':
				value = a + b;
				break;
			case '-':
				value = a - b;
				break;
			case '*':
				value = a * b;
				break;
			case '/':
				value = a / b;
				break;
		}
		System.out.println(a + "" + t + "" + b + "=" + value); 
		//캐릭터 사용시 "" 두개 없으면 캐릭터 아스키코로 변형되여 연산이 진행됨
	}

}

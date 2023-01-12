package test1;

import java.util.Scanner;

public class Dec02_08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int total = 0;
		System.out.println("정수를 5개 입력하세요.");
		int i = 1;
		while(i <= 5 ) {
			int a = s.nextInt();
			i++;
			if(a > 0) {
			total += a	;
			}
			 
		}
		System.out.println("양수의 합은 : " +total);
		
//Scanner s = new Scanner(System.in);
//		
//		System.out.println("정수를 5개 입력하세요.");
//		int sum=0;
//		for(int i=0; i<5; i++) {
//			int n = s.nextInt(); // 키보드에서 정수 입력
//			if(n<=0) { 
//				continue;
//			} else {// 양수가 아닌 경우 다음 반복으로 진행
//				sum += n; // 양수인 경우 덧셈
//			}
//		}
//		System.out.println("양수의 합은 " + sum);
//​
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

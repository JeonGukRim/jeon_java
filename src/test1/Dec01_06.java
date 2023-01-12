package test1;

import java.util.Scanner;

public class Dec01_06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int total = 0;
		int total2 = 0;
		System.out.print("숫자를 입력하세요");
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
	
//		for(int i = 1 ; i <10; i++) {
//			System.out.println(a + "*" + i + "=" + a*i);
//		}
//		
//		for(int i = 1; i <= a; i++) {
//			total += i;
//			}
//		System.out.println(total);
//		
		for ( int i = 1; i <= a ; i++) {
			if(i % 2 == 1) {
				total += i ;
			} else {
			total2 += i;
			}
		}
		System.out.println("홀수의 합 : " + total);
		System.out.println("짝수의 합 : " + total2);
	
		
		
		
		
		
		
		
		
		
		
		
	}

}

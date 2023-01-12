package test1;

import java.util.Scanner;

public class Dec01_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.print("숫자를 입력하세요:");
		int a = s.nextInt();
		
		if (a % 2 == 0) {
			if(a >= 100 ) {
				System.out.println("짝수 이면서 100이상입니다");
			}else {
				System.out.println("짝수입니다");
			}
		}	
			else {
				if(a >= 100 ) {
					System.out.println("홀수 이면서 100이상입니다");
				}else {
					System.out.println("홀수입니다");
				}
			
			
			
			
		}
		
		
		
		
		
		
	}

}

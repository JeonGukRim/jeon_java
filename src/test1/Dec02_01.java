package test1;

import java.util.Scanner;

public class Dec02_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("입력된 값에서 3의 배수의 개수는");
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int cout = 0 ;
		
//		System.out.println(a/3);
		
		for(int i = 1; i <= a ; i++) {
			
			if( i % 3 == 0) {
				
				cout++;  //숫자 카운트 할때 기록되는 회수랑 같음
			}
			
			
		}
		
		System.out.println(cout);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

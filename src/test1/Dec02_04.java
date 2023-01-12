package test1;

import java.util.Scanner;

public class Dec02_04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		System.out.print("숫자를 입력하세요");    //while 구구단
//		Scanner s = new Scanner(System.in);
//		int a = s.nextInt();
//		
		int i = 1;
		int total = 0 ;
//		while (i < 10) {
//			System.out.println(a + "*" + i + "=" +a*i);
//			if(i == 6 ) {
//				break;
//			}
//			i++;
//		}
//		
		while(true) {
			total += i;     
			if( total >= 10000 ) {
				break;
			}
			i++;
		}
		System.out.println(i);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

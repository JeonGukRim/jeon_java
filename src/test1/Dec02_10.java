package test1;

import java.util.Scanner;

public class Dec02_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("정수를 입력하세요. 0 입력시 종료");
//		int a = s.nextInt();
//		int sum = 0 ;
//		while( a != 0) {
//			if(a < 0) {
//				continue;
//			}else {
//			sum += a;
//			a = s.nextInt();
//			}
//		
//		}
//		System.out.println(sum);
		
		
	     int a = s.nextInt();
	        int sum = 0;
	        
	    while(a != 0 ) {
	        
	        if( a < 0 ) {
	            continue;
	        }
	        sum += a;
	      
	        a = s.nextInt();
	        
//	        if( a > 0) {
//	            sum += a;
//	        }
	        
	    }
	        System.out.println(sum);
	        
		
	}

}

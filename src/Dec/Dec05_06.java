package Dec;

import java.util.Scanner;

public class Dec05_06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
		int a [] = new int[5];
		Scanner s = new Scanner(System.in);
		int max = 0 ;
		for(int i = 0 ; i < a.length ; i++) {	
			a[i] = s.nextInt();
			if(max < a[i]) {
				max = a[i];
			}                                 // 최대치 구하는 방법 방법2 -- max=Math.max(a[1],max);
		 }
		for(int i = 0 ; i < a.length ; i++) {
		System.out.println(a[i]);
		}
	}	

}

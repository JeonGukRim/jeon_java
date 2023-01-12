package Dec;

import java.util.Scanner;

public class Dec05_05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int a[] = new int[5];
		int max = 0 ;
		System.out.println("양수 5개를 입력하세요");
		for( int i = 0 ; i < 5 ; i++) {
			a [i] =s.nextInt();
			max = Math.max(max, a[i]);
		}
		
		int sum = 0;
		for(int i = 0 ; i < a.length ; i++) {
			System.out.println(a[i]);
			sum += a[i];
		}
		System.out.println("총합은"+ sum);
	}

}

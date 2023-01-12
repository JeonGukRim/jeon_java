package Dec;

import java.util.Scanner;

public class Dec05_index {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int a[] = new int[5];
		int max = 0 ;
		System.out.println("양수 5개를 입력하세요");
		for( int i = 0 ; i < 5 ; i++) {
			a [i] =s.nextInt();
			max += a[i];
		}
		for( int i = 0 ; i < 5 ; i++) {
			System.out.println(a[i]);
			//max = Math.max(max,a[i]);
//			if(a[i] > max) {
//				max = a[i];
//			}

		}
//		System.out.print("가장 큰 수는" + max + "입니다.");
		System.out.print("총합은" + max + "입니다.");
	}

}

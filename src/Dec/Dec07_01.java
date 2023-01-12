package Dec;

import java.util.Scanner;

public class Dec07_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 입력한 숫자만큼 오름차 순으로 *표 찍기 
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		
		for (int i = 1 ; i <= a ; i++) {
			for( int j = 1 ; j <=i ; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int i = 1 ; i <= a ; i++) {
			for( int j = 1 ; j <= a ; j++) {
				if( j <= a-i) {
					System.out.print(" ");
				}else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		
		
	}

}

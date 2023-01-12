package Dec;

import java.util.Arrays;
import java.util.Scanner;

public class Dec08_06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 입력받은 배열의 숫자에 순차적으로 접근하여 홀수일 경우 음수로 바꿔준다

		Scanner s = new Scanner(System.in);
		int array[] = new int[6];
		int a;
		int y = 0;
		int e = 0;
		double sum = 0;
		int index = 0;
		for (int i = 0; i < array.length; i++) {
			a = s.nextInt();
			if (a % 2 == 1) {
				array[i] = a * (-1);
				e++;
			} else {
				array[i] = a;
				sum += array[i];
				y++;
			}
		}
		//if (a % 2 == 1) {
		//	array[i] = -array[i];
		//	}
		
		System.out.println(Arrays.toString(array));
		// 배열내 양수의 평균을 구한다
		System.out.println((sum/y));
		// 배열내 음수의 개수를 구한다
		System.out.println("음수의 개수는" + e);
		//배열내 수를 재정렬 한다 양수 음수 반복순서로
		 y = 0;
		 e = 0;
		 int array1[] = new int[6];
		 int array2[] = new int[6];
		 int array3[] = new int[6];
		for(int i = 0 ; i < array.length; i++ ) {
			if( array[i] < 0) {
				array1[e++] = array[i];
//				e++;
			}else {
				array2[y++] = array[i];
//				y++;
			}
			
		}
//		for(int i = 0 ; i < array.length; i++ ) {
//			if( array[i] < 0) {
//				array2[y] = array[i];
//				y++;
//			}
//		}
		int index1 = 0;
		for(int i = 0 ; i < array3.length ; i++) {
			if ( array2 [i] != 0 ) {
			array3[index1++] = array2[i];
			}
			if ( array1 [i] != 0 ) {
			array3[index1++] = array1[i];
			}
		}
			
		System.out.println(Arrays.toString(array3));
		
		
		
		
		
	}
}

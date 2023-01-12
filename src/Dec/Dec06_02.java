package Dec;

import java.util.Arrays;
import java.util.Scanner;

public class Dec06_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//버블 정렬
		
		Scanner s =  new Scanner(System.in);
		System.out.println("개수를 선택해주세요");
		int length = s.nextInt();
		
		System.out.println("숫자를" + length + "개 입력해주세요");
		
		int array[]= new int[length];
		
		for(int i = 0 ; i < length ; i++) {
			array[i] = s.nextInt();
		}
		
//		for(int i = length -1 ; i > 0 ; i--) { 
//
//			for(int j = 0 ; j < i ; j++) {
//				if (array[j] > array[j+1]) {   // 오름차순  array[j] < array[j+1] 일때는 내림차순
//					int temp = array[j];
//					array[j] = array[j+1];
//					array[j+1] = temp;
//				}
//			}
//		}
//		System.out.println(Arrays.toString(array));
//		
		for(int i = 1 ; i < array.length ; i++) { 

			for(int j = 0 ; j < array.length-1 ; j++) {
				if (array[j] > array[j+1]) {   // 오름차순  array[j] < array[j+1] 일때는 내림차순
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(array));
		
		
		
		
		
	}

}

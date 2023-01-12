package Dec;

import java.util.Arrays;

public class Dec07_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//삽입형 정렬;
		int array [] = {4,3,2,5,1};
	
//		for(int i = 1 ; i < array.length ; i++) {  
//			if(array[i-1] > array [1]) {
//				int temp = array[i];
//				array[i] = array [i-1];
//				array[i-1] = temp;
//			}
//		}
//		System.out.println(Arrays.toString(array));
//		for(int i = 2 ; i > 0 ; i--) {
//			if(array[i-1] > array [i]) {
//				int temp = array[i];
//				array[i] = array [i-1];
//				array[i-1] = temp;
//			}
//		}
//		System.out.println(Arrays.toString(array));
//		for(int i = 3 ; i > 0 ; i--) {
//		if(array[i-1] > array [i]) {
//			int temp = array[i];
//			array[i] = array [i-1];
//			array[i-1] = temp;
//		}
//	}
//	System.out.println(Arrays.toString(array));
		// 이상 규칙 i ==> 1씩 증가  이하 for문 이용 문법 변경;
		
		for(int j = 1 ; j < array.length ; j++) {    
			for(int i = j ; i > 0 ; i--) {
				if(array[i-1] > array [i]) {
					int temp = array[i];
					array[i] = array [i-1];
					array[i-1] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(array));
	}
}
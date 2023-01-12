package Dec;

import java.util.ArrayList;
import java.util.Arrays;

public class Dec06_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
//		for(int i = 2 ; i <= 9 ; i++) {
//		System.out.println("==== " + i +" 단 ====");
//			for(int j =1 ; j <=9 ; j++) {
//				System.out.println(i + " * " + j + " = " + i*j);
//			}
//			System.out.println();
//		}
//		
//		
		int list[] =  {7, 4, 5, 1, 3};
		int temp;
		for(int i  = list.length - 1 ; i > 0 ; i--) {
			for(int j = 0 ; j < i ; j++) {
				if(list[j] < list[j+1]) {
					temp = list[j];
					list[j] = list[j+1];
					list[j+1] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(list));
		
		
		
		
		
	}

}

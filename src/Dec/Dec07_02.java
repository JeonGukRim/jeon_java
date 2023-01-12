package Dec;

import java.util.Arrays;

public class Dec07_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		int array [] = {4,3,2,5,1};
//	
		
//		for(int j = 0 ; j < array.length ; j++ ) {
//			int minindex = j;
//			
//			for(int i = j+1 ; i < array.length ; i++) {
//				if(array[minindex] > array[i]) {
//					minindex = i;
//				}
//				int temp = array[j];
//				array [j] = array[minindex];
//				array [minindex] = temp;
//			}
//		}
		
		int array[] = {3,5,2,1,4};
		
		int index = 0 ;
		for(int i = 1 ; i < array.length ; i++) {
			if(array[index] > array[i]) {
				index = i ;
			}
		}
		int temp = array[0];
		array [0] = array[index];
		array[index] = temp ;
		System.out.println(Arrays.toString(array));
		
		index = 1 ;
		for(int i = 2 ; i < array.length ; i++) {
			if(array[index] > array[i]) {
				index = i ;
			}
		}
		temp = array[1];
		array [1] = array[index];
		array[index] = temp ;
		System.out.println(Arrays.toString(array));
		
		index = 2 ;
		for(int i = 3 ; i < array.length ; i++) {
			if(array[index] > array[i]) {
				index = i ;
			}
		}
		temp = array[2];
		array [2] = array[index];
		array[index] = temp ;
		System.out.println(Arrays.toString(array));
		
		
		index = 3 ;
		for(int i = 4 ; i < array.length ; i++) {
			if(array[index] > array[i]) {
				index = i ;
			}
		}
		temp = array[3];
		array [3] = array[index];
		array[index] = temp ;
		System.out.println(Arrays.toString(array));
		
		
		
		
		
		
		
		
		
	}

}

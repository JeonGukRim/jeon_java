package Dec;

import java.util.Arrays;
import java.util.Collections;

public class Dec08_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//
		Integer array [] = {10,30,5,15,25};  //클래스 내림차순을 사용할때는 int를 Integer로 기재해야됨
		Arrays.sort(array); // 배열 정렬 됨 오름차순으로 
		Arrays.sort(array,Collections.reverseOrder());   // 배열 정렬 됨 내림차순으로 
		System.out.println(Arrays.toString(array));

		String array1[] = {"orange","kiwi","apple","pear",};
		
		Arrays.sort(array1);
		Arrays.sort(array1,Collections.reverseOrder());
		System.out.println(Arrays.toString(array1));
		
		String array2[] = {"orange~~","kiwi","apple","pears~",};

		for(int i = 0 ; i < array2.length ; i++) {
			int index = i;
			for(int j = i+1 ; j < array2.length ; j++ ) {
				if ( array2[index].length() < array2[j].length() ) {
					index = j;
				}
				 String temp = array2[index];
				 array2[index] = array2[j];
				 array2[j] = temp;		 
			}
		}
		System.out.println(Arrays.toString(array2));
		
		
		
		
		
	}

}

package Dec;

import java.util.Arrays;

public class Dec06_04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 삽입 정렬
		int array [] = {4,3,5,6,8,1,2,7};
		
		for( int i = 1 ; i < array.length; i++) {
			for( int j = i ; j >= 1 ; j-- ) {
				if(array[j] < array[j-1]) {
					int temp =array[j];
					array[j] = array[j-1];
					array[j-1] = temp;
				}else break;
			}
		}
		System.out.println(Arrays.toString(array));
	}

}

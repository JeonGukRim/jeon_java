package Dec;

import java.util.Arrays;

public class Dec06_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//선택 정렬 은 데이터 오름차순으로 정렬한 코드
		
		int array [] = {4,3,5,6,8,1,2,7};
		int minindex = 0;
		for(int i = 0 ; i < array.length; i++) {
			minindex = i;
			for(int j  = i +1 ; j < array.length; j++) {
				if( array[minindex] > array [j] ) {
					minindex = j;
				}
			}
			int temp = array[i];
			array[i] = array[minindex];
			array[minindex] = temp ;
		}
		System.out.println(Arrays.toString(array));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

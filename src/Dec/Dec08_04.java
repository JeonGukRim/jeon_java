package Dec;

import java.util.Arrays;

public class Dec08_04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//가장 작은 차이의 배열숫자를 찾기
	
		int array[] = {1, 3, 4, 8, 13, 17, 12, 20};
		Arrays.sort(array);
		int min = array[array.length-1];
		
		for(int i=1; i<array.length; i++) {
			min = Math.min(min, array[i] - array[i-1]);
		}
		for(int i=1; i<array.length; i++) {
			if(array[i] - array[i-1] == min) {
				System.out.println("(" + array[i-1] + "," + array[i] + ")");
			}
		}
		
		
		
		
		
		
		
//		System.out.println(Arrays.toString(array));
		
		
		
		
		
		
		
		
		
		
	}

}

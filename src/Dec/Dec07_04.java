package Dec;

import java.util.Arrays;

public class Dec07_04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array [] = {30, 20, 50, 15, 25};
	// 1.3번째 숫자 홀짝 판단
		if( array[2] % 2 == 0) {
			System.out.println("3번째 숫자 "+ array[2] + " 은(는) 짝수 입니다.");
		}else {
			System.out.println("3번째 숫자 "+ array[2] +" 은(는) 홀수 입니다.");
		}
	//2. 배열에 있는 수의 평균 구하기	
		int sum = 0;

		for(int i = 0 ; i < array.length ;i++) {
			sum += array[i];
		}
		System.out.println("배열에 있는 수의 평균은 " + (sum/array.length) + " 입니다");
	//3. 배열에서 최대값과 최소값구하기;
		int max = 0;
		int min = 9999999;
	
//		for(int i = 0 ; i < array.length ;i++) {
//			for( int j = 1 ; j <array.length ; j++) {
//				if(array[j-1] > array [j]) {
//					max = j-1;
//				}else if(array[j-1] < array [j]) {
//					min = j-1;
//				}
//			}
//		}	
		
		for(int i=0; i<array.length; i++) {
			max = Math.max(max, array[i]);
			min = Math.min(min, array[i]);
//			if(max < array[i]) {
//				max = array[i];
//			}
//			if(min < array[i]) {
//				min = array[i];
//			}
//			if 문구 사용시 예;
		}
		
		//4. 내림차순으로 정렬(큰수에서 작은수 순으로)
		int maxindex = 0;
		for(int i = 0 ; i < array.length ;i++) {
				maxindex = i;
			for( int j =i + 1 ; j <array.length ; j++) {
				if(array[maxindex] < array [j]) {
					maxindex = j;
				}
				int temp = array[i];
				array[i] = array[maxindex];
				array[maxindex] = temp;
			}
		}
		
//		for(int i=1; i<array.length; i++) {
//			for(int j=i; j>0; j--) {
//				if(array[j] > array[j-1]) {
//					int temp = array[j];
//					array[j] = array[j-1];
//					array[j-1] = temp;
//				}
//			}
//		}
//		System.out.println(Arrays.toString(array));
		
		System.out.println("배열에 최대 값은 " + max);
		System.out.println("배열에 최소 값은 " + min);
		System.out.println(Arrays.toString(array));

		
		
		
		
		
		
		
		
		
		
		
		
	}

}

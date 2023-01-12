package Dec;

import java.util.Arrays;

public class Dec07_06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 6.배열에서 중복된 값 제거하기
	
		
		int array3[] = {30, 20, 60, 0, 25, 20, 60, 0, 10, 30};
		int tempArray[] = new int[array3.length];
		int index = 0; 
		boolean flg = false;
		boolean zeroflg = true; // 중복여부
		for(int i=0; i<array3.length; i++) {
			for(int j=0; j<tempArray.length; j++) {
				
				if(array3[i] == 0 && zeroflg  ) {
					tempArray[index] = array3[i];
					zeroflg = false;
					index ++;
				}  //0일때 비교후 입력
				
				
				
				if(array3[i] == tempArray[j]  ) {
					flg = true; // 중복있음
					break;
				}
			}
			if(!flg ) { // 중복없을 때 추가
				tempArray[index] = array3[i];
				index++; 
			}
			flg = false; // 초기화
		}
		int newArray[] = new int[index];
		for(int i=0; i<newArray.length; i++) {
			newArray[i] = tempArray[i];
		}
		System.out.println(Arrays.toString(newArray));
	}
}

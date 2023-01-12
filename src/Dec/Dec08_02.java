package Dec;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Dec08_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		int array[] = { -1, 1, 3, -2, 2 };

//		for (int i = 0; i < array.length; i++) {
//			int index = i;
//			for (int j = i; j < array.length; j++) {
//				if (array[j] < 0 ) {
//					index = j;
//					break;
//				}
//			}
//			int temp = array[i];
//			array[i] = array[index];
//			array[index] = temp;
//		}
//		System.out.println(Arrays.toString(array));
			//1. n개의 정수를 가진 배열이 있다. 이 배열은 양의정수와 음의 정수를 모두 가지고 있다. 
		
			//이제 당신은 이 배열을 좀 특별한 방법으로 정렬해야 한다.
			//
			//정렬이 되고 난 후, 음의 정수는 앞쪽에 양의정수는 뒷쪽에 있어야 한다. 
			//
			//또한 양의정수와 음의정수의 순서에는 변함이 없어야 한다.
			//
			//예. -1 1 3 -2 2 ans: -1 -2 1 3 2.
		// 1번 -> 단순 삽입
				int array[] = {-1, 1, 3, -2, 2};
				int newArray[] = new int[array.length];
				int index = 0;
				for(int i=0; i<array.length; i++) {
					if(array[i] < 0) {
						newArray[index] = array[i];
						index++;
					}
				}
				for(int i=0; i<array.length; i++) {
					if(array[i] > 0) {
						newArray[index] = array[i];
						index++;
					}
				}
				System.out.println(Arrays.toString(newArray));
				
				// 1번 -> 정렬
				for(int i=1; i<array.length; i++) {
					for(int j=i; j>0; j--) {
						if(array[j] < 0 && array[j-1] > 0) {
							int temp = array[j];
							array[j] = array[j-1];
							array[j-1] = temp;
						}
					}
				}
				System.out.println(Arrays.toString(array));
				System.out.println();
				
				// 2번
				
				Random r = new Random();
				Scanner s = new Scanner(System.in);
				int ran = r.nextInt(100) + 1;
				int count = 1;
				System.out.println("컴퓨터가 1~100 중 랜덤 숫자 하나를 정합니다.");
				System.out.println("이 숫자를 맞춰주세요.");
				while(true) {
					System.out.print("1-100 숫자 입력 : ");
					int input = s.nextInt();
					if(ran == input) {
						System.out.println("정답입니다! " + count + "번 만에 맞추셨습니다.");
						break;
					} else if(ran > input) {
						System.out.println("UP");
						count++;
					} else {
						System.out.println("DOWN");
						count++;
					}
				}
	
	
	
	
	
	}

}

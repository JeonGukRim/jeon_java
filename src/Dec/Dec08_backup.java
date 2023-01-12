package Dec;

import java.util.Arrays;
import java.util.Scanner;

public class Dec08_backup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		1-1. Scanner 클래스를 통해 6개의 공간을 가지는 int형 배열에 값을 입력한다.
//
//		(단, 0이하의 숫자를 입력할 경우 저장하지 않고 1이상의 숫자를 입력하라는 안내문구를 띄운다)
//
//		 ex) {10, 5, 3, 8, 20, 15}
//
//		1-2. 입력받은 배열의 숫자에 순차적으로 접근하여 홀수일 경우 음수로 바꿔준다.
//
//		 ex) {10, -5, -3, 8, 20, -15}
//
//		​
//
//		1-3. 배열내 양수의 평균을 구한다.(소수점까지) 
//
//		1-4. 배열내 음수의 개수를 구한다. 
//
//		  -> 1-3, 1-4는 어렵지 않다고 생각되는 경우 풀이를 생략해도 됨.
//
//		​
//
//		1-5. 배열내 수를 재정렬 한다.(양수, 음수, 양수, 음수 반복. 순서는 그대로)
//
//		 ex) {10, -5, 8, -3, 20, -15}
//
//		​
//
//		1-6. 배열내에서 2개의 수의 차가 가장 큰 경우를 구하라.
//
//		 단, 음수는 절대값을 씌우고(양수) 계산 함.
//
//		 ex) 가장 큰수의 20과 작은수인 3(-3절대값) 두개를 구함.

		// 1번 
				Scanner s = new Scanner(System.in);
				int array[] = new int[6];
				System.out.println("숫자 6개 입력해주세요. (양수)");
				for(int i=0; i<array.length; i++) {
					int num = s.nextInt();
					if(num <= 0) {
						System.out.println("1이상의 숫자를 입력해 주세요.");
						i--;
					} else {
						array[i] = num;
					}
				}
//				int array[] = {10, 5, 3, 7, 9, 10, 8, 20, 15};
				System.out.println(Arrays.toString(array));
				
				// 2번
				for(int i=0; i<array.length; i++) {
					if(array[i] % 2 == 1) {
						array[i] = -array[i];
					}
				}
				System.out.println(Arrays.toString(array));
				
				// 3번 ~ 4번
				int sum = 0;
				int cnt = 0;
				for(int i=0; i<array.length; i++) {
					if(array[i] > 0) {
						sum += array[i];
						cnt++;
					}
				}
				System.out.println((double)sum/cnt);
				System.out.println(array.length - cnt); // 음수 갯수

				// 5번 --> 특정 경우(홀수 연속 세번 등)에 동작하지 않으므로 동작하도록 수정해보기
				for(int i=1; i<array.length; i++) {
					for(int j=i; j>0; j--) {
						if((array[j] > 0 && array[j-1] < 0) && j % 2 == 1 ) {
							int temp = array[j];
							array[j] = array[j-1];
							array[j-1] = temp;
						}
					}
				}
				System.out.println(Arrays.toString(array));
				
				// 6번
				for(int i=0; i<array.length; i++) {
					array[i] = Math.abs(array[i]);
				}
				Arrays.sort(array);
				System.out.println(array[array.length-1] - array[0]);
				System.out.println("(" + array[array.length-1] + "," + array[0] + ")");
		
		
		
	}

}

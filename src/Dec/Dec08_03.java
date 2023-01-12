package Dec;

import java.util.Arrays;

public class Dec08_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] = { 10, 25, 32, 54, 23, 16, 27, 61 };
		// 홀수 오름차순 짝수는 내림차순
		// 홀,짝 순서로 출력
		int oddArray[] = new int[array.length];
		int evenArray[] = new int[array.length];
		Arrays.sort(array);
		int index = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 == 1) {
				oddArray[index] = array[i];
				index++;
			}
		}
		int index2 = 0;
		for (int i = array.length - 1; i >= 0; i--) {
			if (array[i] % 2 == 0) {
				evenArray[index2] = array[i];
				index2++;
			}
		}                                          // 내림차순으로 출력해야 되서 뒤로부터입력
		int newArray[] = new int[array.length];
		index = 0;
		for (int i = 0; i < array.length; i++) {
			if (oddArray[i] != 0) {
				newArray[index++] = oddArray[i];
			}
			if (evenArray[i] != 0) {
				newArray[index++] = evenArray[i];
			}
		}
		System.out.println(Arrays.toString(newArray));

		// 홀수, 짝수 개수 같을 때
		int newArray2[] = new int[array.length];
		int oIndex = 0;
		int eIndex = array.length - 1;
		for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 == 1) {
				newArray2[oIndex] = array[i];
				oIndex += 2;
			} else {
				newArray2[eIndex] = array[i];
				eIndex -= 2;
			}
		}
		System.out.println(Arrays.toString(newArray2));

	}

}

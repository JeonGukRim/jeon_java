package Dec;

import java.util.Arrays;

public class Dec08_07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 배열내에서 2개의 수의 차가 가장 큰 경우를 구하라 단 음수는 절대 값을 씌우고 양수
		int array[] = { 10, -5, 8, -3, 20, -15 , 30};

		int newarray[] = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			newarray[i] = Math.abs(array[i]);
		}
		Arrays.sort(newarray);
		System.out.println("(" + newarray[0] + "," + newarray[array.length-1] + ")");
		}
}

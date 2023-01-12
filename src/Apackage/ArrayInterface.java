package Apackage;

import java.util.Arrays;

interface ArrayInterface {
	int [] arraySort(int[] array1); // 배열 내림차순

	int arrayAvg(int[] array2); // 배열 평균값

	int arrayMax(int[] array3); // 배열내 최대값
}

class ArrayClass implements ArrayInterface {
	private int sum = 0;
//	private int cal = 0;
	private int max = 0;

	@Override
	public int [] arraySort(int[] array1) {
		// TODO Auto-generated method stub
		for (int i = 1; i < array1.length; i++) {
			for (int j = i; j >= 1; j--) {
				if (array1[j] > array1[j - 1]) {
					int temp = array1[j];
					array1[j] = array1[j - 1];
					array1[j - 1] = temp;
				} else
					break;
			}
		}
		return array1;
	}

	@Override
	public int arrayAvg(int[] array2) {
		// TODO Auto-generated method stub
		for (int i = 0; i < array2.length; i++) {
			this.sum += array2[i];
		}
		return this.sum / array2.length;
//		return this.cal;
	}

	@Override
	public int arrayMax(int[] array3) {
		// TODO Auto-generated method stub
		for (int i = 0; i < array3.length; i++) {
			this.max = Math.max(this.max, array3[i]);
		}
		return this.max;
	}

}
package Apackage;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		ArrayClass arr =  new ArrayClass(); //객체생성 그이후 배열로 메소드 호출;
		System.out.print("배열 크기를 입력하세요 >>");
		int array1 [] = new int [s.nextInt()];
		for(int i = 0; i< array1.length; i++) {
				array1[i] = s.nextInt();
		}
		
//		arr.arraySort(array1);
		System.out.println(Arrays.toString(arr.arraySort(array1)));
		System.out.println("평균은 "+arr.arrayAvg(array1));
		System.out.println("최대치 값은 "+arr.arrayMax(array1));
		
		
	}

}

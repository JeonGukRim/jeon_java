package Apackage;

import java.util.Arrays;

public class MathEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(Math.PI);
		System.out.println(Math.ceil(10.8));// ceil 반올림
		System.out.println(Math.floor(10)); //floor 내림
		System.out.println(Math.sqrt(9));// 제곱
		System.out.println(Math.exp(2)); //e의 2승
		System.out.println(Math.pow(2, 3)); //2의 3승
		System.out.println(Math.round(3.14)); // 반올림
		
		
		System.out.println("이번주 행운의 번호는 ");
		int array [] = new int[10];
		int count = 0;
		for(int i =0 ; i < 10 ; i++) {

			array[i] =(int) (Math.random()*10+1);
 			for(int j =i-1 ; j >= 0 ;j--) {
				
				if(array[i] == array[j]) {
					count++;
					if(count > 1) {
						i--;
						break;
					}
				}
			}
 			count = 0;
		}
		
		System.out.println(Arrays.toString(array));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

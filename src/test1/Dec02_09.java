package test1;

import java.util.Scanner;

public class Dec02_09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		
		System.out.println("정수를 입력하고 마지막에 -1을 입력하세요.");
		int sum = 0;
		int count = 0;
		int a = s.nextInt();	
		while(true) {
			if( a != -1) {
				sum += a;
				count++;	
				a = s.nextInt();
			}else {
				break;
			}
		}
		if(count == 0) {
		System.out.println("확인된 정수가 없습니다.");
		}else {
			System.out.println("정수의 개수는 " + count + "이며 평균은 " + sum/count + "입니다 .");   //평균계산하는 카운터가 0이 되면 안됨 count == 0 조건 추가
		}
		
		
		
		
		
		
		
	}

}

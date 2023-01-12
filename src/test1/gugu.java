package test1;

import java.util.Random;
import java.util.Scanner;

public class gugu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		Random ra = new Random();
		System.out.print("도전할 회수를 입력하세요>>");
		int a = s.nextInt();
		int count = 0;
		for(int i = 1 ; i <= a ; i++) {
		System.out.println("=====" + i +" 번째 문제=====");
		int r1 = ra.nextInt(8)+2;
		int r2 = ra.nextInt(8)+2;
		System.out.print(r1 + " * "+ r2 +" = " );
		if(r1*r2 == s.nextInt()) {
			System.out.println("정답입니다");
			count++;
		}else {
			System.out.println("틀리셨습니다");
		}
		}
		System.out.println("총" + count +"개 문제 맞추셨습니다");
		
		
		
	}

}

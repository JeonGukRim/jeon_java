package test1;

import java.util.Scanner;

public class Dec01_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s= new Scanner(System.in);
		
		System.out.print("학년을 입력하세요:");
		int b = s.nextInt();	
		
		System.out.print("점수를 입력하세요:");
		int a = s.nextInt();
		
		if(b <= 2 && b > 0) {
			if(a >= 70) {
				System.out.println("합격");
			}else {
				System.out.println("불합격");
			}
		}else  {
			if(a >= 80) {
				System.out.println("합격");
			}else {
				System.out.println("불합격");
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

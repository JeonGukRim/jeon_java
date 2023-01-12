package test1;

import java.util.Scanner;

public class Dec01_05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char g;
		Scanner s = new Scanner(System.in);
		int score = s.nextInt();
		
		switch (score/10) {
			case 10:
			case 9:
				g = 'A';
			break;        //조건 9을 만족하고 브레이크가 없다면 밑단계 8조건무시하고 브레이크위 'B'값을 가짐
			case 8:
				g = 'B';
			break;
			case 7:
				g = 'C';
			break;
			case 6:
				g = 'D';
			break;
			case 5:       //int인 관계로 소수점은 유실됨 55/10 = 5.5   ==> 5가 됨
				g = 'E';
			break;
			default:
				g = 'F';
		}		
		System.out.println("학점은 " + g + "입니다.");
	}

}

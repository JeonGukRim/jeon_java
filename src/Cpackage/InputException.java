package Cpackage;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		System.out.println("정수 3개를 입력하세요");
		int sum =0,n=0;
		for(int i = 0 ; i <3 ; i++) {
			System.out.print(i + ">>");
			try {
				n = scanner.nextInt();
			}catch(InputMismatchException e) {
				System.out.println(e.getMessage());
				System.out.println("정수가 아닙니다. 다시 입력하세요");
				scanner.next();   //n이 int로 선언되여 오류 발생 캐치로 이동 (n에 담기전에 캐치로 넘어감;)
				i--;
				continue;
			}
			sum += n;
		}
		System.out.println("합은 " + sum);
		scanner.close();
		
		
	}

}

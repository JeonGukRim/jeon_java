package Dec;

import java.util.Arrays;
import java.util.Scanner;

public class Dec08_05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Scanner 클래스를 통해 6개의 공간을 가지는 int 형 
		//배열에 값을 입력한다 단 0이하의 숫자를 입력할 경우 저장안하고 1이상의 숫자를 입력
		
		Scanner s = new Scanner(System.in);
		int array [] = new int [6];
		int a;
		for(int i = 1 ; i <= array.length ; i++) {
			a = s.nextInt();
			if(a <= 0) {
				System.out.println("1이상의 숫자를 입력하세요");
				i--;
			} else {
			array[i] = a;
			}
		}
		
		System.out.println(Arrays.toString(array));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

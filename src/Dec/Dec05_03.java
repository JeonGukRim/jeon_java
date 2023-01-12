package Dec;

import java.util.Random;
import java.util.Scanner;

public class Dec05_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		Random ra = new Random();
		int r = ra.nextInt(8)+2;
		int r1 =ra.nextInt(8)+2;
		System.out.print(r + "*" + r1 + "= ");
		int a = s.nextInt();
		if(a == r*r1) {
			System.out.println("정답입니다.");
		}else {
			System.out.println("오답입니다. 정답은" + r*r1 +"입니다.");
		}
		
		
		
		
		
		
	}

}

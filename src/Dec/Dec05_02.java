package Dec;

import java.util.Random;

public class Dec05_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Math.random() -> 0.0 ~ 1.0
//		System.out.println((int)(Math.random()*8)+2);
		Random ra = new Random();
		for (int i = 1 ; i <=10 ; i++) {
			int r = ra.nextInt(8)+2;
			System.out.println(r);
		}
		
		
		
		
	}

}

package Dec;

import java.util.Arrays;
import java.util.Random;

public class Dec05_test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 랜덤의 6개의 숫자를 뽑기 중복 x
		Random random = new Random();
		int num[] = new int[6];
		for (int i = 0; i < num.length; i++) {
			num[i] = random.nextInt(45) + 1;
			for (int j = 0; j < i; j++) {   //for (int j = 1; j < num.length; j++)
				if (num[i] == num[j]) {
					i--;
					break;
				}
			}
		}
		for(int i = 0 ; i <num.length; i++) {
			System.out.println(num[i]);
		}
	
	}

}

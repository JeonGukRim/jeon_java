package Dec;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Dec05_test02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random = new Random();
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int num[] = new int[a];
		
		
		for (int i = 0; i < num.length; i++) {
			num[i] = random.nextInt(45) + 1;
			for(int j = 0 ; j < i ; j++) {
				if( num[i] == num[j] ) {
					i--;
					break;
				}
			}
		
		}
		System.out.println(Arrays.toString(num));
		}
}

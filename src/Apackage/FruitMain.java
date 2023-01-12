package Apackage;

import java.util.Scanner;

public class FruitMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		Fruit banana = new Fruit("바나나",1,1500);
		Fruit orange = new Fruit("오렌지",2,2000);
		
		System.out.println(banana.buy(5));
		System.out.println(banana.getBuyNum());
		
		while(true) {
			System.out.println("구매 개수 입력");
			banana.buy(s.nextInt());
			System.out.println("현재까지 총 구매 개수" + banana.getBuyNum());
			System.out.println("추가 구매(1)    종료(2)");
			if(s.nextInt() == 2) {
				break;
			}
		}
		
		
		
	}

}

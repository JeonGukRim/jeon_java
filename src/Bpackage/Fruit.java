package Bpackage;

import java.util.Scanner;

public class Fruit {

	private String name;
	private String color;

	Fruit(String name, String color) {
		this.name = name;
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public String getColor() {
		return color;
	}
}

class FruitP extends Fruit {
	private int price;
	Scanner s = new Scanner(System.in);

	FruitP(String name, String color, int price) {
		super(name, color);
		this.price = price;
		System.out.println(name + " 를 판매 합니다");
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void run() {
		int sum = 0;
		while (true) {
			System.out.print("구매 개수 입력 :  ");
			int a = s.nextInt();
			System.out.println(getName() + " " + a + "개 추가");
			System.out.println("추가구매(1),   종료(2)");
			int b = s.nextInt();
			if (b == 2) {
				sum += a;
				System.out.println(getColor() + " 과일 " + getName() + "를 개당 " + getPrice() + "원에 " + sum + " 개 구매"
						+ "( 총 금액 :" + sum * (this.price) + ")");
				break;
			} else {
				sum += a;
			}
		}
	}

	public void run2() {
		int sum = 0;
		while(true) {
			System.out.print("구매 개수 입력 :  ");
			int a = s.nextInt();
			System.out.println(getName() + " " + a + "개 추가");
			System.out.println("추가구매(1),   종료(2)");
			sum +=a ;
			int c = s.nextInt();
			if(c == 2) {
				System.out.println(getColor() + " 과일 " + getName() + "를 개당 " + getPrice() + "원에 " + sum + " 개 구매"
						+ "( 총 금액 :" + sum * (this.price) + ")");
				break;
			}
		}
	}

}

/* int b = s.nextInt();
			if (b == 2) {
				sum += a;
				System.out.println(getColor() + " 과일 " + getName() + "를 개당 " + getPrice() + "원에 " + sum + " 개 구매"
						+ "( 총 금액 :" + sum * (this.price) + ")");
				break;
			} else {
				sum += a;
			} */

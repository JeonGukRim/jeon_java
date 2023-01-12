package Apackage;

public class Fruit {
	private String name; //과일명
	private int buyNum; //구개개수
	private int price; // 가격
	
	Fruit(String nmae, int buyNum , int price){
		this.name = name;
		this.buyNum = buyNum;
		this.price = price;
	}

	public int buy(int num) {
	
		this.buyNum += num;
		return this.buyNum;
	}
	
	
	
	
	
	
	
	
	public String getName() {
		return name;
	}

	public int getBuyNum() {
		return buyNum;
	}

	public int getPrice() {
		return price;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBuyNum(int buyNum) {
		this.buyNum = buyNum;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

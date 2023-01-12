package Dec_w3;

class Food {
	String name;
	int price;

	Food() {
	}

	Food(String name, int price) {
		this.name = name;
		this.price = price;
	}

}

class Noodles extends Food {
	String kind;

	Noodles(String name, int price, String kind) {
		super(name, price);
		this.kind = kind;
	}
}

class Sushi extends Food {
	String kind;

	Sushi(String name, int price, String kind) {
		super(name, price);
		this.kind = kind;
	}
}

class Samgyeopsal extends Food {
	String kind;

	Samgyeopsal(String name, int price, String kind) {
		super(name, price);
		this.kind = kind;
	}
}

public class FoodMain {
	
	static void choice(Food food) {
		if (food instanceof Noodles) {
			System.out.println("라면 선택 완료");
		} else if (food instanceof Sushi) {
			System.out.println("초밥 선택 완료");
		} else if (food instanceof Samgyeopsal) {
			System.out.println("삼겹살 선택 완료");
		}
	}

	public static void main(String[] args) {
		Food noodles = new Noodles("라면", 2000, "면");
		Food Sushi = new Sushi("초밥", 10000, "밥");
		Food samgyeopsal = new Samgyeopsal("삼겹살", 20000, "고기");

		choice(noodles);
		choice(Sushi);
		choice(samgyeopsal);
	}
}

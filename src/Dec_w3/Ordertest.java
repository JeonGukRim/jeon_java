package Dec_w3;

public class Ordertest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Order order = new Order("202212121234", "test123", "홍길동", "2022.12.12", "인천", 0);
		order.setPrice(50000);
		System.out.println(order.toString());
	
	}

}

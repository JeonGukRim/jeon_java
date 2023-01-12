package Dec_w3;

public class Order {
	private static final int TRAN_PRICE = 2500;
	private String orderNum;
	private String customerId;
	private String customerName;
	private String orderDate;
	private String orderAddress;
	private int price;
	
	Order(){}
	Order(String orderNum, String customerId, String customerName, String orderDate
			, String orderAddress , int price)	{
		this.orderNum = orderNum;
		this.customerId = customerId;
		this.customerName = customerName;
		this.orderDate = orderDate;
		this.orderAddress = orderAddress;
		this.price = price;
	}
	
	public String toString() {
		String orderInfo = "주문번호 : " + orderNum
							+ "\n주문자 아이디 : " + customerId
							+ "\n주문자 이름 : " + customerName
							+ "\n주문 날짜 : " + orderDate
							+ "\n배송 주소 : " + orderAddress
							+ "\n가격 : " + price
							+ "\n택배가격 : " + TRAN_PRICE;
		return orderInfo;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderAddress() {
		return orderAddress;
	}
	public void setOrderAddress(String orderAddress) {
		this.orderAddress = orderAddress;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public static int getTranPrice() {
		return TRAN_PRICE;
	}
	
	
	
	
	
	
	
	
}

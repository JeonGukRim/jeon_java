package Dec_class;

	public class Human {
		String name;
		String address;
		String phone;
		int age;
		
		public String toString() {
			return "이름은 " + name + ", 주소는 " + address + ", 핸드폰번호는 " + phone +" 입니다.";
		} 
		
		public Human(String name) {
			this(name, "알수없음", "알수없음");
		}
		public Human(String name, String address) {
			this(name, address, "알수없음");
		}
		public Human(String name, String address, String phone) {
			this.name = name;
			this.address = address;
			this.phone = phone;
		}
		public Human(String name, String address, String phone, int age) {
			this.name = name;
			this.address = address;
			this.phone = phone;
			this.age = age;
		}
	}

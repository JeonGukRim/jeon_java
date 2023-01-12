package Cpackage;

public class StringFormat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = "홍길동";
		int age = 30;
		
		System.out.println("사람의 이름은 " + name + "이고 나이는 " + age + "이다");
		System.out.printf("사람의 이름은 %s 이고 나이는 %d 이다",name,age);
	}

}

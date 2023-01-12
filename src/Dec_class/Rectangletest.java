package Dec_class;

import java.util.Scanner;

public class Rectangletest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Rectangle rect = new Rectangle();
		// Dec_class.Rectangle r2 = new Rectangle (); 같은 패키지에있는 클래스를 의미 
		Scanner scanner = new Scanner (System.in);
		System.out.print(">>");
		rect.setWidth(scanner.nextInt());
		int height = scanner.nextInt();
		rect.setHeight(height);            //두가지 방법으로 입력
		
//		rect.width = scanner.nextInt();
//		rect.height = scanner.nextInt();
		
		System.out.print("사각형의 면적은" + rect.getArea());
		
		scanner.close(); //프로그램 운영 속도를 위해 닫아 주는 습관;
	}

}

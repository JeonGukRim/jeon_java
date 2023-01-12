package Dec_w3;

class Shape {
	protected String name;

	public void paint() {
		draw();
	}

	public void draw() {
		System.out.println(name);
	}
}

class Circle01 extends Shape {
	protected String name;

	public void draw() {                // 오버라이딩 되였을대 무조건 자식 클래스 재정의된걸 호출한다 항상먼저 재정의된 자식 메소드 호출된다
		name = "Circle"; //this name 과 같다
		super.draw();
		System.out.println(name);
	}
}

public class ShapeMain {
	
	public static void main(String[] args) {
		Shape b = new Circle01();
		b.paint();

	}
}
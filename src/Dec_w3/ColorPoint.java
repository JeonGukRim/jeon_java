package Dec_w3;

public class ColorPoint extends Point {
	
	ColorPoint(){
		System.out.println("calPoint 클래스의 기본 생성자");
	}
	
	
	private String color;
	public ColorPoint (int x,int y) {
		super(x,y); //이걸 쓰면 부모 클래스의 매개변수 생성자로 지정 호출; 
			System.out.println("calPoint 클래스의 매개변수 생성자");
		}
	public void setColor(int x,int y) {
	// super(x,y);// 첫줄에 있어야한다 
		System.out.println("calPoint 클래스의 매개변수 생성자");
	}
	public void showColorPoint() {
		System.out.print(color);
		showPoint();
	}
}

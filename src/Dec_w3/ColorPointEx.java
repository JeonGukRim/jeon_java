package Dec_w3;

public class ColorPointEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Point p =new Point();
//		p.set(1, 2);
//		p.showPoint();
//		
//		ColorPoint cp = new ColorPoint();
//		cp.set(3,4);
//		cp.setColor("red");
//		cp.showColorPoint();
		
//		ColorPoint cp = new ColorPoint();  
		//자식 생성자의 생성자  호출은 하지만 부모클래스의 기본생성자로 이동하고 출력한다;
		ColorPoint cp = new ColorPoint(5,6);
		//자식매겨 변수 있는 생성자의 생성자  호출은 하지만 super로지정하지 않아서 부모클래스의 기본생성자로 출력한다;
//		Point p = new Point();
		
		
	}

}

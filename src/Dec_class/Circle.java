package Dec_class;
//써클 생성
public class Circle {
	//변수 선언 객체 특징
public int radius;
public String name;
public String color;
	// 메소드 생성
	public double getArea() {
		return 3.14 * radius * radius;
		// double area = 3.14 * radius * radius;
		// return area;   이렇게 작성해도 된다
		
	}
	
	public String getColor() {  //getColor 는 메소드 이름
		return color;
	}
	
	
	
	
	
//	public void getArea() {    //void 는 실행만 하고 값을 돌려 주진 않는다
//		radius = 10;
//	}
}

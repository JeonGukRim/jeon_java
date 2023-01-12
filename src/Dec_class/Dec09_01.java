package Dec_class;

public class Dec09_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//class 제작
		Circle c = new Circle(); // 겍체  생성
		
		c.radius =3 ;
		c.color = "red";
		c.getArea();
		System.out.println(c.radius);
		
		Circle c3 = new Circle();
		c3.radius = 10 ;
		c3.color = "yellow";
		
		double area = c3.getArea();
		
		System.out.println(area);
		
		System.out.println(c3.getColor());
		
		String color1 = c3.getColor();
		
		System.out.println(color1);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

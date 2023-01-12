package Bpackage;

class Circle {

	private int radius;

	public Circle(int radius) {
		this.radius = radius;
	}

	public int getRadius() {
		return radius;
	}

}

class NamedCircle extends Circle {
	String y;

	NamedCircle(int radius, String y) {
		super(radius);
		this.y = y;
	}
	
	public void show() {
	System.out.println( this.y+", "+ " 반지름 = " + getRadius());
	}
}

public class CircleMain {
	public static void main(String[] args){

		NamedCircle w = new NamedCircle(5,"waffle");

		w.show();

		}
}

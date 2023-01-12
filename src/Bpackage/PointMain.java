package Bpackage;

class Point {
	private int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	protected void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class ColorPoint extends Point {
	private String color;

	ColorPoint() {
		super(0, 0);
		this.color = "BLACK";
	}

	ColorPoint(int x, int y) {
		super(x, y);
		this.color = "BLACK";
	}

	ColorPoint(int x, int y, String color) {
		super(x, y);
		this.color = color;
	}

	public void setXY(int x, int y) {
		super.move(x, y);
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String toString() {
		return color + "색의 " + "(" + getX() + "," + getY() + ")의 점";
	}
}

class Point3D extends Point {
	private int z;

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	Point3D(int x, int y, int z) {
		super(x, y);
		this.z = z;
	}

	public String toString() {
		return "(" + getX() + "," + getY() + "," + getZ() + ") 의 점";
	}

	public void moveUp() {
		this.z = this.z + 1;
		// this.z +=1;
	}

	public void moveDown() {
		this.z = this.z - 1;
		// this.z -=1;
	}

//	public void move(int x, int y) {
	//	super.move(x, y);
//	}

	public void move(int x, int y, int z) {
		super.move(x, y);
		this.z = z;
	}

}

class PositivePoint extends Point {
	PositivePoint() {
		super(0,0);
	}
	
	PositivePoint(int x, int y) {
	/*	if (x < 0 && y < 0) {
			super.move(0, 0);
		} else {
			super.move(x, y);
		}
	}*/
			 super(0,0);
			 move(x,y);
	}
	public void move(int x, int y) {
		if (x > 0 && y > 0) {
			super.move(x, y);
		}
	}
	public String toString() {
		return "(" + getX() + "," + getY() + ")의 점";
	}

}

public class PointMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// [5번] Point를 상속받아 색을 가진 점을 나타내는 ColorPoint 클래스를 작성하라.
		// 다음 main() 메소드를 포함하고 실행 결과와 같이 출력되게 하라.
		ColorPoint cp = new ColorPoint(5, 5, "YELLOW");
		cp.setXY(10, 20);
		cp.setColor("RED");
		String str = cp.toString();
		System.out.println(str + "입니다. ");

		//[6번] Point를 상속받아 색을 가진 점을 나타내는 ColorPoint 클래스를 작성하라.
		//다음 main() 메소드를 포함하고 실행 결과와 같이 출력되게 하라.
		ColorPoint zeroPoint = new ColorPoint(); // (0,0) 위치의 BLACK 색 점
		System.out.println(zeroPoint.toString() + "입니다.");
		ColorPoint cp2 = new ColorPoint(10, 10); // (10,10) 위치의 BLACK 색 점
		cp2.setXY(5, 5);
		cp2.setColor("RED");
		System.out.println(cp2.toString() + "입니다.");

		//[7번] Point를 상속받아 3차원의 점을 나타내는 Point3D 클래스를 작성하라.
		//다음 main() 메소드를 포함하고 실행 결과와 같이 출력되게 하라.		
		Point3D p = new Point3D(1, 2, 3); // 1,2,3은 각각 x, y, z축의 값.
		System.out.println(p.toString() + "입니다.");
		p.moveUp(); // z 축으로 위쪽 이동
		System.out.println(p.toString() + "입니다.");
		p.moveDown(); // z 축으로 아래쪽 이동
		p.move(10, 10); // x, y 축으로 이동
		System.out.println(p.toString() + "입니다.");
		p.move(100, 200, 300); // x, y, z축으로 이동
		System.out.println(p.toString() + "입니다.");

		// [8번] Point를 상속받아 양수의 공간에서만 점을 나타내는 PositivePoint 클래스를 작성하라.
		// 다음 main() 메소드를 포함하고 실행 결과와 같이 출력되게 하라.
		PositivePoint p1 = new PositivePoint();
		p1.move(10, 10);
		System.out.println(p1.toString() + "입니다.");
		p1.move(-5, 5); // 객체 p는 음수 공간으로 이동되지 않음
		System.out.println(p1.toString() + "입니다.");
		PositivePoint p2 = new PositivePoint(-10, -10);
		System.out.println(p2.toString() + "입니다.");

	}
}

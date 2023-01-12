package Dec_w3;

public class CircleArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Circle[] c;
		c = new Circle[5];

		for (int i = 0; i < c.length; i++) {
			c[i] = new Circle(i);  //객체여서 객체를 생성하면서 넣어야 된다
		}

		for (int j = 0; j < c.length; j++)
			System.out.println((int) (c[j].getArea()) + " ");

	}

}

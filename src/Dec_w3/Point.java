package Dec_w3;

class Point {
	private int x, y; // 한 점을 구성하는 x, y 좌표
	public Point() {
		System.out.println("Point 클래스의 기본 생성자");
		this.x = this.y = 0;
	}
	public Point(int x, int y) {
		
		System.out.println("Point 클래스의 매개변수 생성자");
		this.x = x; this.y = y;
	}
	public void showPoint() { // 점의 좌표 출력
		System.out.println("(" + x + "," + y + ")");
	}
}

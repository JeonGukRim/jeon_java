package TreadPackage;

import java.util.Scanner;

public class TestEx1 extends Thread {

//	public TestEx1() {
//	}

	public void run() {
		System.out.println("스레드 실행 시작");
		for (int i = 1; i < 11; i++) {
			System.out.print(i + " ");
		}
		System.out.println("\n스레드 종료");
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		TestEx1 th = new TestEx1();
		System.out.print("아무키나 입력>>");
		if (s.nextLine() != null) {
			th.start();
		}
		s.close();
	}

}
